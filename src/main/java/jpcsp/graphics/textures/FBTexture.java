/*
This file is part of jpcsp.

Jpcsp is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Jpcsp is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Jpcsp.  If not, see <http://www.gnu.org/licenses/>.
 */
package jpcsp.graphics.textures;

import static jpcsp.graphics.GeCommands.TFLT_NEAREST;
import static jpcsp.graphics.GeCommands.TWRAP_WRAP_MODE_CLAMP;

import jpcsp.graphics.GeCommands;
import jpcsp.graphics.VideoEngine;
import jpcsp.graphics.RE.IRenderingEngine;

/**
 * A texture being used as a render target, using OpenGL FrameBuffer Object (FBO).
 * 
 * @author gid15
 *
 */
public class FBTexture extends GETexture {
	private int fboId = -1;
	private int depthTextureId = -1;
	private static final int depthPixelFormat = IRenderingEngine.RE_DEPTH_COMPONENT;

	public FBTexture(int address, int bufferWidth, int width, int height, int pixelFormat) {
		super(address, bufferWidth, width, height, pixelFormat, true);
	}

	public FBTexture(FBTexture copy) {
		super(copy.address, copy.bufferWidth, copy.width, copy.height, copy.pixelFormat, copy.useViewportResize);
	}

	@Override
	public void bind(IRenderingEngine re, boolean forDrawing) {
		if (forDrawing) {
			// We are copying the texture back to the main frame buffer,
			// bind the texture, not the FBO.
			re.bindFramebuffer(IRenderingEngine.RE_FRAMEBUFFER, 0);
			super.bind(re, forDrawing);
		} else {
			// Create the FBO if not yet created or
			// re-create it if the viewport resize factor has been changed dynamically.
			if (fboId == -1 || isResized()) {
				createFBO(re, forDrawing);
			} else {
				// Bind the FBO
				re.bindFramebuffer(IRenderingEngine.RE_FRAMEBUFFER, fboId);
			}
		}
	}

	protected void createFBO(IRenderingEngine re, boolean forDrawing) {
		if (fboId != -1) {
			re.deleteFramebuffer(fboId);
			fboId = -1;
		}
		if (depthTextureId != -1) {
			re.deleteTexture(depthTextureId);
			depthTextureId = -1;
		}

		// Create the FBO and associate it to the texture
		fboId = re.genFramebuffer();
		re.bindFramebuffer(IRenderingEngine.RE_FRAMEBUFFER, fboId);

		// Create a texture for the depth buffer
		depthTextureId = re.genTexture();
		re.bindTexture(depthTextureId);
		re.setTexImage(0, depthPixelFormat, getTexImageWidth(), getTexImageHeight(), depthPixelFormat, depthPixelFormat, 0, null);
        re.setTextureMipmapMinFilter(TFLT_NEAREST);
        re.setTextureMipmapMagFilter(TFLT_NEAREST);
        re.setTextureMipmapMinLevel(0);
        re.setTextureMipmapMaxLevel(0);
        re.setTextureWrapMode(TWRAP_WRAP_MODE_CLAMP, TWRAP_WRAP_MODE_CLAMP);

		// Create the texture
		super.bind(re, forDrawing);

		// Attach the texture to the FBO
		re.setFramebufferTexture(IRenderingEngine.RE_FRAMEBUFFER, IRenderingEngine.RE_COLOR_ATTACHMENT0, textureId, 0);
		// Attach the depth texture to the FBO
		re.setFramebufferTexture(IRenderingEngine.RE_FRAMEBUFFER, IRenderingEngine.RE_DEPTH_ATTACHMENT, depthTextureId, 0);
	}

	public int getDepthTextureId() {
		return depthTextureId;
	}

	@Override
	public void delete(IRenderingEngine re) {
		if (fboId != -1) {
			re.deleteFramebuffer(fboId);
			fboId = -1;
		}
		if (depthTextureId != -1) {
			re.deleteTexture(depthTextureId);
			depthTextureId = -1;
		}
		super.delete(re);
	}

	public void blitFrom(IRenderingEngine re, FBTexture src) {
		if (fboId == -1) {
			createFBO(re, false);
		}

		// Bind the source and destination FBOs
		re.bindFramebuffer(IRenderingEngine.RE_READ_FRAMEBUFFER, src.fboId);
		re.bindFramebuffer(IRenderingEngine.RE_DRAW_FRAMEBUFFER, fboId);

		// Copy the source FBO to the destination FBO
		re.blitFramebuffer(0, 0, src.getResizedWidth(), src.getResizedHeight(), 0, 0, getResizedWidth(), getResizedHeight(), IRenderingEngine.RE_COLOR_BUFFER_BIT, GeCommands.TFLT_NEAREST);

		// Re-bind the source FBO
		re.bindFramebuffer(IRenderingEngine.RE_FRAMEBUFFER, src.fboId);
	}

	@Override
	public String toString() {
		return String.format("FBTexture[0x%08X-0x%08X, %dx%d, bufferWidth=%d, pixelFormat=%d(%s), textureId=%d, depthTextureId=%d, fboId=%d]", address, address + length, width, height, bufferWidth, pixelFormat, VideoEngine.getPsmName(pixelFormat), textureId, depthTextureId, fboId);
	}
}

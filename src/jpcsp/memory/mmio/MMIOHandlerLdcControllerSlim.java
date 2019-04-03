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
package jpcsp.memory.mmio;

import java.io.IOException;

import org.apache.log4j.Logger;

import jpcsp.HLE.modules.sceHibari;
import jpcsp.state.StateInputStream;
import jpcsp.state.StateOutputStream;

public class MMIOHandlerLdcControllerSlim extends MMIOHandlerBase {
	public static Logger log = sceHibari.log;
	private static final int STATE_VERSION = 0;
	private int unknown08;
	private int unknown0C;

	public MMIOHandlerLdcControllerSlim(int baseAddress) {
		super(baseAddress);
	}

	@Override
	public void read(StateInputStream stream) throws IOException {
		stream.readVersion(STATE_VERSION);
		unknown08 = stream.readInt();
		unknown0C = stream.readInt();
		super.read(stream);
	}

	@Override
	public void write(StateOutputStream stream) throws IOException {
		stream.writeVersion(STATE_VERSION);
		stream.writeInt(unknown08);
		stream.writeInt(unknown0C);
		super.write(stream);
	}

	private void setUnknown04(int value) {
		if (value == 0x2) {
			unknown0C |= 0x2;
		}
	}

	private void setUnknown08(int value) {
		unknown08 = value;

		if (value == 0x1E00 || value == 0x3E00) {
			unknown0C |= 0x4;
		}
		if (value == 0x3E00) {
			unknown08 |= 0x00A0;
		}
	}

	private int readUnknown08() {
		unknown0C &= ~0x4;
		return unknown08;
	}

	@Override
	public int read32(int address) {
		int value;
		switch (address - baseAddress) {
			case 0x08: value = readUnknown08(); break;
			case 0x0C: value = unknown0C; break;
			default: value = super.read32(address); break;
		}

		if (log.isTraceEnabled()) {
			log.trace(String.format("0x%08X - read32(0x%08X) returning 0x%08X", getPc(), address, value));
		}

		return value;
	}

	@Override
	public void write32(int address, int value) {
		switch (address - baseAddress) {
			case 0x00: break;
			case 0x04: setUnknown04(value); break;
			case 0x08: setUnknown08(value); break;
			case 0x10: break;
			case 0x14: break;
			case 0x24: break;
			default: super.write32(address, value); break;
		}

		if (log.isTraceEnabled()) {
			log.trace(String.format("0x%08X - write32(0x%08X, 0x%08X) on %s", getPc(), address, value, this));
		}
	}
}
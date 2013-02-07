/* This autogenerated file is part of jpcsp. */
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

package jpcsp.HLE.modules150;

import jpcsp.HLE.Modules;
import jpcsp.HLE.modules.HLEModule;
import jpcsp.HLE.modules.HLEModuleFunction;
import jpcsp.HLE.modules.HLEModuleManager;

import jpcsp.Memory;
import jpcsp.Processor;

import jpcsp.Allegrex.CpuState; // New-Style Processor

public class sceParseHttp implements HLEModule {
	@Override
	public String getName() { return "sceParseHttp"; }
	
	@Override
	public void installModule(HLEModuleManager mm, int version) {
		if (version >= 150) {
		
			mm.addFunction(sceParseHttpStatusLineFunction, 0x8077A433);
			mm.addFunction(sceParseHttpResponseHeaderFunction, 0xAD7BFDEF);
			
		}
	}
	
	@Override
	public void uninstallModule(HLEModuleManager mm, int version) {
		if (version >= 150) {
		
			mm.removeFunction(sceParseHttpStatusLineFunction);
			mm.removeFunction(sceParseHttpResponseHeaderFunction);
			
		}
	}
	
	
	public void sceParseHttpStatusLine(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function sceParseHttpStatusLine [0x8077A433]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void sceParseHttpResponseHeader(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function sceParseHttpResponseHeader [0xAD7BFDEF]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public final HLEModuleFunction sceParseHttpStatusLineFunction = new HLEModuleFunction("sceParseHttp", "sceParseHttpStatusLine") {
		@Override
		public final void execute(Processor processor) {
			sceParseHttpStatusLine(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceParseHttpModule.sceParseHttpStatusLine(processor);";
		}
	};
    
	public final HLEModuleFunction sceParseHttpResponseHeaderFunction = new HLEModuleFunction("sceParseHttp", "sceParseHttpResponseHeader") {
		@Override
		public final void execute(Processor processor) {
			sceParseHttpResponseHeader(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceParseHttpModule.sceParseHttpResponseHeader(processor);";
		}
	};
    
};
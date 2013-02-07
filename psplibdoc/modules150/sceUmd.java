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

public class sceUmd implements HLEModule {
	@Override
	public String getName() { return "sceUmd"; }
	
	@Override
	public void installModule(HLEModuleManager mm, int version) {
		if (version >= 150) {
		
			mm.addFunction(sceUmdRegisterGetUMDInfoCallBackFunction, 0x7850F057);
			mm.addFunction(sceUmdRegisterUMDCallBackFunction, 0xAEE7404D);
			mm.addFunction(sceUmdUnRegisterUMDCallBackFunction, 0xBD2BDE07);
			mm.addFunction(sceUmdUnRegisterGetUMDInfoCallBackFunction, 0x27A764A1);
			mm.addFunction(sceUmdUnRegisterActivateCallBackFunction, 0x319ED97C);
			mm.addFunction(sceUmdRegisterActivateCallBackFunction, 0x086DDC0D);
			mm.addFunction(sceUmdUnRegisterDeactivateCallBackFunction, 0xBBB5F05C);
			mm.addFunction(sceUmdRegisterDeactivateCallBackFunction, 0x2D81508D);
			mm.addFunction(sceUmd_F8352373Function, 0xF8352373);
			mm.addFunction(sceUmd_5469DC37Function, 0x5469DC37);
			mm.addFunction(sceUmdSetDetectUMDCallBackIdFunction, 0x075F1E0B);
			mm.addFunction(sceUmdGetDetectUMDCallBackIdFunction, 0xEB56097E);
			mm.addFunction(sceUmdCheckMediumFunction, 0x46EBB729);
			mm.addFunction(sceUmdSetDriveStatusFunction, 0x230666E3);
			mm.addFunction(sceUmdClearDriveStatusFunction, 0xAE53DC2D);
			mm.addFunction(sceUmdGetDriveStatusFunction, 0xD45D1FE6);
			mm.addFunction(sceUmdGetUserEventFlagIdFunction, 0x3D0DECD5);
			mm.addFunction(sceUmdGetAssignedFlagFunction, 0xD01B2DC6);
			mm.addFunction(sceUmdSetAssignedFlagFunction, 0x3925CBD8);
			mm.addFunction(sceUmdGetSuspendResumeModeFunction, 0x6A41ED25);
			mm.addFunction(sceUmdSetSuspendResumeModeFunction, 0x4C952ACF);
			mm.addFunction(sceUmdSetErrorStatusFunction, 0x9B22AED7);
			
		}
	}
	
	@Override
	public void uninstallModule(HLEModuleManager mm, int version) {
		if (version >= 150) {
		
			mm.removeFunction(sceUmdRegisterGetUMDInfoCallBackFunction);
			mm.removeFunction(sceUmdRegisterUMDCallBackFunction);
			mm.removeFunction(sceUmdUnRegisterUMDCallBackFunction);
			mm.removeFunction(sceUmdUnRegisterGetUMDInfoCallBackFunction);
			mm.removeFunction(sceUmdUnRegisterActivateCallBackFunction);
			mm.removeFunction(sceUmdRegisterActivateCallBackFunction);
			mm.removeFunction(sceUmdUnRegisterDeactivateCallBackFunction);
			mm.removeFunction(sceUmdRegisterDeactivateCallBackFunction);
			mm.removeFunction(sceUmd_F8352373Function);
			mm.removeFunction(sceUmd_5469DC37Function);
			mm.removeFunction(sceUmdSetDetectUMDCallBackIdFunction);
			mm.removeFunction(sceUmdGetDetectUMDCallBackIdFunction);
			mm.removeFunction(sceUmdCheckMediumFunction);
			mm.removeFunction(sceUmdSetDriveStatusFunction);
			mm.removeFunction(sceUmdClearDriveStatusFunction);
			mm.removeFunction(sceUmdGetDriveStatusFunction);
			mm.removeFunction(sceUmdGetUserEventFlagIdFunction);
			mm.removeFunction(sceUmdGetAssignedFlagFunction);
			mm.removeFunction(sceUmdSetAssignedFlagFunction);
			mm.removeFunction(sceUmdGetSuspendResumeModeFunction);
			mm.removeFunction(sceUmdSetSuspendResumeModeFunction);
			mm.removeFunction(sceUmdSetErrorStatusFunction);
			
		}
	}
	
	
	public void sceUmdRegisterGetUMDInfoCallBack(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function sceUmdRegisterGetUMDInfoCallBack [0x7850F057]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void sceUmdRegisterUMDCallBack(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function sceUmdRegisterUMDCallBack [0xAEE7404D]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void sceUmdUnRegisterUMDCallBack(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function sceUmdUnRegisterUMDCallBack [0xBD2BDE07]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void sceUmdUnRegisterGetUMDInfoCallBack(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function sceUmdUnRegisterGetUMDInfoCallBack [0x27A764A1]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void sceUmdUnRegisterActivateCallBack(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function sceUmdUnRegisterActivateCallBack [0x319ED97C]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void sceUmdRegisterActivateCallBack(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function sceUmdRegisterActivateCallBack [0x086DDC0D]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void sceUmdUnRegisterDeactivateCallBack(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function sceUmdUnRegisterDeactivateCallBack [0xBBB5F05C]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void sceUmdRegisterDeactivateCallBack(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function sceUmdRegisterDeactivateCallBack [0x2D81508D]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void sceUmd_F8352373(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function sceUmd_F8352373 [0xF8352373]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void sceUmd_5469DC37(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function sceUmd_5469DC37 [0x5469DC37]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void sceUmdSetDetectUMDCallBackId(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function sceUmdSetDetectUMDCallBackId [0x075F1E0B]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void sceUmdGetDetectUMDCallBackId(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function sceUmdGetDetectUMDCallBackId [0xEB56097E]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void sceUmdCheckMedium(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function sceUmdCheckMedium [0x46EBB729]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void sceUmdSetDriveStatus(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function sceUmdSetDriveStatus [0x230666E3]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void sceUmdClearDriveStatus(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function sceUmdClearDriveStatus [0xAE53DC2D]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void sceUmdGetDriveStatus(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function sceUmdGetDriveStatus [0xD45D1FE6]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void sceUmdGetUserEventFlagId(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function sceUmdGetUserEventFlagId [0x3D0DECD5]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void sceUmdGetAssignedFlag(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function sceUmdGetAssignedFlag [0xD01B2DC6]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void sceUmdSetAssignedFlag(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function sceUmdSetAssignedFlag [0x3925CBD8]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void sceUmdGetSuspendResumeMode(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function sceUmdGetSuspendResumeMode [0x6A41ED25]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void sceUmdSetSuspendResumeMode(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function sceUmdSetSuspendResumeMode [0x4C952ACF]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void sceUmdSetErrorStatus(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function sceUmdSetErrorStatus [0x9B22AED7]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public final HLEModuleFunction sceUmdRegisterGetUMDInfoCallBackFunction = new HLEModuleFunction("sceUmd", "sceUmdRegisterGetUMDInfoCallBack") {
		@Override
		public final void execute(Processor processor) {
			sceUmdRegisterGetUMDInfoCallBack(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceUmdModule.sceUmdRegisterGetUMDInfoCallBack(processor);";
		}
	};
    
	public final HLEModuleFunction sceUmdRegisterUMDCallBackFunction = new HLEModuleFunction("sceUmd", "sceUmdRegisterUMDCallBack") {
		@Override
		public final void execute(Processor processor) {
			sceUmdRegisterUMDCallBack(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceUmdModule.sceUmdRegisterUMDCallBack(processor);";
		}
	};
    
	public final HLEModuleFunction sceUmdUnRegisterUMDCallBackFunction = new HLEModuleFunction("sceUmd", "sceUmdUnRegisterUMDCallBack") {
		@Override
		public final void execute(Processor processor) {
			sceUmdUnRegisterUMDCallBack(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceUmdModule.sceUmdUnRegisterUMDCallBack(processor);";
		}
	};
    
	public final HLEModuleFunction sceUmdUnRegisterGetUMDInfoCallBackFunction = new HLEModuleFunction("sceUmd", "sceUmdUnRegisterGetUMDInfoCallBack") {
		@Override
		public final void execute(Processor processor) {
			sceUmdUnRegisterGetUMDInfoCallBack(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceUmdModule.sceUmdUnRegisterGetUMDInfoCallBack(processor);";
		}
	};
    
	public final HLEModuleFunction sceUmdUnRegisterActivateCallBackFunction = new HLEModuleFunction("sceUmd", "sceUmdUnRegisterActivateCallBack") {
		@Override
		public final void execute(Processor processor) {
			sceUmdUnRegisterActivateCallBack(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceUmdModule.sceUmdUnRegisterActivateCallBack(processor);";
		}
	};
    
	public final HLEModuleFunction sceUmdRegisterActivateCallBackFunction = new HLEModuleFunction("sceUmd", "sceUmdRegisterActivateCallBack") {
		@Override
		public final void execute(Processor processor) {
			sceUmdRegisterActivateCallBack(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceUmdModule.sceUmdRegisterActivateCallBack(processor);";
		}
	};
    
	public final HLEModuleFunction sceUmdUnRegisterDeactivateCallBackFunction = new HLEModuleFunction("sceUmd", "sceUmdUnRegisterDeactivateCallBack") {
		@Override
		public final void execute(Processor processor) {
			sceUmdUnRegisterDeactivateCallBack(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceUmdModule.sceUmdUnRegisterDeactivateCallBack(processor);";
		}
	};
    
	public final HLEModuleFunction sceUmdRegisterDeactivateCallBackFunction = new HLEModuleFunction("sceUmd", "sceUmdRegisterDeactivateCallBack") {
		@Override
		public final void execute(Processor processor) {
			sceUmdRegisterDeactivateCallBack(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceUmdModule.sceUmdRegisterDeactivateCallBack(processor);";
		}
	};
    
	public final HLEModuleFunction sceUmd_F8352373Function = new HLEModuleFunction("sceUmd", "sceUmd_F8352373") {
		@Override
		public final void execute(Processor processor) {
			sceUmd_F8352373(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceUmdModule.sceUmd_F8352373(processor);";
		}
	};
    
	public final HLEModuleFunction sceUmd_5469DC37Function = new HLEModuleFunction("sceUmd", "sceUmd_5469DC37") {
		@Override
		public final void execute(Processor processor) {
			sceUmd_5469DC37(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceUmdModule.sceUmd_5469DC37(processor);";
		}
	};
    
	public final HLEModuleFunction sceUmdSetDetectUMDCallBackIdFunction = new HLEModuleFunction("sceUmd", "sceUmdSetDetectUMDCallBackId") {
		@Override
		public final void execute(Processor processor) {
			sceUmdSetDetectUMDCallBackId(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceUmdModule.sceUmdSetDetectUMDCallBackId(processor);";
		}
	};
    
	public final HLEModuleFunction sceUmdGetDetectUMDCallBackIdFunction = new HLEModuleFunction("sceUmd", "sceUmdGetDetectUMDCallBackId") {
		@Override
		public final void execute(Processor processor) {
			sceUmdGetDetectUMDCallBackId(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceUmdModule.sceUmdGetDetectUMDCallBackId(processor);";
		}
	};
    
	public final HLEModuleFunction sceUmdCheckMediumFunction = new HLEModuleFunction("sceUmd", "sceUmdCheckMedium") {
		@Override
		public final void execute(Processor processor) {
			sceUmdCheckMedium(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceUmdModule.sceUmdCheckMedium(processor);";
		}
	};
    
	public final HLEModuleFunction sceUmdSetDriveStatusFunction = new HLEModuleFunction("sceUmd", "sceUmdSetDriveStatus") {
		@Override
		public final void execute(Processor processor) {
			sceUmdSetDriveStatus(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceUmdModule.sceUmdSetDriveStatus(processor);";
		}
	};
    
	public final HLEModuleFunction sceUmdClearDriveStatusFunction = new HLEModuleFunction("sceUmd", "sceUmdClearDriveStatus") {
		@Override
		public final void execute(Processor processor) {
			sceUmdClearDriveStatus(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceUmdModule.sceUmdClearDriveStatus(processor);";
		}
	};
    
	public final HLEModuleFunction sceUmdGetDriveStatusFunction = new HLEModuleFunction("sceUmd", "sceUmdGetDriveStatus") {
		@Override
		public final void execute(Processor processor) {
			sceUmdGetDriveStatus(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceUmdModule.sceUmdGetDriveStatus(processor);";
		}
	};
    
	public final HLEModuleFunction sceUmdGetUserEventFlagIdFunction = new HLEModuleFunction("sceUmd", "sceUmdGetUserEventFlagId") {
		@Override
		public final void execute(Processor processor) {
			sceUmdGetUserEventFlagId(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceUmdModule.sceUmdGetUserEventFlagId(processor);";
		}
	};
    
	public final HLEModuleFunction sceUmdGetAssignedFlagFunction = new HLEModuleFunction("sceUmd", "sceUmdGetAssignedFlag") {
		@Override
		public final void execute(Processor processor) {
			sceUmdGetAssignedFlag(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceUmdModule.sceUmdGetAssignedFlag(processor);";
		}
	};
    
	public final HLEModuleFunction sceUmdSetAssignedFlagFunction = new HLEModuleFunction("sceUmd", "sceUmdSetAssignedFlag") {
		@Override
		public final void execute(Processor processor) {
			sceUmdSetAssignedFlag(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceUmdModule.sceUmdSetAssignedFlag(processor);";
		}
	};
    
	public final HLEModuleFunction sceUmdGetSuspendResumeModeFunction = new HLEModuleFunction("sceUmd", "sceUmdGetSuspendResumeMode") {
		@Override
		public final void execute(Processor processor) {
			sceUmdGetSuspendResumeMode(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceUmdModule.sceUmdGetSuspendResumeMode(processor);";
		}
	};
    
	public final HLEModuleFunction sceUmdSetSuspendResumeModeFunction = new HLEModuleFunction("sceUmd", "sceUmdSetSuspendResumeMode") {
		@Override
		public final void execute(Processor processor) {
			sceUmdSetSuspendResumeMode(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceUmdModule.sceUmdSetSuspendResumeMode(processor);";
		}
	};
    
	public final HLEModuleFunction sceUmdSetErrorStatusFunction = new HLEModuleFunction("sceUmd", "sceUmdSetErrorStatus") {
		@Override
		public final void execute(Processor processor) {
			sceUmdSetErrorStatus(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceUmdModule.sceUmdSetErrorStatus(processor);";
		}
	};
    
};
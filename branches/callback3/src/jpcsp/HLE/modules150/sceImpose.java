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

import jpcsp.HLE.modules.HLEModule;
import jpcsp.HLE.modules.HLEModuleFunction;
import jpcsp.HLE.modules.HLEModuleManager;
import jpcsp.HLE.Modules;

import jpcsp.Memory;
import jpcsp.Processor;

import jpcsp.Allegrex.CpuState; // New-Style Processor

public class sceImpose implements HLEModule {
	@Override
	public String getName() { return "sceImpose"; }

	@Override
	public void installModule(HLEModuleManager mm, int version) {
		if (version >= 150) {

			mm.addFunction(sceImposeHomeButtonFunction, 0x381BD9E7);
			mm.addFunction(sceImposeSetHomePopupFunction, 0x5595A71A);
			mm.addFunction(sceImposeGetHomePopupFunction, 0x0F341BE4);
			mm.addFunction(sceImposeSetUMDPopupFunction, 0x72189C48);
			mm.addFunction(sceImposeGetUMDPopupFunction, 0xE0887BC8);
			mm.addFunction(sceImposeSetLanguageModeFunction, 0x36AA6E91);
			mm.addFunction(sceImposeGetLanguageModeFunction, 0x24FD7BCF);
			mm.addFunction(sceImposeGetBatteryIconStatusFunction, 0x8C943191);

            // TODO add to settings gui
            languageMode_language = PSP_LANGUAGE_ENGLISH;
            languageMode_button = PSP_CONFIRM_BUTTON_CROSS;
		}
	}

	@Override
	public void uninstallModule(HLEModuleManager mm, int version) {
		if (version >= 150) {

			mm.removeFunction(sceImposeHomeButtonFunction);
			mm.removeFunction(sceImposeSetHomePopupFunction);
			mm.removeFunction(sceImposeGetHomePopupFunction);
			mm.removeFunction(sceImposeSetUMDPopupFunction);
			mm.removeFunction(sceImposeGetUMDPopupFunction);
			mm.removeFunction(sceImposeSetLanguageModeFunction);
			mm.removeFunction(sceImposeGetLanguageModeFunction);
			mm.removeFunction(sceImposeGetBatteryIconStatusFunction);

		}
	}

    // TODO get all the language codes
    public final static int PSP_LANGUAGE_JAPANESE = 0;
    public final static int PSP_LANGUAGE_ENGLISH = 1;
    public final static int PSP_LANGUAGE_FRENCH = 2;
    public final static int PSP_LANGUAGE_SPANISH = 3; // unconfirmed
    public final static int PSP_LANGUAGE_GERMAN = 4; // unconfirmed
    public final static int PSP_LANGUAGE_ITALIAN = 5; // unconfirmed
    public final static int PSP_LANGUAGE_DUTCH = 6; // unconfirmed
    public final static int PSP_LANGUAGE_PORTUGUESE = 7; // unconfirmed
    public final static int PSP_LANGUAGE_RUSSIAN = 8; // unconfirmed
    public final static int PSP_LANGUAGE_KOREAN = 9;
    public final static int PSP_LANGUAGE_TRADITIONAL_CHINESE = 10; // unconfirmed
    public final static int PSP_LANGUAGE_SIMPLIFIED_CHINESE = 11; // unconfirmed
    private int languageMode_language;

    // TODO check assignment
    public final static int PSP_CONFIRM_BUTTON_CIRCLE = 0;
    public final static int PSP_CONFIRM_BUTTON_CROSS = 1;
    private int languageMode_button;

	public void sceImposeHomeButton(Processor processor) {
	    CpuState cpu = processor.cpu; // New-Style Processor
		Memory mem = Processor.memory;

		/* put your own code here instead */

		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  ...  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  ... float f19 = cpu.fpr[19];

		Modules.log.warn("Unimplemented NID function sceImposeHomeButton [0x381BD9E7]");

		cpu.gpr[2] = 0xDEADC0DE;

		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32); cpu.fpr[0] = result;
	}

	public void sceImposeSetHomePopup(Processor processor) {
		CpuState cpu = processor.cpu; // New-Style Processor
		Memory mem = Processor.memory;

		/* put your own code here instead */

		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  ...  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  ... float f19 = cpu.fpr[19];

		Modules.log.warn("Unimplemented NID function sceImposeSetHomePopup [0x5595A71A]");

		cpu.gpr[2] = 0xDEADC0DE;

		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32); cpu.fpr[0] = result;
	}

	public void sceImposeGetHomePopup(Processor processor) {
		CpuState cpu = processor.cpu; // New-Style Processor
		Memory mem = Processor.memory;

		/* put your own code here instead */

		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  ...  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  ... float f19 = cpu.fpr[19];

		Modules.log.warn("Unimplemented NID function sceImposeGetHomePopup [0x0F341BE4]");

		cpu.gpr[2] = 0xDEADC0DE;

		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32); cpu.fpr[0] = result;
	}

	public void sceImposeSetUMDPopup(Processor processor) {
		CpuState cpu = processor.cpu; // New-Style Processor
		Memory mem = Processor.memory;

		/* put your own code here instead */

		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  ...  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  ... float f19 = cpu.fpr[19];

		Modules.log.warn("Unimplemented NID function sceImposeSetUMDPopup [0x72189C48]");

		cpu.gpr[2] = 0xDEADC0DE;

		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32); cpu.fpr[0] = result;
	}

	public void sceImposeGetUMDPopup(Processor processor) {
		CpuState cpu = processor.cpu; // New-Style Processor
		Memory mem = Processor.memory;

		/* put your own code here instead */

		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  ...  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  ... float f19 = cpu.fpr[19];

		Modules.log.warn("Unimplemented NID function sceImposeGetUMDPopup [0xE0887BC8]");

		cpu.gpr[2] = 0xDEADC0DE;

		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32); cpu.fpr[0] = result;
	}

	public void sceImposeSetLanguageMode(Processor processor) {
		CpuState cpu = processor.cpu; // New-Style Processor
		Memory mem = Processor.memory;

        int lang = cpu.gpr[4];
        int button = cpu.gpr[5];

        String langStr;
        switch(lang) {
            case PSP_LANGUAGE_JAPANESE: langStr = "JAP"; break;
            case PSP_LANGUAGE_ENGLISH: langStr = "ENG"; break;
            case PSP_LANGUAGE_FRENCH: langStr = "FR"; break;
            case PSP_LANGUAGE_KOREAN: langStr = "KOR"; break;
            default: langStr = "PSP_LANGUAGE_UNKNOWN" + lang; break;
        }

		Modules.log.debug("sceImposeSetLanguageMode(lang=" + lang + "(" + langStr + "),button=" + button + ")");

        languageMode_language = lang;
        languageMode_button = button;

		cpu.gpr[2] = 0;
	}

    public void sceImposeGetLanguageMode(Processor processor) {
        CpuState cpu = processor.cpu; // New-Style Processor
        Memory mem = Processor.memory;

        int lang_addr = cpu.gpr[4];
        int button_addr = cpu.gpr[5];

        Modules.log.debug("sceImposeGetLanguageMode(lang=0x" + Integer.toHexString(lang_addr)
            + ",button=0x" + Integer.toHexString(button_addr) + ")"
            + " returning lang=" + languageMode_language + " button=" + languageMode_button);

        if (mem.isAddressGood(lang_addr)) {
            mem.write32(lang_addr, languageMode_language);
        }

        if (mem.isAddressGood(button_addr)) {
            mem.write32(button_addr, languageMode_button);
        }

        cpu.gpr[2] = 0;
    }

	public void sceImposeGetBatteryIconStatus(Processor processor) {
		CpuState cpu = processor.cpu; // New-Style Processor
		Memory mem = Processor.memory;

        int addrCharging = cpu.gpr[4];
        int addrIconStatus = cpu.gpr[5];
        int batteryPowerPercent = scePower.getBatteryPowerPercent();
        // Possible values for iconStatus: 0..3
        int iconStatus = Math.min(batteryPowerPercent / 25, 3);
        boolean charging = scePower.isBatteryCharging();

        if (mem.isAddressGood(addrCharging)) {
            mem.write32(addrCharging, charging ? 1 : 0); // Values: 0..1
        }
        if (mem.isAddressGood(addrIconStatus)) {
            mem.write32(addrIconStatus, iconStatus); // Values: 0..3
        }

		cpu.gpr[2] = 0;
	}

	public final HLEModuleFunction sceImposeHomeButtonFunction = new HLEModuleFunction("sceImpose", "sceImposeHomeButton") {
		@Override
		public final void execute(Processor processor) {
			sceImposeHomeButton(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceImposeModule.sceImposeHomeButton(processor);";
		}
	};

	public final HLEModuleFunction sceImposeSetHomePopupFunction = new HLEModuleFunction("sceImpose", "sceImposeSetHomePopup") {
		@Override
		public final void execute(Processor processor) {
			sceImposeSetHomePopup(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceImposeModule.sceImposeSetHomePopup(processor);";
		}
	};

	public final HLEModuleFunction sceImposeGetHomePopupFunction = new HLEModuleFunction("sceImpose", "sceImposeGetHomePopup") {
		@Override
		public final void execute(Processor processor) {
			sceImposeGetHomePopup(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceImposeModule.sceImposeGetHomePopup(processor);";
		}
	};

	public final HLEModuleFunction sceImposeSetUMDPopupFunction = new HLEModuleFunction("sceImpose", "sceImposeSetUMDPopup") {
		@Override
		public final void execute(Processor processor) {
			sceImposeSetUMDPopup(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceImposeModule.sceImposeSetUMDPopup(processor);";
		}
	};

	public final HLEModuleFunction sceImposeGetUMDPopupFunction = new HLEModuleFunction("sceImpose", "sceImposeGetUMDPopup") {
		@Override
		public final void execute(Processor processor) {
			sceImposeGetUMDPopup(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceImposeModule.sceImposeGetUMDPopup(processor);";
		}
	};

	public final HLEModuleFunction sceImposeSetLanguageModeFunction = new HLEModuleFunction("sceImpose", "sceImposeSetLanguageMode") {
		@Override
		public final void execute(Processor processor) {
			sceImposeSetLanguageMode(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceImposeModule.sceImposeSetLanguageMode(processor);";
		}
	};

	public final HLEModuleFunction sceImposeGetLanguageModeFunction = new HLEModuleFunction("sceImpose", "sceImposeGetLanguageMode") {
		@Override
		public final void execute(Processor processor) {
			sceImposeGetLanguageMode(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceImposeModule.sceImposeGetLanguageMode(processor);";
		}
	};

	public final HLEModuleFunction sceImposeGetBatteryIconStatusFunction = new HLEModuleFunction("sceImpose", "sceImposeGetBatteryIconStatus") {
		@Override
		public final void execute(Processor processor) {
			sceImposeGetBatteryIconStatus(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceImposeModule.sceImposeGetBatteryIconStatus(processor);";
		}
	};
};
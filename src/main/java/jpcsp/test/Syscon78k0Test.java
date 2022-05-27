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
package jpcsp.test;

import static jpcsp.HLE.modules.sceSyscon.getSysconCmdName;
import static jpcsp.memory.mmio.syscon.MMIOHandlerSysconFirmwareSfr.getInterruptName;
import static jpcsp.nec78k0.Nec78k0Memory.BASE_RAM0;
import static jpcsp.nec78k0.Nec78k0Memory.END_RAM0;
import static jpcsp.util.Utilities.readUnaligned32;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import jpcsp.Emulator;
import jpcsp.Allegrex.compiler.RuntimeContext;
import jpcsp.autotests.AutoTestsRunner;
import jpcsp.hardware.Model;
import jpcsp.hardware.Wlan;
import jpcsp.nec78k0.Nec78k0Interpreter;
import jpcsp.nec78k0.Nec78k0Memory;
import jpcsp.nec78k0.Nec78k0Processor;
import jpcsp.util.LWJGLFixer;

/**
 * @author gid15
 *
 */
public class Syscon78k0Test {
	public static Logger log;

	public static void main(String[] args) {
        LWJGLFixer.fixOnce();
        DOMConfigurator.configure("LogSettings.xml");
        log = Nec78k0Processor.log;
		RuntimeContext.setLog4jMDC();
		Wlan.initialize();
        new Emulator(new AutoTestsRunner.DummyGUI());
        Emulator.getClock().resume();
		RuntimeContext.debugCodeBlockCalls = true;
		Emulator.run = true;

		new Syscon78k0Test().testFirmware();
	}

	public void testFirmware() {
		int model = Model.MODEL_PSP_SLIM; // syscon_02g.bin
//		model = Model.MODEL_PSP_FAT;      // syscon_01g.bin
//		model = Model.MODEL_PSP_BRITE;    // syscon_03g.bin
//		model = Model.MODEL_PSP_BRITE2;   // syscon_04g.bin
//		model = Model.MODEL_PSP_BRITE4;   // syscon_09g.bin
//		model = Model.MODEL_PSP_STREET;   // syscon_11g.bin

		Model.setModel(model);
		String fileName = String.format("syscon_%02dg.bin", Model.getGeneration());
		log.debug(String.format("Reading %s", fileName));
		File inputFile = new File(fileName);
		byte[] buffer = new byte[(int) inputFile.length()];
		int length = buffer.length;
		try {
			InputStream is = new FileInputStream(inputFile);
			length = is.read(buffer);
			is.close();
		} catch (IOException e) {
			log.error(e);
		}

		Nec78k0Memory mem = new Nec78k0Memory(log);
		Nec78k0Processor processor = new Nec78k0Processor(mem);
		Nec78k0Interpreter interpreter = new Nec78k0Interpreter(processor);

		int baseAddress = BASE_RAM0;
		length = Math.min(length, END_RAM0);
		for (int i = 0; i < length; i += 4) {
			mem.write32(baseAddress + i, readUnaligned32(buffer, i));
		}

		if (true) {
			for (int i = 0; i < 0x40; i += 2) {
				int addr = mem.internalRead16(i);
				if (addr != 0 && addr != 0xFFFF) {
					log.info(String.format("Disassembling Vector Table entry 0x%02X(%s): 0x%04X", i, getInterruptName(i), addr));
					processor.disassemble(addr);
				}
			}
			for (int i = 0x88; i < 0xAE; i += 2) {
				int addr = mem.internalRead16(i);
				if (addr != 0 && addr != 0xFFFF) {
					log.info(String.format("Disassembling sysconCmdGetOps table 0x%02X(%s): 0x%04X", i, getSysconCmdName((i - 0x88) / 2), addr));
					processor.disassemble(addr);
				}
			}
			for (int i = 0xAE; i < 0xDC; i += 2) {
				int addr = mem.internalRead16(i);
				if (addr != 0 && addr != 0xFFFF) {
					log.info(String.format("Disassembling mainOperations table 0x%02X(%s): 0x%04X", i, getSysconCmdName((i - 0xAE) / 2 + 0x20), addr));
					processor.disassemble(addr);
				}
			}
			for (int i = 0xDC; i < 0x10A; i += 2) {
				int addr = mem.internalRead16(i);
				if (addr != 0 && addr != 0xFFFF) {
					log.info(String.format("Disassembling peripheralOperations table 0x%02X(%s): 0x%04X", i, getSysconCmdName((i - 0xDC) / 2 + 0x40), addr));
					processor.disassemble(addr);
				}
			}
			processor.disassemble(0x8100);
		}

		processor.reset();

		interpreter.run();

		long minimumDuration = 3000L; // Run for at least 3 seconds
		long start = now();
		while ((now() - start) < minimumDuration) {
			// TODO This is triggering the start of the serial communication where the firmware is receiving requests from the PSP.
			// Not yet found how to properly come to that state.
			processor.mem.write8(0xFE34, (byte) 0x01);

			interpreter.run();
		}
	}

	public static long now() {
		return Emulator.getClock().currentTimeMillis();
	}
}

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
package jpcsp.memory.mmio.syscon;

import static jpcsp.memory.mmio.syscon.MMIOHandlerSysconFirmwareSfr.IFtoINT;
import static jpcsp.memory.mmio.syscon.MMIOHandlerSysconFirmwareSfr.getInterruptName;
import static jpcsp.util.Utilities.hasBit;

import java.io.IOException;

import jpcsp.state.StateInputStream;
import jpcsp.state.StateOutputStream;

/**
 * @author gid15
 *
 */
public class SysconTimerEventCounter8 extends AbstractSysconTimerEventCounter {
	private static final int STATE_VERSION = 0;
	private final int interruptFlagCompare;
	private int timerModeControl;
	private int clockSelection;
	private int compare;

	public SysconTimerEventCounter8(MMIOHandlerSysconFirmwareSfr sfr, SysconScheduler scheduler, String name, int interruptFlagCompare) {
		super(sfr, scheduler, name, 0xFF);
		this.interruptFlagCompare = interruptFlagCompare;
	}

	@Override
	public void read(StateInputStream stream) throws IOException {
		stream.readVersion(STATE_VERSION);
		timerModeControl = stream.readInt();
		clockSelection = stream.readInt();

		super.read(stream);
	}

	@Override
	public void write(StateOutputStream stream) throws IOException {
		stream.writeVersion(STATE_VERSION);
		stream.writeInt(timerModeControl);
		stream.writeInt(clockSelection);

		super.write(stream);
	}

	@Override
	public void reset() {
		timerModeControl = 0x00;
		clockSelection = 0x00;
		compare = 0x00;

		super.reset();

		updateCompare();
	}

	@Override
	protected void onTimerCounterOverflow() {
		// Nothing to do
	}

	@Override
	protected void onTimerCounterCompare0() {
		if (log.isTraceEnabled()) {
			log.trace(String.format("%s onTimerCounterCompare0 triggering interrupt %s", name, getInterruptName(IFtoINT(interruptFlagCompare))));
		}
		sfr.setInterruptRequest(interruptFlagCompare);
	}

	@Override
	protected void onTimerCounterCompare1() {
		// Nothing to do
	}

	public void setTimerModeControl(int value) {
		if (hasBit(value, 0)) {
			log.error(String.format("%s setTimerModeControl unimplemented output enabled 0x%02X", name, value));
		}
		if (hasBit(value, 7)) {
			setMode(false, true);
		}

		timerModeControl = value;
	}

	public int getTimerModeControl() {
		// Bits 2 and 3 are write-only
		return timerModeControl & 0xF3;
	}

	public void setClockSelection(int value) {
		clockSelection = value;
	}

	private void updateCompare() {
		setCompare0(compare);
	}

	public void setCompare(int value) {
		compare = value;

		updateCompare();
	}
}

package com.github.finalfin.multitimer.core;

import java.time.Instant;

public interface TimerListElement {
	String getName();

	void setName(String name);

	boolean supportsStop();

	boolean supportsRestart();

	boolean supportsPause();

	boolean supportsEndTime();

	void disable();

	void enable();

	Instant getEndTime();

	void stop();

	void restart();

	void reset();

	TimerState getState();
}

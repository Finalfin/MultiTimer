package com.github.finalfin.multitimer.core;

import java.time.Duration;
import java.time.Instant;

public class CountdownTimer implements TimerListElement {
	private TimerState state;
	private Duration startingValue;
	private Duration currentValue;
	private Instant endTime;
	private String name;

	public CountdownTimer(String counterName) {
		this(counterName, Duration.ofMinutes(1));
	}

	public CountdownTimer(String counterName, Duration duration) {
		endTime = null;
		currentValue = startingValue = duration;
		state = TimerState.Stopped;
		name = counterName;
	}

	@Override
	public boolean supportsStop() {
		return true;
	}

	@Override
	public boolean supportsRestart() {
		return true;
	}

	@Override
	public boolean supportsPause() {
		return true;
	}

	@Override
	public boolean supportsEndTime() {
		return true;
	}

	@Override
	public void disable() {
	}

	@Override
	public void enable() {
	}

	@Override
	public Instant getEndTime() {
		return endTime;
	}

	@Override
	public void stop() {
		currentValue = Duration.between(Instant.now(), endTime);
		endTime = null;
		state = TimerState.Stopped;
	}

	@Override
	public void restart() {
		endTime = Instant.now().plus(currentValue);
		currentValue = null;
		state = TimerState.Running;
	}

	@Override
	public void reset() {
		endTime = null;
		currentValue = startingValue;
	}

	@Override
	public TimerState getState() {
		return state;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String timerName) {
		name = timerName;
	}

}

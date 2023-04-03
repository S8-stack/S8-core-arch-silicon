package com.s8.stack.arch.silicon.clock;

import com.s8.io.xml.annotations.XML_SetAttribute;
import com.s8.io.xml.annotations.XML_Type;
import com.s8.stack.arch.silicon.SiliconEngine;


@XML_Type(name = "T3UnitConfig")	
public class ClockUnitConfig {

	private long tick = 250;
	
	@XML_SetAttribute(name = "tick")
	public void setTick(long tick) {
		this.tick = tick;
	}

	public ClockUnitConfig() {
		super();
	}

	public ClockUnit build(SiliconEngine engine) {
		return new ClockUnit(engine, tick);
	}


	/**
	 * 
	 * @return
	 */
	public static ClockUnitConfig createDefault() {
		ClockUnitConfig config = new ClockUnitConfig();
		return config;
	}
}

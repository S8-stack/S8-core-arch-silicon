package com.s8.arch.silicon.clock;

import com.s8.arch.silicon.SiliconEngine;
import com.s8.io.xml.annotations.XML_SetAttribute;
import com.s8.io.xml.annotations.XML_Type;


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

	public ClockSiUnit build(SiliconEngine engine) {
		return new ClockSiUnit(engine, tick);
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

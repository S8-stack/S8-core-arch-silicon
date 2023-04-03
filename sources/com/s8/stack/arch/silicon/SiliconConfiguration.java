package com.s8.stack.arch.silicon;

import com.s8.io.xml.annotations.XML_SetElement;
import com.s8.io.xml.annotations.XML_Type;
import com.s8.stack.arch.silicon.async.AsyncUnitConfig;
import com.s8.stack.arch.silicon.clock.ClockUnitConfig;
import com.s8.stack.arch.silicon.watch.WatchUnitConfig;

@XML_Type(name = "SiliconAppConfiguration", root = true)
public class SiliconConfiguration {

	public AsyncUnitConfig t1UnitConfig = AsyncUnitConfig.createDefault();
	
	public WatchUnitConfig t2UnitConfig = WatchUnitConfig.createDefault();
	
	public ClockUnitConfig t3UnitConfig = ClockUnitConfig.createDefault();
	
	
	@XML_SetElement(tag = "T1-unit")
	public void setT1UnitConfig(AsyncUnitConfig config) {
		this.t1UnitConfig = config;
	}
	
	@XML_SetElement(tag = "T2-unit")
	public void setT2UnitConfig(WatchUnitConfig config) {
		this.t2UnitConfig = config;
	}
	
	@XML_SetElement(tag = "T3-unit")
	public void setT3UnitConfig(ClockUnitConfig config) {
		this.t3UnitConfig = config;
	}
	
	
	
	
}

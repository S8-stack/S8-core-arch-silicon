package com.s8.core.arch.silicon;

import com.s8.core.arch.silicon.async.AsyncSiModuleConfig;
import com.s8.core.arch.silicon.clock.ClockSiModuleConfig;
import com.s8.core.arch.silicon.watch.WatchSiModuleConfig;
import com.s8.core.io.xml.annotations.XML_SetElement;
import com.s8.core.io.xml.annotations.XML_Type;

@XML_Type(name = "SiliconAppConfiguration", root = true)
public class SiliconConfiguration {
	
	

	public AsyncSiModuleConfig t1UnitConfig = AsyncSiModuleConfig.createDefault();
	
	public WatchSiModuleConfig t2UnitConfig = WatchSiModuleConfig.createDefault();
	
	public ClockSiModuleConfig t3UnitConfig = ClockSiModuleConfig.createDefault();
	
	
	@XML_SetElement(tag = "T1-unit")
	public void setT1UnitConfig(AsyncSiModuleConfig config) {
		this.t1UnitConfig = config;
	}
	
	@XML_SetElement(tag = "T2-unit")
	public void setT2UnitConfig(WatchSiModuleConfig config) {
		this.t2UnitConfig = config;
	}
	
	@XML_SetElement(tag = "T3-unit")
	public void setT3UnitConfig(ClockSiModuleConfig config) {
		this.t3UnitConfig = config;
	}
	
	

	public static SiliconConfiguration createDefault4Cores() {
		SiliconConfiguration configuration = new SiliconConfiguration();
		configuration.t1UnitConfig = AsyncSiModuleConfig.createDefault();
		configuration.t2UnitConfig = WatchSiModuleConfig.createDefault();
		configuration.t3UnitConfig = ClockSiModuleConfig.createDefault();
		return configuration;
	}
	
	
}

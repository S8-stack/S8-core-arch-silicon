package com.s8.core.arch.silicon.clock;

import com.s8.core.arch.silicon.SiliconEngine;

/**
 * 
 * @author pierreconvert
 *
 */
public interface ClockSiTask {

	/**
	 * 
	 * @param t relative time
	 * @param engine
	 * @return
	 */
	public boolean trigger(long t, SiliconEngine engine);
	
}

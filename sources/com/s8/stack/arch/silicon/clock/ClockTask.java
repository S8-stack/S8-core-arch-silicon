package com.s8.stack.arch.silicon.clock;

import com.s8.stack.arch.silicon.SiliconEngine;

/**
 * 
 * @author pierreconvert
 *
 */
public interface ClockTask {

	/**
	 * 
	 * @param t relative time
	 * @param engine
	 * @return
	 */
	public boolean trigger(long t, SiliconEngine engine);
	
}

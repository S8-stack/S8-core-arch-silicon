package com.s8.arch.silicon;

import com.s8.arch.silicon.async.AsyncTask;
import com.s8.arch.silicon.async.AsyncSiUnit;
import com.s8.arch.silicon.clock.ClockTask;
import com.s8.arch.silicon.clock.ClockSiUnit;
import com.s8.arch.silicon.watch.WatchTask;
import com.s8.arch.silicon.watch.WatchSiUnit;

/**
 * 
 * @author pierreconvert
 *
 */
public class SiliconEngine {


	final AsyncSiUnit asyncUnit;

	/**
	 * 
	 */
	final WatchSiUnit watchUnit;

	
	/**
	 * 
	 */
	final ClockSiUnit clockUnit;


	/**
	 * 
	 * @param nUnits
	 * @param capacity
	 * @param mappings
	 */
	public SiliconEngine(SiliconConfiguration c) {
		super();
		
		// initialize
		asyncUnit = c.t1UnitConfig.build();
		watchUnit = c.t2UnitConfig.build();
		clockUnit = c.t3UnitConfig.build(this);
	}



	/**
	 * 
	 */
	public void start() {

		/* <start-processing-units> */
		asyncUnit.start();
		watchUnit.start();
		clockUnit.start();
		/* </start-processing-units> */
	}


	
	
	public void pushAsyncTask(AsyncTask task) {
		asyncUnit.pushTask(task);
	}
	
	
	public void pushWatchTask(WatchTask task) {
		watchUnit.pushTask(task);
	}
	

	public void pushClockTask(ClockTask task) {
		clockUnit.pushTask(task);
	}
	
	

	/**
	 * 
	 */
	public void stop() {

		
		/* <stop-processing-units> */
		asyncUnit.stop();
		watchUnit.stop();
		/* </stop-processing-units> */
	}


	public static SiliconEngine startBasic() {

		SiliconConfiguration appConfig = new SiliconConfiguration();
		SiliconEngine app = new SiliconEngine(appConfig);
		app.start();
		return app;

	}



}

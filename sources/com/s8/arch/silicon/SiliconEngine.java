package com.s8.arch.silicon;

import com.s8.arch.silicon.async.AsyncTask;
import com.s8.arch.silicon.async.AsyncUnit;
import com.s8.arch.silicon.clock.ClockTask;
import com.s8.arch.silicon.clock.ClockUnit;
import com.s8.arch.silicon.watch.WatchTask;
import com.s8.arch.silicon.watch.WatchUnit;

/**
 * 
 * @author pierreconvert
 *
 */
public class SiliconEngine {


	final AsyncUnit t1Unit;

	/**
	 * 
	 */
	final WatchUnit t2Unit;

	
	/**
	 * 
	 */
	final ClockUnit t3Unit;


	/**
	 * 
	 * @param nUnits
	 * @param capacity
	 * @param mappings
	 */
	public SiliconEngine(SiliconConfiguration c) {
		super();
		
		// initialize
		t1Unit = c.t1UnitConfig.build();
		t2Unit = c.t2UnitConfig.build();
		t3Unit = c.t3UnitConfig.build(this);
	}



	/**
	 * 
	 */
	public void start() {

		/* <start-processing-units> */
		t1Unit.start();
		t2Unit.start();
		t3Unit.start();
		/* </start-processing-units> */
	}


	
	
	public void pushT1Task(AsyncTask task) {
		t1Unit.pushTask(task);
	}
	
	
	public void pushT2Task(WatchTask task) {
		t2Unit.pushTask(task);
	}
	

	public void pushT3Task(ClockTask task) {
		t3Unit.pushTask(task);
	}
	
	

	/**
	 * 
	 */
	public void stop() {

		
		/* <stop-processing-units> */
		t1Unit.stop();
		t2Unit.stop();
		/* </stop-processing-units> */
	}


	public static SiliconEngine startBasic() {

		SiliconConfiguration appConfig = new SiliconConfiguration();
		SiliconEngine app = new SiliconEngine(appConfig);
		app.start();
		return app;

	}



}

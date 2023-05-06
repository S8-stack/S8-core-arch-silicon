package com.s8.arch.silicon.async;

public class AsyncSiUnit {


	private final int nThreads;

	/**
	 * 
	 */
	private final AsyncWorker[] workers;

	private final ProfileMapping[] mappings;




	/**
	 * 
	 * @param nThreads
	 * @param capacity
	 */
	public AsyncSiUnit(int nThreads, int capacity, ProfileMapping[] rules) {
		super();
		this.nThreads = nThreads;
		workers = new AsyncWorker[nThreads];

		for(int slot = 0; slot<nThreads; slot++) {
			workers[slot] = new AsyncWorker(slot, capacity);
		}
		
		// set rules
		this.mappings = rules;
	}


	public void start() {
		for(int i=0; i<nThreads; i++) {
			workers[i].start();
		}
	}


	/**
	 * 
	 * @param rules
	 */
	public void setRules(ProfileMapping[] rules) {

		
	}




	/**
	 * 
	 * @param task
	 */
	public void pushTask(AsyncTask task) {
		if(task!=null) {
			MthProfile profile = task.profile();
			int slot = mappings[profile.code].getSlot();
			boolean isTaskAccepted = workers[slot].pushTask(task);	
			if(!isTaskAccepted) {
				throw new RuntimeException("failed to submit task");
			}	
		}
	}


	public void stop() {

		int n = workers.length;
		for(int i=0; i<n; i++) {
			workers[i].stop();
		}
	}
}

package com.s8.arch.silicon.watch;

/**
 * 
 * @author pierreconvert
 *
 */
public class WatchSiUnit {

	public static final int DEFAULT_CAPACITY = 8;


	private final boolean isVerbose;

	private final int nThreads;


	private final WatchWorker[] workers;


	public WatchSiUnit(int nThreads, boolean isVerbose) {
		super();
		this.nThreads = nThreads;
		this.isVerbose = isVerbose;

		workers = new WatchWorker[nThreads];
		for(int i=0; i<nThreads; i++) {
			workers[i] = new WatchWorker(i, isVerbose);
		}
	}




	public void start() {

	}



	public void pushTask(WatchTask task) {

		if(task!=null) {
			if(isVerbose) {
				System.out.println("\t Start looking for workers, for task="+task.describe());
			}
			
			boolean isAccepted = false;
			int i = 0;
			while(!isAccepted && i<nThreads) {
				isAccepted = workers[i++].submit(task);
			}

			if(!isAccepted) {
				throw new RuntimeException("failed to submit task");	
			}
		}
	}

	
	
	/**
	 * 
	 */
	public void stop() {
		for(int i=0; i<nThreads; i++) {
			workers[i].stop();
		}
	}





}

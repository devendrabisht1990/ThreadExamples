package com.dev.example.threadpool;

import java.util.concurrent.*;

/**
 * 
 * @author devendra
 *
 */
public class ThreadPool {
	
	private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();	
	
	private Worker[] workers;
	
	public ThreadPool(int number){
		workers = new Worker[number];
		for(int i=0;i<number;i++){
			workers[i] = new Worker(queue);
			workers[i].start();
		}
	}
	
	public void execute(Runnable task){
		synchronized(queue){
		queue.add(task);
		queue.notifyAll();
		}
		}
}

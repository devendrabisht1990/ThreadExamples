package com.dev.example.threadpool;

import java.util.concurrent.*;

/**
 * 
 * @author devendra
 *
 */
public class Worker extends Thread{
	
	private BlockingQueue<?> queue;
	
	public Worker(BlockingQueue<?> queue){
		this.queue = queue;
	}
	
	public void run(){
		System.out.println("Thread started :"+this.getName());
		while(true){
		synchronized(queue){
			if(queue.isEmpty()){
				try{
				queue.wait();
				}
				catch(InterruptedException e){
					
				}
			}
			else{
				Thread thread = new Thread((Runnable) queue.poll());
				thread.start();
			}
		}
		}
	}
	

}

package com.dev.example.threadpool;

/**
 * Main Class
 * @author devendra
 *
 */
public class Main {

	public static void main(String[] args) {
		ThreadPool executor = new ThreadPool(10);
		
		//100 task 1
		for(int i =0 ; i<100;i++){
		Runnable task = () -> {System.out.println("task 1");};
		executor.execute(task);
		}
		
		//100 task 2
		for(int i =0 ; i<100;i++){
			Runnable task = () -> {System.out.println("task 2");};
			executor.execute(task);
			}

	}

}

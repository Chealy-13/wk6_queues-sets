/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chris.week6ca;


import java.util.LinkedList;

import java.util.NoSuchElementException;



/**
 *
 * @author chris
 */
public class BoundedPriorityQueueSet {

    private int maxSize;
    private LinkedList<Task> taskQueue;
    

    public BoundedPriorityQueueSet() {
        this(10);
    }

    public BoundedPriorityQueueSet(int maxSize) {
        this.maxSize = maxSize;
        taskQueue = new LinkedList<>();
        
    }

    public int size() {
        return taskQueue.size();
    }

    public boolean isEmpty() {
        return taskQueue.isEmpty();
    }

    public boolean isFull() {
        return taskQueue.size() >= maxSize;
    }

    public int add(Task task) {
        if (taskQueue.contains(task)) {
            throw new DuplicateElementException();
        }

        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }

        int position = 0;
        for (Task t : taskQueue) {
            if (task.compareTo(t) < 0) {
                taskQueue.add(position, task);
                return position;
            }
            position++;
        }


        taskQueue.add(task);
        return position;
    }
    
    public Task peek() {
        if (taskQueue.isEmpty()) {
            throw new NoSuchElementException();
        }
        return taskQueue.get(0);  
    }
    
    public Task remove() {
        if (taskQueue.isEmpty()) {
            throw new NoSuchElementException();
        }
        return taskQueue.removeFirst();  
    }
    
}

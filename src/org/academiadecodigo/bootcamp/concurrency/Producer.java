package org.academiadecodigo.bootcamp.concurrency;

import org.academiadecodigo.bootcamp.concurrency.bqueue.BQueue;

/**
 * Produces and stores integers into a blocking queue
 */
public class Producer implements Runnable {

    private final BQueue<Integer> queue;
    private int elementNum;

    /**
     * @param queue      the blocking queue to add elements to
     * @param elementNum the number of elements to produce
     */
    public Producer(BQueue queue, int elementNum) {
        this.queue = queue;
        this.elementNum = elementNum;
    }

    @Override
    public void run() {
        for (int i = 0; i < elementNum; i++) {
            synchronized (queue) {
                try {
                    queue.offer(i);

            } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ": made a product");
                if( queue.getSize() == queue.getLimit())
                    System.out.println("queue is full, wait for someone to consume");
                }

            }

        }
    }

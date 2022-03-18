package com.company;

import java.util.ArrayList;

public class Generator extends Thread {
    private volatile ArrayList<Integer> buffer = new ArrayList();

    public Generator() {
    }

    public ArrayList<Integer> getBuffer() {
        return this.buffer;
    }

    public void run() {
        int count=0;
        while(count < 800) {
            synchronized(this.buffer) {
                while(this.buffer.size() == 4) {
                    try {
                        this.buffer.wait();
                    } catch (InterruptedException var8) {
                        var8.printStackTrace();
                    }
                }
                int result =(int) (Math.random() * 8);
                this.buffer.add(result);
                System.out.println("Первый поток. Число № " + (count+1) + " значение: " + result);
                ++count;
                this.buffer.notifyAll();
            }
        }

    }
}


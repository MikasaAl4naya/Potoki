package com.company;

import java.util.ArrayList;

public class NotGenerator extends Thread{
    private volatile ArrayList<Integer> buffer;

    public NotGenerator(Generator generator) {
        this.buffer = generator.getBuffer();
    }


    public void run() {
        int count = 0;

        while(count < 800) {
            synchronized(this.buffer) {
                    while(this.buffer.isEmpty()) {
                        try {
                            this.buffer.wait();
                        } catch (InterruptedException var10) {
                            var10.printStackTrace();
                        }
                    }
                    int num = (Integer)this.buffer.get(0);
                    this.buffer.remove(0);
                    String result1 = Integer.toBinaryString(num);
                    System.out.println("Второй поток. Число № " + (count+1) + " значение: " + result1);
                    ++count;
                    this.buffer.notifyAll();

            }
        }

    }
}

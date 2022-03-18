package com.company;

public class Main {
    public Main(){

    }
    public static void main(String[] args) throws InterruptedException {
        Generator generator= new Generator();
        NotGenerator ng = new NotGenerator(generator);
        generator.start();
        ng.start();
    }

}
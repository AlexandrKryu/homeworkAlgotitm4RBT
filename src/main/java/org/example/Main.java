package org.example;

import java.util.*;

class Main {
    public static final int ADD_COUNT = 100;
    public static final int SEARCH_COUNT = 10;
    public static final int MAX = 2147483647;

    public static void main(String[] args) {
        Random prn = new Random(System.nanoTime());
        long initialTime = 0, startTime = 0, avgTime = 0, totalTime = 0;
        RBTree t = null, rbt = new RBTree();
        RBNode foundNode = null;
        int i, fromKey, searchKey;

        startTime = avgTime = 0;
        initialTime = System.nanoTime();
        System.out.println("\n*** Вставка " + ADD_COUNT + " Узел ***\n");
        for (i = 0; i < ADD_COUNT; i++) {
            startTime = System.nanoTime();
            rbt.add(prn.nextInt(MAX));
            avgTime += System.nanoTime() - startTime;
        }
        System.out.println("Среднее время (ns): " + avgTime / ADD_COUNT);
        System.out.printf("Среднее (s): %.10f\n", (avgTime / ADD_COUNT / 10e9));
        System.out.println("-------------------------------------------------");

        startTime = avgTime = 0;
        fromKey = 1_000_000;
        System.out.println("\n*** Поиск следующих 50 узлов " + fromKey + " ***\n");
        startTime = System.nanoTime();
        t = rbt.find50(fromKey);
        avgTime += System.nanoTime() - startTime;
        System.out.println("Среднее время поиска по до 50 узла (ns): " + avgTime / ADD_COUNT);
        System.out.printf("Среднее время поиска до 50 узла: %.10f\n", (avgTime / ADD_COUNT / 10e9));
        //t.graph();
        System.out.println("-------------------------------------------------");

        startTime = avgTime = 0;
        System.out.println("\n*** Поиск в " + SEARCH_COUNT + " узлах ***\n");
        for (i = 0; i < SEARCH_COUNT; i++) {
            searchKey = prn.nextInt(MAX);
            System.out.println("Поиск " + searchKey);
            startTime = System.nanoTime();
            foundNode = rbt.find(searchKey);
            avgTime += System.nanoTime() - startTime;
            System.out.println(foundNode.key == searchKey ? "* Найден " + searchKey : "# "
                    + searchKey + " не найден");
            System.out.println();
        }
        System.out.println("Среднее время (ns): " + avgTime / ADD_COUNT);
        System.out.printf("Среднее время (s): %.10f\n", (avgTime / ADD_COUNT / 10e9));
        System.out.println("-------------------------------------------------");

        totalTime = System.nanoTime() - initialTime;
        System.out.println();
        System.out.println("Общее время (ns): " + totalTime);
        System.out.println("Общее время (s): " + (totalTime / 10e9));
    }
}
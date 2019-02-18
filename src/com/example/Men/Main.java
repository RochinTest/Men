//3). В кругу стоят N человек, пронумерованных от 1 до N. При ведении
// счета по кругу вычеркивается каждый второй человек, пока не останется один.
// Составить две программы, моделирующие процесс. Одна из программ должна
// использовать класс ArrayList, а вторая - LinkedList.
package com.example.Men;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Men> personMenL = new ArrayList<>();
        List<Men> personMenA = new LinkedList<>();
        makeMen(personMenA, personMenL);
        show(personMenA);
        circleMen(personMenA, personMenL);
    }

    private static List<Men> makeMen(List<Men> personMenA, List<Men> personMenL) {
        int n;
        System.out.println("Введите количество людей в кругу");
        n = input();
        for (int i = 0; i < n; i++) {
            personMenA.add(new Men(i));
            personMenL.add(new Men(i));
        }
        return personMenA;
    }

    private static int input() {
        int n2 = 0;
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            n2 = sc.nextInt();
        }
        return n2;
    }

    private static void circleMen(List<Men> personMenA, List<Men> personMenL) {
        int n = 0;
        do {
            if (n % 2 == 0) {
                personMenA.remove(n);
                personMenL.remove(n);
            }
            n++;
            if (n >= personMenA.size()) {
                n = 0;
            }
        } while (personMenA.size() >= 2);

        System.out.println(personMenA + " " + personMenL);
    }

    private static void show(List<Men> personMenA) {
        System.out.println(personMenA);
    }
}

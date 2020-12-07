package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("단어 하나 입력");
        String str= sc.next();

        System.out.println("-100~100  값 하나 입력");
        int i = sc.nextInt();

        System.out.println("우측으로 갈지 좌측으로 갈지 L,R");
        String hand=sc.next();

        Step_1 step_1=new Step_1();
        step_1.calc(str,i,hand);

    }
}

package com.company;

import java.util.Scanner;

public class Step_2 {
    private String [][]cube={{"R","R","W"},{"G","C","W"},{"G","B","B"}};


    public void startGame(){
        Scanner sc=new Scanner(System.in);

        print(' ');
        while (true){
            System.out.print("CUBE>");
            String commend=sc.nextLine();
            commend=commend.replace("U'","u").replace("R'","r")
                    .replace("L'","l").replace("B'","b");
            //'는 자르기 힘드니까 바꿔서 계산하기

            char[] chars=commend.toCharArray();
            int result = commandSwitch(chars); //리턴값이 -1이면 끝
            if (result==-1){
                break;
            }
        }
    }
}

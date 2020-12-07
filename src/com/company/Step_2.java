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

    private void print(char c){
        String str=c+"";
        str=str.replace("u","U'").replace("r","R'")
                .replace("l","L'").replace("b","B'");
        System.out.println(str);
        for (int i = 0; i < cube.length; i++) {
            for (int j=0;j<cube[0].length;j++){
                System.out.print(cube[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    private int commandSwitch(char[]chars){
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]){
                case 'U':
                    U(cube);
                    print(chars[i]);
                    break;
                case 'u':
                    UComa(cube);
                    print(chars[i]);
                    break;
                case 'R':
                    R(cube);
                    print(chars[i]);
                    break;
                case 'r':
                    RComa(cube);
                    print(chars[i]);
                    break;
                case 'L':
                    L(cube);
                    print(chars[i]);
                    break;
                case 'l':
                    LComa(cube);
                    print(chars[i]);
                    break;
                case 'B':
                    B(cube);
                    print(chars[i]);
                    break;
                case 'b':
                    BComa(cube);
                    print(chars[i]);
                    break;
                default:
                    System.out.println("Bye~");
                    return -1;

            }
        }
        return 0;
    }
}

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

    private void print(char c,String[][]rocalArr){
        String str=c+"";
        str=str.replace("u","U'").replace("r","R'")
                .replace("l","L'").replace("b","B'");
        System.out.println(str);
        for (int i = 0; i < rocalArr.length; i++) {
            for (int j=0;j<rocalArr[0].length;j++){
                System.out.print(rocalArr[i][j]+" ");
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
    private void U(String[][] cube){
        //가장 윗줄을 왼쪽으로 한 칸 밀기 RRW -> RWR
        String save1=cube[0][0];
        String save2=cube[0][1];
        String save3=cube[0][2];

        cube[0][0]=save2;
        cube[0][1]=save3;
        cube[0][2]=save1;
    }
    private void UComa(String[][] cube){
        //가장 윗줄을 오른쪽으로 한 칸 밀기 RRW -> WRR
        String save1=cube[0][0];
        String save2=cube[0][1];
        String save3=cube[0][2];

        cube[0][0]=save3;
        cube[0][1]=save1;
        cube[0][2]=save2;
    }
    private void R(String[][] cube){
        //가장 오른쪽 줄을 위로 한 칸 밀기 WWB -> WBW
        String save1=cube[0][2];
        String save2=cube[1][2];
        String save3=cube[2][2];

        cube[0][2]=save2;
        cube[1][2]=save3;
        cube[2][2]=save1;
    }

    private void RComa(String[][] cube){
        //가장 오른쪽 줄을 아래로 한 칸 밀기 WWB -> BWW
        String save1=cube[0][2];
        String save2=cube[1][2];
        String save3=cube[2][2];

        cube[0][2]=save3;
        cube[1][2]=save1;
        cube[2][2]=save2;
    }
    private void L(String[][] cube){
        //가장 왼쪽 줄을 아래로 한 칸 밀기 RGG -> GRG (L의 경우 R과 방향이 반대임을 주의한다.)
        String save1=cube[0][0];
        String save2=cube[1][0];
        String save3=cube[2][0];

        cube[0][0]=save3;
        cube[1][0]=save1;
        cube[2][0]=save2;
    }
    private void LComa(String[][] cube){
        //가장 왼쪽 줄을 위로 한 칸 밀기 RGG -> GGR
        String save1=cube[0][0];
        String save2=cube[1][0];
        String save3=cube[2][0];

        cube[0][0]=save2;
        cube[1][0]=save3;
        cube[2][0]=save1;
    }
    private void B(String[][] cube){
        //가장 아랫줄을 오른쪽으로 한 칸 밀기 GBB -> BGB (B의 경우도 U와 방향이 반대임을 주의한다.)
        String save1=cube[2][0];
        String save2=cube[2][1];
        String save3=cube[2][2];

        cube[2][0]=save3;
        cube[2][1]=save1;
        cube[2][2]=save2;
    }
    private void BComa(String[][] cube){
        //가장 아랫줄을 왼쪽으로 한 칸 밀기 GBB -> BBG
        String save1=cube[2][0];
        String save2=cube[2][1];
        String save3=cube[2][2];

        cube[2][0]=save2;
        cube[2][1]=save3;
        cube[2][2]=save1;
    }
}

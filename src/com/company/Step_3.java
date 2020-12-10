package com.company;

import java.util.Scanner;

public class Step_3 {
    String [][]FCube={{"1","2","3"},
            {"4","5","6"},
            {"7","8","9"}}; //앞
    String [][]BCube={{"1","2","3"},
            {"4","5","6"},
            {"7","8","9"}};//뒤
    String [][]LCube={{"1","2","3"},
            {"4","5","6"},
            {"7","8","9"}};//좌
    String [][]RCube={{"1","2","3"},
            {"4","5","6"},
            {"7","8","9"}};//우
    String [][]UCube={{"1","2","3"},
            {"4","5","6"},
            {"7","8","9"}};//상
    String [][]DCube={{"1","2","3"},
            {"4","5","6"},
            {"7","8","9"}};//하
    private boolean flag=true;

    public void startGame(){
        Scanner sc=new Scanner(System.in);
        print(' ');

        while (flag){
            System.out.print("CUBE>");
            String commend=sc.nextLine();
            commend=replaceCommend(commend);

            char[] chars=commend.toCharArray();
            commandSwitch(chars);

        }
    }
    private void commandSwitch(char[]chars){

        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]){
                case 'U':
                    U();
                    print(chars[i]);
                    break;
                case 'u':
                    UComma();
                    print(chars[i]);
                    break;
                case 'R':
                    R();
                    print(chars[i]);
                    break;
                case 'r':
                    RComma();
                    print(chars[i]);
                    break;
                case 'L':
                    L();
                    print(chars[i]);
                    break;
                case 'l':
                    LComma();
                    print(chars[i]);
                    break;
                case 'B':
                    B();
                    print(chars[i]);
                    break;
                case 'b':
                    BComma();
                    print(chars[i]);
                    break;
                case 'F':
                    F();
                    print(chars[i]);
                    break;
                case 'f':
                    FComma();
                    print(chars[i]);
                    break;
                case 'D':
                    D();
                    print(chars[i]);
                    break;
                case 'd':
                    DComma();
                    print(chars[i]);
                    break;
                case '2':
                    //숫자 2가 들어왔을떄
                    break;
                default:
                    System.out.println("Bye~");
                    flag=false;
                    break;
            }
        }

    }



    private String replaceCommend(String commend){
        String result=commend.replace("U'","u").replace("R'","r")
                .replace("L'","l").replace("B'","b")
                .replace("F'","f").replace("D'","d");
        //'는 자르기 힘드니까 바꿔서 계산하기
        return result;
    }


    private String replaceCommendChar(char c){
        //원복
        String str=c+""; 
        String result=str.replace("u","U'").replace("r","R'")
                .replace("l","L'").replace("b","B'")
                .replace("f","F'").replace("d","D'");
        return result;
    }
    private void printsolo(String[][]cube){
        for (int i = 0; i < cube.length; i++) {
            System.out.print("\t"+"\t");
            for (int j = 0; j < cube[0].length; j++) {
                System.out.print(cube[i][j]);
            }
            System.out.println(" ");
        }
    }
    public void print(char c){
        String str = replaceCommendChar(c); //글자 하나씩 출력
        System.out.println("\n"+str);
        printsolo(UCube);
        for (int i = 0; i < UCube.length; i++) {
            StringBuilder str1=new StringBuilder();
            StringBuilder str2=new StringBuilder();
            StringBuilder str3=new StringBuilder();
            StringBuilder str4=new StringBuilder();
            for (int j = 0; j < UCube[0].length; j++) {
                str1.append(LCube[i][j]);
                str2.append(FCube[i][j]);
                str3.append(RCube[i][j]);
                str4.append(BCube[i][j]);
            }
            System.out.print(str1+"\t"+str2+"\t"+str3+"\t"+str4+"\t"+"\n");
        }
        printsolo(DCube);
    }
    public void U(){
        String []temp={BCube[0][0],BCube[0][1],BCube[0][2]};//입력이 U일때
        BCube[0][0]=LCube[0][0];//옆면들 옮기기 시작
        BCube[0][1]=LCube[0][1];
        BCube[0][2]=LCube[0][2];

        LCube[0][0]=FCube[0][0];
        LCube[0][1]=FCube[0][1];
        LCube[0][2]=FCube[0][2];

        FCube[0][0]=RCube[0][0];
        FCube[0][1]=RCube[0][1];
        FCube[0][2]=RCube[0][2];

        RCube[0][0]=temp[0];
        RCube[0][1]=temp[1];
        RCube[0][2]=temp[2];
        UCube=turnClock(UCube);//이제 평면 부분 돌기
    }

    public void L(){
        String []temp={UCube[0][0],UCube[1][0],UCube[2][0]};//입력이 L일때
        UCube[2][0]=BCube[0][2];//옆면들 옮기기 시작
        UCube[1][0]=BCube[1][2];
        UCube[0][0]=BCube[2][2];

        BCube[0][2]=DCube[2][0];
        BCube[1][2]=DCube[1][0];
        BCube[2][2]=DCube[0][0];

        DCube[2][0]=FCube[2][0];
        DCube[1][0]=FCube[1][0];
        DCube[0][0]=FCube[0][0];

        FCube[0][0]=temp[0];
        FCube[1][0]=temp[1];
        FCube[2][0]=temp[2];
        LCube=turnClock(LCube);//이제 평면 부분 돌기
    }
    public void R(){
        String []temp={UCube[0][2],UCube[1][2],UCube[2][2]};//입력이 R일때
        UCube[0][2]=FCube[0][2];//옆면들 옮기기 시작
        UCube[1][2]=FCube[1][2];
        UCube[2][2]=FCube[2][2];

        FCube[0][2]=DCube[0][2];
        FCube[1][2]=DCube[1][2];
        FCube[2][2]=DCube[2][2];

        DCube[0][2]=BCube[2][0];
        DCube[1][2]=BCube[1][0];
        DCube[2][2]=BCube[0][0];

        BCube[2][0]=temp[0];
        BCube[1][0]=temp[1];
        BCube[0][0]=temp[2];
        RCube=turnClock(RCube);//이제 평면 부분 돌기
    }

    public void B(){
        String []temp={UCube[0][0],UCube[0][1],UCube[0][2]};//입력이 B일때
        UCube[0][0]=RCube[0][2];//옆면들 옮기기 시작
        UCube[0][1]=RCube[1][2];
        UCube[0][2]=RCube[2][2];

        RCube[0][2]=DCube[2][2];
        RCube[1][2]=DCube[2][1];
        RCube[2][2]=DCube[2][0];

        DCube[2][2]=LCube[2][0];
        DCube[2][1]=LCube[1][0];
        DCube[2][0]=LCube[0][0];

        LCube[2][0]=temp[0];
        LCube[1][0]=temp[1];
        LCube[0][0]=temp[2];
        BCube=turnClock(BCube);//이제 평면 부분 돌기
    }

    public void D(){
        String []temp={FCube[2][0],FCube[2][1],FCube[2][2]};//입력이 D일때
        FCube[2][2]=LCube[2][2];//옆면들 옮기기 시작
        FCube[2][1]=LCube[2][1];
        FCube[2][0]=LCube[2][0];

        LCube[2][2]=BCube[2][2];
        LCube[2][1]=BCube[2][1];
        LCube[2][0]=BCube[2][0];

        BCube[2][2]=RCube[2][2];
        BCube[2][1]=RCube[2][1];
        BCube[2][0]=RCube[2][0];

        RCube[2][2]=temp[2];
        RCube[2][1]=temp[1];
        RCube[2][0]=temp[0];
        DCube=turnClock(DCube);//이제 평면 부분 돌기
    }
    public void F(){
        String []temp={UCube[2][0],UCube[2][1],UCube[2][2]};//입력이 F일때
        UCube[2][0]=LCube[2][2];//옆면들 옮기기 시작
        UCube[2][1]=LCube[1][2];
        UCube[2][2]=LCube[0][2];

        LCube[0][2]=DCube[0][0];
        LCube[1][2]=DCube[0][1];
        LCube[2][2]=DCube[0][2];

        DCube[0][0]=RCube[2][0];
        DCube[0][1]=RCube[1][0];
        DCube[0][2]=RCube[0][0];

        RCube[0][0]=temp[0];
        RCube[1][0]=temp[1];
        RCube[2][0]=temp[2];
        FCube=turnClock(FCube);//이제 평면 부분 돌기

    }
    private void UComma(){
        String []temp={BCube[0][0],BCube[0][1],BCube[0][2]};//입력이 U일때
        BCube[0][0]=RCube[0][0];//옆면들 옮기기 시작
        BCube[0][1]=RCube[0][1];
        BCube[0][2]=RCube[0][2];

        RCube[0][0]=FCube[0][0];
        RCube[0][1]=FCube[0][1];
        RCube[0][2]=FCube[0][2];

        FCube[0][0]=LCube[0][0];
        FCube[0][1]=LCube[0][1];
        FCube[0][2]=LCube[0][2];

        LCube[0][0]=temp[0];
        LCube[0][1]=temp[1];
        LCube[0][2]=temp[2];
        UCube=turnAnticlockwise(UCube);//이제 평면 부분 반시계로돌기
    }
    private void LComma(){
        String []temp={UCube[0][0],UCube[1][0],UCube[2][0]};//입력이 L일때
        UCube[2][0]=FCube[2][0];//옆면들 옮기기 시작
        UCube[1][0]=FCube[1][0];
        UCube[0][0]=FCube[0][0];

        FCube[2][0]=DCube[2][0];
        FCube[1][0]=DCube[1][0];
        FCube[0][0]=DCube[0][0];

        DCube[2][0]=BCube[0][2];
        DCube[1][0]=BCube[1][2];
        DCube[0][0]=BCube[2][2];

        BCube[2][2]=temp[0];
        BCube[1][2]=temp[1];
        BCube[0][2]=temp[2];
        LCube=turnAnticlockwise(LCube);//이제 평면 부분 반시계로돌기
    }

    private String[][] turnAnticlockwise(String[][] cube) {
        //반시계 방향으로 턴
        String[][]rocalCube=new String[3][3];

        rocalCube[2][0]=cube[0][0];
        rocalCube[1][0]=cube[0][1];
        rocalCube[0][0]=cube[0][2];

        rocalCube[2][1]=cube[1][0];
        rocalCube[1][1]=cube[1][1];
        rocalCube[0][1]=cube[1][2];

        rocalCube[2][2]=cube[2][0];
        rocalCube[1][2]=cube[2][1];
        rocalCube[0][2]=cube[2][2];

        return rocalCube;
    }

    public String[][] turnClock(String[][]cube){
        //시계 방향으로 턴
        String[][]rocalCube=new String[3][3];

        rocalCube[0][2]=cube[0][0];
        rocalCube[1][2]=cube[0][1];
        rocalCube[2][2]=cube[0][2];

        rocalCube[0][1]=cube[1][0];
        rocalCube[1][1]=cube[1][1];
        rocalCube[2][1]=cube[1][2];

        rocalCube[0][0]=cube[2][0];
        rocalCube[1][0]=cube[2][1];
        rocalCube[2][0]=cube[2][2];

        return rocalCube;

    }

}

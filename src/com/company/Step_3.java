package com.company;

import java.util.Scanner;

public class Step_3 {
    String [][]FCube={{"O","O","O"},
            {"O","O","O"},
            {"O","O","O"}}; //앞
    String [][]BCube={{"Y","Y","Y"},
            {"Y","Y","Y"},
            {"Y","Y","Y"}};//뒤
    String [][]LCube={{"W","W","W"},
            {"W","W","W"},
            {"W","W","W"}};//좌
    String [][]RCube={{"G","G","G"},
            {"G","G","G"},
            {"G","G","G"}};//우
    String [][]UCube={{"B","B","B"},
            {"B","B","B"},
            {"B","B","B"}};//상
    String [][]DCube={{"R","R","R"},
            {"R","R","R"},
            {"R","R","R"}};//하
    private boolean flag=true;
    private int count=0;
    private Long startTime=0L;
    private Long endTime=0L;

    public void startGame(){
        Scanner sc=new Scanner(System.in);
        print(' ');
        getStartTime();// 처음 시간 측정
        while (flag){
            System.out.print("CUBE>");
            String commend=sc.nextLine();
            commend=replaceCommend(commend);

            char[] chars=commend.toCharArray();
            commandSwitch(chars); 
            if(count>0){ //다 돌고 와서 맞는지 검사 맞으면  함수 내에서 게임 종료
                checkCube();
            }
        }
        endGame();//끝나면
    }
    private void commandSwitch(char[]chars){

        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]){
                case 'U':
                    U();
                    ++count;
                    print(chars[i]);
                    break;
                case 'u':
                    UComma();
                    ++count;
                    print(chars[i]);
                    break;
                case 'R':
                    R();
                    ++count;
                    print(chars[i]);
                    break;
                case 'r':
                    RComma();
                    ++count;
                    print(chars[i]);
                    break;
                case 'L':
                    L();
                    ++count;
                    print(chars[i]);
                    break;
                case 'l':
                    LComma();
                    ++count;
                    print(chars[i]);
                    break;
                case 'B':
                    B();
                    ++count;
                    print(chars[i]);
                    break;
                case 'b':
                    BComma();
                    ++count;
                    print(chars[i]);
                    break;
                case 'F':
                    F();
                    ++count;
                    print(chars[i]);
                    break;
                case 'f':
                    FComma();
                    ++count;
                    print(chars[i]);
                    break;
                case 'D':
                    D();
                    ++count;
                    print(chars[i]);
                    break;
                case 'd':
                    DComma();
                    ++count;
                    print(chars[i]);
                    break;
                case '2':
                    //숫자 2가 들어왔을떄 앞의 글자를 한번 더 실행
                    commandSwitch(new char[]{chars[i-1]});
                    break;
                case 'T'://Ten의 T를 입력하면 10번 섞음
                    random();
                    break;
                default:
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
        //원복 //print에서 사용
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
    private void print(char c){
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
            System.out.print(str1+"\t"+str2+"\t"+"\t"+str3+"\t"+str4+"\t"+"\n");
        }
        printsolo(DCube);
    }
    private void U(){
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

    private void L(){
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
    private void R(){
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

    private void B(){
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

    private void D(){
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
    private void F(){
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
    private void RComma(){
        String []temp={UCube[0][2],UCube[1][2],UCube[2][2]};//입력이 R일때
        UCube[0][2]=BCube[2][0];//옆면들 옮기기 시작
        UCube[1][2]=BCube[1][0];
        UCube[2][2]=BCube[0][0];

        BCube[0][0]=DCube[2][2];
        BCube[1][0]=DCube[1][2];
        BCube[2][0]=DCube[0][2];

        DCube[2][2]=FCube[2][2];
        DCube[1][2]=FCube[1][2];
        DCube[0][2]=FCube[0][2];

        FCube[2][2]=temp[2];
        FCube[1][2]=temp[1];
        FCube[0][2]=temp[0];
        RCube=turnAnticlockwise(RCube);//이제 평면 부분 반시계로돌기
    }
    private void BComma(){
        String []temp={UCube[0][0],UCube[0][1],UCube[0][2]};//입력이 B일때
        UCube[0][0]=LCube[2][0];//옆면들 옮기기 시작
        UCube[0][1]=LCube[1][0];
        UCube[0][2]=LCube[0][0];

        LCube[0][0]=DCube[2][0];
        LCube[1][0]=DCube[2][1];
        LCube[2][0]=DCube[2][2];

        DCube[2][2]=RCube[0][2];
        DCube[2][1]=RCube[1][2];
        DCube[2][0]=RCube[2][2];

        RCube[0][2]=temp[0];
        RCube[1][2]=temp[1];
        RCube[2][2]=temp[2];
        BCube=turnAnticlockwise(BCube);//이제 평면 부분 반시계로돌기
    }
    private void DComma(){
        String []temp={FCube[2][0],FCube[2][1],FCube[2][2]};//입력이 D일때
        FCube[2][2]=RCube[2][2];//옆면들 옮기기 시작
        FCube[2][1]=RCube[2][1];
        FCube[2][0]=RCube[2][0];

        RCube[2][2]=BCube[2][2];
        RCube[2][1]=BCube[2][1];
        RCube[2][0]=BCube[2][0];

        BCube[2][2]=LCube[2][2];
        BCube[2][1]=LCube[2][1];
        BCube[2][0]=LCube[2][0];

        LCube[2][2]=temp[2];
        LCube[2][1]=temp[1];
        LCube[2][0]=temp[0];
        DCube=turnAnticlockwise(DCube);//이제 평면 부분 반시계로돌기
    }

    private void FComma(){
        String []temp={UCube[2][0],UCube[2][1],UCube[2][2]};//입력이 F일때
        UCube[2][0]=RCube[0][0];//옆면들 옮기기 시작
        UCube[2][1]=RCube[1][0];
        UCube[2][2]=RCube[2][0];

        RCube[0][0]=DCube[0][2];
        RCube[1][0]=DCube[0][1];
        RCube[2][0]=DCube[0][0];

        DCube[0][0]=LCube[0][2];
        DCube[0][1]=LCube[1][2];
        DCube[0][2]=LCube[2][2];

        LCube[2][2]=temp[0];
        LCube[1][2]=temp[1];
        LCube[0][2]=temp[2];
        FCube=turnAnticlockwise(FCube);//이제 평면 부분 반시계로돌기
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

    private String[][] turnClock(String[][]cube){
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
    private void endGame(){
        //끝내는 함수 시간의 마지막을 저장하고 조작갯수 찍고 ㅇㅇ
        getEndTime(); //초 찍고
        System.out.println("조작갯수: "+count);
        System.out.println("이용해주셔서 감사합니다. 뚜뚜뚜.");
    }

    //시간을 검사하는 함수 작성
    private void getStartTime(){
        startTime=System.currentTimeMillis();
    }
    private void getEndTime(){
        endTime=System.currentTimeMillis();
        long ingGameTime=(endTime-startTime)/1000; //초
        long m=ingGameTime/60; //초를 분으로
        ingGameTime%=60;//분으로 나누고 나머지를 초로 계산
        System.out.println("경과시간: "+String.format("%02d",m)+":"+String.format("%02d",ingGameTime));

    }
    private void checkCube(){
        //큐브가 다 맞춰졌는지 검사 + 축하메시지와 프로그램 종료
        for (int i = 0; i < FCube.length; i++) {
            for (int j = 0; j < FCube[0].length; j++) {
                if(UCube[i][j]=="B" &&LCube[i][j]=="W" &&FCube[i][j]=="O"
                        &&RCube[i][j]=="G" &&BCube[i][j]=="Y" &&DCube[i][j]=="R" ){
                    continue;
                }
                return;
            }
        }
        //여기까지 온거면 다 맞다
        //축하메시지
        System.out.println("다 맞췄어요!");
        flag=false; //끝내기
    }
    private void random(){
        //무작위로 섞기 10번
        StringBuilder stringBuilder=new StringBuilder();
        String[] chars={"U","L","F","R","B","D","U'","L'","F'","R'","B'","D'"};
        for (int i = 0; i < 10; i++) {
            String c=chars[(int)(Math.random()*11)];
            stringBuilder.append(c);
        }
        String returnStr = replaceCommend(stringBuilder.toString()); //바뀌어온 글자들
        commandSwitch(returnStr.toCharArray()); //커맨드실행
    }
}

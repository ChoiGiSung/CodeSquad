package com.company;

import java.util.Scanner;

public class Step_1 {

    //호출 메서드
    public void input(){
        Scanner sc=new Scanner(System.in);

        System.out.println("단어 하나 입력");
        String str= sc.next();

        System.out.println("-100~100  값 하나 입력");
        int i = sc.nextInt();

        System.out.println("우측으로 갈지 좌측으로 갈지 L,R");
        String hand=sc.next();

        calc(str,i,hand);
    }

    private void calc(String str,int data,String RL){
        char hand = Character.toUpperCase(RL.charAt(0));
        if(hand=='R'){
            Right(str,data);
        }else if(hand=='L'){
            Left(str,data);
        }else {
            System.out.println("값을 다시 입력하세요");
        }
    }

    private void Left(String str,int data){
        //L이면 - 기호
        int appendData = data*-1;
        char[] chars = str.toCharArray();

        int[] index = FillIndex(appendData, new int[str.length()]);
        //인덱스를 배열에 담기

        printStr(chars,index);
        //그리기
    }

    private void Right(String str,int data){
        //R이면 + 기호
        int appendData = data;
        char[] chars = str.toCharArray();

        int[] index = FillIndex(appendData, new int[str.length()]);
        //인덱스를 배열에 담기

        printStr(chars,index);
    }

    private int [] FillIndex(int plusminus,int index[]){
        for (int i = 0; i < index.length; i++) {
            //인덱스 배열에 움직일 배열 인덱스를 계산해서 넣기
            int indexIndex=i+plusminus;

            if(indexIndex<0){

                //인덱스값이 0보다 아래면 0이상으로 만들기
                while (indexIndex<0){
                    indexIndex+=index.length;
                }
                index[i] =indexIndex;

            }else if (indexIndex>=index.length){
                //인덱스 값이 str길이보다 크면 str길이 이하로 줄이기
                while (indexIndex>=index.length){
                    indexIndex%=index.length;
                    //크기가 길이 보다 작아질때 까지
                }
                index[i] = indexIndex;
            }else{
                index[i]=indexIndex;
            }
        }
        return index;
    }
    //출력
    private void printStr(char []chars,int []index){
        StringBuilder stringBuilder=new StringBuilder();
        char[] result=new char[chars.length];

        for (int i = 0; i < index.length; i++) {
            char aChar = chars[i];
            result[index[i]]=aChar;

        }

        for (char c : result) {
            stringBuilder.append(c);
        }
        System.out.print(stringBuilder.toString());
    }


}

package com.company;

public class Step_1 {

    //호출 메서드
    public void calc(String str,int data,String RL){
        char hand = Character.toUpperCase(RL.charAt(0));
        if(hand=='R'){
            Right(str,data);
        }else if(hand=='L'){
            Left(str,data);
        }else {
            System.out.println("값을 다시 입력하세요");
        }
    }




}

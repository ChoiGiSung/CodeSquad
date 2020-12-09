package com.company;

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


    public void print(){
        System.out.println("");
        for (int i = 0; i < UCube.length; i++) {
            for (int j = 0; j < UCube[0].length; j++) {
                System.out.print(UCube[i][j]);
            }
            System.out.println(" ");
        }
        for (int i = 0; i < UCube.length; i++) {
            for (int j = 0; j < UCube[0].length; j++) {
                System.out.print(LCube[i][j]);
            }
            System.out.print("\t");
            for (int j = 0; j < UCube[0].length; j++) {
                System.out.print(FCube[i][j]);

            }
            System.out.print("\t");
            for (int j = 0; j < UCube[0].length; j++) {
                System.out.print(RCube[i][j]);

            }
            System.out.print("\t");
            for (int j = 0; j < UCube[0].length; j++) {
                System.out.print(BCube[i][j]);

            }
            System.out.println(" ");
        }

        for (int i = 0; i < UCube.length; i++) {
            for (int j = 0; j < UCube[0].length; j++) {
                System.out.print(DCube[i][j]);
            }
            System.out.println(" ");
        }

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

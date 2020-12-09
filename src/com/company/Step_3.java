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
    public void B(){
        //입력이 B일때
        String []temp={UCube[0][0],UCube[0][1],UCube[0][2]};

        //옆면들 옮기기 시작
        UCube[0][0]=RCube[0][2];
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

        //이제 평면 부분 돌기
        BCube=turnClock(BCube);
    }

    public void D(){
        //입력이 D일때
        String []temp={FCube[2][0],FCube[2][1],FCube[2][2]};

        //옆면들 옮기기 시작
        FCube[2][2]=LCube[2][2];
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

        //이제 평면 부분 돌기
        DCube=turnClock(DCube);
    }
    public void F(){
        //입력이 F일때
        String []temp={UCube[2][0],UCube[2][1],UCube[2][2]};

        //옆면들 옮기기 시작
        UCube[2][0]=LCube[2][2];
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

        //이제 평면 부분 돌기
        FCube=turnClock(FCube);

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

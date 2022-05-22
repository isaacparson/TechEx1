import Creations.Human;

import java.io.*;

public class Solution {

    public static String getResult(String Pole, String Race) {
        int[][] matrixA, matrixB;
        String PoleNum;
        matrixA = new int[4][4];
        matrixB = new int[4][4];
        int stringCount = 0;
        PoleNum = Main.poleNum(Race, Pole);

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                String ch = String.valueOf(PoleNum.charAt(stringCount));
                matrixA[i][j] = Integer.parseInt(ch);
                stringCount++;
            }
        }

        Main.minWay(matrixA, matrixB);
        return Integer.toString(matrixB[3][3]);
    }
}

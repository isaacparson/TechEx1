import Creations.Human;
import Creations.Swamper;
import Creations.Woodman;

import java.io.*;

public class Main {

    //Ввод с клавиатуры
    public static String enter() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    //Замена букв на цифры
    public static String poleNum(String Race, String Pole) {
        String PoleA, PoleB, PoleC, PoleNum = null;
        switch (Race) {
            case  ("Human"):
                PoleA = Pole.replace('S', Human.getS());
                PoleB = PoleA.replace('W', Human.getW());
                PoleC = PoleB.replace('T', Human.getT());
                PoleNum = PoleC.replace('P', Human.getP());
                break;
            case ("Swamper"):
                PoleA = Pole.replace('S', Swamper.getS());
                PoleB = PoleA.replace('W', Swamper.getW());
                PoleC = PoleB.replace('T', Swamper.getT());
                PoleNum = PoleC.replace('P', Swamper.getP());
                break;
            case ("Woodman"):
                PoleA = Pole.replace('S', Woodman.getS());
                PoleB = PoleA.replace('W', Woodman.getW());
                PoleC = PoleB.replace('T', Woodman.getT());
                PoleNum = PoleC.replace('P', Woodman.getP());
                break;
            default:
                break;
        }
        return PoleNum;
    }

    //Нахождение минимального пути в матрице
    public static void minWay(int[][] matrixA, int [][] matrixB) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 0 && j == 0) {
                    matrixB[i][j] = 0;
                } else if (i == 0 && j != 0) {
                    matrixB[i][j] = matrixA[i][j] + matrixB[i][j-1];
                } else if (i != 0 && j == 0) {
                    matrixB[i][j] = matrixA[i][j] + matrixB[i-1][j];
                } else {
                    if (matrixB[i-1][j] < matrixB[i][j-1]) {
                        matrixB[i][j] = matrixA[i][j] + matrixB[i-1][j];
                    } else {
                        matrixB[i][j] = matrixA[i][j] + matrixB[i][j-1];
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.print("Введите поле: ");
        String Pole = enter();
        System.out.print("Введите расу: ");
        String Race = enter();
        System.out.print("Минимальный путь: ");
        System.out.println(Solution.getResult(Pole, Race));
    }
}

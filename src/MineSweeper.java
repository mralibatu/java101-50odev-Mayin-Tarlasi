import java.util.Scanner;

public class MineSweeper {
    int satir;
    int sutun;
    boolean isPatladi = false;
    boolean isWin = false;

    public MineSweeper(int satir, int sutun) {
        this.satir = satir;
        this.sutun = sutun;
    }


    public void Tarama(String[][] mayin, String[][] tarla, int a, int b) {
        int count = 0;
        if ((b - 1 >= 0) && (mayin[a][b - 1]).equals("*")) {
            count++;
        }
        if ((b + 1 < mayin[0].length) && (mayin[a][b + 1]).equals("*")) {
            count++;
        }
        if ((a - 1 >= 0) && (mayin[a - 1][b]).equals("*")) {
            count++;
        }
        if ((a - 1 >= 0) && (b + 1 < mayin[0].length) && (mayin[a - 1][b + 1]).equals("*")) {
            count++;
        }
        if ((a - 1 >= 0) && (b - 1 >= 0) && (mayin[a - 1][b - 1]).equals("*")) {
            count++;
        }
        if ((a + 1 < mayin[0].length) && (mayin[a + 1][b]).equals("*")) {
            count++;
        }

        if ((a + 1 < mayin[0].length) && (b + 1 < mayin[0].length) && (mayin[a + 1][b + 1]).equals("*")) {
            count++;
        }
        if ((a + 1 < mayin[0].length) && (b - 1 >= 0) && (mayin[a + 1][b - 1]).equals("*")) {
            count++;
        }
        if ((mayin[a][b]).equals("*")) {
            isPatladi = true;
        }

        mayin[a][b] = Integer.toString(count);
        Esitleme(mayin, tarla, a, b);
    }

    public void Esitleme(String[][] tara, String[][] tarla, int a, int b) {
        tarla[a][b] = tara[a][b];
    }

    public void Print(String[][] print) {
        for (int i = 0; i < satir; i++) {
            for (int j = 0; j < sutun; j++) {
                System.out.print(print[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public void run() {
        Scanner input = new Scanner(System.in);
        int mayinsayisi = (satir * sutun) / 4;
        String tarla[][] = new String[satir][sutun];
        String[][] mayin = new String[satir][sutun];
        for (int i = 0; i < satir; i++) {
            for (int j = 0; j < sutun; j++) {
                tarla[i][j] = "-";
            }
        }
        for (int i = 0; i < satir; i++) {
            for (int j = 0; j < sutun; j++) {
                mayin[i][j] = "-";
            }
        }
        for (int i = 0; i < mayinsayisi; i++) {
            mayin[(int) (Math.random() * satir)][(int) (Math.random() * sutun)] = "*";
        }
        int count = 0;
        while (!isPatladi) {
            count++;
            Print(tarla);
            System.out.println("Satir ve sutun giriniz : ");
            int ssatir = input.nextInt() - 1;
            int ssutun = input.nextInt() - 1;
            Tarama(mayin, tarla, ssatir, ssutun);
            if (isPatladi) {
                tarla[ssatir][ssutun] = "X";
                System.out.println("GAME OVER!!");
                Print(tarla);
                break;
            }
            if ((satir * sutun) - mayinsayisi == count) {
                System.out.println("KAZANDINIZ!!");
                Print(tarla);
                break;
            }
            System.out.println("==========================================================");
        }
    }
}

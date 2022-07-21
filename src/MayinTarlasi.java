import java.util.Scanner;

public class MayinTarlasi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Mayin Tarlasi'na Hosgeldiniz! \n" +
                "Lutfen tarla olculerini giriniz \n" +
                "==========================================================");

        System.out.print("Satir sayisi giriniz : ");
        int satir = input.nextInt();
        System.out.print("Sutun sayisi giriniz : ");
        int sutun = input.nextInt();
        MineSweeper mineSweeper = new MineSweeper(satir,sutun);
        mineSweeper.run();
    }
}

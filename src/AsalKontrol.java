import java.util.ArrayList;
import java.util.Scanner;

public class AsalKontrol {


    public static void main(String[] args) {
        Prime();
    }

    public static void Prime() {
        Scanner veri = new Scanner(System.in);
        ArrayList<Integer> bolunensayilar = new ArrayList<>();
        System.out.println("\n"+"Enter a number.");
        long sayi = veri.nextLong();
        float kontrol;
        if (sayi <= 0) {
            Cikis("You can only check positive numbers.");
        }
        if (sayi > 1) {
            if (String.valueOf(sayi).length() < 10) {
                if (String.valueOf(sayi).length() > 5)
                    Wait();
                for (int i = 2; i < sayi - 1; i++) {
                    kontrol = (float) sayi / i;
                    String[] nokta = String.valueOf(kontrol).split("\\.");
                    if (nokta[1].equalsIgnoreCase("0")) {
                        bolunensayilar.add(i);
                    }
                }
            } else {
                Cikis("You can check numbers up to 9 digits.");
            }
        } else {
            Cikis("You can only check numbers greater than 1.");
        }
        if (bolunensayilar.isEmpty()) {
            Cikis("\n"+(int) sayi+" is a prime number.");
        } else {
            Cikis("\n"+(int) sayi+" is not prime number.\nAll the factors of "+(int) sayi+": \n"+bolunensayilar);
        }
    }

    public static void Cikis(String mesaj) {
        if (mesaj != null)
            System.out.println(mesaj);
        Prime();
    }

    public static void Wait() {
        System.out.println("\nProcessing...\nJust a moment! Checking number too large.");
    }

}

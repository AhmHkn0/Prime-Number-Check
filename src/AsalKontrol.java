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
        if (sayi <= 1)
            return;
        for (int i = 2; i < sayi - 1; i++) {
            kontrol = (float) sayi / i;
            String[] nokta = String.valueOf(kontrol).split("\\.");
            if (nokta[1].equalsIgnoreCase("0")) {
                bolunensayilar.add(i);
            }
        }
        if (bolunensayilar.isEmpty()) {
            System.out.println((int) sayi+" is a prime number.");
        } else {
            System.out.println((int) sayi+" is not prime number.\nDivisible by: \n"+bolunensayilar);
        }
        Prime();
    }
}

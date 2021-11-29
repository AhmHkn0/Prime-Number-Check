import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AsalKontrol {

    public static void main(String[] args) {
        Menu();
    }

    public static void Menu() {
        Message("\n[1] Prime Number Check\n[2] Perfect Number Check\n[3] Find Prime Numbers (up to 5 digits)\n[4] Find Perfect Numbers (up to 5 digits)");
        Scanner veri = new Scanner(System.in);
        String i = veri.next();
        if (i.equals("1") || i.equals("2") || i.equals("3") || i.equals("4")) {
            if (i.equals("1"))
                Prime();
            if (i.equals("2"))
                PerfectNumber();
            if (i.equals("3"))
                FindPrimeNumbers();
            if (i.equals("4"))
                FindPerfectNumbers();
        } else {
            Cikis("Choose 1 or 2 or 3");
        }
    }


    public static void Prime() {
        Scanner veri = new Scanner(System.in);
        ArrayList<Integer> bolunensayilar = new ArrayList<>();
        Message("\n"+"Enter a number.");
        long sayi = veri.nextLong();
        if (sayi <= 0) {
            Cikis("You can only check positive numbers.");
        }
        if (sayi > 1) {
            if (String.valueOf(sayi).length() < 10) {
                if (String.valueOf(sayi).length() > 5)
                    Wait();
                for (int i = 2; i < sayi; i++) {
                    if (sayi % i == 0) {
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

    public static void PerfectNumber() {
        Scanner veri = new Scanner(System.in);
        ArrayList<Integer> bolunensayilar = new ArrayList<>();
        Message("\n"+"Enter a number.");
        long sayi = veri.nextLong();
        if (sayi <= 0) {
            Cikis("You can only check positive numbers.");
        }
        int kontrol = 0;
        if (sayi > 1) {
            if (String.valueOf(sayi).length() < 10) {
                if (String.valueOf(sayi).length() > 5)
                    Wait();
                for (int i = 1; i < sayi; i++) {
                    if (sayi % i == 0) {
                        kontrol += i;
                        bolunensayilar.add(i);
                    }
                }
            } else {
                Cikis("You can check numbers up to 9 digits.");
            }
        } else {
            Cikis("You can only check numbers greater than 1.");
        }
        if (kontrol == sayi) {
            Cikis("\n"+(int) sayi+" is a Perfect Number.\n"+ Arrays.toString(Arrays.stream(bolunensayilar.toArray()).toArray()).replace(",", " +")+" = "+sayi);
        } else {
            Cikis("\n"+(int) sayi+" is not a Perfect Number.");
        }
    }


    public static void FindPrimeNumbers() {
        ArrayList<Integer> list = new ArrayList<>();
        Wait();
        list.add(2);
        for (int sayi = 2; sayi < 10000; sayi++) {
            boolean check = false;
            for (int i = 2; i < sayi; i++) {
                if (sayi % i == 0) {
                    check = true;
                    break;
                }
            }
            if (!check)
                list.add(sayi);
        }
        Cikis("\nPrime Numbers: "+ Arrays.toString(list.toArray()));
    }

    public static void FindPerfectNumbers() {
        ArrayList<Integer> list = new ArrayList<>();
        Wait();
        for (int sayi = 2; sayi < 10000; sayi++) {
            int kontrol = 0;
            for (int i = 1; i < sayi; i++) {
                if (sayi % i == 0) {
                    kontrol += i;
                }
            }
            if (kontrol == sayi)
                list.add(sayi);
        }
        Cikis("\nPerfect Numbers: "+ Arrays.toString(list.toArray()));
    }

    public static void Cikis(String mesaj) {
        if (mesaj != null)
            System.out.println(mesaj);
        Menu();
    }

    public static void Wait() {
        System.out.println("\nProcessing...\nJust a moment! Checking number too large.");
    }

    public static void Message(String s) {
        System.out.println(s);
    }


}

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GameTebakUrutan {

    // Bubble Sort
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    // Logika Game
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Membuat array acak
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(50) + 1; // Angka acak antara 1 dan 50
        }

        int[] originalArray = array.clone();

        System.out.println("Selamat datang di Game Tebak Urutan!");
        System.out.println("Berikut adalah array acak:");
        System.out.println(Arrays.toString(array));

        System.out.println("Pilih metode pengurutan:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Quick Sort");
        int pilihan = scanner.nextInt();

        switch (pilihan) {
            case 1:
                bubbleSort(array);
                System.out.println("Anda memilih Bubble Sort!");
                break;
            case 2:
                quickSort(array, 0, array.length - 1);
                System.out.println("Anda memilih Quick Sort!");
                break;
            default:
                System.out.println("Pilihan tidak valid! Game berakhir.");
                scanner.close();
                return;
        }

        // Mengacak ulang array asli untuk ditebak
        Random shuffleRandom = new Random();
        for (int i = originalArray.length - 1; i > 0; i--) {
            int j = shuffleRandom.nextInt(i + 1);
            int temp = originalArray[i];
            originalArray[i] = originalArray[j];
            originalArray[j] = temp;
        }

        System.out.println("Sekarang, tebak urutan yang benar!");
        System.out.println("Array acak untuk ditebak: " + Arrays.toString(originalArray));

        // Membaca input tebakan dari pengguna
        int[] tebakanPengguna = new int[array.length];
        System.out.println("Masukkan tebakan Anda (angka dipisahkan dengan spasi):");
        for (int i = 0; i < tebakanPengguna.length; i++) {
            tebakanPengguna[i] = scanner.nextInt();
        }

        if (Arrays.equals(tebakanPengguna, array)) {
            System.out.println("Selamat! Anda berhasil menebak urutan yang benar!");
        } else {
            System.out.println("Sayang sekali! Tebakan Anda salah. Urutan yang benar adalah:");
            System.out.println(Arrays.toString(array));
        }

        scanner.close();
    }
}

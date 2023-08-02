import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan panjang array: ");
        int length = 0;
        if (scanner.hasNextInt()) {
            length = scanner.nextInt();
        } else {
            System.out.println("Masukkan hanya angka sebagai panjang array.");
            return;
        }
        scanner.nextLine();

        int[] arr = new int[length];
        System.out.print("Masukkan elemen array (" + length + " angka dipisahkan spasi): ");
        String input = scanner.nextLine();

        // Menghapus spasi berlebih
        input = input.replaceAll("\\s{2,}", " ");

        String[] elements = input.trim().split(" ");

        if (elements.length != length) {
            System.out.println("Jumlah elemen tidak sesuai dengan panjang array yang ditentukan.");
            return;
        }

        for (int i = 0; i < length; i++) {
            if (!isNumeric(elements[i])) {
                System.out.println("Masukkan hanya angka sebagai elemen array.");
                return;
            }
            arr[i] = Integer.parseInt(elements[i]);
        }

        int unique = countUnique(arr);
        System.out.println("Jumlah pasangan angka unik yang ditemukan: " + unique);
    }

    public static int countUnique(int[] arr) {
        int count = 0;
        Arrays.sort(arr);

        int i = 0;
        while (i < arr.length - 1) {
            if (arr[i] != arr[i + 1]) {
                count++;
            }
            i++;
        }

        return count;
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+");
    }
}

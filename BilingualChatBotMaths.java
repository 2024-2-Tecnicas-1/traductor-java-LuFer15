package bilingualchatbotmaths;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BilingualChatBotMaths {

    
    public static Map<Integer, String> numerosPalabra = new HashMap<>();
    public static Map<Integer, String> numberWord = new HashMap<>();

    static {
        inicializarNumeros();
        inicializarNumbers();
    }

    private static void inicializarNumeros() {
        String[] numeros1 = {"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};
        String[] excepciones = {"diez", "once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete", "dieciocho", "diecinueve"};
        String[] especiales = {"", "", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"};

        for (int i = 0; i <= 9; i++) {
            numerosPalabra.put(i, numeros1[i]);
        }
        for (int i = 10; i <= 19; i++) {
            numerosPalabra.put(i, excepciones[i - 10]);
        }
        for (int i = 20; i <= 29; i++) {
            numerosPalabra.put(i, "veinte" + (i > 20 ? " y " + numeros1[i % 10] : ""));
        }
        for (int i = 30; i <= 99; i += 10) {
            numerosPalabra.put(i, especiales[i / 10]);
        }
        for (int i = 31; i <= 99; i++) {
            if (i % 10 != 0) {
                numerosPalabra.put(i, especiales[i / 10] + " y " + numeros1[i % 10]);
            }
        }
        numerosPalabra.put(100, "cien");
    }
    private static void inicializarNumbers() {
        String[] numbers1 = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] exceptions = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] specials = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        for (int i = 0; i <= 9; i++) {
            numberWord.put(i, numbers1[i]);
        }
        for (int i = 10; i <= 19; i++) {
            numberWord.put(i, exceptions[i - 10]);
        }
        for (int i = 20; i <= 29; i++) {
            numberWord.put(i, "twenty" + (i > 20 ? "-" + numbers1[i % 10] : ""));
        }
        for (int i = 30; i <= 99; i += 10) {
            numberWord.put(i, specials[i / 10]);
        }
        for (int i = 31; i <= 99; i++) {
            if (i % 10 != 0) {
                numberWord.put(i, specials[i / 10] + "-" + numbers1[i % 10]);
            }
        }
        numberWord.put(100, "one hundred");
    }

    public static String numerosPalabras(int numero) {
        return numerosPalabra.getOrDefault(numero, "Número fuera de rango");
    }

    public static String numbersWords(int number) {
        return numberWord.getOrDefault(number, "Number out of range");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        if ((num1 < 0 || num1 > 100) || (num2 < 0 || num2 > 100)) {
            System.out.println("Los números deben estar entre 0 y 100.");
            sc.close();
            return;
        }

        String primeraPalabraEs = numerosPalabras(num1);
        String segundaPalabraEs = numerosPalabras(num2);
        String firstWordEn = numbersWords(num1);
        String secondWordEn = numbersWords(num2);

        int sum = num1 + num2;

        System.out.println("La suma de "+primeraPalabraEs + " más " + segundaPalabraEs + " es " + numerosPalabras(sum));
        System.out.println("The sum of " + firstWordEn + " plus " + secondWordEn + " is " + numbersWords(sum));
        sc.close();
    }
}

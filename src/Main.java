import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception  {

        Calculobus Calculobus = new Calculobus();
        System.out.println("Введите выражение:");
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println(Calculobus.calc(input));

    }
}
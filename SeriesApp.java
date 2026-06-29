import java.util.Scanner;

public class SeriesApp {

    private static Scanner sc = new Scanner(System.in);
    private static Series manager = new Series(sc);

    public static void main(String[] args) {

        System.out.println("=== SERIES MANAGEMENT SYSTEM 2025 ===");

        while (true) {
            menu();
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> manager.add();
                case 2 -> manager.search();
                case 3 -> manager.update();
                case 4 -> manager.delete();
                case 5 -> manager.report();
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void menu() {
        System.out.println("\n1 Add Series");
        System.out.println("2 Search Series");
        System.out.println("3 Update Series");
        System.out.println("4 Delete Series");
        System.out.println("5 Report");
        System.out.println("6 Exit");
        System.out.print("Choice: ");
    }
}

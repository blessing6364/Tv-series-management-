import java.util.ArrayList;
import java.util.Scanner;

public class App {

    // ================= MODEL =================
    static class SeriesModel {
        private String id;
        private String name;
        private int ageRestriction;
        private int episodes;

        public SeriesModel(String id, String name, int ageRestriction, int episodes) {
            this.id = id;
            this.name = name;
            this.ageRestriction = ageRestriction;
            this.episodes = episodes;
        }

        public String getId() { return id; }
        public String getName() { return name; }
        public int getAgeRestriction() { return ageRestriction; }
        public int getEpisodes() { return episodes; }

        public void setName(String name) { this.name = name; }
        public void setAgeRestriction(int ageRestriction) { this.ageRestriction = ageRestriction; }
        public void setEpisodes(int episodes) { this.episodes = episodes; }

        public String toString() {
            return id + " | " + name + " | Age: " + ageRestriction + " | Episodes: " + episodes;
        }
    }

    // ================= SERVICE =================
    static class SeriesService {
        private ArrayList<SeriesModel> list = new ArrayList<>();

        public void add(String id, String name, int age, int episodes) {
            list.add(new SeriesModel(id, name, age, episodes));
            System.out.println("Series added successfully!");
        }

        public void search(String id) {
            for (SeriesModel s : list) {
                if (s.getId().equals(id)) {
                    System.out.println(s);
                    return;
                }
            }
            System.out.println("Series not found.");
        }

        public void update(String id, Scanner sc) {
            for (SeriesModel s : list) {
                if (s.getId().equals(id)) {

                    System.out.print("New name (enter to skip): ");
                    String name = sc.nextLine();
                    if (!name.isEmpty()) s.setName(name);

                    System.out.print("New age (enter to skip): ");
                    String age = sc.nextLine();
                    if (!age.isEmpty()) s.setAgeRestriction(Integer.parseInt(age));

                    System.out.print("New episodes (enter to skip): ");
                    String ep = sc.nextLine();
                    if (!ep.isEmpty()) s.setEpisodes(Integer.parseInt(ep));

                    System.out.println("Updated successfully!");
                    return;
                }
            }
            System.out.println("Series not found.");
        }

        public void delete(String id) {
            boolean removed = list.removeIf(s -> s.getId().equals(id));
            System.out.println(removed ? "Deleted successfully!" : "Series not found.");
        }

        public void report() {
            System.out.println("\n=== SERIES REPORT ===");
            if (list.isEmpty()) {
                System.out.println("No series available.");
                return;
            }
            for (SeriesModel s : list) {
                System.out.println(s);
            }
        }
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SeriesService service = new SeriesService();

        while (true) {

            System.out.println("\n===== TV SERIES MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Series");
            System.out.println("2. Search Series");
            System.out.println("3. Update Series");
            System.out.println("4. Delete Series");
            System.out.println("5. View Report");
            System.out.println("6. Exit");

            System.out.print("Choose option: ");
            String choice = sc.nextLine();

            switch (choice) {

                case "1" -> {
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter age restriction: ");
                    int age = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter episodes: ");
                    int ep = Integer.parseInt(sc.nextLine());

                    service.add(id, name, age, ep);
                }

                case "2" -> {
                    System.out.print("Enter ID: ");
                    service.search(sc.nextLine());
                }

                case "3" -> {
                    System.out.print("Enter ID: ");
                    service.update(sc.nextLine(), sc);
                }

                case "4" -> {
                    System.out.print("Enter ID: ");
                    service.delete(sc.nextLine());
                }

                case "5" -> service.report();

                case "6" -> {
                    System.out.println("Goodbye!");
                    return;
                }

                default -> System.out.println("Invalid option.");
            }
        }
    }
}

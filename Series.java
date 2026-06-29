import java.util.ArrayList;
import java.util.Scanner;

public class Series {
    private ArrayList<SeriesModel> list = new ArrayList<>();
    private Scanner sc;

    public Series(Scanner sc) {
        this.sc = sc;
    }

    public void add() {
        System.out.print("ID: ");
        String id = sc.nextLine();

        if (find(id) != null) {
            System.out.println("Series ID already exists!");
            return;
        }

        System.out.print("Name: ");
        String name = sc.nextLine();

        int age = getInt("Age (2–18): ", 2, 18);
        int eps = getInt("Episodes (>0): ", 1, Integer.MAX_VALUE);

        list.add(new SeriesModel(id, name, age, eps));
        System.out.println("Series added successfully!");
    }

    public void search() {
        System.out.print("Enter ID: ");
        SeriesModel s = find(sc.nextLine());
        System.out.println(s != null ? s : "Series not found.");
    }

    public void update() {
        System.out.print("Enter ID: ");
        SeriesModel s = find(sc.nextLine());

        if (s == null) {
            System.out.println("Not found.");
            return;
        }

        System.out.print("New name (enter to skip): ");
        String name = sc.nextLine();
        if (!name.trim().isEmpty()) s.setSeriesName(name);

        System.out.print("New age (enter to skip): ");
        String ageInput = sc.nextLine();
        if (!ageInput.isEmpty()) s.setSeriesAge(Integer.parseInt(ageInput));

        System.out.print("New episodes (enter to skip): ");
        String epInput = sc.nextLine();
        if (!epInput.isEmpty()) s.setSeriesEpisodes(Integer.parseInt(epInput));

        System.out.println("Updated successfully!");
    }

    public void delete() {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSeriesId().equals(id)) {
                list.remove(i);
                System.out.println("Deleted successfully!");
                return;
            }
        }
        System.out.println("Not found.");
    }

    public void report() {
        if (list.isEmpty()) {
            System.out.println("No series available.");
            return;
        }

        System.out.println("\n=== SERIES REPORT ===");
        for (SeriesModel s : list) {
            System.out.println(s);
            System.out.println("----------------------");
        }
    }

    private SeriesModel find(String id) {
        for (SeriesModel s : list) {
            if (s.getSeriesId().equals(id)) return s;
        }
        return null;
    }

    private int getInt(String msg, int min, int max) {
        int val;
        while (true) {
            try {
                System.out.print(msg);
                val = Integer.parseInt(sc.nextLine());
                if (val >= min && val <= max) return val;
            } catch (Exception e) {}
            System.out.println("Invalid input. Try again.");
        }
    }
}

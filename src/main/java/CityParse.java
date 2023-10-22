import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CityParse {
    public static List<City> parse() {
        List<City> cities = new ArrayList<>();
        try {
            File file = new File("C:\\Users\\nikim\\IdeaProjects\\City\\city.csv");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                cities.add(parse(scanner.nextLine()));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return cities;
    }


    private static City parse(String line) {
        Scanner scanner = new Scanner(line);
        String[] fields = line.split(";", 6);
        if (fields[5].isEmpty()) { // В файле с городами возможно отсутствие данного значения
            fields[5] = null;
        }
        scanner.close();
        return new City(fields[1], fields[2], fields[3], Integer.parseInt(fields[4]), fields[5]);
        // объект City, используя значения полей из строки
    }
}

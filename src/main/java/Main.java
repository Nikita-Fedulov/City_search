import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {

        List<City> cities = CityParse.parse();
       /*  print(cities);
        sortNameCity(cities);
        print(cities);*/
        //print(sortDistrictAndNameCity(cities));
        //searchСityMaxPopulation(cities);
        quantityOfCitiesByRegion(cities);
    }


    //вывод городов из списка
    public static void print(List<City> cities) {
        cities.forEach(System.out::println);
    }

    //Сортировка списка городов по наименованию в алфавитном порядке по убыванию без учета регистра
    private static void sortNameCity(List<City> cities) {
        cities.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
    }

    //Сортировка списка городов по федеральному округу и наименованию города
    //внутри каждого федерального округа в алфавитном порядке по убыванию с учетом регистра;
    private static List<City> sortDistrictAndNameCity(List<City> cities) {
        List<City> sortCitiesDistrictAndName = cities.stream()
                .sorted(Comparator.comparing(City::getName))
                .sorted(Comparator.comparing(City::getDistrict))
                .collect(Collectors.toList());
        return sortCitiesDistrictAndName;
    }

    // Поиск города с наибольшим количеством жителей
    //     Преобразовать список городов в массив
    //     и путем перебора массива найти индекс элемента
    //     и значение с наибольшим количеством жителей города.
    private static void searchСityMaxPopulation(List<City> cities) {
        City[] arr = cities.toArray(new City[0]);
        int max = 0;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getPopulation() > max) {
                max = arr[i].getPopulation();
                index = i;
            }
        }
        System.out.println(index + "=" + max);
    }

    private static void quantityOfCitiesByRegion(List<City> cities) {
        cities.stream()
                .collect(Collectors.groupingBy(
                        City::getRegion, Collectors.counting()))
                .forEach((s, count) -> System.out.println(s + " - " + count));

    }
}

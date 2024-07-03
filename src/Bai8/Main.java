package Bai8;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Country> countryList = new ArrayList<>();
        List<City> cityList = new ArrayList<>();

        try {
            Scanner myReader = new Scanner(new File("countries.dat"));

            while (myReader.hasNextLine())
                countryList.add(new Country(myReader.nextLine()));

            myReader = new Scanner(new File("cities.dat"));

            while (myReader.hasNextLine())
                cityList.add(new City(myReader.nextLine()));

            myReader.close();

        } catch (IOException e) {
            System.out.println("loi doc");

            e.printStackTrace();
        }

        // 1.1
        Map<String, Optional<City>> largestCityByCountry = cityList.stream()
                .collect(Collectors.groupingBy(City::getCountryCode,
                        Collectors.maxBy(Comparator.comparing(City::getPopulation))));

        // 1.2
        Map<String, Optional<City>> largestCityByContinent = cityList.stream()
                .collect(Collectors.groupingBy(
                        city -> Country.getCountryByCode(countryList, city.getCountryCode()).getContinent(),
                        Collectors.maxBy(Comparator.comparingInt(City::getPopulation))
                ));

        // 1.3
        Optional<City> largestCapitalCity = cityList.stream()
                .filter(city -> city.getId() == Country.getCountryByCode(countryList, city.getCountryCode()).getCapital())
                .max(Comparator.comparingInt(City::getPopulation));

        // 1.4
        Map<String, Optional<City>> largestCapitalCityByContinent = cityList.stream()
                .filter(city -> city.getId() == Country.getCountryByCode(countryList, city.getCountryCode()).getCapital())
                .collect(Collectors.groupingBy(
                        city -> Country.getCountryByCode(countryList, city.getCountryCode()).getContinent(),
                        Collectors.maxBy(Comparator.comparingInt(City::getPopulation))
                ));

        // 1.5
        List<Country> countriesSortedByCities = countryList.stream()
                .sorted(Comparator.comparing(country -> Country.countCities(cityList, country.getCode())))
                .toList()
                .reversed();

        // 1.6
        List<Country> countriesSortedByPopulationDensity = countryList.stream()
                .filter(country -> country.getPopulation() > 0 && country.getSurfaceArea() > 0)
                .sorted(Comparator.comparingDouble(country -> (double) country.getPopulation() / country.getSurfaceArea()))
                .toList()
                .reversed();

        //
        System.out.println("1.1 Thành phố đông dân nhất của mỗi quốc gia:");
        largestCityByCountry.forEach((code, city) -> city.ifPresent(c -> System.out.println(Country.getCountryByCode(countryList, code).getName() + ": " + c.getName() + " (" + c.getPopulation() + " people)")));

        System.out.println("\n1.2 Thành phố đông dân nhất của mỗi lục địa:");
        largestCityByContinent.forEach((continent, city) -> city.ifPresent(c -> System.out.println(continent + ": " + c.getName() + " (" + c.getPopulation() + " people)")));

        System.out.println("\n1.3 Thành phố là thủ đô, đông dân nhất:");
        largestCapitalCity.ifPresent(city -> System.out.println("Thủ đô: " + city.getName() + " (" + city.getPopulation() + " people)"));

        System.out.println("\n1.4 Thành phố là thủ đô, đông dân nhất của mỗi lục địa:");
        largestCapitalCityByContinent.forEach((continent, city) -> city.ifPresent(c -> System.out.println(continent + ": " + c.getName() + " (" + c.getPopulation() + " people)")));

        System.out.println("\n1.5 Quốc gia sắp xếp theo số lượng thành phố giảm dần:");
        countriesSortedByCities.forEach(country -> System.out.println(country.getName() + " - " + Country.countCities(cityList, country.getCode()) + " cities"));

        System.out.println("\n1.6 Quốc gia sắp xếp theo mật độ dân số giảm dần:");
        countriesSortedByPopulationDensity.forEach(country -> {
            double density = (double) country.getPopulation() / country.getSurfaceArea();
            System.out.printf("%s - Population density: %.2f people per sq unit%n", country.getName(), density);
        });
    }
}

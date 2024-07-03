package Bai8;

import java.util.List;
import java.util.StringTokenizer;

public class Country {
    private String code;
    private String name;
    private String continent;
    private double surfaceArea;
    private int population;
    private double gnp;
    private int capital;

    public Country() {

    }

    public Country(String s) {
        StringTokenizer st = new StringTokenizer(s,"=,}");

        st.nextToken(); // Country{code
        String stcode = st.nextToken();

        st.nextToken(); //  name
        String stname = st.nextToken();

        st.nextToken(); //  continent
        String stcontinent = st.nextToken();

        st.nextToken(); //  surfaceArea
        String stsurfaceArea = st.nextToken();

        st.nextToken(); //  population
        String stpopulation = st.nextToken();

        st.nextToken(); //  gnp
        String stgnp = st.nextToken();

        st.nextToken(); //  capital
        String stcapital = st.nextToken();

        code = stcode;
        name = stname;
        continent = stcontinent;
        surfaceArea = Double.parseDouble(stsurfaceArea);
        population = Integer.parseInt(stpopulation);
        gnp = Double.parseDouble(stgnp);
        capital = Integer.parseInt(stcapital);
    }

    public Country(String code, String name, String continent, double surfaceArea, int population, double gnp, int capital) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.surfaceArea = surfaceArea;
        this.population = population;
        this.gnp = gnp;
        this.capital = capital;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getGnp() {
        return gnp;
    }

    public void setGnp(double gnp) {
        this.gnp = gnp;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", surfaceArea=" + surfaceArea +
                ", population=" + population +
                ", gnp=" + gnp +
                ", capital=" + capital +
                '}';
    }

    public static Country getCountryByCode(List<Country> countries, String code) {
        return countries.stream()
                .filter(country -> country.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }

    public static int countCities(List<City> cities, String countryCode) {
        return (int) cities.stream()
                .filter(city -> city.getCountryCode().equals(countryCode))
                .count();
    }
}

package Bai8;

import java.util.StringTokenizer;

public class City {
    private int id;
    private String name;
    private int population;
    private String countryCode;

    public City() {

    }

    public City(String s) {
        StringTokenizer st = new StringTokenizer(s,"=,]");

        st.nextToken(); // City [id
        String stid = st.nextToken();

        st.nextToken(); //  name
        StringBuilder stname = new StringBuilder(st.nextToken());

        String chek = st.nextToken(); //  population

        if(!chek.equals(" population")){
            stname.append(",");
            stname.append(chek);

            st.nextToken(); //  population
        }

        String stpopulation = st.nextToken();

        st.nextToken(); //  countryCode
        String stcountryCode = st.nextToken();

        id = Integer.parseInt(stid);
        name = stname.toString();
        population = Integer.parseInt(stpopulation);
        countryCode = stcountryCode;
    }

    public City(int id, String name, int population, String countryCode) {
        this.id = id;
        this.name = name;
        this.population = population;
        this.countryCode = countryCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}

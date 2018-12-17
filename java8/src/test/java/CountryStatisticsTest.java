import com.edgehoop.java8.Continent;
import com.edgehoop.java8.Country;
import com.edgehoop.java8.CountryStatistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalToIgnoringCase;


public class CountryStatisticsTest {

    private final Country austria = new Country("AUT", "Austria", Continent.EUROPE, 8600000.0);
    private final Country germany = new Country("DEU", "Germany", Continent.EUROPE, 81700000.0);
    private final Country brazil = new Country("BRA", "Brazil", Continent.SOUTH_AMERICA, 207000000.0);
    private final Country unitedKingdom = new Country("GBR", "United Kingdom", Continent.EUROPE, 65100000.0);
    private final Country kenya = new Country("KEN", "Kenya", Continent.AFRICA, 46000000.0);
    private final Country mauritius = new Country("MUS", "Mauritius", Continent.AFRICA, 1260000.0);
    private final Country australia = new Country("AUS", "Australia", Continent.AUSTRALIA, 24770000.0);

    private CountryStatistics countryStatistics = new CountryStatistics();

    @BeforeEach
    void setUp() {
        countryStatistics.addCountry(austria);
        countryStatistics.addCountry(germany);
        countryStatistics.addCountry(brazil);
        countryStatistics.addCountry(unitedKingdom);
        countryStatistics.addCountry(kenya);
        countryStatistics.addCountry(mauritius);
        countryStatistics.addCountry(australia);
    }

    @Test
    public void getCountryWithHighestPopulation() {
        Optional<Country> result = countryStatistics.countryWithHighestPopulation();
        assertThat(result.get().getName(), equalToIgnoringCase("brazil"));
    }

    @Test
    public void getCountriesInEurope() {
        List<String> results = countryStatistics.countriesInEurope();
        assertThat(results.size(), is(3));
        assertThat(results, containsInAnyOrder("Austria", "Germany", "United Kingdom"));
    }

    @Test
    public void getPopulationFilter() {
        List<String> results = countryStatistics.threeCountriesWithPopulationsAbove40000000();
        assertThat(results.size(), is(3));
        assertThat(results, not(containsInAnyOrder("Australia", "Austria")));
    }

    @Test
    public void getCountByContinent() {
        Map<Continent, Long> results = countryStatistics.countByContinent();
        assertThat(results.get(Continent.EUROPE), is(3L));
        assertThat(results.get(Continent.AFRICA), is(2L));
    }

    //Failing test
    //TODO write prod code
    @Test
    public void getCountriesByContinent() {
        Map<Continent, List<String>> results = countryStatistics.countriesByContinent();
        assertThat(results.get(Continent.AFRICA), containsInAnyOrder("Kenya", "Mauritius"));
        assertThat(results.get(Continent.EUROPE), containsInAnyOrder("Austria", "Germany", "United Kingdom"));
    }
}
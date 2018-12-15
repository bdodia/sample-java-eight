package com.edgehoop.java8;

import java.util.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

public class CountryStatistics {

        //Setup sample country data
        List<Country> countries = Arrays.asList(
                new Country("AUT","Austria", Continent.EUROPE, 8600000),
                new Country("DEU", "Germany", Continent.EUROPE, 81700000),
                new Country("BRA","Brazil", Continent.SOUTH_AMERICA, 207000000),
                new Country("GBR","United Kingdom", Continent.EUROPE,65100000),
                new Country("KEN", "Kenya", Continent.AFRICA, 46000000),
                new Country("MUS", "Mauritius", Continent.AFRICA, 1260000),
                new Country("AUS", "Australia", Continent.AUSTRALIA, 24770000)
        );


        //max using comparator
        public Optional<Country> countryWithHighestPopulation() {
                Optional < Country > countryWithHighestPopulation =
                        countries.stream()
                                .max(Comparator.comparing(Country::getPopulation));

                System.out.println("Country with highest population is "+countryWithHighestPopulation);
                return countryWithHighestPopulation;
        }

        //filter, map and collect
        public List<String> countriesInEurope() {
            List<String> countriesInEurope =
                    countries.stream()
                            .filter(c -> c.getContinent() == Continent.EUROPE)
                            .map(Country::getName)
                            .collect(toList());

            System.out.println("Countries in Europe are " + countriesInEurope);
            return countriesInEurope;
        }

        //collect, group by using collector
        public Map<Continent,Long> countByContinent() {
            Map<Continent, Long> countByContinent =
                    countries.stream()
                            .collect(Collectors.groupingBy(Country::getContinent, Collectors.counting()));

            System.out.println("Count by continent" + countByContinent);
            return countByContinent;
        }

        public List<String> threeCountriesWithPopulationsAbove40000000() {
            List<String> threeCountriesWithPopulationsAbove40000000 =
                    countries.stream()
                            .filter(c -> c.getPopulation() > 40000000)
                            .map(Country::getName)
                            .limit(3)
                            .collect(toList());

            System.out.println("3 countries with populations exceeding 40000000" + threeCountriesWithPopulationsAbove40000000);
            return threeCountriesWithPopulationsAbove40000000;
        }

}


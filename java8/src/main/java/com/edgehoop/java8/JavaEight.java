package com.edgehoop.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class JavaEight {
    public static void main(String[] args) {

        //Setup sample country data
        List<Country> countries = Arrays.asList(
                new Country("AUT","Austria", Continent.AUSTRALIA, 24770000),
                new Country("DEU", "Germany", Continent.EUROPE, 81700000),
                new Country("BRA","Brazil", Continent.SOUTH_AMERICA, 207000000),
                new Country("GBR","United Kingdon", Continent.EUROPE,65100000)
        );

        Optional<Country> countryWithHighestPopulation =
                countries.stream()
                         .max(Comparator.comparing(Country::getPopulation));

        System.out.println("Country with highest population is "+countryWithHighestPopulation);

        List<String> countriesInEurope =
                countries.stream()
                         .filter(c -> c.getContinent() == Continent.EUROPE)
                         .map(Country::getName)
                         .collect(toList());

        System.out.println("Countries in Europe are "+countriesInEurope);
    }
}


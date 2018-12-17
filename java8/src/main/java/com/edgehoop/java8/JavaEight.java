package com.edgehoop.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class JavaEight {
    public static void main(String[] args) {

        //Streams Section
        CountryStatistics countryStatistics = new CountryStatistics();

        countryStatistics.addCountry(new Country("AUT","Austria", Continent.EUROPE, 8600000));
        countryStatistics.addCountry(new Country("DEU", "Germany", Continent.EUROPE, 81700000));
        countryStatistics.addCountry(new Country("BRA","Brazil", Continent.SOUTH_AMERICA, 207000000));
        countryStatistics.addCountry(new Country("GBR","United Kingdom", Continent.EUROPE,65100000));
        countryStatistics.addCountry(new Country("KEN", "Kenya", Continent.AFRICA, 46000000));
        countryStatistics.addCountry(new Country("MUS", "Mauritius", Continent.AFRICA, 1260000));
        countryStatistics.addCountry(new Country("AUS", "Australia", Continent.AUSTRALIA, 24770000));

        countryStatistics.countByContinent();
        countryStatistics.countryWithHighestPopulation();
        countryStatistics.countriesInEurope();
        countryStatistics.threeCountriesWithPopulationsAbove40000000();
        countryStatistics.countriesByContinent();

        //Date Time Section
        List<String> letters = new ArrayList<>();
        letters.add("Alpha");
        letters.add("Beta");
        letters.add("Gamma");
        letters.add("Delta");

        Boolean containsZeta = letters.contains("Zeta");

        String removedValue = letters.remove(2);

        System.out.println(letters);
        System.out.println(containsZeta);
        System.out.println(removedValue);

        LocalDate today = LocalDate.now();
        LocalTime todaysTime = LocalTime.of(14,32,45);
        LocalDateTime specificDataTime = LocalDateTime.of(today,todaysTime);

        System.out.println(today);
        System.out.println(todaysTime);
        System.out.println(specificDataTime);

        LocalDate furtureDate = today.plusMonths(4).plusWeeks(2);

        System.out.println(furtureDate);
    }
}


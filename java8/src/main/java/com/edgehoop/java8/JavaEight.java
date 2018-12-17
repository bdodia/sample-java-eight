package com.edgehoop.java8;

public class JavaEight {
    public static void main(String[] args) {

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

    }
}


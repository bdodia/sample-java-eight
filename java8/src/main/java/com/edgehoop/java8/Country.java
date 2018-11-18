package com.edgehoop.java8;

import lombok.Data;


@Data
public class Country {
    private final String country_iso_code;
    private final String name;
    private final Continent continent;
    private final double population;

    @Override
    public String toString() {
        return name;
    }


}

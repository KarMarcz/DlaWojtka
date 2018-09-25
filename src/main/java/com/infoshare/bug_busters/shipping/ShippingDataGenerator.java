package com.infoshare.bug_busters.shipping;


import com.infoshare.bug_busters.random.RandomDataGenerator;

import java.io.IOException;

public class ShippingDataGenerator {

    public static ShippingData prepareShippingData() throws IOException {

        Integer houseNumber = RandomDataGenerator.prepareHouseNumber();
        String streetName = RandomDataGenerator.prepareStreetName();
        String city = RandomDataGenerator.prepareCity() ;
        String postCode = RandomDataGenerator.preparePostCode();
        String country = RandomDataGenerator.prepareCountry();

        return new ShippingData(houseNumber, streetName, city, postCode, country);
    }
}


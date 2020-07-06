package com.challenger.random.service;

import com.challenger.random.AbstractRandomTest;
import com.challenger.random.model.Randomizer;
import org.junit.Test;

import java.util.Locale;
import java.util.Random;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.matchesPattern;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class RandomizerTest extends AbstractRandomTest {

    @Test
    public void testStreetAddressStartsWithNumber() {
        final String streetAddressNumber = randomizer.streetAddress();
        assertThat(streetAddressNumber, matchesPattern("[0-9]+ .+"));
    }

    @Test
    public void testStreetAddressIsANumber() {
        final String streetAddressNumber = randomizer.streetAddressNumber();
        assertThat(streetAddressNumber, matchesPattern("[0-9]+"));
    }

    @Test
    public void testTimeZone() {
        assertThat(randomizer.timeZone(), matchesPattern("[A-Za-z_]+/[A-Za-z_]+[/A-Za-z_]*"));
    }

    @Test
    public void testState() {
        assertThat(randomizer.state(), matchesPattern("[A-Za-z ]+"));
    }

    @Test
    public void testCity() {
        assertThat(randomizer.city(), matchesPattern("[A-Za-z'() ]+"));
    }

    @Test
    public void testCityName() {
        assertThat(randomizer.cityName(), matchesPattern("[A-Za-z'() ]+"));
    }

    @Test
    public void testCountry() {
        assertThat(randomizer.country(), matchesPattern("[A-Za-z\\- &.,'()\\d]+"));
    }

    @Test
    public void testCountryCode() {
        assertThat(randomizer.countryCode(), matchesPattern("[A-Za-z ]+"));
    }

    @Test
    public void testStreetAddressIncludeSecondary() {
        assertNotNull(randomizer.streetAddress(true));
    }

    @Test
    public void testCityWithLocaleFranceAndSeed() {
        long seed = 1L;
        Randomizer firstFaker = new Randomizer(Locale.FRANCE, new Random(seed));
        Randomizer secondFaker = new Randomizer(Locale.FRANCE, new Random(seed));
        assertThat(firstFaker.city(), is(secondFaker.city()));
    }

    @Test
    public void testFullAddress() {
        assertNotNull(randomizer.fullAddress());
    }

    @Test
    public void testZipCodeByState() {
        randomizer = new Randomizer(new Locale("en-US"));
        assertNotNull(randomizer.zipCodeByState(randomizer.stateAbbr()));
    }

    @Test
    public void testHungarianZipCodeByState() {
        randomizer = new Randomizer(new Locale("hu"));
        assertNotNull(randomizer.zipCodeByState(randomizer.stateAbbr()));
    }

    @Test
    public void testStreetPrefix() {
        assertNotNull(randomizer.streetPrefix());
    }
}

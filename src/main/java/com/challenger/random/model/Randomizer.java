package com.challenger.random.model;

import com.challenger.random.service.RandomService;
import com.challenger.random.service.RandomValuesService;

import java.util.Locale;
import java.util.Random;

public class Randomizer {
    private final RandomService randomService;
    private final RandomValuesService randomValuesService;
    private final Name name;

    public Randomizer() {
        this(Locale.ENGLISH);
    }

    public Randomizer(Locale locale) {
        this(locale, null);
    }

    public Randomizer(Random random) {
        this(Locale.ENGLISH, random);
    }
    
    public Randomizer(Locale locale, Random random) {
        randomService = new RandomService(random);
        randomValuesService = new RandomValuesService(locale, randomService);

        this.name = new Name(this);

    }

    /**
     * Constructs Address instance with default argument.
     *
     * @return {@link Randomizer#Randomizer()}
     */
    public static Randomizer instance() {
        return new Randomizer();
    }

    /**
     * Constructs Address instance with provided {@link Locale}.
     *
     * @param locale - {@link Locale}
     * @return {@link Randomizer#Randomizer(Locale)}
     */
    public static Randomizer instance(Locale locale) {
        return new Randomizer(locale);
    }

    /**
     * Constructs Address instance with provided {@link Random}.
     *
     * @param random - {@link Random}
     * @return {@link Randomizer#Randomizer(Random)}
     */
    public static Randomizer instance(Random random) {
        return new Randomizer(random);
    }

    /**
     * Constructs Address instance with provided {@link Locale} and {@link Random}.
     *
     * @param locale - {@link Locale}
     * @param random - {@link Random}
     * @return {@link Randomizer#Randomizer(Locale, Random)}
     */
    public static Randomizer instance(Locale locale, Random random) {
        return new Randomizer(locale, random);
    }

    public RandomService random() {
        return this.randomService;
    }

    public RandomValuesService randomValuesService() {
        return this.randomValuesService;
    }

    public Name name() {
        return name;
    }
    /**
     * Returns a string with the '#' characters in the parameter replaced with random digits between 0-9 inclusive.
     * <p>
     * For example, the string "ABC##EFG" could be replaced with a string like "ABC99EFG".
     *
     * @param numberString
     * @return
     */
    public String numerify(String numberString) {
        return randomValuesService.numerify(numberString);
    }

    /**
     * Applies to {@link #numerify(String)}
     * over the incoming string.
     *
     * @param string
     * @return
     */
    public String bothify(String string) {
        return randomValuesService.bothify(string);
    }

    public String streetName() {
        return randomValuesService.resolve("address.street_name", this, this);
    }

    public String streetAddressNumber() {
        return String.valueOf(random().nextInt(1000));
    }

    public String streetAddress() {
        return randomValuesService.resolve("address.street_address", this, this);
    }

    public String streetAddress(boolean includeSecondary) {
        String streetAddress = randomValuesService.resolve("address.street_address", this, this);
        if (includeSecondary) {
            streetAddress = streetAddress + " " + secondaryAddress();
        }
        return streetAddress;
    }

    public String secondaryAddress() {
        return numerify(randomValuesService.resolve("address.secondary_address", this, this));
    }

    public String zipCode() {
        return bothify(randomValuesService.resolve("address.postcode", this, this));
    }

    public String zipCodeByState(String stateAbbr) {
        return randomValuesService.resolve("address.postcode_by_state." + stateAbbr, this, this);
    }

    public String countyByZipCode(String postCode) {
        return randomValuesService.resolve("address.county_by_postcode." + postCode, this, this);
    }

    public String streetSuffix() {
        return randomValuesService.resolve("address.street_suffix", this, this);
    }

    public String streetPrefix() {
        return randomValuesService.resolve("address.street_prefix", this, this);
    }

    public String citySuffix() {
        return randomValuesService.resolve("address.city_suffix", this, this);
    }

    public String cityPrefix() {
        return randomValuesService.resolve("address.city_prefix", this, this);
    }

    public String city() {
        return randomValuesService.resolve("address.city", this, this);
    }

    public String cityName() {
        return randomValuesService.resolve("address.city_name", this, this);
    }

    public String state() {
        return randomValuesService.resolve("address.state", this, this);
    }

    public String stateAbbr() {
        return randomValuesService.resolve("address.state_abbr", this, this);
    }

    public String latitude() {
        return String.format("%.8g", (random().nextDouble() * 180) - 90);
    }

    public String longitude() {
        return String.format("%.8g", (random().nextDouble() * 360) - 180);
    }

    public String timeZone() {
        return randomValuesService.resolve("address.time_zone", this, this);
    }

    public String country() {
        return randomValuesService.resolve("address.country", this, this);
    }

    public String countryCode() {
        return randomValuesService.resolve("address.country_code", this, this);
    }

    public String buildingNumber() {
        return numerify(randomValuesService.resolve("address.building_number", this, this));
    }

    public String fullAddress() {
        return randomValuesService.resolve("address.full_address", this, this);
    }

}

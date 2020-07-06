package com.challenger.random.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonPropertyOrder({"house", "street", "city", "county", "state", "stateCode", "country", "countryCode", "postalCode"})
public class Address {

    static String house;
    static String street;
    static String postalCode;
    static String city;
    static String county;
    static String state;
    static String stateCode;
    static String country;
    static String countryCode;
    static String fullAddress;

    public Address() {
    }

    public String getHouse() {
        return house;
    }

    public Address setHouse(String house) {
        Address.house = house;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Address setStreet(String street) {
        Address.street = street;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public Address setPostalCode(String postalCode) {
        Address.postalCode = postalCode;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        Address.city = city;
        return this;
    }

    public String getCounty() {
        return county;
    }

    public Address setCounty(String county) {
        Address.county = county;
        return this;
    }

    public String getState() {
        return state;
    }

    public Address setState(String state) {
        Address.state = state;
        return this;
    }

    public String getStateCode() {
        return stateCode;
    }

    public Address setStateCode(String stateCode) {
        Address.stateCode = stateCode;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Address setCountry(String country) {
        Address.country = country;
        return this;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public Address setCountryCode(String countryCode) {
        Address.countryCode = countryCode;
        return this;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public Address setFullAddress() {
        Address.fullAddress = Address.house+", "
                +Address.street+", "
                +Address.city+", "
                +Address.county+", "
                +Address.state+", "
                +Address.country+", "
                +Address.postalCode;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}

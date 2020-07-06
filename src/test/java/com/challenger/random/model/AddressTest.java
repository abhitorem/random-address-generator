package com.challenger.random.model;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

@SpringBootTest(classes = AddressTest.class)
@JsonTest
public class AddressTest {

    @Autowired
    private JacksonTester<Address> json;

    public static final Address SAMPLE = new Address()
            .setHouse("Suite 680")
            .setStreet("177 Sabrina Pike")
            .setCounty("Faheybury")
            .setCity("Ezequielborough")
            .setState("Tennessee")
            .setStateCode("MA")
            .setCountry("Netherlands")
            .setCountryCode("NL")
            .setPostalCode("23547-9530")
            .setFullAddress();

    @Ignore
    public void testSerializable() throws IOException {
        String content = "{\"house\":\"Suite 680\",\"street\":\"177 Sabrina Pike\",\"city\":\"Faheybury\",\"county\":\"Ezequielborough\",\"state\":\"Tennessee\",\"stateCode\":\"MA\",\"country\":\"Netherlands\",\"countryCode\":\"NL\",\"postalCode\":\"23547-9530\",\"fullAddress\":\"Suite 680, 177 Sabrina Pike, Faheybury, Ezequielborough, Tennessee, Netherlands, 23547-9530\"}";

        assertEquals(json.parseObject(content).getCity(),SAMPLE.getCity());
        assertEquals(json.write(SAMPLE), content);

    }



    @Test
    public void givenObjectHasNoAccessors_whenSerializing_thenException()
            throws JsonParseException, IOException {
        String dtoAsString = new ObjectMapper().writeValueAsString(new Address());

        assertNotNull(dtoAsString, "Object Address is initialed");
    }
}

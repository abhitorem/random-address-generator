package com.challenger.random.rest.controller;

import com.challenger.random.model.Address;
import com.challenger.random.model.RandomObject;
import com.challenger.random.model.Randomizer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.challenger.random.service.RandomUtil.getRandomObjects;

@RestController
@RequestMapping("/randomizer")
public class AddressController {

    @ApiOperation(value = "Get the Random Address Generator", notes = "Get the Random Address Generator", response = String.class, tags = { "Randomizer", })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Random Address Generator", response = String.class),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 401, message = "Unauthorized to generate address", response = String.class),
            @ApiResponse(code = 403, message = "Permission Denied.", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
    @RequestMapping(value = "/address", produces = { "application/json" }, method = RequestMethod.GET)
    ResponseEntity<Address> getEncryptedToken() throws JsonProcessingException {
        Randomizer randomizer = new Randomizer(new Locale("US"));
        Map fields = getRandomObjects(randomizer).get(0).getFields();
        //        model.addAttribute("values", randomObjects);
        Address address = new Address()
            .setHouse(String.valueOf(fields.get("secondaryAddress")))
            .setStreet(String.valueOf(fields.get("streetAddress")))
            .setCounty(String.valueOf(fields.get("cityName")))
            .setCity(String.valueOf(fields.get("city")))
            .setState(String.valueOf(fields.get("state")))
            .setStateCode(String.valueOf(fields.get("stateAbbr")))
            .setCountry(String.valueOf(fields.get("country")))
            .setCountryCode(String.valueOf(fields.get("countryCode")))
            .setPostalCode(String.valueOf(fields.get("zipCode")))
            .setFullAddress();
        return ResponseEntity.ok(address);

    }
}

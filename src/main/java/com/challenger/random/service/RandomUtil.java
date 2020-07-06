package com.challenger.random.service;

import com.challenger.random.model.Randomizer;
import com.challenger.random.model.RandomField;
import com.challenger.random.model.RandomObject;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class RandomUtil {

    private static final Set<String> METHODS_TO_INCLUDE = new HashSet<>(Arrays.asList("streetName",
            "streetAddressNumber",
            "streetAddress",
            "secondaryAddress",
            "zipCode",
            "zipCodeByState",
            "countyByZipCode",
            "streetSuffix",
            "streetPrefix",
            "citySuffix",
            "cityPrefix",
            "city",
            "cityName",
            "state",
            "stateAbbr",
            "latitude",
            "longitude",
            "timeZone",
            "country",
            "countryCode",
            "buildingNumber",
            "fullAddress"));

    public static List<RandomObject> getRandomObjects(Randomizer randomizer) {
        Method[] declaredMethods = randomizer.getClass().getDeclaredMethods();
        return Arrays.stream(declaredMethods).sorted(Comparator.comparing(Method::getName)).filter(m -> {
            boolean isGetterMethod = m.getName().startsWith("get");
            boolean hasNoArguments = m.getParameterCount() == 0;
            return !isGetterMethod && hasNoArguments && !METHODS_TO_INCLUDE.contains(m.getName());
        }).map(m -> {
            try {
                return m.invoke(randomizer, null);
            } catch (Exception e) {
                System.out.println(m);
                e.printStackTrace();
            }
            return null;
        }).map(RandomUtil::convertTo).collect(Collectors.toList());
    }

    private static RandomObject convertTo(Object randomObjectWithValues) {
        List<RandomField> fields = Arrays.stream(randomObjectWithValues.getClass().getDeclaredMethods()).map(m -> {
            if (m.getReturnType().equals(String.class)) {
                try {
                    String value = m.invoke(randomObjectWithValues, null).toString();
                    return new RandomField(m.getName(), value);
                } catch (Exception e) {
                    return null;
                }
            }
            return null;
        }).filter(field -> field != null).filter(field1 -> randomObjectWithValues.getClass().getSimpleName().equalsIgnoreCase("Randomizer")).collect(Collectors.toList());
        HashMap<String, String> keyValue = new HashMap<>();
        fields.forEach(l -> keyValue.put(l.getLabel(), l.getValue()));
        return new RandomObject(randomObjectWithValues.getClass().getSimpleName(), keyValue);
    }

}

package com.challenger.random.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RandomValuesGrouping implements RandomValueInterface {

    private List<RandomValues> randomValuesList = new ArrayList<RandomValues>();

    public void add(RandomValues randomValues) {
        randomValuesList.add(randomValues);
    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public Map get(String key) {
        Map result = null;
        for (RandomValues randomValues : randomValuesList) {
            if (randomValues.supportsPath(key)) {
                if (result != null) {
                    final Map newResult = randomValues.get(key);
                    result.putAll(newResult);
                } else {
                    result = randomValues.get(key);
                }
            }
        }
        return result;
    }

}

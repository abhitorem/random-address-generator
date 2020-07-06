package com.challenger.random.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Map;

public class RandomObject implements Serializable {

    private final String name;
    private final Map fields;

    public RandomObject(String name, Map fields) {
        this.name = name;
        this.fields = fields;
    }

    public String getName() {
        return name;
    }

    public Map getFields() {
        return fields;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}

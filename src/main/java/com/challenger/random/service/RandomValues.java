package com.challenger.random.service;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class RandomValues implements RandomValueInterface {

    private final Locale locale;
    private final String filename;
    private final String path;
    private Map values;

    RandomValues(Locale locale) {
        this(locale, getFilename(locale), getFilename(locale));
    }

    private static String getFilename(Locale locale) {
        final StringBuilder filename = new StringBuilder(language(locale));
        if (!"".equals(locale.getCountry())) {
            filename.append("-").append(locale.getCountry());
        }
        return filename.toString();
    }

    /**
     * If you new up a locale with "he", it gets converted to "iw" which is old.
     * This addresses that unfortunate condition.
     */
    private static String language(Locale l) {
        if (l.getLanguage().equals("iw")) {
            return "he";
        }
        return l.getLanguage();
    }

    RandomValues(Locale locale, String filename, String path) {
        this.locale = locale;
        this.filename = filename;
        this.path = path;
    }

    @Override
    public Map get(String key) {
        if (values == null) {
            values = loadValues();
        }

        return values == null ? null : (Map) values.get(key);
    }

    private Map loadValues() {
        String pathWithFilename = "/yml/" + filename;

        List<String> paths = Arrays.asList(pathWithFilename);
        InputStream stream = null;
        for (String path : paths) {
            stream = findStream(path);
            if (stream != null) {
                break;
            }
        }

        if (stream == null) {
            return null;
        }

        final Map valuesMap = new Yaml().loadAs(stream, Map.class);
        Map localeBased = (Map) valuesMap.get(locale.getLanguage());
        if (localeBased == null) {
            localeBased = (Map) valuesMap.get(filename);
        }
        return localeBased;
    }

    private InputStream findStream(String filename) {
        InputStream streamOnClass = getClass().getResourceAsStream(filename);
        if (streamOnClass != null) {
            return streamOnClass;
        }
        return getClass().getClassLoader().getResourceAsStream(filename);
    }

    boolean supportsPath(String path) {
        return this.path.equals(path);
    }

}

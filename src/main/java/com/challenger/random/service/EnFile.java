package com.challenger.random.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnFile {

    private final String file;
    private final String path;

    private EnFile(String file) {
        this(file, file.replaceFirst(".yml", ""));
    }

    private EnFile(String file, String path) {
        this.file = file;
        this.path = path;
    }


    public String getFile() {
        return file;
    }

    public String getPath() {
        return path;
    }

    private static List<String> FILES = Arrays.asList("address.yml",
            "name.yml"
            );

    public static List<EnFile> getFiles() {
        List<EnFile> files = new ArrayList<EnFile>();
        for (String file : FILES) {
            files.add(new EnFile(file));
        }

        return files;
    }

}

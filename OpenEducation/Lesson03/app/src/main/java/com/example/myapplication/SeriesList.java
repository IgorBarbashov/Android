package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class SeriesList {
    List<String> getListTV(String spinner) {
        List<String> list = new ArrayList<>();

        if (spinner.equals("Комедия")) {
            list.add("Друзья");
        }
        if (spinner.equals("Фэнтези")) {
            list.add("Игра престолов");
        }
        if (spinner.equals("Ужасы")) {
            list.add("Ходячие мертвецы");
        }
        if (spinner.equals("Фантастика")) {
            list.add("Футурама");
        }
        if (spinner.equals("Криминал")) {
            list.add("Во все тяжкие");
            list.add("Менталист");
        }

        return list;
    }
}
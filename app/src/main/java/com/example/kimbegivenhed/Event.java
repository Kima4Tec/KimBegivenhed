package com.example.kimbegivenhed;

public class Event {
    private int imageResId;
    private String name;
    private String date;
    private String description;
    private String url;

    // Opretter et Event-objekt med billede, navn, dato, beskrivelse og URL
    public Event(int imageResId, String name, String date, String description, String url) {
        this.imageResId = imageResId;
        this.name = name;
        this.date = date;
        this.description = description;
        this.url = url;
    }

    // Returnerer billedet (drawable resource id) til eventet
    public int getImageResId() {
        return imageResId;
    }

    // Returnerer navnet på eventet
    public String getName() {
        return name;
    }

    // Returnerer datoen for eventet
    public String getDate() {
        return date;
    }

    // Returnerer beskrivelsen af eventet
    public String getDescription() {
        return description;
    }

    // Returnerer URL’en til eventet (hjemmeside)
    public String getUrl() {
        return url;
    }
}
package com.example.learn_it;

class DataModel {
    private final String title;
    private final String description;
    private final int imageId;

    DataModel(String title, String description, int imageId) {
        this.title = title;
        this.description = description;
        this.imageId = imageId;
    }

    String getTitle() {
        return title;
    }

    String getDescription() {
        return description;
    }

    int getImageId() {
        return imageId;
    }
}
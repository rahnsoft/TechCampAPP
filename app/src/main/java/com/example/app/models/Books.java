package com.example.app.models;

public class Books {
    private String title, description, category;
    private int thumbnail;

    public Books() {
    }

    public Books(String title, String description, String category, int thumbnail) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }


}

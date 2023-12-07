package com.chalim.backend.dto;

public class WordcloudResponse {
    private final String imagePath;

    public WordcloudResponse(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }
}

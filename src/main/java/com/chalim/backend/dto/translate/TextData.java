package com.chalim.backend.dto.translate;

public class TextData {
    private String transcription;
    private Integer priceValue; // Optional
    private int[][] points;

    public TextData() {
    }

    public TextData(String transcription, int[][] points) {
        this.transcription = transcription;
        this.points = points;
    }

    public TextData(Integer priceValue, int[][] points) {
        this.priceValue = priceValue;
        this.points = points;
    }

    // Getters and setters
    public String getTranscription() {
        return transcription;
    }

    public void setTranscription(String transcription) {
        this.transcription = transcription;
    }

    public Integer getPriceValue() {
        return priceValue;
    }

    public void setPriceValue(Integer priceValue) {
        this.priceValue = priceValue;
    }

    public int[][] getPoints() {
        return points;
    }

    public void setPoints(int[][] points) {
        this.points = points;
    }
}

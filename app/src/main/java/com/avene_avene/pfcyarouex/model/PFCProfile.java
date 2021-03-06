package com.avene_avene.pfcyarouex.model;

/**
 * Created by Juc-y on 6/7/2016.
 */
public class PFCProfile {
    private double weight;
    private double fatMassRate;
    private double calsFromFatRate;
    private double proteinFactor;
    private int totalCals;
    private int proteinGrams;
    private int fatGrams;
    private int carboGrams;

    public PFCProfile() {
        this.weight = 0;
        this.fatMassRate = 0;
        this.calsFromFatRate = 10;
        this.proteinFactor = 0;
        this.totalCals = 0;
        this.proteinGrams = 0;
        this.fatGrams = 0;
        this.carboGrams = 0;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getFatMassRate() {
        return fatMassRate;
    }

    public void setFatMassRate(double fatMassRate) {
        this.fatMassRate = fatMassRate;
    }

    public double getCalsFromFatRate() {
        return calsFromFatRate;
    }

    public void setCalsFromFatRate(double calsFromFatRate) {
        this.calsFromFatRate = calsFromFatRate;
    }

    public double getProteinFactor() {
        return proteinFactor;
    }

    public void setProteinFactor(double proteinFactor) {
        this.proteinFactor = proteinFactor;
    }

    public void setWeight(String weightString) {
        try {
            this.setWeight(Double.parseDouble(weightString));
        } catch (NumberFormatException e) {
            this.setFatMassRate(0);
        }
    }

    public void setFatMassRate(String fatMassRateString) {
        try {
            this.setFatMassRate(Double.parseDouble(fatMassRateString));
        } catch (NumberFormatException e) {
            this.setFatMassRate(0);
        }
    }

    public void setCalsFromFatRate(String calsFromFatRateString) {
        try {
            this.setCalsFromFatRate(Double.parseDouble(calsFromFatRateString));
        } catch (NumberFormatException e) {
            this.setFatMassRate(0);
        }
    }

    public void setProteinFactor(String proteinFactorString) {
        try {
            this.setProteinFactor(Double.parseDouble(proteinFactorString));
        } catch (NumberFormatException e) {
            this.setFatMassRate(0);
        }
    }

    public int getTotalCals() {
        return totalCals;
    }

    public double getProteinGrams() {
        return proteinGrams;
    }

    public double getFatGrams() {
        return fatGrams;
    }

    public double getCarboGrams() {
        return carboGrams;
    }

    public double getCalsFromProtein() {
        return proteinGrams * 4;
    }

    public double getCalsFromFat() {
        return fatGrams * 9;
    }

    public double getCalsFromCarbo() {
        return carboGrams * 4;
    }

    public void calculate() {
        totalCals = (int) (weight * (1 - (fatMassRate * 0.01)) * 40);
        double calsFromFat = totalCals * calsFromFatRate * 0.01;
        fatGrams = (int) calsFromFat / 9;
        proteinGrams = (int) (proteinFactor * weight);
        int calsFromProtein = proteinGrams * 4;
        carboGrams = (int) (totalCals - calsFromFat - calsFromProtein) / 4;
    }
}

package com.snmi.model;

/**
 * Employee object
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class Employee {

    /**
     * Variables
     */
    private String name;
    private int totalSales;
    private int salesPeriod;
    private double experienceMultiplier;
    private double score;

    /**
     * Custom constructor
     * @param name take the name
     * @param totalSales take the total sales
     * @param salesPeriod take the sales period
     * @param experienceMultiplier take the experience multiplier
     * @param score take the score
     */
    public Employee(String name, int totalSales, int salesPeriod, double experienceMultiplier, double score) {
        this.name = name;
        this.totalSales = totalSales;
        this.salesPeriod = salesPeriod;
        this.experienceMultiplier = experienceMultiplier;
        this.score = score;
    }

    /**
     * Setters and getters
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(int totalSales) {
        this.totalSales = totalSales;
    }

    public int getSalesPeriod() {
        return salesPeriod;
    }

    public void setSalesPeriod(int salesPeriod) {
        this.salesPeriod = salesPeriod;
    }

    public double getExperienceMultiplier() {
        return experienceMultiplier;
    }

    public void setExperienceMultiplier(double experienceMultiplier) {
        this.experienceMultiplier = experienceMultiplier;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    /**
     * Implementation of to string method
     * @return the employee presentation
     */
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", totalSales=" + totalSales +
                ", salesPeriod=" + salesPeriod +
                ", experienceMultiplier=" + experienceMultiplier +
                ", score=" + score +
                '}';
    }
}

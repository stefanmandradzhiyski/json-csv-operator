package com.snmi.model;

/**
 * Report definition
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class ReportDefinition {

    /**
     * Variables
     */
    private int topPerformersThreshold;
    private boolean isExperienceMultiplierUsed;
    private int periodLimit;

    /**
     * Custom constructor
     * @param topPerformersThreshold take the top performers threshold
     * @param isExperienceMultiplierUsed is experience multiplier used
     * @param periodLimit take the period limit
     */
    public ReportDefinition(int topPerformersThreshold, boolean isExperienceMultiplierUsed, int periodLimit) {
        this.topPerformersThreshold = topPerformersThreshold;
        this.isExperienceMultiplierUsed = isExperienceMultiplierUsed;
        this.periodLimit = periodLimit;
    }

    /**
     * Setters and getters
     */
    public int getTopPerformersThreshold() {
        return topPerformersThreshold;
    }

    public void setTopPerformersThreshold(int topPerformersThreshold) {
        this.topPerformersThreshold = topPerformersThreshold;
    }

    public boolean isExperienceMultiplierUsed() {
        return isExperienceMultiplierUsed;
    }

    public void setExperienceMultiplierUsed(boolean experienceMultiplierUsed) {
        isExperienceMultiplierUsed = experienceMultiplierUsed;
    }

    public int getPeriodLimit() {
        return periodLimit;
    }

    public void setPeriodLimit(int periodLimit) {
        this.periodLimit = periodLimit;
    }
}

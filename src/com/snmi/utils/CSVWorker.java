package com.snmi.utils;

import com.snmi.model.ReportDefinition;
import com.snmi.model.Staff;

import java.io.FileWriter;
import java.io.IOException;

/**
 * CSV Worker util class which job is to create the CSV file
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class CSVWorker {

    /**
     * Constants
     */
    private static final String CSV_NAME = "Name";
    private static final String CSV_SPLITTER = ",";
    private static final String CSV_SCORE = "Score";
    private static final String NEW_LINE = "\n";
    private static final String ERROR_SAVING_MESSAGE = "The location doesn't exist. Please select correct location and set the name of file like: " +
            "'C:\\ProgramFiles\\CSV\\Results.csv'";

    /**
     * Private constructor
     */
    private CSVWorker() {}

    /**
     * Creating a result CSV file
     * @param staff take the staff
     * @param reportDefinition take the report definition
     * @param CSVFilePath take the csv file path
     * @return the result of creation
     */
    public static boolean createCSV(Staff staff, ReportDefinition reportDefinition, String CSVFilePath) {
        FileWriter csvWriter;
        try {
            csvWriter = new FileWriter(CSVFilePath);
            csvWriter.append(CSV_NAME).append(CSV_SPLITTER).append(CSV_SCORE).append(NEW_LINE);

            staff.getStaffList().removeIf(employee -> employee.getSalesPeriod() > reportDefinition.getPeriodLimit());
            staff.getStaffList().sort((e1, e2) -> Double.compare(e2.getScore(), e1.getScore()));

            for (int current = 0; current < reportDefinition.getTopPerformersThreshold(); current++) {
                if (current < staff.getStaffList().size()) {
                    String employeeName = staff.getStaffList().get(current).getName();
                    String employeeScore = String.valueOf(staff.getStaffList().get(current).getScore());
                    csvWriter.append(String.join(CSV_SPLITTER, employeeName + CSV_SPLITTER))
                             .append(String.join(CSV_SPLITTER, employeeScore)).append(NEW_LINE);
                }
            }

            csvWriter.flush();
            csvWriter.close();
            return true;
        } catch (IOException e) {
            System.out.println(ERROR_SAVING_MESSAGE);
            return false;
        }
    }
}

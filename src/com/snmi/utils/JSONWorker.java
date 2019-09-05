package com.snmi.utils;

import com.snmi.model.Employee;
import com.snmi.model.ReportDefinition;
import com.snmi.model.Staff;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

/**
 * JSON Worker util class
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class JSONWorker {

    /**
     * Constants
     */
    private static final String PARSING_COMMON_JSON_EXCEPTION = "Something went wrong when try to parse the JSON object!";
    private static final String TOP_PERFORMERS_THRESHOLD = "topPerformersThreshold";
    private static final String USE_EXPERIENCE_MULTIPLIER = "useExperienceMultiplier";
    private static final String PERIOD_LIMIT = "periodLimit";
    private static final String EMPLOYEE_JSON_ARRAY_NAME = "staff";
    private static final String EMPLOYEE_JSON_NAME = "name";
    private static final String EMPLOYEE_JSON_TOTAL_SALES = "totalSales";
    private static final String EMPLOYEE_JSON_SALES_PERIOD = "salesPeriod";
    private static final String EMPLOYEE_JSON_EXPERIENCE_MULTIPLIER = "experienceMultiplier";
    private static final String PARSING_STAFF_EXCEPTION = "Something went wrong when try to parse the Staff JSON object!";

    /**
     * Private constructor
     */
    private JSONWorker() {}

    /**
     * Parsing the Report Definition JSON file
     * @param JSONFilePath take the JSON file path
     * @return the created report definition object
     */
    public static ReportDefinition parseJSON(String JSONFilePath) {
        try {
            JSONParser JSONParser = new JSONParser();
            Object object = JSONParser.parse(new FileReader(JSONFilePath));
            JSONObject JSONObject = (JSONObject) object;

            int topPerformersThreshold = Integer.parseInt(String.valueOf(JSONObject.get(TOP_PERFORMERS_THRESHOLD)));
            boolean isExperienceMultiplierUsed = Boolean.parseBoolean(String.valueOf(JSONObject.get(USE_EXPERIENCE_MULTIPLIER)));
            int periodLimit = Integer.parseInt(String.valueOf(JSONObject.get(PERIOD_LIMIT)));

            return new ReportDefinition(topPerformersThreshold, isExperienceMultiplierUsed, periodLimit);
        } catch (IllegalArgumentException | ParseException | IOException e) {
            System.out.println(PARSING_COMMON_JSON_EXCEPTION);
            return null;
        }
    }

    /**
     * Parsing the Staff JSON File
     * @param JSONFilePath take the JSON file path
     * @param reportDefinition take the report definition object
     * @param staff take the staff
     * @return boolean result of parsing the JSON file
     */
    public static boolean parseJSON(String JSONFilePath, ReportDefinition reportDefinition, Staff staff) {
        try {
            JSONParser JSONParser = new JSONParser();
            Object object = JSONParser.parse(new FileReader(JSONFilePath));
            JSONObject JSONObject = (JSONObject) object;
            JSONArray JSONArray = (JSONArray) JSONObject.get(EMPLOYEE_JSON_ARRAY_NAME);

            if (JSONArray != null) {
                for (Object specificJSONObjectFromArray : JSONArray) {
                    JSONObject JSONEmployeeObject = (JSONObject) specificJSONObjectFromArray;
                    fillStaffList(reportDefinition, staff, JSONEmployeeObject);
                }
                return true;
            }

        } catch (ParseException | IOException exception) {
            System.out.println(PARSING_COMMON_JSON_EXCEPTION);
            return false;
        }

        return false;
    }

    /**
     * Fill the staff list with employees which meet the requirements
     * @param reportDefinition  take the report definition object
     * @param staff take the staff object
     * @param JSONEmployeeObject take the JSON Employee object
     */
    private static void fillStaffList(ReportDefinition reportDefinition, Staff staff, JSONObject JSONEmployeeObject) {
        try {
            String employeeName = String.valueOf(JSONEmployeeObject.get(EMPLOYEE_JSON_NAME));
            int employeeTotalSales = Integer.parseInt(String.valueOf(JSONEmployeeObject.get(EMPLOYEE_JSON_TOTAL_SALES)));
            int employeeSalesPeriod = Integer.parseInt(String.valueOf(JSONEmployeeObject.get(EMPLOYEE_JSON_SALES_PERIOD)));
            double employeeExperienceMultiplier = Double.parseDouble(String.valueOf(JSONEmployeeObject.get(EMPLOYEE_JSON_EXPERIENCE_MULTIPLIER)));

            double employeeScore;
            if (reportDefinition.isExperienceMultiplierUsed()) {
                employeeScore = (employeeTotalSales / employeeSalesPeriod) * employeeExperienceMultiplier;
            } else {
                employeeScore = employeeTotalSales / employeeSalesPeriod;
            }

            Employee currentEmployee = new Employee(employeeName,employeeTotalSales,employeeSalesPeriod,
                    employeeExperienceMultiplier,employeeScore);
            staff.addEmployee(currentEmployee);
        } catch(IllegalArgumentException exception) {
            System.out.println(PARSING_STAFF_EXCEPTION);
        }
    }

}

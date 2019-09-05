package com.snmi.controller;

import com.snmi.actions.ActionType;
import com.snmi.model.ReportDefinition;
import com.snmi.model.Staff;
import com.snmi.utils.CSVWorker;
import com.snmi.utils.JSONWorker;
import com.snmi.view.UserConsole;

/**
 * JSON and CSV Controller
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class JSONnCSVController {

    /**
     * Variables
     */
    private Staff model;
    private UserConsole view;
    private ReportDefinition reportDefinition;

    /**
     * Custom constructor
     * @param model take the staff model
     * @param view take the user console view
     */
    public JSONnCSVController(Staff model, UserConsole view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Parsing JSONs files
     */
    public void parseJSON() {
        do {
            String reportDefinitionJSONFilePath = view.getUserInput(ActionType.REPORT_DEFINITION);
            reportDefinition = JSONWorker.parseJSON(reportDefinitionJSONFilePath);
        } while(reportDefinition == null);

        boolean validStaffJSONFilePath;
        do {
            String staffJSONFilePath = view.getUserInput(ActionType.STAFF);
            validStaffJSONFilePath = JSONWorker.parseJSON(staffJSONFilePath, reportDefinition, model);
        } while(!validStaffJSONFilePath);
    }

    /**
     * Creating the Result CSV file
     */
    public void createCSV() {
        boolean isCSVCreated;
        if (reportDefinition != null && !model.getStaffList().isEmpty()) {
            do {
                String CSVFilePath = view.getUserInput(ActionType.CSV);
                isCSVCreated = CSVWorker.createCSV(model, reportDefinition, CSVFilePath);
                view.CSVNotification(isCSVCreated);
            } while(!isCSVCreated);
        }
    }

}

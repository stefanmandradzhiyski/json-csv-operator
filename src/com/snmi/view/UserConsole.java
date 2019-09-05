package com.snmi.view;

import com.snmi.actions.ActionType;

import java.util.Scanner;

/**
 * User console view
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class UserConsole {

    /**
     * Constants
     */
    private static final String GUIDE_MESSAGE_FOR_REPORT_DEFINITION_JSON_FILE_PATH = "Please, input correct report definition JSON file path: ";
    private static final String GUIDE_MESSAGE_FOR_EMPLOYEES_JSON_FILE_PATH = "Please, input correct staff JSON file path: ";
    private static final String GUIDE_MESSAGE_CSV_SET_FILE_PATH = "Please, enter the location where you want to save the CSV file: ";
    private static final String MESSAGE_CSV_IS_CREATED = "CSV file have been created successfully!";
    private static final String MESSAGE_CSV_FAILED_TO_CREATE = "An error occurred while creating the CSV file!";
    private static final String NO_SUCH_ACTION = "No such action type available!";

    /**
     * Getting the user action input
     * @param actionType take the action input
     * @return the user input
     */
    public String getUserInput(ActionType actionType){
        switch (actionType) {
            case STAFF: System.out.print(GUIDE_MESSAGE_FOR_EMPLOYEES_JSON_FILE_PATH); break;
            case REPORT_DEFINITION: System.out.print(GUIDE_MESSAGE_FOR_REPORT_DEFINITION_JSON_FILE_PATH); break;
            case CSV: System.out.print(GUIDE_MESSAGE_CSV_SET_FILE_PATH); break;
            default: throw new IllegalArgumentException(NO_SUCH_ACTION);
        }

        Scanner console = new Scanner(System.in);
        return console.nextLine();
    }

    /**
     * CSV Notification
     * @param isCSVCreated take the boolean of csv creation
     */
    public void CSVNotification(boolean isCSVCreated){
        if (isCSVCreated) {
            System.out.println(MESSAGE_CSV_IS_CREATED);
        } else {
            System.out.println(MESSAGE_CSV_FAILED_TO_CREATE);
        }
    }

}

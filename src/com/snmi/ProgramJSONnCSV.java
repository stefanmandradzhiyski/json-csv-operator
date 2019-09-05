package com.snmi;

import com.snmi.controller.JSONnCSVController;
import com.snmi.model.Staff;
import com.snmi.view.UserConsole;

/**
 * The program is operating both with JSON and CSV files
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class ProgramJSONnCSV {

    public static void main(String[] args) {
        Staff model = new Staff();
        UserConsole view = new UserConsole();
        JSONnCSVController controller = new JSONnCSVController(model, view);
        controller.parseJSON();
        controller.createCSV();
    }

}

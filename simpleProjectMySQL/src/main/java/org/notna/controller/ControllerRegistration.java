package org.notna.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class ControllerRegistration {

    @FXML
    private TextField txf_coure;

    @FXML
    private TextField txf_mobile;

    @FXML
    private TextField txf_name;

    @FXML
    private Button btn_add;

    @FXML
    private Button btn_delete;

    @FXML
    private Button btn_edit;

    @FXML
    private TableColumn<?, ?> column_id;

    @FXML
    private TableColumn<?, ?> column_name;

    @FXML
    private TableColumn<?, ?> column_mobile;

    @FXML
    private TableColumn<?, ?> column_course;

}

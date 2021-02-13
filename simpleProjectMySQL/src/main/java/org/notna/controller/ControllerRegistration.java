package org.notna.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.notna.model.Student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ControllerRegistration implements Initializable {

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

    @FXML
    private TableView<Student> tableViewStudent;

    @FXML
    void handleAddAction(ActionEvent event) {
    	this.tableViewStudent.getItems().add(new Student(this.txf_name.getText(), this.txf_mobile.getText(), this.txf_coure.getText()));
    }

    @FXML
    void handleDeleteAction(ActionEvent event) {

    }

    @FXML
    void handleEditAction(ActionEvent event) {

    }

	public void initialize(URL location, ResourceBundle resources) {
		this.tableViewStudent = new TableView<Student>();
		this.column_id = new TableColumn<Student, Integer>();
	    this.column_name = new TableColumn<Student, String>();
	    this.column_mobile = new TableColumn<Student, String>();
	    this.column_course = new TableColumn<Student, String>();
	    this.getStudentData();

	}

	private void getStudentData(){
		this.tableViewStudent.getItems().addAll(/*get Student from DB*/);
	}
}

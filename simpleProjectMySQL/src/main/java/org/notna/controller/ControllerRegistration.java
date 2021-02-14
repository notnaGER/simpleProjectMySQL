package org.notna.controller;

import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;

import org.notna.database.DbConnection;
import org.notna.database.DbStatement;
import org.notna.model.Student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;

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
    private TableColumn<Student, Integer> column_id;

    @FXML
    private TableColumn<Student, String> column_name;

    @FXML
    private TableColumn<Student, String> column_mobile;

    @FXML
    private TableColumn<Student, String> column_course;

    @FXML
    private TableView<Student> tableViewStudent;

    @FXML
    void addClickAction(MouseEvent event) {
    	this.tableViewStudent.getSelectionModel().clearSelection();
    	Arrays.asList(this.txf_name,this.txf_mobile,this.txf_coure).stream().forEach(txf->txf.setText(""));
    }

    @FXML
    void handleAddAction(ActionEvent event) {
    	this.tableViewStudent.getItems().add(new Student(this.txf_name.getText(), this.txf_mobile.getText(), this.txf_coure.getText()));
    	Arrays.asList(this.txf_name,this.txf_mobile,this.txf_coure).stream().forEach(txf->txf.setText(""));
    	DbStatement.insertStudent(new Student(this.txf_name.getText(), this.txf_mobile.getText(), this.txf_coure.getText()));
    }

    @FXML
    void handleDeleteAction(ActionEvent event) {
    	this.tableViewStudent.getItems().remove(this.tableViewStudent.getSelectionModel().getSelectedItem());
    	Arrays.asList(this.txf_name,this.txf_mobile,this.txf_coure).stream().forEach(txf->txf.setText(""));
    }

    @FXML
    void handleEditAction(ActionEvent event) {
    	Student oldValue = this.tableViewStudent.getSelectionModel().getSelectedItem();
    	Collections.replaceAll(this.tableViewStudent.getItems(), oldValue , new Student(this.txf_name.getText(), this.txf_mobile.getText(), this.txf_coure.getText()));

    }

    @FXML
    void handleChoiceAction(MouseEvent event) {
    	if(!this.tableViewStudent.getSelectionModel().isEmpty()){
    		Student chooseStudent = this.tableViewStudent.getSelectionModel().getSelectedItem();
        	this.txf_name.setText(chooseStudent.getName());
        	this.txf_mobile.setText(chooseStudent.getMobileNr());
        	this.txf_coure.setText(chooseStudent.getCourse());
    	}

    }

	public void initialize(URL location, ResourceBundle resources) {
		this.getStudentData();
	    this.column_id.setCellValueFactory(new PropertyValueFactory<Student,Integer>("id"));
	    this.column_name.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
	    this.column_mobile.setCellValueFactory(new PropertyValueFactory<Student,String>("mobileNr"));
	    this.column_course.setCellValueFactory(new PropertyValueFactory<Student,String>("course"));
	    this.column_name.setCellFactory(TextFieldTableCell.forTableColumn());
	    this.column_mobile.setCellFactory(TextFieldTableCell.forTableColumn());
	    this.column_course.setCellFactory(TextFieldTableCell.forTableColumn());
	}

	private void getStudentData(){
		this.tableViewStudent.getItems().addAll(new Student("Peter", "01564", "php"));
	}
}

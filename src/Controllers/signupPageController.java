package Controllers;

import DBManager.DBManager;
import Initialization.Main;
import User.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Status:
 */
public class signupPageController extends UIController {

    @FXML
    private TextField firstName, middleInitial, lastName, username, password, email, phoneNo;
    @FXML
    private Button backButton, signupButton;
    @FXML
    private AnchorPane anchorPane;

    private DBManager dbManager = new DBManager();

    void start(Main main) {
        this.main = main;
        setActionOnEnter(signupButton);
        setActionOnEnter(phoneNo);
        // Add a listener to the middleInitial text field to restrict it to one character
        middleInitial.textProperty().addListener((observable, oldValue, newValue) -> {
            if(middleInitial.getText().length() > 1) {
                String s = middleInitial.getText().substring(0,1);
                middleInitial.setText(s);
            }
        });
    }

    /**
     * Allows ENTER key press when focused on password text field to call loginAction.
     * Allows ENTER key press when focused on loginButton to fire loginAction.
     */
    private void setActionOnEnter(Node node) {
        node.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if(event.getCode() == KeyCode.ENTER) {
                signupButton.fire();
                event.consume();
            }
        });
    }

    /**
     * Redirects to loginPage.fxml
     * @throws IOException - throws exception
     */
    @FXML
    private void returnToLoginPage() throws IOException {
        Stage stage;
        stage=(Stage) backButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/loginPage.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
        loginPageController controller = loader.getController();
        controller.start(this.main);
    }

    /**
     * Creates a user and stores it's information in the database
     * @throws IOException - throws exception
     */
    @FXML
    private void createUser() throws IOException {
        String FirstName = firstName.getText();
        String MiddleInitial = middleInitial.getText();
        String LastName = lastName.getText();
        String Username = username.getText();
        String Password = password.getText();
        String Email = email.getText();
        String PhoneNo = phoneNo.getText();
        if(FirstName.isEmpty() || MiddleInitial.isEmpty() || LastName.isEmpty() || Username.isEmpty() ||
                Password.isEmpty() || Email.isEmpty() || PhoneNo.isEmpty()) {
            System.out.println("Empty fields! fill in"); // TODO: add error label
            return;
        }
        // Check for null values TODO
        User newUser = new User(Username, Password, FirstName, MiddleInitial, LastName, Email, PhoneNo, 1);
        boolean createSuccess = dbManager.persistUser(newUser);
        if(!createSuccess) {
            //errorLabel.setText("Invalid Username / Email already exists");
            System.out.println("Invalid user. Try again"); //TODO: add error label
        } else {
            returnToMain();
        }
    }

    /**
     * Returns to mainPage.fxml from signupPage.fxml
     * @throws IOException - throws exception
     */
    @FXML
    private void returnToMain() throws IOException {
        Stage stage;
        stage=(Stage) backButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/mainPage.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
        mainPageController controller = loader.getController();
        controller.start(this.main);
    }

}

package Controllers;

import Initialization.Main;
import User.User;
import DBManager.DBManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Status: incomplete
 */
public class loginPageController extends UIController {

    @FXML
    private Button loginButton, signupButton, backButton;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    private DBManager dbManager = new DBManager();

    void start(Main main) {
        this.main = main;
    }

    /**
     * Returns to mainPage.fxml from loginPage.fxml
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

    /**
     * Redirects to signupPage.fxml
     * @throws IOException - throws exception
     */
    @FXML
    private void signupAction() throws IOException {
        Stage stage;
        stage=(Stage) signupButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/signupPage.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
        signupPageController controller = loader.getController();
        controller.start(this.main);
    }

    /**
     * Login user and redirect to loggedMainPage.fxml if successful
     */
    @FXML
    private void loginAction() throws IOException {
        User loginUser = dbManager.findUser("username='" + username.getText() + "' and password='" + password.getText() + "'");
        if(loginUser != null && loginUser.getUid() != null) {
            super.main.setUser(loginUser);
            displayLoggedMainPage();
        } else {
            System.out.println("No such user found!");
        }
    }

    private void displayLoggedMainPage() throws IOException {
        Stage stage;
        stage=(Stage) loginButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/mainPage.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
        mainPageController controller = loader.getController();
        controller.start(this.main);
    }
}

package Initialization;

import Controllers.mainPageController;
import User.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private User user = new User();

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/mainPage.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Standalone Application");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();
        mainPageController controller = loader.getController();
        controller.start(this);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

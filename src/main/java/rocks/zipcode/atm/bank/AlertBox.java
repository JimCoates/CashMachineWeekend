package rocks.zipcode.atm.bank;
import com.sun.org.apache.xpath.internal.operations.Mod;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.stage.*;

public class AlertBox {

    public static void display(String title, String message){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Okay, I'm Sorry");
        closeButton.setOnAction(e-> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,closeButton);
        layout.setAlignment(Pos. CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
        window.showAndWait();
    }
}

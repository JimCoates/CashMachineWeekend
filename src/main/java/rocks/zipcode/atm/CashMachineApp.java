package rocks.zipcode.atm;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import rocks.zipcode.atm.bank.AccountData;
import rocks.zipcode.atm.bank.AlertBox;
import rocks.zipcode.atm.bank.Bank;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author ZipCodeWilmington
 */
public class CashMachineApp extends Application {

    private TextField field = new TextField();
    private CashMachine cashMachine = new CashMachine(new Bank());

    Label depositLabel = new Label("Deposit");
    TextField despositField = new TextField();


    Label withdrawLabel = new Label ("Withdraw");
    TextField withdrawField = new TextField();

    TextArea areaInfo = new TextArea();




        public void start(Stage primaryStage){

            GridPane root = new GridPane();

            root.setPadding(new Insets(20));
            root.setHgap(25);
            root.setVgap(10);

            Label labelTitle = new Label("Login with your account number to begin");

            // Put on cell (0,0), span 2 column, 1 row.
            root.add(labelTitle, 0, 0, 2, 1);

            Label labelUserName = new Label("Account Number");
            TextField fieldUserName = new TextField();

            Label labelWithdraw = new Label("Withdraw");
            TextField fieldwithdraw = new TextField();

            Label labelDeposit = new Label("Deposit");
            TextField fielddeposit = new TextField();

            Label labelActivity = new Label("Activity");

            TextField withdrawField = new TextField();

            Button btnDeposit = new Button("Deposit");
            btnDeposit.setDisable(true);

            Button btnWithdraw = new Button("Withdraw");
            btnWithdraw.setDisable(true);

            TextField fieldEmail = new TextField();
            TextField fieldname = new TextField();









            //BUTTONS


            Button btnSubmit = new Button("Login");
            btnSubmit.setOnAction(e -> {
                int id = Integer.parseInt(fieldUserName.getText());
                cashMachine.login(id);
                btnDeposit.setDisable(false);
                btnWithdraw.setDisable(false);

                areaInfo.setText(cashMachine.toString());

            });

            //Button btnDeposit = new Button("Deposit");
            btnDeposit.setOnAction(e -> {
                Double amount = Double.parseDouble(fielddeposit.getText());
                cashMachine.deposit(amount);

                areaInfo.setText(cashMachine.toString());
            });

            //Button btnWithdraw = new Button("Withdraw");
            btnWithdraw.setOnAction(e -> {
                Double amount = Double.parseDouble(fieldwithdraw.getText());
                cashMachine.withdraw(amount);

                areaInfo.setText(cashMachine.toString());
                //AlertBox.display("Your account is overdrawn", "Please deposit additional funds or lower your withdrawl amount");

            });

            Button btnExit = new Button("Exit");
            btnExit.setOnAction(e -> {
                cashMachine.exit();

                areaInfo.setText(cashMachine.toString());
            });






            GridPane.setHalignment(labelUserName, HPos.RIGHT);

            // Put on cell (0,1)
            root.add(labelUserName, 0, 1);

            root.add(labelWithdraw, 0,3);

            root.add(labelDeposit,3,3);

            root.add(labelActivity, 0,7);


            GridPane.setHalignment(fieldUserName, HPos.LEFT);
            root.add(fieldUserName, 1, 1);



            GridPane.setHalignment(btnSubmit, HPos.LEFT);
            root.add(btnSubmit, 1,2);

            GridPane.setHalignment(areaInfo, HPos.LEFT);
            root.add(areaInfo, 1,7, 4,4);





            GridPane.setHalignment(btnDeposit, HPos.LEFT);
            root.add(btnDeposit, 4, 5);

            GridPane.setHalignment(btnWithdraw, HPos.LEFT);
            root.add(btnWithdraw, 1, 5);

            GridPane.setHalignment(despositField, HPos.LEFT);
            root.add(fielddeposit, 4, 3);

            GridPane.setHalignment(withdrawField, HPos.LEFT);
            root.add(fieldwithdraw, 1, 3);

            GridPane.setHalignment(btnExit, HPos.LEFT);
            root.add(btnExit, 1, 13);





            Scene scene = new Scene(root, 700, 500);
            primaryStage.setTitle("Welcome to your ZipBank Account");
            primaryStage.setScene(scene);
            primaryStage.show();


        }


        public static void main(String[] args) {
            launch(args);
        }

    }
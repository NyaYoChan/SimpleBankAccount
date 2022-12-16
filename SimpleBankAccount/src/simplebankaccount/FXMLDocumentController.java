package simplebankaccount;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button depositButton;
    @FXML
    private Button withdrawButton;
    @FXML
    private Button checkButton;
    
    @FXML
    private TextField moneyTextField;
     
    @FXML
    private TextArea screenTextArea;
    
    private int money = 0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void clickedButton(ActionEvent event){
        try{
            int input = Integer.valueOf(moneyTextField.getText());
            Button curClickedButton = (Button)event.getSource();
            switch(curClickedButton.getId()){
                case "depositButton":
                    money += input;
                    screenTextArea.appendText("存款" + String.valueOf(input) + "\n");
                    screenTextArea.appendText("帳戶餘額：" + String.valueOf(money) + "\n");
                    break;
                case "withdrawButton":
                    if(money >= input){
                        money -= input;
                        screenTextArea.appendText("提款" + String.valueOf(input) + "\n");
                        screenTextArea.appendText("帳戶餘額：" + String.valueOf(money) + "\n");
                    }else{
                        screenTextArea.appendText("提款" + String.valueOf(input) + "\n");
                        screenTextArea.appendText("帳戶餘額：" + String.valueOf(money) + "\n");
                        int diff = input - money;
                        screenTextArea.appendText("餘額不足" + String.valueOf(diff) + "\n");
                    }
                    break;
                case "checkButton":
                    screenTextArea.appendText("帳戶餘額：" + String.valueOf(money) + "\n");
                    break;
            }
            screenTextArea.appendText("\n");
        }catch(Exception e){
            
        }
    }
    
}

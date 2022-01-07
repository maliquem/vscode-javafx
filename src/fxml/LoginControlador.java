package fxml;

import org.controlsfx.control.Notifications;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginControlador {

    @FXML
    private TextField campoUser;
    @FXML
    private PasswordField campoSenha;

    public void entrar() {
        boolean userValido = campoUser.getText().equals("jael.rabelo");
        boolean senhaValido = campoSenha.getText().equals("suikoden");

        if (userValido && senhaValido) {
            Notifications.create().position(Pos.TOP_CENTER).title("Login FXML").text("Login Efetuado com Sucesso")
                    .showInformation();
        } else {
            Notifications.create().position(Pos.TOP_CENTER).title("Login FXML").text("Usuário ou senha invalido!")
                    .showError();
        }
    }

}

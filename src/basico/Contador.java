package basico;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Contador extends Application {

    private Integer cont = 0;

    private void atualizarEstilo(Label label) {
        label.setText(cont.toString());

        label.getStyleClass().remove("verde");
        label.getStyleClass().remove("vermelho");

        if (cont < 0) {
            label.getStyleClass().add("vermelho");
        } else if (cont > 0) {
            label.getStyleClass().add("verde");
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Label labelTitulo = new Label("Contador");
        labelTitulo.getStyleClass().add("titulo");
        Label labelNumero = new Label(cont.toString());
        labelNumero.getStyleClass().add("numero");

        Button botaoMais = new Button("+");
        Button botaoMenos = new Button("-");
        botaoMais.setOnAction(e -> {
            cont++;
            atualizarEstilo(labelNumero);
        });

        botaoMenos.setOnAction(e -> {
            cont--;
            atualizarEstilo(labelNumero);
        });

        botaoMais.getStyleClass().add("botao");
        botaoMenos.getStyleClass().add("botao");

        HBox boxBotoes = new HBox();
        boxBotoes.setAlignment(Pos.CENTER);
        boxBotoes.setSpacing(10);
        boxBotoes.getChildren().add(botaoMenos);
        boxBotoes.getChildren().add(botaoMais);

        VBox boxPrincipal = new VBox();
        boxPrincipal.getStyleClass().add("conteudo");
        boxPrincipal.setAlignment(Pos.CENTER);
        boxPrincipal.setSpacing(10);
        boxPrincipal.getChildren().add(labelTitulo);
        boxPrincipal.getChildren().add(labelNumero);
        boxPrincipal.getChildren().add(boxBotoes);

        String caminhoDoCss = getClass().getResource("/basico/Contador.css").toExternalForm();
        Scene cenaPrincipal = new Scene(boxPrincipal, 400, 400);
        cenaPrincipal.getStylesheets().add(caminhoDoCss);

        primaryStage.setScene(cenaPrincipal);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

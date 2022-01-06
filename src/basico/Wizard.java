package basico;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Wizard extends Application {

    private Stage janela;
    private Scene passo1;
    private Scene passo2;
    private Scene passo3;

    @Override
    public void start(Stage primaryStage) throws Exception {

        janela = primaryStage;

        criarPasso1();
        criarPasso2();
        criarPasso3();

        janela.setScene(passo1);
        janela.setTitle("Wizard :: Passo 01");
        janela.show();

    }

    private void criarPasso1() {
        Button botao = new Button("Proximo ->");
        botao.setOnAction(e -> {
            janela.setScene(passo2);
            janela.setTitle("Wizard :: Passo 02");
        });

        HBox box = new HBox();
        box.setAlignment(Pos.CENTER);
        box.getChildren().add(botao);

        passo1 = new Scene(box, 400, 400);
    }

    private void criarPasso2() {
        Button botaoA = new Button("<- Anterior");
        botaoA.setOnAction(e -> {
            janela.setScene(passo1);
            janela.setTitle("Wizard :: Passo 01");
        });
        Button botaoP = new Button("Proximo ->");
        botaoP.setOnAction(e -> {
            janela.setScene(passo3);
            janela.setTitle("Wizard :: Passo 03");
        });

        HBox box = new HBox();
        box.setAlignment(Pos.CENTER);
        box.setSpacing(30);
        box.getChildren().add(botaoA);
        box.getChildren().add(botaoP);

        passo2 = new Scene(box, 400, 400);
    }

    private void criarPasso3() {
        Button botaoA = new Button("<- Anterior");
        botaoA.setOnAction(e -> {
            janela.setScene(passo2);
            janela.setTitle("Wizard :: Passo 02");
        });
        Button botaoP = new Button("SAIR!");
        botaoP.setOnAction(e -> System.exit(0));

        HBox box = new HBox();
        box.setAlignment(Pos.CENTER);
        box.setSpacing(30);
        box.getChildren().add(botaoA);
        box.getChildren().add(botaoP);

        passo3 = new Scene(box, 400, 400);
    }

    public static void main(String[] args) {
        launch(args);
    }

}

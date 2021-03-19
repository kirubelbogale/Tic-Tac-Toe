package ca.cmpt213.asn4.tictactoe.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToe extends Application {
    public int turn = 0;
    public Label myLabel = new Label("");
    public int[][] arr = new int [4][4];
    public static void main(String[] args) {
        launch(args);
    }
    public GridPane gridpane = new GridPane();

    public void createGrid() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Image img = new Image("file:blank.png");
                ImageView imgView = new ImageView(img);
                imgView.setFitHeight(100);
                imgView.setFitWidth(100);
                gridpane.add(imgView, i, j);
                imgView.addEventHandler(MouseEvent.MOUSE_CLICKED, new ImageClickHandler());
            }
        }
    }

    public void endGame() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = 3;
            }
        }
    }

    public void xWins() {
        endGame();
        myLabel.setText("X is the winner!");
        gridpane.add(myLabel, 2, 4);
    }

    public void yWins() {
        endGame();
        myLabel.setText("Y is the winner!");
        gridpane.add(myLabel, 2, 4);
    }

    public void diagonalCheck() {
        if (((arr[0][0] == arr[1][1]) && (arr[1][1] == arr[2][2])) && (arr[2][2] == arr[3][3])) {
            if (arr[1][1] == 1) {
                xWins();
            } else if (arr[1][1] == 2) {
                yWins();
            }
        } else if (((arr[3][0] == arr[2][1]) && (arr[2][1] == arr[1][2])) && (arr[1][2] == arr[0][3])) {
            if (arr[3][0] == 1) {
                xWins();
            } else if (arr[3][0] == 2) {
                yWins();
            }
        }
    }

    public void rowCheck() {
        if (((arr[0][0] == arr[1][0]) && (arr[1][0] == arr[2][0])) && (arr[2][0] == arr[3][0])) {
            if (arr[3][0] == 1) {
                xWins();
            } else if (arr[3][0] == 2) {
                yWins();
            }
        }
        if (((arr[0][1] == arr[1][1]) && (arr[1][1] == arr[2][1])) && (arr[2][1] == arr[3][1])) {
            if (arr[0][1] == 1) {
                xWins();
            } else if (arr[0][1] == 2) {
                yWins();
            }
        }
        if (((arr[0][2] == arr[1][2]) && (arr[1][2] == arr[2][2])) & (arr[2][2] == arr[3][2])) {
            if (arr[0][2] == 1) {
                xWins();
            } else if (arr[0][2] == 2) {
                yWins();
            }
        }
        if (((arr[0][1] == arr[1][1]) && (arr[1][1] == arr[2][1])) && (arr[2][1] == arr[3][1])) {
            if (arr[1][1] == 1) {
                xWins();
            } else if (arr[1][1] == 2) {
                yWins();
            }
        }
        if (((arr[0][3] == arr[1][3]) && (arr[1][3] == arr[2][3])) && (arr[2][3] == arr[3][3])) {
            if (arr[0][3] == 1) {
                xWins();
            } else if (arr[0][3] == 2) {
                yWins();
            }
        }
    }

    public void columnCheck() {
        if (((arr[0][0] == arr[0][1]) && (arr[0][1] == arr[0][2])) && (arr[0][2] == arr[0][3])) {
            if (arr[0][2] == 1) {
                xWins();
            } else if (arr[0][2] == 2) {
                yWins();
            }
        }
        if (((arr[1][0] == arr[1][1]) && (arr[1][1] == arr[1][2])) && (arr[1][2] == arr[1][3])) {
            if (arr[1][0] == 1) {
                xWins();
            } else if (arr[1][0] == 2) {
                yWins();
            }
        }
        if (((arr[2][0] == arr[2][1]) && (arr[2][1] == arr[2][2])) && (arr[2][2] == arr[2][3])) {
            if (arr[2][0] == 1) {
                xWins();
            } else if (arr[2][0] == 2) {
                yWins();
            }
        }
        if (((arr[3][0] == arr[3][1]) && (arr[3][1] == arr[3][2])) && (arr[3][2] == arr[3][3])) {
            if (arr[3][0] == 1) {
                xWins();
            } else if (arr[3][0] == 2) {
                yWins();
            }
        }
    }

    public void checkForTie() {
        int x = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (arr[i][j] == 1) {
                    x++;
                } else if (arr[i][j] == 2) {
                    x++;
                }
            }
        }
        if (x == 16) {
            myLabel.setText("Tie game.");
            gridpane.add(myLabel, 2, 4);
        }
    }

    public void playGame() {
        diagonalCheck();
        rowCheck();
        columnCheck();
        checkForTie();
    }

    @Override
    public void start(Stage gameStage) throws Exception {
        gameStage.setTitle("Tic-Tac-Toe");
        Button reset = new Button ("New Game");
        reset.setOnAction(new ButtonClickHandler());
        reset.setMaxSize(100, 50);
        gridpane.add(reset, 3, 6);
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        gridpane.setAlignment(Pos.TOP_CENTER);
        createGrid();
        gridpane.setPadding(new Insets(10));
        Scene scene = new Scene(gridpane, 600, 600);
        gameStage.setScene(scene);
        gameStage.show();
    }

    class ImageClickHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            ImageView source = (ImageView)event.getSource();
            Integer columnIndex = GridPane.getColumnIndex(source);
            int row = GridPane.getRowIndex(source);
            int column = columnIndex;
            if (turn % 2 == 0) {
                if (arr[row][column] != 0) {
                    return;
                }
                ((ImageView)event.getSource()).setImage(new Image("file:x.png"));
                turn++;
                arr[row][column] = 1;
                playGame();
            } else {
                if (arr[row][column] != 0) {
                    return;
                }
                ((ImageView)event.getSource()).setImage(new Image("file:o.png"));
                turn++;
                arr[row][column] = 2;
                playGame();
            }
        }
    }

    class ButtonClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            turn = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    arr[i][j] = 0;
                }
            }
            myLabel.setText("");
            createGrid();
        }
    }
}

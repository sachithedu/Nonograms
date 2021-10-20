package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ColumnCluesView implements FXComponent {

  private Controller controller;

  public ColumnCluesView(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    HBox hbox = new HBox();
    hbox.setAlignment(Pos.CENTER);

    for (int col = 0; col < controller.getClues().getWidth(); col++) {
      VBox vbox = new VBox();
      vbox.setAlignment(Pos.CENTER);
      int[] colClues = controller.getClues().getColClues(col);
      for (int row = 0; row < controller.getClues().getColCluesLength(); row++) {
        TextField text = new TextField(String.valueOf(colClues[row]));
        if (text.getText().equals("0")) {
          text.setText("-");
        }
        text.setEditable(false);
        text.setStyle("fx-focus-color: transparent");
        text.setPrefSize(30, 30);
        vbox.getChildren().add(text);
      }
      hbox.getChildren().add(vbox);
    }
    return hbox;
  }
}

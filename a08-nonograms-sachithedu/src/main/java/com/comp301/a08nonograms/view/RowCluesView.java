package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class RowCluesView implements FXComponent {

  private Controller controller;

  public RowCluesView(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    VBox vbox = new VBox();
    vbox.setAlignment(Pos.CENTER);

    for (int row = 0; row < controller.getClues().getHeight(); row++) {
      HBox hbox = new HBox();
      hbox.setAlignment(Pos.CENTER);
      int[] rowClues = controller.getClues().getRowClues(row);
      for (int col = 0; col < controller.getClues().getRowCluesLength(); col++) {
        TextField text = new TextField(String.valueOf(rowClues[col]));
        if (text.getText().equals("0")) {
          text.setText("-");
        }
        text.setEditable(false);
        text.setPrefSize(30, 30);
        hbox.getChildren().add(text);
      }
      vbox.getChildren().add(hbox);
    }
    return vbox;
  }
}

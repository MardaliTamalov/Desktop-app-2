package com.example.desktopapp2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class DesktopApp extends Application {
       @Override
    public void start(final Stage stage) throws Exception {
        Button button = new Button("выберите файл");
        stage.setTitle("Моя программа");
        Label text = new Label();
           text.setWrapText(true);
        button.setOnAction(event -> {
            FileChooser chooser = new FileChooser();
            File fileName = chooser.showOpenDialog(stage);
            String fileContents;
            try {
                fileContents = Files.lines(Paths.get(fileName.toString()))//, StandardCharsets.UTF_8)
                        .collect(Collectors.joining("\n"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            text.setText("файл содержит: "+ "\n" + fileContents);
        });

        VBox vbox = new VBox(20, button, text);
       // vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        stage.setScene(new Scene(vbox,1000,500));
        stage.show();
    }
}
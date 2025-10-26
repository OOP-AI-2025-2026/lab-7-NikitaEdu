package ua.opnu.TaskBonus;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SortingList extends Application {

    private ObservableList<Student> students;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Список студентів");

        students = populateList();

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(5));
        vbox.setAlignment(Pos.CENTER);

        final ListView<Student> listView = new ListView<>(students);
        listView.setPrefSize(400, 240);

        final HBox hbox = setButtons();

        vbox.getChildren().addAll(listView, hbox);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private ObservableList<Student> populateList() {
        Student student1 = new Student("Борис", "Іванов", 75);
        Student student2 = new Student("Петро", "Петренко", 92);
        Student student3 = new Student("Сергій", "Сергієнко", 61);
        Student student4 = new Student("Григорій", "Сковорода", 88);

        return FXCollections.observableArrayList(
                student1, student2, student3, student4);
    }

    private HBox setButtons() {
        final Button sortByNameButton = new Button("Сортувати за ім'ям");
        final Button sortByLastNameButton = new Button("Сортувати за прізвищем");
        final Button sortByMarkButton = new Button("Сортувати за оцінкою");

        HBox.setHgrow(sortByNameButton, Priority.ALWAYS);
        HBox.setHgrow(sortByLastNameButton, Priority.ALWAYS);
        HBox.setHgrow(sortByMarkButton, Priority.ALWAYS);
        sortByNameButton.setMaxWidth(Double.MAX_VALUE);
        sortByLastNameButton.setMaxWidth(Double.MAX_VALUE);
        sortByMarkButton.setMaxWidth(Double.MAX_VALUE);

        final boolean[] order = {true, true, true};

        sortByNameButton.setOnAction(event -> {
            students.sort((s1, s2) -> order[0] ? s1.getName().compareTo(s2.getName()) : s2.getName().compareTo(s1.getName()));
            order[0] = !order[0];
        });

        sortByLastNameButton.setOnAction(event -> {
            students.sort((s1, s2) -> order[1] ? s1.getLastName().compareTo(s2.getLastName()) : s2.getLastName().compareTo(s1.getLastName()));
            order[1] = !order[1];
        });

        sortByMarkButton.setOnAction(event -> {
            students.sort((s1, s2) -> order[2] ? Double.compare(s1.getAvgMark(), s2.getAvgMark()) : Double.compare(s2.getAvgMark(), s1.getAvgMark()));
            order[2] = !order[2];
        });

        HBox hb = new HBox(5, sortByNameButton, sortByLastNameButton, sortByMarkButton);
        hb.setAlignment(Pos.CENTER);

        return hb;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
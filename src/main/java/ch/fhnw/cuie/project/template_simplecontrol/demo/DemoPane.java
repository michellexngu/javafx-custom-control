package ch.fhnw.cuie.project.template_simplecontrol.demo;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import ch.fhnw.cuie.project.template_simplecontrol.SnowControl;
import javafx.util.converter.NumberStringConverter;

class DemoPane extends BorderPane {

    private final SnowPM pm;

    // declare the custom control
    private SnowControl snowControl;

    // all controls
    private TextField snowHeight;
    private Label snowHeightLabel;

    public DemoPane(SnowPM pm) {
        this.pm = pm;
        initializeControls();
        layoutControls();
        setupBindings();
        setupValueChangeListener();
    }

    private void initializeControls() {
        setPadding(new Insets(10));

        snowControl = new SnowControl();
        snowHeight = new TextField();
        snowHeightLabel = new Label("Current height in cm:");
    }

    private void layoutControls() {
        VBox controlPane = new VBox(new Label("Snow"),
                            snowHeightLabel, snowHeight);

        controlPane.setPadding(new Insets(0, 20, 0, 20));
        controlPane.setSpacing(2);

        setCenter(snowControl);
        setRight(controlPane);
    }

    private void setupBindings() {
        //snowControl.valueProperty().bindBidirectional(pm.pmValueProperty());
        snowHeight.textProperty().bindBidirectional(pm.snowValueProperty(), new NumberStringConverter());
        snowControl.valueProperty().bindBidirectional(pm.snowValueProperty());
    }

    private void setupValueChangeListener() {
        snowHeight.textProperty().addListener((observable, oldValue, newValue) -> {
            if (snowHeight.getText().isEmpty()) {

            }
            else if(!(Double.valueOf(newValue).doubleValue() >=-300 && Double.valueOf(newValue).doubleValue() <=300 )){
                this.snowHeight.textProperty().setValue(oldValue);
            }
        });
    }

}

package ch.fhnw.cuie.project.template_simplecontrol.demo;

import javafx.geometry.Insets;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import ch.fhnw.cuie.project.template_simplecontrol.SnowControl;

class DemoPane extends BorderPane {

    private final PresentationModel pm;

    // declare the custom control
    private SnowControl cc;

    // all controls
    private TextField snowHeight;


    public DemoPane(PresentationModel pm) {
        this.pm = pm;
        initializeControls();
        layoutControls();
        setupBindings();
    }

    private void initializeControls() {
        setPadding(new Insets(10));

        cc = new SnowControl();
        snowHeight = new TextField();
    }

    private void layoutControls() {
        VBox controlPane = new VBox(new Label("Snow Height"),
                                    snowHeight);
        controlPane.setPadding(new Insets(0, 50, 0, 50));
        controlPane.setSpacing(10);

        setCenter(cc);
        setRight(controlPane);
    }

    private void setupBindings() {
        cc.valueProperty().bindBidirectional(pm.pmValueProperty());

    }

}

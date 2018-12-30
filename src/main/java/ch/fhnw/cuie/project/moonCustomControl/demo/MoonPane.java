package ch.fhnw.cuie.project.moonCustomControl.demo;

import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

/**
 * @author Dieter Holz
 */
public class MoonPane extends StackPane {
	private Region regionMoon;
	private Region summitLeft;
	private Region sliderButton;

	public MoonPane() {
        initializeSelf();
		initializeParts();
		layoutParts();
	}

    private void initializeSelf() {
	    setPrefSize(300, 300);
        String fonts = getClass().getResource("/fonts/fonts.css").toExternalForm();
        getStylesheets().add(fonts);

        String stylesheet = getClass().getResource("style.css").toExternalForm();
        getStylesheets().add(stylesheet);
    }

	private void initializeParts() {
		regionMoon = new Region();
		regionMoon.getStyleClass().addAll("moonPlayground");

		summitLeft = new Region();
		summitLeft.getStyleClass().add("summit-left");

		sliderButton = new Region();
		sliderButton.getStyleClass().add("slider-button");
	}

	private void layoutParts() {
		getChildren().addAll(regionMoon, sliderButton, summitLeft);
	}
}

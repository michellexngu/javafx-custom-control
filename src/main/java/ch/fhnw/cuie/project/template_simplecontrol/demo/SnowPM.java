package ch.fhnw.cuie.project.template_simplecontrol.demo;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;

public class SnowPM {
    private final DoubleProperty        pmValue   = new SimpleDoubleProperty();
    private final DoubleProperty        snowValue = new SimpleDoubleProperty();

    public double getPmValue() {
        return pmValue.get();
    }

    public DoubleProperty pmValueProperty() {
        return pmValue;
    }

    public void setPmValue(double pmValue) {
        this.pmValue.set(pmValue);
    }

    public double getSnowValue() {
        return snowValue.get();
    }

    public DoubleProperty snowValueProperty() {
        return snowValue;
    }

    public void setSnowValue(double snowValue) {
        this.snowValue.set(snowValue);
    }

}

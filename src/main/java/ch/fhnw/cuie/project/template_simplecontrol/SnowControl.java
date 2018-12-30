package ch.fhnw.cuie.project.template_simplecontrol;

import java.util.List;
import java.util.Locale;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.css.CssMetaData;
import javafx.css.SimpleStyleableObjectProperty;
import javafx.css.Styleable;
import javafx.css.StyleableObjectProperty;
import javafx.css.StyleablePropertyFactory;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextBoundsType;

/**
 * ToDo: CustomControl kurz beschreiben
 *
 * @author
 * Julia Müller
 * Michelle Ngu
 */

//Todo: Umbenennen.
public class SnowControl extends Region {
    // needed for StyleableProperties
    private static final StyleablePropertyFactory<SnowControl> FACTORY = new StyleablePropertyFactory<>(Region.getClassCssMetaData());

    @Override
    public List<CssMetaData<? extends Styleable, ?>> getCssMetaData() {
        return FACTORY.getCssMetaData();
    }

    private static final Locale CH = new Locale("de", "CH");

    private static final double ARTBOARD_WIDTH  = 500;  // Todo: Breite der "Zeichnung" aus dem Grafik-Tool übernehmen
    private static final double ARTBOARD_HEIGHT = 350;

    private static final double ASPECT_RATIO = ARTBOARD_WIDTH / ARTBOARD_HEIGHT;

    private static final double MINIMUM_WIDTH  = 25;    // Todo: Anpassen
    private static final double MINIMUM_HEIGHT = MINIMUM_WIDTH / ASPECT_RATIO;

    private static final double MAXIMUM_WIDTH = 800;    // Todo: Anpassen

    // Todo: diese Parts durch alle notwendigen Parts der gewünschten CustomControl ersetzen
    private Region mountains;
    private Region snowSlider;
    private Button sliderButton;
    private Region fallingSnow;

    private Region snowHillRight;
    private Region snowShadowRight;
    private Region snowHillLeft;
    private Region snowShadowLeft;
    private Region snowHillBottom;


    // Todo: ersetzen durch alle notwendigen Properties der CustomControl
    private final DoubleProperty value = new SimpleDoubleProperty();

    // Todo: ergänzen mit allen  CSS stylable properties
    private static final CssMetaData<SnowControl, Color> BASE_COLOR_META_DATA = FACTORY.createColorCssMetaData("-base-color", s -> s.baseColor);

    private final StyleableObjectProperty<Color> baseColor = new SimpleStyleableObjectProperty<Color>(BASE_COLOR_META_DATA, this, "baseColor") {
        @Override
        protected void invalidated() {
            setStyle(getCssMetaData().getProperty() + ": " + colorToCss(get()) + ";");
            applyCss();
        }
    };

    // needed for resizing
    private Pane drawingPane;

    private Group snowHillGroup;

    public SnowControl() {
        initializeSelf();
        initializeParts();
        initializeDrawingPane();
        layoutParts();
        setupEventHandlers();
        setupValueChangeListeners();
        setupBindings();
    }

    private void initializeSelf() {
        // load stylesheets
        String fonts = getClass().getResource("/fonts/fonts.css").toExternalForm();
        getStylesheets().add(fonts);

        String stylesheet = getClass().getResource("style.css").toExternalForm();
        getStylesheets().add(stylesheet);

        getStyleClass().add("Snow-control");
    }

    private void initializeParts() {
        //ToDo: alle deklarierten Parts initialisieren

        snowHillRight = new Region();
        snowHillRight.getStyleClass().add("snow-hill-right");
        snowHillRight.setPrefWidth(323.4);
        snowHillRight.setPrefHeight(132.32);
        snowHillRight.setLayoutX(177);
        snowHillRight.setLayoutY(217);

        snowShadowRight = new Region();
        snowShadowRight.getStyleClass().add("snow-shadow-right");
        snowShadowRight.setPrefWidth(299.8);
        snowShadowRight.setPrefHeight(72.93);
        snowShadowRight.setLayoutX(200);
        snowShadowRight.setLayoutY(229);

        snowHillLeft = new Region();
        snowHillLeft.getStyleClass().add("snow-hill-left");
        snowHillLeft.setPrefWidth(499.98);
        snowHillLeft.setPrefHeight(127.24);
        snowHillLeft.setLayoutX(0);
        snowHillLeft.setLayoutY(222);

        snowShadowLeft = new Region();
        snowShadowLeft.getStyleClass().add("snow-shadow-left");
        snowShadowLeft.setPrefWidth(499.97);
        snowShadowLeft.setPrefHeight(89.69);
        snowShadowLeft.setLayoutX(0);
        snowShadowLeft.setLayoutY(257);

        snowHillBottom = new Region();
        snowHillBottom.getStyleClass().add("snow-hill-bottom");
        snowHillBottom.setPrefWidth(500);
        snowHillBottom.setPrefHeight(68);
        snowHillBottom.setLayoutX(0);
        snowHillBottom.setLayoutY(282);

        mountains = new Region();
        mountains.setPrefHeight(274.23);
        mountains.setPrefWidth(437.46);
        mountains.setLayoutX(60);
        mountains.setLayoutY(52);;
        mountains.getStyleClass().add("mountains");

        snowSlider = new Region();
        snowSlider.setPrefHeight(229.02);
        snowSlider.setPrefWidth(50.81);
        snowSlider.setLayoutX(0);
        snowSlider.setLayoutY(121);
        snowSlider.getStyleClass().add("snow-slider");

        sliderButton = new Button();
        sliderButton.setLayoutY(213);
        sliderButton.setLayoutX(2);
        sliderButton.getStyleClass().add("slider-button");

        fallingSnow = new Region();
        fallingSnow.getStyleClass().add("falling-snow");
        fallingSnow.setVisible(true);

    }

    private void initializeDrawingPane() {
        drawingPane = new Pane();
        drawingPane.getStyleClass().add("drawing-pane");
        drawingPane.setMaxSize(ARTBOARD_WIDTH, ARTBOARD_HEIGHT);
        drawingPane.setMinSize(ARTBOARD_WIDTH, ARTBOARD_HEIGHT);
        drawingPane.setPrefSize(ARTBOARD_WIDTH, ARTBOARD_HEIGHT);

        snowHillGroup = new Group();
    }

    private void layoutParts() {
        // ToDo: alle Parts zur drawingPane hinzufügen

        snowHillGroup.getChildren().addAll(snowHillRight, snowShadowRight, snowHillLeft, snowShadowLeft, snowHillBottom);
        drawingPane.getChildren().addAll(fallingSnow, mountains, snowHillGroup, snowSlider, sliderButton);

        getChildren().add(drawingPane);
    }

    private void setupEventHandlers() {
        //ToDo: bei Bedarf ergänzen
    }

    private void setupValueChangeListeners() {
        //ToDo: bei Bedarf ergänzen
    }

    private void setupBindings() {
        //ToDo dieses Binding ersetzen

    }


    //resize by scaling
    @Override
    protected void layoutChildren() {
        super.layoutChildren();
        resize();
    }

    private void resize() {
        Insets padding         = getPadding();
        double availableWidth  = getWidth() - padding.getLeft() - padding.getRight();
        double availableHeight = getHeight() - padding.getTop() - padding.getBottom();

        double width = Math.max(Math.min(Math.min(availableWidth, availableHeight * ASPECT_RATIO), MAXIMUM_WIDTH), MINIMUM_WIDTH);

        double scalingFactor = width / ARTBOARD_WIDTH;

        if (availableWidth > 0 && availableHeight > 0) {
            relocateDrawingPaneCentered();
            drawingPane.setScaleX(scalingFactor);
            drawingPane.setScaleY(scalingFactor);
        }
    }

    private void relocateDrawingPaneCentered() {
        drawingPane.relocate((getWidth() - ARTBOARD_WIDTH) * 0.5, (getHeight() - ARTBOARD_HEIGHT) * 0.5);
    }

    private void relocateDrawingPaneCenterBottom(double scaleY, double paddingBottom) {
        double visualHeight = ARTBOARD_HEIGHT * scaleY;
        double visualSpace  = getHeight() - visualHeight;
        double y            = visualSpace + (visualHeight - ARTBOARD_HEIGHT) * 0.5 - paddingBottom;

        drawingPane.relocate((getWidth() - ARTBOARD_WIDTH) * 0.5, y);
    }

    private void relocateDrawingPaneCenterTop(double scaleY, double paddingTop) {
        double visualHeight = ARTBOARD_HEIGHT * scaleY;
        double y            = (visualHeight - ARTBOARD_HEIGHT) * 0.5 + paddingTop;

        drawingPane.relocate((getWidth() - ARTBOARD_WIDTH) * 0.5, y);
    }

    // some handy functions

    //ToDo: diese Funktionen anschauen und für die Umsetzung des CustomControls benutzen

    private double percentageToValue(double percentage, double minValue, double maxValue){
        return ((maxValue - minValue) * percentage) + minValue;
    }

    private double valueToPercentage(double value, double minValue, double maxValue) {
        return (value - minValue) / (maxValue - minValue);
    }

    private double valueToAngle(double value, double minValue, double maxValue) {
        return percentageToAngle(valueToPercentage(value, minValue, maxValue));
    }

    private double mousePositionToValue(double mouseX, double mouseY, double cx, double cy, double minValue, double maxValue){
        double percentage = angleToPercentage(angle(cx, cy, mouseX, mouseY));

        return percentageToValue(percentage, minValue, maxValue);
    }

    private double angleToPercentage(double angle){
        return angle / 360.0;
    }

    private double percentageToAngle(double percentage){
        return 360.0 * percentage;
    }

    private double angle(double cx, double cy, double x, double y) {
        double deltaX = x - cx;
        double deltaY = y - cy;
        double radius = Math.sqrt((deltaX * deltaX) + (deltaY * deltaY));
        double nx     = deltaX / radius;
        double ny     = deltaY / radius;
        double theta  = Math.toRadians(90) + Math.atan2(ny, nx);

        return Double.compare(theta, 0.0) >= 0 ? Math.toDegrees(theta) : Math.toDegrees((theta)) + 360.0;
    }

    private Point2D pointOnCircle(double cX, double cY, double radius, double angle) {
        return new Point2D(cX - (radius * Math.sin(Math.toRadians(angle - 180))),
                           cY + (radius * Math.cos(Math.toRadians(angle - 180))));
    }

    private Text createCenteredText(String styleClass) {
        return createCenteredText(ARTBOARD_WIDTH * 0.5, ARTBOARD_HEIGHT * 0.5, styleClass);
    }

    private Text createCenteredText(double cx, double cy, String styleClass) {
        Text text = new Text();
        text.getStyleClass().add(styleClass);
        text.setTextOrigin(VPos.CENTER);
        text.setTextAlignment(TextAlignment.CENTER);
        double width = cx > ARTBOARD_WIDTH * 0.5 ? ((ARTBOARD_WIDTH - cx) * 2.0) : cx * 2.0;
        text.setWrappingWidth(width);
        text.setBoundsType(TextBoundsType.VISUAL);
        text.setY(cy);
        text.setX(cx - (width / 2.0));

        return text;
    }

    private Group createTicks(double cx, double cy, int numberOfTicks, double overallAngle, double tickLength, double indent, double startingAngle, String styleClass) {
        Group group = new Group();

        double degreesBetweenTicks = overallAngle == 360 ?
                                     overallAngle /numberOfTicks :
                                     overallAngle /(numberOfTicks - 1);
        double outerRadius         = Math.min(cx, cy) - indent;
        double innerRadius         = Math.min(cx, cy) - indent - tickLength;

        for (int i = 0; i < numberOfTicks; i++) {
            double angle = 180 + startingAngle + i * degreesBetweenTicks;

            Point2D startPoint = pointOnCircle(cx, cy, outerRadius, angle);
            Point2D endPoint   = pointOnCircle(cx, cy, innerRadius, angle);

            Line tick = new Line(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
            tick.getStyleClass().add(styleClass);
            group.getChildren().add(tick);
        }

        return group;
    }

//    private Group createNumberedTicks(double cx, double cy, int numberOfTicks, double overallAngle, double tickLength, double indent, double startingAngle, String styleClass) {
//            Group group = new Group();
//
//            int width = 30;
//            double degreesBetweenTicks = overallAngle == 360 ?
//                    overallAngle / numberOfTicks :
//                    overallAngle / (numberOfTicks - 1);
//            double outerRadius = Math.min(cx - width, cy - width) - indent;
//            double innerRadius = Math.min(cx - width, cy - width) - indent - tickLength;
//
//            for (int i = 0; i < numberOfTicks; i++) {
//                double angle = 180 + startingAngle + i * degreesBetweenTicks;
//
//                if (i % 5 == 0 && i % 2 != 0) {
//                    Point2D startPoint = pointOnCircle(cx, cy, outerRadius, angle);
//                    Point2D endPoint = pointOnCircle(cx, cy, innerRadius * 0.95, angle);
//                    Line tick = new Line(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
//                    tick.getStyleClass().add(styleClass);
//                    group.getChildren().add(tick);
//                }
//                if (i % 10 == 0) {
//                    Point2D startPoint = pointOnCircle(cx, cy, outerRadius, angle);
//                    Point2D endPoint = pointOnCircle(cx, cy, innerRadius * 0.9, angle);
//
//                    Line bigTick = new Line(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
//                    bigTick.getStyleClass().add(styleClass);
//                    group.getChildren().add(bigTick);
//
//                    Point2D textPosition = pointOnCircle(cx - 7, cy + 5, innerRadius * 0.8, angle);
//                    Text number = new Text(textPosition.getX(), textPosition.getY(), Integer.toString(i));
//                    number.getStyleClass().add("tick-number");
//                    group.getChildren().add(number);
//
//                } else {
//                    Point2D startPoint = pointOnCircle(cx, cy, outerRadius, angle);
//                    Point2D endPoint = pointOnCircle(cx, cy, innerRadius, angle);
//                    Line tick = new Line(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
//                    tick.getStyleClass().add(styleClass);
//                    group.getChildren().add(tick);
//                }
//            }
//
//            return group;
//        }

    private String colorToCss(final Color color) {
  		return color.toString().replace("0x", "#");
  	}


    // compute sizes

    @Override
    protected double computeMinWidth(double height) {
        Insets padding           = getPadding();
        double horizontalPadding = padding.getLeft() + padding.getRight();

        return MINIMUM_WIDTH + horizontalPadding;
    }

    @Override
    protected double computeMinHeight(double width) {
        Insets padding         = getPadding();
        double verticalPadding = padding.getTop() + padding.getBottom();

        return MINIMUM_HEIGHT + verticalPadding;
    }

    @Override
    protected double computePrefWidth(double height) {
        Insets padding           = getPadding();
        double horizontalPadding = padding.getLeft() + padding.getRight();

        return ARTBOARD_WIDTH + horizontalPadding;
    }

    @Override
    protected double computePrefHeight(double width) {
        Insets padding         = getPadding();
        double verticalPadding = padding.getTop() + padding.getBottom();

        return ARTBOARD_HEIGHT + verticalPadding;
    }

    // alle getter und setter  (generiert via "Code -> Generate... -> Getter and Setter)

    // ToDo: ersetzen durch die Getter und Setter Ihres CustomControls
    public double getValue() {
        return value.get();
    }

    public DoubleProperty valueProperty() {
        return value;
    }

    public void setValue(double value) {
        this.value.set(value);
    }
}

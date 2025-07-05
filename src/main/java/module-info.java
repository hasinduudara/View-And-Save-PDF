module lk.hasindu.viewandsavepdf {
    requires javafx.controls;
    requires javafx.fxml;
    requires itextpdf;


    opens lk.hasindu.viewandsavepdf to javafx.fxml;
    exports lk.hasindu.viewandsavepdf;
    opens lk.hasindu.viewandsavepdf.controller to javafx.fxml;
}
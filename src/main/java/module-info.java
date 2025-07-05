module lk.hasindu.viewandsavepdf {
    requires javafx.controls;
    requires javafx.fxml;


    opens lk.hasindu.viewandsavepdf to javafx.fxml;
    exports lk.hasindu.viewandsavepdf;
}
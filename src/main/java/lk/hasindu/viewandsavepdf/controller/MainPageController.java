package lk.hasindu.viewandsavepdf.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileOutputStream;

public class MainPageController {

    @FXML
    private Button btnSavePDF;

    @FXML
    private AnchorPane mainPage;

    @FXML
    private TextArea txtMailDescription;

    @FXML
    private TextField txtMailTitle;

    @FXML
    void btnSavePDFOnAction(ActionEvent event) {
        try {
            // Get user input
            String title = txtMailTitle.getText();
            String description = txtMailDescription.getText();

            // Choose where to save
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save PDF");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
            fileChooser.setInitialFileName("mail.pdf");
            File file = fileChooser.showSaveDialog(mainPage.getScene().getWindow());

            if (file != null) {
                // Create PDF
                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream(file));
                document.open();

                // Add email-like formatting
                document.add(new Paragraph("Subject: " + title));
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("Description: " + description));

                document.close();

//              System.out.println("PDF saved successfully.");

                // Show success notification
                javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("PDF saved successfully!");
                alert.showAndWait();

                clearTitleAndDescription();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearTitleAndDescription() {
        txtMailTitle.clear();
        txtMailDescription.clear();
    }

}

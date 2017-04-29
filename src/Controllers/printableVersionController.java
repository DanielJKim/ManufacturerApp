package Controllers;

import Form.Form;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Status: incomplete.
 */
public class printableVersionController {

    private Form form;

    @FXML
    private AnchorPane printAnchorPane;
    @FXML
    private Label ttb_id_print;
    @FXML
    private Label rep_id_print;
    @FXML
    private Label permit_no_print;
    @FXML
    private Label serial_no_print;
    @FXML
    private Label brand_name_print;
    @FXML
    private Label fanciful_name_print;
    @FXML
    private Label formula_print;
    @FXML
    private Label grape_varietals_print;
    @FXML
    private Label wine_appellation_print;
    @FXML
    private Label phone_no_print;
    @FXML
    private Label email_print;
    @FXML
    private Label mailing_street_address1_print;
    @FXML
    private Label mailing_second_line1_print;
    @FXML
    private Label mailing_third_line1_print;
    @FXML
    private Label mailing_street_address2_print;
    @FXML
    private Label mailing_second_line2_print;
    @FXML
    private Label mailing_third_line2_print;
    @FXML
    private CheckBox domesticCheck;
    @FXML
    private CheckBox importCheck;
    @FXML
    private CheckBox wineCheck;
    @FXML
    private CheckBox distilledCheck;
    @FXML
    private CheckBox maltCheck;
    @FXML
    private Label label_text_print;
    @FXML
    private Label submit_date_print,
            signature_print,
            applicant_name_print;
    @FXML
    private CheckBox cert_label_approval_print,
            cert_exemption_print,
            cert_distinctive_print,
            cert_resubmission_print;
    public void setFormPrintableVersion(Form form) {
        System.out.println("this is form" + form);
        System.out.println(form.getttb_id());
//        form = dbManager.findSingleForm(form.getttb_id(), new ArrayList<>());
        ttb_id_print.setText(form.getttb_id());
        rep_id_print.setText(form.getrep_id());
        permit_no_print.setText(form.getpermit_no());
        serial_no_print.setText(form.getserial_no());
        brand_name_print.setText(form.getbrand_name());
        fanciful_name_print.setText(form.getfanciful_name());
        formula_print.setText(form.getformula());
        wine_appellation_print.setText(form.getwine_appellation());
        grape_varietals_print.setText(form.getgrape_varietals());
        phone_no_print.setText(form.getphone_no());
        email_print.setText(form.getEmail());
        mailing_street_address1_print.setText("");
        mailing_street_address2_print.setText("");
        mailing_second_line1_print.setText("");
        mailing_second_line2_print.setText("");
        mailing_third_line1_print.setText("");
        mailing_third_line2_print.setText("");
        if(form.getSource().equals("Domestic")) {
            domesticCheck.setSelected(true);
        } else {
            importCheck.setSelected(true);
        }
        if(form.getalcohol_type().equals("Wine")) {
            wineCheck.setSelected(true);
        } else if(form.getalcohol_type().equals("Malt Beverages")) {
            maltCheck.setSelected(true);
        } else {
            distilledCheck.setSelected(true);
        }
        label_text_print.setText(form.getlabel_text());
        submit_date_print.setText(form.getsubmit_date().toString());
        signature_print.setText(form.getSignature());
        applicant_name_print.setText(form.getapplicant_id()); // TODO: add query for getting search
        if(!form.getapplication_type().isEmpty() && form.getapplication_type().get(0) == true) {
            cert_label_approval_print.setSelected(true);
        } else if(!form.getapplication_type().isEmpty() && form.getapplication_type().get(1) == true) {
            cert_exemption_print.setSelected(true);
        } else if(!form.getapplication_type().isEmpty() && form.getapplication_type().get(2) == true) {
            cert_distinctive_print.setSelected(true);
        } else {
            cert_resubmission_print.setSelected(true);
        }
    }


    public void saveAsPng(){
        WritableImage image = printAnchorPane.snapshot(new SnapshotParameters(), null);
        // TODO: probably use a file chooser here
        File file = new File(System.getProperty("user.dir") + "/form.png");
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            // TODO: handle exception here
            e.printStackTrace();
        }

    }
}

package builder;

import javax.persistence.*;

@Entity
@Table(name = "testDrugs", schema = "drugs")
public class Drug {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "dosage_form")
    private String dosageForm;
    @Column(name = "indication")
    private String medicalIndication;
    @Column(name = "contraindication")
    private String medicalContraIndication;
    @Column(name = "side_effect")
    private String sideEffect;
    @Column(name = "overdose")
    private String overdose;
    @Column(name = "warning")
    private String warning;
    @Column(name = "pregnancy")
    private String pregnancy;

    public Drug() {
    }

    public Drug(String name, String manufacturer, String dosageForm, String medicalIndication,
                String medicalContraIndication, String sideEffect, String overdose,
                String warning, String pregnancy) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.dosageForm = dosageForm;
        this.medicalIndication = medicalIndication;
        this.medicalContraIndication = medicalContraIndication;
        this.sideEffect = sideEffect;
        this.overdose = overdose;
        this.warning = warning;
        this.pregnancy = pregnancy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDosageForm() {
        return dosageForm;
    }

    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
    }

    public String getMedicalIndication() {
        return medicalIndication;
    }

    public void setMedicalIndication(String medicalIndication) {
        this.medicalIndication = medicalIndication;
    }

    public String getMedicalContraIndication() {
        return medicalContraIndication;
    }

    public void setMedicalContraIndication(String medicalContraIndication) {
        this.medicalContraIndication = medicalContraIndication;
    }

    public String getSideEffect() {
        return sideEffect;
    }

    public void setSideEffect(String sideEffect) {
        this.sideEffect = sideEffect;
    }

    public String getOverdose() {
        return overdose;
    }

    public void setOverdose(String overdose) {
        this.overdose = overdose;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public String getPregnancy() {
        return pregnancy;
    }

    public void setPregnancy(String pregnancy) {
        this.pregnancy = pregnancy;
    }

    @Override
    public String toString() {
        return "0.Drug \n" +
                "1.name\n '" + name + '\'' + '\n' +
                "2.manufacturer\n '" + manufacturer + '\'' + '\n' +
                "3.dosageForm\n'" + dosageForm + '\'' + '\n' +
                "4.medicalIndication\n'" + medicalIndication + '\'' + '\n' +
                "5.medicalContraIndication\n'" + medicalContraIndication + '\'' + '\n' +
                "6.sideEffect\n'" + sideEffect + '\'' + '\n' +
                "7.overdose\n'" + overdose + '\'' + '\n' +
                "8.warning\n'" + warning + '\'' + '\n' +
                "9.pregnancy\n'" + pregnancy + '\'' + '\n';
    }
}

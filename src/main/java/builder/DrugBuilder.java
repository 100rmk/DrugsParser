package builder;

public class DrugBuilder implements Builder {
    private String name;
    private String manufacturer;
    private String dosageForm;
    private String medicalIndication;
    private String medicalContraIndication;
    private String sideEffect;
    private String overdose;
    private String warning;
    private String pregnancy;


    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
    }

    @Override
    public void setMedicalIndication(String medicalIndication) {
        this.medicalIndication = medicalIndication;
    }

    @Override
    public void setMedicalContraindication(String medicalContraindication) {
        this.medicalContraIndication = medicalContraindication;
    }

    @Override
    public void setSideEffect(String sideEffect) {
        this.sideEffect = sideEffect;
    }

    @Override
    public void setOverdose(String overdose) {
        this.overdose = overdose;
    }

    @Override
    public void setWarning(String warning) {
        this.warning = warning;
    }

    @Override
    public void setPregnancy(String pregnancy) {
        this.pregnancy = pregnancy;
    }

    public Drug getResult() {
        return new Drug(name, manufacturer, dosageForm, medicalIndication, medicalContraIndication, sideEffect,
                overdose, warning, pregnancy);
    }
}

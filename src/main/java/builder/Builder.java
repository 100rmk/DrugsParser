package builder;

public interface Builder {
    void setName(String name);
    void setManufacturer(String manufacturer);
    void setDosageForm(String dosageForm);
    void setMedicalIndication(String medicalIndication);
    void setMedicalContraindication(String medicalContraindication);
    void setSideEffect(String sideEffect);
    void setOverdose(String overdose);
    void setWarning(String warning);
    void setPregnancy(String pregnancy);

}

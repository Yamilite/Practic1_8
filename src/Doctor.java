class Doctor {
    String fullName;
    String specialty;
    int employeeNumber;
    int workShiftsPerMonth;
    boolean certification;

    public Doctor(String fullName, String specialty, int employeeNumber, int workShiftsPerMonth, boolean certification) {
        this.fullName = fullName;
        this.specialty = specialty;
        this.employeeNumber = employeeNumber;
        this.workShiftsPerMonth = workShiftsPerMonth;
        this.certification = certification;
    }

    @Override
    public String toString() {
        return fullName + ", " + specialty + ", " + employeeNumber + ", " + workShiftsPerMonth + ", " + certification;
    }
}
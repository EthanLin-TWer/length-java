public class Length {
    private final double value;
    private final String unit;

    public Length(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(String targetUnit) {
        Length result = this;
        final String FOOT = "f";
        if (this.unit.equals(FOOT)) {
            if (targetUnit.equals("yard")) {
                result = new Length(this.value / 3, targetUnit);
            } else if (targetUnit.equals("inch")) {
                result = new Length(this.value * 12, targetUnit);
            }
        }

        if (this.unit.equals("yard")) {
            if (targetUnit.equals("inch")) {
                result = new Length(this.value * 36, targetUnit);
            } else if (targetUnit.equals("f")){
                result = new Length(this.value * 3, targetUnit);
            }
        }

        if (this.unit.equals("inch")) {
            if (targetUnit.equals("f")) {
                result = new Length(this.value / 12, targetUnit);
            } else if (targetUnit.equals("yard")) {
                result = new Length(this.value / 36, targetUnit);
            }
        }

        return result;
    }

    public double getValue() {
        return this.value;
    }

    public String getUnit() {
        return this.unit;
    }
}

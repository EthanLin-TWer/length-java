public class Length {
    static final String YARD = "yard";
    static final String FOOT = "f";
    static final String INCH = "inch";
    private final double value;
    private final String unit;

    public Length(double val, String unit) {
        this.value = val;
        this.unit = unit;
    }

    public Length as(String targetUnit) {
        return temp_as(targetUnit, null);
    }

    public Length temp_as(String targetUnit, Unit tempUnit) {
        Length len = this;
        if (this.unit.equals(Length.FOOT)) {
            if (targetUnit.equals(Length.YARD)) {
                len = new Length(this.value / 3, targetUnit);
            } else if (targetUnit.equals(Length.INCH)) {
                len = new Length(this.value * 12, targetUnit);
            }
        }

        if (this.unit.equals(Length.YARD)) {
            if (targetUnit.equals(Length.INCH)) {
                len = new Length(this.value * 36, targetUnit);
            } else if (targetUnit.equals(Length.FOOT)) {
                len = new Length(this.value * 3, targetUnit);
            }
        }

        if (this.unit.equals(Length.INCH)) {
            if (targetUnit.equals(Length.FOOT)) {
                len = new Length(this.value / 12, targetUnit);
            } else if (targetUnit.equals(Length.YARD)) {
                len = new Length(this.value / 36, targetUnit);
            }
        }

        return len;
    }

    public double getVal() {
        return this.value;
    }

    public String getUnit() {
        return this.unit;
    }
}

public class Length {
    static final String YARD = "yard";
    static final String FOOT = "f";
    static final String INCH = "inch";
    private final double value;
    private final String unit;
    private final Unit tempUnit;

    public Length(double val, String unit) {
        this.value = val;
        this.unit = unit;
        this.tempUnit = null;
    }

    public Length(double val, String unit, Unit tempUnit) {
        this.value = val;
        this.unit = unit;
        this.tempUnit = tempUnit;
    }

    public Length as(String targetUnit, Unit tempUnit) {
        Length len = this;
        if (this.unit.equals(Length.FOOT)) {
            if (tempUnit == Unit.YARD) {
                len = new Length(this.value / 3, targetUnit, tempUnit);
            } else if (tempUnit == Unit.INCH) {
                len = new Length(this.value * 12, targetUnit, tempUnit);
            }
        }

        if (this.unit.equals(Length.YARD)) {
            if (tempUnit == Unit.INCH) {
                len = new Length(this.value * 36, targetUnit, tempUnit);
            } else if (tempUnit == Unit.FOOT) {
                len = new Length(this.value * 3, targetUnit, tempUnit);
            }
        }

        if (this.unit.equals(Length.INCH)) {
            if (tempUnit == Unit.FOOT) {
                len = new Length(this.value / 12, targetUnit, tempUnit);
            } else if (tempUnit == Unit.YARD) {
                len = new Length(this.value / 36, targetUnit, tempUnit);
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

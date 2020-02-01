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
        Unit tempUnit = null;
        if (targetUnit.equals(Length.YARD)) {
            tempUnit = Unit.YARD;
        } else if (targetUnit.equals(Length.FOOT)) {
            tempUnit = Unit.FOOT;
        } else if (targetUnit.equals(Length.INCH)) {
            tempUnit = Unit.INCH;
        }
        return temp_as(targetUnit, tempUnit);
    }

    public Length temp_as(String targetUnit, Unit tempUnit) {
        Length len = this;
        if (this.unit.equals(Length.FOOT)) {
            if (tempUnit == Unit.YARD) {
                len = new Length(this.value / 3, targetUnit);
            } else if (tempUnit == Unit.INCH) {
                len = new Length(this.value * 12, targetUnit);
            }
        }

        if (this.unit.equals(Length.YARD)) {
            if (tempUnit == Unit.INCH) {
                len = new Length(this.value * 36, targetUnit);
            } else if (tempUnit == Unit.FOOT) {
                len = new Length(this.value * 3, targetUnit);
            }
        }

        if (this.unit.equals(Length.INCH)) {
            if (tempUnit == Unit.FOOT) {
                len = new Length(this.value / 12, targetUnit);
            } else if (tempUnit == Unit.YARD) {
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

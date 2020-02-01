public class Length {
    private final double value;
    private final Unit unit;

    public Length(double val, Unit unit) {
        this.value = val;
        this.unit = unit;
    }

    public Length as(Unit unit) {
        Length len = this;
        if (this.unit ==Unit.FOOT) {
            if (unit == Unit.YARD) {
                len = new Length(this.value / 3, unit);
            } else if (unit == Unit.INCH) {
                len = new Length(this.value * 12, unit);
            }
        }

        if (this.unit ==Unit.YARD) {
            if (unit == Unit.INCH) {
                len = new Length(this.value * 36, unit);
            } else if (unit == Unit.FOOT) {
                len = new Length(this.value * 3, unit);
            }
        }

        if (this.unit ==Unit.INCH) {
            if (unit == Unit.FOOT) {
                len = new Length(this.value / 12, unit);
            } else if (unit == Unit.YARD) {
                len = new Length(this.value / 36, unit);
            }
        }

        return len;
    }

    public double getVal() {
        return this.value;
    }

    public Unit getUnit() {
        return this.unit;
    }
}

public class Length {
    private final double value;
    private final Unit unit;

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(Unit target) {
        double value = getValue(target);
        return new Length(value, target);
    }

    public double getValue(Unit target) {
        if (this.unit == Unit.FOOT) {
            if (target == Unit.YARD) {
                return this.value / 3;
            }
            if (target == Unit.INCH) {
                return this.value * 12;
            }
        }

        if (this.unit == Unit.YARD) {
            if (target == Unit.INCH) {
                return this.value * 36;
            } else if (target == Unit.FOOT){
                return this.value * 3;
            }
        }

        if (this.unit == Unit.INCH) {
            if (target == Unit.FOOT) {
                return this.value / 12;
            } else if (target == Unit.YARD) {
                return this.value / 36;
            }
        }
        return this.value;
    }

    public double getValue() {
        return this.value;
    }

    public Unit getUnit() {
        return unit;
    }
}

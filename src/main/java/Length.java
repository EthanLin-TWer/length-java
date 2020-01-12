public class Length {
    private final double value;
    private final Unit temp_unit;

    public Length(double value, Unit temp_unit) {
        this.value = value;
        this.temp_unit = temp_unit;
    }

    public Length as(Unit target) {
        Length result = this;

        if (this.temp_unit == Unit.FOOT) {
            if (target == Unit.YARD) {
                result = new Length(this.value / 3, target);
            } else if (target == Unit.INCH) {
                result = new Length(this.value * 12, target);
            }
        }

        if (this.temp_unit == Unit.YARD) {
            if (target == Unit.INCH) {
                result = new Length(this.value * 36, target);
            } else if (target == Unit.FOOT){
                result = new Length(this.value * 3, target);
            }
        }

        if (this.temp_unit == Unit.INCH) {
            if (target == Unit.FOOT) {
                result = new Length(this.value / 12, target);
            } else if (target == Unit.YARD) {
                result = new Length(this.value / 36, target);
            }
        }

        return result;
    }

    public double getValue() {
        return this.value;
    }

    public Unit getUnit() {
        return temp_unit;
    }
}

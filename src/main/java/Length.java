public class Length {
    private final double value;
    private final String unit;
    private final Unit temp_unit;
    public static final String FOOT = "foot";
    public static final String YARD = "yard";
    public static final String INCH = "inch";

    public Length(double value, String unit, Unit temp_unit) {
        this.value = value;
        this.unit = unit;
        this.temp_unit = temp_unit;
    }

    public Length as(Unit target) {
        Length result = this;

        if (this.unit.equals(Length.FOOT)) {
            if (target == Unit.YARD) {
                result = new Length(this.value / 3, null, target);
            } else if (target == Unit.INCH) {
                result = new Length(this.value * 12, null, target);
            }
        }

        if (this.unit.equals(Length.YARD)) {
            if (target == Unit.INCH) {
                result = new Length(this.value * 36, null, target);
            } else if (target == Unit.FOOT){
                result = new Length(this.value * 3, null, target);
            }
        }

        if (this.unit.equals(Length.INCH)) {
            if (target == Unit.FOOT) {
                result = new Length(this.value / 12, null, target);
            } else if (target == Unit.YARD) {
                result = new Length(this.value / 36, null, target);
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

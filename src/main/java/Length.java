public class Length {
    private final double value;
    private final String unit;
    private final Unit temp_unit;
    public static final String FOOT = "foot";
    public static final String YARD = "yard";
    public static final String INCH = "inch";

    public Length(double value, String unit) {
        this.value = value;
        this.unit = unit;
        this.temp_unit = temp_determineUnit(unit);
    }

    public Unit temp_determineUnit(String targetUnit) {
        Unit temp_unit = null;
        if (targetUnit.equals(Length.INCH)) {
            temp_unit = Unit.INCH;
        }
        if (targetUnit.equals(Length.YARD)) {
            temp_unit = Unit.YARD;
        }
        if (targetUnit.equals(Length.FOOT)) {
            temp_unit = Unit.FOOT;
        }
        return temp_unit;
    }

    public Length temp_as(String targetUnit, Unit temp_unit) {
        Length result = this;

        if (this.unit.equals(Length.FOOT)) {
            if (temp_unit == Unit.YARD) {
                result = new Length(this.value / 3, targetUnit);
            } else if (temp_unit == Unit.INCH) {
                result = new Length(this.value * 12, targetUnit);
            }
        }

        if (this.unit.equals(Length.YARD)) {
            if (temp_unit == Unit.INCH) {
                result = new Length(this.value * 36, targetUnit);
            } else if (temp_unit == Unit.FOOT){
                result = new Length(this.value * 3, targetUnit);
            }
        }

        if (this.unit.equals(Length.INCH)) {
            if (temp_unit == Unit.FOOT) {
                result = new Length(this.value / 12, targetUnit);
            } else if (temp_unit == Unit.YARD) {
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

    public Unit getTemp_unit() {
        return temp_unit;
    }
}

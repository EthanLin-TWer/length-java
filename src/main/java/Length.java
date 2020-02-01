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

    public Length as(String u) {
        Length len = this;
        if (this.unit.equals(Length.FOOT)) {
            if (u.equals(Length.YARD)) {
                len = new Length(this.value / 3, u);
            } else if (u.equals(Length.INCH)) {
                len = new Length(this.value * 12, u);
            }
        }

        if (this.unit.equals(Length.YARD)) {
            if (u.equals(Length.INCH)) {
                len = new Length(this.value * 36, u);
            } else if (u.equals(Length.FOOT)) {
                len = new Length(this.value * 3, u);
            }
        }

        if (this.unit.equals(Length.INCH)) {
            if (u.equals(Length.FOOT)) {
                len = new Length(this.value / 12, u);
            } else if (u.equals(Length.YARD)) {
                len = new Length(this.value / 36, u);
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

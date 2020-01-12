import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LengthTest {
    @Test
    public void should_1_inch_equals_1_inch() {
        Length result = new Length(1, Length.INCH).temp_as(Length.INCH, Unit.INCH);

        assertThat(result.getValue(), is(1.0));
        assertThat(result.getTemp_unit(), is(Unit.INCH));
    }

    @Test
    public void should_2_feet_equals_2_feet() {
        Length result = new Length(2, Length.FOOT).temp_as(Length.FOOT, Unit.FOOT);

        assertThat(result.getValue(), is(2.0));
        assertThat(result.getTemp_unit(), is(Unit.FOOT));
    }

    @Test
    public void should_1_yard_equals_1_yard() {
        Length result = new Length(1, Length.YARD).temp_as(Length.YARD, Unit.YARD);

        assertThat(result.getValue(), is(1.0));
        assertThat(result.getTemp_unit(), is(Unit.YARD));
    }

    @Test
    public void should_1_foot_equals_12_inches() {
        Length result = new Length(1, Length.FOOT).temp_as(Length.INCH, Unit.INCH);

        assertThat(result.getValue(), is(12.0));
        assertThat(result.getTemp_unit(), is(Unit.INCH));
    }

    @Test
    public void should_3_foot_equals_1_yard() {
        Length result = new Length(3, Length.FOOT).temp_as(Length.YARD, Unit.YARD);

        assertThat(result.getValue(), is(1.0));
        assertThat(result.getTemp_unit(), is(Unit.YARD));
    }

    @Test
    public void should_1_yard_equals_3_feet() {
        Length result = new Length(1, Length.YARD).temp_as(Length.FOOT, Unit.FOOT);

        assertThat(result.getValue(), is(3.0));
        assertThat(result.getTemp_unit(), is(Unit.FOOT));
    }

    @Test
    public void should_1_yard_equals_36_inches() {
        Length result = new Length(1, Length.YARD).temp_as(Length.INCH, Unit.INCH);

        assertThat(result.getValue(), is(36.0));
        assertThat(result.getTemp_unit(), is(Unit.INCH));
    }

    @Test
    public void should_2_yards_equals_72_inches() {
        Length result = new Length(2, Length.YARD).temp_as(Length.INCH, Unit.INCH);

        assertThat(result.getValue(), is(72.0));
        assertThat(result.getTemp_unit(), is(Unit.INCH));
    }

    @Test
    public void should_12_inches_equals_1_foot() {
        Length result = new Length(12, Length.INCH).temp_as(Length.FOOT, Unit.FOOT);

        assertThat(result.getValue(), is(1.0));
        assertThat(result.getTemp_unit(), is(Unit.FOOT));
    }

    @Test
    public void should_36_inches_equals_1_yard() {
        Length result = new Length(36, Length.INCH).temp_as(Length.YARD, Unit.YARD);

        assertThat(result.getValue(), is(1.0));
        assertThat(result.getTemp_unit(), is(Unit.YARD));
    }

    @Test
    public void should_18_inches_equals_half_yard() {
        Length result = new Length(18, Length.INCH).temp_as(Length.YARD, Unit.YARD);

        assertThat(result.getValue(), is(0.5));
        assertThat(result.getTemp_unit(), is(Unit.YARD));
    }
}

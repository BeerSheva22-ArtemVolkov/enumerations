package telran.measure.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.measure.*;

class LengthTest {
	
	Length length1 = new Length(1, LengthUnit.KM);
	Length length2 = new Length(500, LengthUnit.M);
	Length length3 = new Length(50000, LengthUnit.CM);
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testEqualsObject() {
		assertEquals(length2, length3);
		assertNotEquals(length1, length2);
	}

	@Test
	void testCompareTo() {
		assertTrue(length2.compareTo(length1) < 0);
		assertTrue(length1.compareTo(length2) > 0);
		assertTrue(length2.compareTo(length3) == 0);
	}

	@Test
	void testConvert() {
		Length length = length3.convert(LengthUnit.M);
		assertEquals(length2.getAmount(), length.getAmount());
		assertEquals(length2.getUnit(), length.getUnit());
		Length newLength = length3.convert(LengthUnit.KM);
		assertEquals(0.5f, newLength.getAmount());
		assertEquals(length1.getUnit(), newLength.getUnit());
	}

	@Test
	void testToString() {
		assertEquals("1.0KM", length1.toString());
		assertEquals("500.0M", length2.toString());
		assertEquals("50000.0CM", length3.toString());
	}
	@Test
	void testBetween() {
		Length length = LengthUnit.M.between(length2, length1);
		assertEquals(length.getAmount(), length2.getAmount());
		assertEquals(length.getUnit(), length2.getUnit());
		assertEquals(length.getUnit(), LengthUnit.M);
		Length newLength = LengthUnit.CM.between(length3, length1);
		assertEquals(newLength.getAmount(), 50000.0f);
		assertEquals(newLength.getUnit(), length3.getUnit());
		assertEquals(newLength.getUnit(), LengthUnit.CM);
	}

}
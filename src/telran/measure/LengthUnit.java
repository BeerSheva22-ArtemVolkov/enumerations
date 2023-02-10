package telran.measure;

public enum LengthUnit {

	MM(1), CM(10), M(1000), KM(1000000), IN(25.4f);
	
	float value;
	
	LengthUnit(float value) {
		this.value = value;
	}
	
	float convert(WeightUnit to, float amount) {
		return value * amount / to.value;
	}
	
	public Length between(Length l1, Length l2) {
		//returns Length object as length between l1 and l2 in "this" units
		//Example: LengthUnit.M.between (new Length(200, LengthUnit.CM), new Length(1, LengthUnit.M))
		//returns Length(1, LengthUnit.M)
		return new Length(Math.abs(l1.getAmount() * l1.getUnit().getValue() - l2.getAmount() * l2.getUnit().getValue()) / this.value, this);
	}
	public float getValue() {
		return value;
	}
}

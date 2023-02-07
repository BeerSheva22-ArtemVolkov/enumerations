package telran.measure;

public enum LengthUnit {

	MM(1), CM(10), M(1000), KM(1000000), IN(25.4f);
	
	float value;
	
	LengthUnit(float value) {
		this.value = value;
	}
	
	//TODO 
	
	float convert(WeightUnit to, float amount) {
		return value * amount / to.value;
	}
}

package telran.measure;

public enum WeightUnit {
	
	GR(1), KG(1000), LBS(453.592f), CN(100000), TN(1000000);
	
	float value;
	
	WeightUnit(float value) {
		this.value = value;
	}
	
	float convert(WeightUnit to, float amount) {
		return value * amount / to.value;
	}
}

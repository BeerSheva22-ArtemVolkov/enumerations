package telran.time;

public enum DayOfWeek {
	
	SUN, MON, TUE, WED, THU, FRI, SHABBAT;
	
	public DayOfWeek plusDays(int days) {
		DayOfWeek res = null;
		if (days < 0) {
			res = minusDays(-days);
		}
		else {
			int seqNumCurrent = ordinal();
			int seqNumRes = (seqNumCurrent + days) % 7; //values().length;
			res = values()[seqNumRes];
		}
		return res;
	}

	public DayOfWeek minusDays(int days) {
		DayOfWeek res = null;
		if (days < 0) {
			res = plusDays(-days);
		}
		else {
			int seqNumCurrent = ordinal();
			int seqNumRes = (seqNumCurrent - days) % 7; //values().length;
			if (seqNumRes < 0) {
				seqNumRes += 7;
			}
			res = values()[seqNumRes];
		}
		return res;
	}

	public static int between(DayOfWeek thu2, DayOfWeek mon2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
}

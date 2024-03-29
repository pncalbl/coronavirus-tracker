package io.javabrains.coronavirustracker.models;

/**
 * @author pncalbl
 * @date 2021/9/24 16:39
 * @e-mail pncalbl@qq.com
 * @description
 **/

public class LocationStats {
	private String state;
	private String country;
	private int latestTotalCases;
	private int diffFromPrevDay;

	public String getState() {
		return state;
	}

	public int getDiffFromPrevDay() {
		return diffFromPrevDay;
	}

	public void setDiffFromPrevDay(int diffFromPrevDay) {
		this.diffFromPrevDay = diffFromPrevDay;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getLatestTotalCases() {
		return latestTotalCases;
	}

	public void setLatestTotalCases(int latestTotalCases) {
		this.latestTotalCases = latestTotalCases;
	}

	@Override
	public String toString() {
		return "LocationStats{" +
				"state='" + state + '\'' +
				", country='" + country + '\'' +
				", latestTotalCases=" + latestTotalCases +
				'}';
	}
}

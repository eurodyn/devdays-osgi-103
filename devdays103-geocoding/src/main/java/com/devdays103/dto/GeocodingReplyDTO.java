package com.devdays103.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodingReplyDTO {
	private String type;
	private String latitude;
	private String longitude;
	private String name;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GeocodingReplyDTO() {

	}

	public GeocodingReplyDTO(String type, String latitude, String longitude, String name) {
		this.type = type;
		this.latitude = latitude;
		this.longitude = longitude;
		this.name = name;
	}

	@Override
	public String toString() {
		return "GeocodingReplyDTO{" +
				"type='" + type + '\'' +
				", latitude='" + latitude + '\'' +
				", longitude='" + longitude + '\'' +
				", name='" + name + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		GeocodingReplyDTO that = (GeocodingReplyDTO) o;

		if (type != null ? !type.equals(that.type) : that.type != null)
			return false;
		if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null)
			return false;
		if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null)
			return false;
		return name != null ? name.equals(that.name) : that.name == null;
	}

	@Override
	public int hashCode() {
		int result = type != null ? type.hashCode() : 0;
		result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
		result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
		result = 31 * result + (name != null ? name.hashCode() : 0);
		return result;
	}
}

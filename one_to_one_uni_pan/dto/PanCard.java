package one_to_one_uni_pan.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PanCard {
	@Id
	private int panid;

	@Override
	public String toString() {
		return "PanCard [panid=" + panid + ", pan_name=" + pan_name + ", address=" + address + "]";
	}

	private String pan_name;
	private String address;

	public int getPanid() {
		return panid;
	}

	public void setPanid(int panid) {
		this.panid = panid;
	}

	public String getPan_name() {
		return pan_name;
	}

	public void setPan_name(String pan_name) {
		this.pan_name = pan_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}

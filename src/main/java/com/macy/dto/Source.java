package com.macy.dto;

import java.io.Serializable;

public class Source implements Serializable{

	private String clientId;
	private String subClientID;
	private String sellingChannelCode;
	private String seperatorSource0;
	private String separatorSource1;

	public Source() {
	}

	public Source(String clientId, String subClientID, String sellingChannelCode, String seperatorSource0,
			String separatorSource1) {
		super();
		this.clientId = clientId;
		this.subClientID = subClientID;
		this.sellingChannelCode = sellingChannelCode;
		this.seperatorSource0 = seperatorSource0;
		this.separatorSource1 = separatorSource1;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getSubClientID() {
		return subClientID;
	}

	public void setSubClientID(String subClientID) {
		this.subClientID = subClientID;
	}

	public String getSellingChannelCode() {
		return sellingChannelCode;
	}

	public void setSellingChannelCode(String sellingChannelCode) {
		this.sellingChannelCode = sellingChannelCode;
	}

	public String getSeperatorSource0() {
		return seperatorSource0;
	}

	public void setSeperatorSource0(String seperatorSource0) {
		this.seperatorSource0 = seperatorSource0;
	}

	public String getSeparatorSource1() {
		return separatorSource1;
	}

	public void setSeparatorSource1(String separatorSource1) {
		this.separatorSource1 = separatorSource1;
	}

	@Override
	public String toString() {
		return "Source [clientId=" + clientId + ", subClientID=" + subClientID + ", sellingChannelCode="
				+ sellingChannelCode + ", seperatorSource0=" + seperatorSource0 + ", separatorSource1="
				+ separatorSource1 + "]";
	}
}

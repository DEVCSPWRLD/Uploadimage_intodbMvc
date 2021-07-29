package com.jkas.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/*
 * Maklum Balas Baru(New feed back)entity class
 * @author C
 */
@Entity
@Table(name = "AgencyNewFeedBack_TAB")
public class AgencyNewFeedBack {

	@Id
	@GeneratedValue
	private Integer feedbackId;
	
	@Column(name = "Organisasi")
	private String organization;
	
	@Column(name = "namaPegawaiMerinyu")
	private String nameOfOfficer;
	
	@Column(name = "maklumBalas")
	private String feedback;
	
	@Column(name="gambarSebelum")
	private String beforePicture;
	
	@Column(name="gambarSelepas")
	private String afterPicture;
	
	@Column(name="date")
	private String date;
	
	
	public Integer getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getNameOfOfficer() {
		return nameOfOfficer;
	}

	public void setNameOfOfficer(String nameOfOfficer) {
		this.nameOfOfficer = nameOfOfficer;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getBeforePicture() {
		return beforePicture;
	}

	public void setBeforePicture(String beforePicture) {
		this.beforePicture = beforePicture;
	}

	public String getAfterPicture() {
		return afterPicture;
	}

	public void setAfterPicture(String afterPicture) {
		this.afterPicture = afterPicture;
	}

	@Override
	public String toString() {
		return "AgencyNewFeedBack [feedbackId=" + feedbackId + ", organization=" + organization + ", nameOfOfficer="
				+ nameOfOfficer + ", feedback=" + feedback + ", beforePicture=" + beforePicture + ", afterPicture="
				+ afterPicture + ", date=" + date + "]";
	}
	
}

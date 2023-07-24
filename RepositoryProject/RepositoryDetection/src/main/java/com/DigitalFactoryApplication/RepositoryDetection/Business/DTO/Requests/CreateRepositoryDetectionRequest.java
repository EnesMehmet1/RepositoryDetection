package com.DigitalFactoryApplication.RepositoryDetection.Business.DTO.Requests;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRepositoryDetectionRequest {
	private long id;
	private String soirNo;
	private long amountNo;
	private String pieceNo;
	private long prjectNo;
	private Date entryTime;
	private Date exityTime;
	public CreateRepositoryDetectionRequest() {
		
	}
	
	public CreateRepositoryDetectionRequest(long id, String soirNo, long amountNo, String pieceNo, long prjectNo,
			Date entryTime, Date exityTime) {
		super();
		this.id = id;
		this.soirNo = soirNo;
		this.amountNo = amountNo;
		this.pieceNo = pieceNo;
		this.prjectNo = prjectNo;
		this.entryTime = entryTime;
		this.exityTime = exityTime;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSoirNo() {
		return soirNo;
	}
	public void setSoirNo(String soirNo) {
		this.soirNo = soirNo;
	}
	public long getAmountNo() {
		return amountNo;
	}
	public void setAmountNo(long amountNo) {
		this.amountNo = amountNo;
	}
	public String getPieceNo() {
		return pieceNo;
	}
	public void setPieceNo(String pieceNo) {
		this.pieceNo = pieceNo;
	}
	public long getPrjectNo() {
		return prjectNo;
	}
	public void setPrjectNo(long prjectNo) {
		this.prjectNo = prjectNo;
	}
	public Date getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}
	public Date getExityTime() {
		return exityTime;
	}
	public void setExityTime(Date exityTime) {
		this.exityTime = exityTime;
	}
}

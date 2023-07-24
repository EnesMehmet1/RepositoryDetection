package com.DigitalFactoryApplication.RepositoryDetection.Entity;

import java.sql.Date;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="RepositoryDetections")
@Entity
@SQLDelete(sql="UPDATE RepositoryDetections SET ACTIVE = 0 WHERE ID = ?",check= ResultCheckStyle.COUNT)
@org.hibernate.annotations.Where(clause = "ACTIVE = 1")
public class RepositoryDetection {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="soirrNo")
	private String soirNo;
	
	@Column(name="amountNo")
	private long amountNo;
	
	@Column(name="pieceNo")
	private String pieceNo;
	
	@Column(name="prjectNo")
	private long prjectNo;
	
	@Column(name="entryTime")
	private Date entryTime;
	
	@Column(name="exityTime")
	private Date exityTime;
	
	@Column(name="ACTIVE")
	private boolean ACTIVE;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Date getExityTime() {     //şu date olayını sor
		return exityTime;
	}

	public void setExityTime(Date exityTime) {
		this.exityTime = exityTime;
	}
	
	public String getSoirNo() {
		return soirNo;
	}

	public void setSoirNo(String soirNo) {
		this.soirNo = soirNo;
	}

	public boolean isACTIVE() {
		return ACTIVE;
	}

	public void setACTIVE(boolean aCTIVE) {
		ACTIVE = aCTIVE;
	}

	public RepositoryDetection() {
		super();
	}

	public RepositoryDetection(long id, String soirNo, long amountNo, String pieceNo, long prjectNo, Date entryTime,
			Date exityTime, boolean aCTIVE) {
		super();
		this.id = id;
		this.soirNo = soirNo;
		this.amountNo = amountNo;
		this.pieceNo = pieceNo;
		this.prjectNo = prjectNo;
		this.entryTime = entryTime;
		this.exityTime = exityTime;
		ACTIVE = aCTIVE;
	}
	
}

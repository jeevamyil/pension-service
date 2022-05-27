package com.pensionDetail.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="bank_detail")
public class BankDetailModel {
	
	@Id
	@Column(name="acc_num", nullable=false)
	private double AccountNumber;
	
	@Column(name="bank_name",nullable=false)
	private String BankName;
	
	@Column(name="bank_type", nullable=false)
	private String BankType;

}

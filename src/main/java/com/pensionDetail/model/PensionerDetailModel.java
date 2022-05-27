package com.pensionDetail.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "pensioner_details")
public class PensionerDetailModel {

	@Column(name = "name", nullable = false)
	private String Name;
	@Column(name = "dob", nullable = false)
	private String Date_of_birth;
	@Id
	@Column(name = "pan_id", nullable = false)
	private String PAN;
	@Column(name = "salary", nullable = false)
	private double SalaryEarned;
	@Column(name = "allowances", nullable = false)
	private double Allowances;
	@Column(name = "pension_type", nullable = false)
	private String PensionType;

	@OneToOne( cascade = CascadeType.ALL)
	@JoinColumn(name="acc_num")
	private BankDetailModel bdm;
}

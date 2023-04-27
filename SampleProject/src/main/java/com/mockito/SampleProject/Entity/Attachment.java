package com.mockito.SampleProject.Entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "it_attachment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "reference_id")
    private UUID referenceId;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "original_file_name")
    private String originalFileName;

    @Column(name = "file_type")
    private String fileType;
    
    @Column(name = "file_path")
    private String filePath;

    @Column(name = "file_size")
	private Long filSize;

    @Column(name = "section_type")
    private String sectionType;

    @Column(name = "it_benefit_id")
    private UUID benefitId;

	@Column(name = "emp_id")
	private UUID empId;
    
    private String extension;

    private String type;
    private String path;
	@Column(name = "folder_name")
    private String folderName;
	@Column(name = "declaration_id")
    private UUID declarationId;
	@Column(name = "excemption_id")
    private UUID excemptionId;
	@Column(name = "salary_others_id")
    private UUID salaryOthersId;
	@Column(name = "tax_payment_id")
    private UUID taxPaymentId;
	@Column(name = "other_income_id")
    private UUID otherIncomeId;
    
    
}


package com.example.selfwork.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
public class Employee implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable = false, updatable = false)
  private Long id;
  private String name;
  private String email;
  private String jobTitle;
  private String phone;
  private String imageUrl;
  @Column(nullable = false, updatable = false)
  private String employeeCode;

  public Employee(Long id, String name, String email, String jobTitle, String phone,
      String imageUrl,
      String employeeCode) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.jobTitle = jobTitle;
    this.phone = phone;
    this.imageUrl = imageUrl;
    this.employeeCode = employeeCode;
  }
}

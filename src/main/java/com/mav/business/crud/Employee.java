package com.mav.business.crud;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employee")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "eid")
  private long id;
  @Column
  private String ename;
  @Column
  private String esal;
  @Column
  private String addr;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getEname() {
    return ename;
  }

  public void setEname(String ename) {
    this.ename = ename;
  }

  public String getEsal() {
    return esal;
  }

  public void setEsal(String esal) {
    this.esal = esal;
  }

  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Employee employee = (Employee) o;
    return id == employee.id &&
            Objects.equals(ename, employee.ename) &&
            Objects.equals(esal, employee.esal) &&
            Objects.equals(addr, employee.addr);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, ename, esal, addr);
  }
}

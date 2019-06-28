package ir.example.businessside.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String family;

    private String email;

    private String dob;

    private String sex;

    private String lid;

    public User(String name, String family, String email, String dob, String sex) {
        this.name = name;
        this.family = family;
        this.email = email;
        this.dob = dob;
        this.sex = sex;
    }

    public User() {
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }

    @Override
    public String toString() {
        return "User{" +
               "name='" + name + '\'' +
               ", dob='" + dob + '\'' +
               ", sex='" + sex + '\'' +
               '}';
    }
}

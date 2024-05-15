package pl.sii.promocodes.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class PromoCode {
    @Id
    @GeneratedValue
    private Long id;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(unique = true)
    private String code;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

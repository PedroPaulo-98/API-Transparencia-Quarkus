package org.acme.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import java.time.YearMonth;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import java.util.List;

@Entity
public class BeneficioSocial extends PanacheEntity {
    public Integer cdMunicipio;
    public String municipio;
    public Integer cdBolsa;
    public String bolsa;
    public Integer cdPagamento;
    public String cdPagamento1;
    public Integer inscricao;
    public String nome;
    public Integer ano;
    public Integer mes;
    public Double valor;

    public static List<BeneficioSocial> findByMunicipio(String municipio) {
        return list("municipio", municipio);
    }
}
package org.acme.config;

import org.acme.model.BeneficioSocial;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import io.quarkus.runtime.StartupEvent;
import java.time.YearMonth;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ImportacaoDados {
    void onStart(@Observes StartupEvent ev) {
        if (BeneficioSocial.count() == 0) {
            importarDadosIniciais(); // Método que contém as operações de persistência
        }
    }

    @Transactional // ← Adicione esta anotação
    void importarDadosIniciais() {
        BeneficioSocial beneficio1 = new BeneficioSocial();
        beneficio1.cdMunicipio = 6;
        beneficio1.municipio = "AMAPA";
        beneficio1.cdBolsa = 1;
        beneficio1.bolsa = "RENDA PARA VIVER MELHOR - PRVM";
        beneficio1.cdPagamento = 1;
        beneficio1.cdPagamento1 = "FOLHA NORMAL";
        beneficio1.inscricao = 122671;
        beneficio1.nome = "ADANICE CARDOSO MELO";
        beneficio1.ano = 2025;
        beneficio1.mes = 3;
        beneficio1.valor = 311.0;
        beneficio1.persist();

            // Adicione mais registros conforme necessário...
        }
    
}
package com.is.findyourplace.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;
import jakarta.persistence.MapsId;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe relativa ai Filtri di una ricerca.<br>
 * I campi sono:
 *  id ricerca,
 *  costo della vita (ALTO - MEDIO - BASSO),
 *  dangerMax in percentuale,
 *  numAbitantiMin,
 *  numAbitantiMax,
 *  numNegoziMin,
 *  NumScuoleMin,
 *  NumRistorantiMin.
 *  @author Pietro Esposito
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Filtri {
    /**
     * Id della ricerca.
     */
    @Id
    @NotNull
    @Column(name = "id_ricerca")
    private long idRicerca;

    /**
     * La chiave primaria deriva dalla chiave della ricerca.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "id_ricerca")
    private Ricerca ricerca;

    /**
     * Enum usato per forzare solo 3 stringhe precise.
     */
    public enum CostoVita {
        /**
         * Costo della vita Basso, Medio o Alto per regione.
         */
        BASSO, MEDIO, ALTO
    }
    /**
     * Campo che definisce il costo della vita della regione.
     */
    @Enumerated(EnumType.STRING)
    private CostoVita costoVita;

    /**
     * Campo che definisce la pericolosità massima.
     */
    @Size(min = 2, max = 100)
    private float dangerMax;

    /**
     * Campo che definisce il numero di abitanti minimo.
     */
    @PositiveOrZero
    @Size(max = 1000000)
    private int numAbitantiMin;

    /**
     * Campo che definisce il numero di abitanti massimo.
     */
    @PositiveOrZero
    @Size(min = 1000, max = 10000000)
    private int numAbitantiMax;

    @PrePersist
    @PreUpdate
    private void validateNumAbitanti() {
        if (numAbitantiMax <= numAbitantiMin) {
            throw new IllegalStateException("Il numero massimo di abitanti deve essere maggiore del numero minimo");
        }
    }

    /**
     * Campo che definisce il numero di negozi minimo.
     */
    @PositiveOrZero
    @Size(max = 1000)
    private int numNegoziMin;

    /**
     * Campo che definisce il numero di scuole minimo.
     */
    @PositiveOrZero
    @Size(max = 100)
    private int numScuoleMin;

    /**
     * Campo che definisce il numero di ristoranti minimo.
     */
    @PositiveOrZero
    @Size(max = 10000)
    private int numRistorantiMin;

    @Override
    public String toString() {
        return "Filtri{" +
                "idRicerca=" + idRicerca +
                ", costoVita=" + costoVita +
                ", dangerMax=" + dangerMax +
                ", numAbitantiMin=" + numAbitantiMin +
                ", numAbitantiMax=" + numAbitantiMax +
                ", numNegoziMin=" + numNegoziMin +
                ", numScuoleMin=" + numScuoleMin +
                ", numRistorantiMin=" + numRistorantiMin +
                '}';
    }
}

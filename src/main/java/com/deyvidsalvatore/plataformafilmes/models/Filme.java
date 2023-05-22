package com.deyvidsalvatore.plataformafilmes.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class Filme {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private String urlGoogleDrive;
    private String imagemCapa;

}

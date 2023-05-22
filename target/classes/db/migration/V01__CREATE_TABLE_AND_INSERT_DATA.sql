CREATE TABLE filme (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descricao TEXT(2000),
    url_google_drive VARCHAR(255) NOT NULL,
    imagem_capa VARCHAR(255)
);

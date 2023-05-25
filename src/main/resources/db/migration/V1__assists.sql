CREATE TABLE `assistances` (
`id` bigint NOT NULL AUTO_INCREMENT,
`description` varchar(255) NOT NULL,
`name` varchar(150) NOT NULL,
PRIMARY KEY (`id`)
);

INSERT INTO assistances (name, description) VALUES ('Troca de aparelho', 'Troca de aparelho decodificador de sinal');
INSERT INTO assistances (name, description) VALUES ('Troca de cabo interno', 'Troca de cabo interno');
INSERT INTO assistances (name, description) VALUES ('Troca de fiação interna', 'Substituição de fiação interna da residência');
INSERT INTO assistances (name, description) VALUES ('Manutenção em fogão', 'Reparo sem necessidade de compra de peças');
INSERT INTO assistances (name, description) VALUES ('Manutenção em geladeira', 'Reparo sem necessidade de compra de peças');
INSERT INTO assistances (name, description) VALUES ('Manutenção em máquina de lavar', 'Reparo sem necessidade de compra de peças');
INSERT INTO assistances (name, description) VALUES ('Suporte de Rede', 'Configuração e resolução de problemas em redes de computadores');
INSERT INTO assistances (name, description) VALUES ('Instalação de Ar-condicionado', 'Colocação e configuração de sistemas de refrigeração para ambientes');
INSERT INTO assistances (name, description) VALUES ('Serviços de Encanamento', 'Reparo e instalação de tubulações e sistemas hidráulicos');
INSERT INTO assistances (name, description) VALUES ('Instalação de Antena Parabólica', 'Montagem e alinhamento de antenas para recepção de sinais de TV');
INSERT INTO assistances (name, description) VALUES ('Limpeza de Piscinas', 'Manutenção e tratamento da água em piscinas residenciais');
INSERT INTO assistances (name, description) VALUES ('Assistência em Eletrônicos', 'Reparo de aparelhos eletrônicos diversos, como TVs, DVD players, etc.');
INSERT INTO assistances (name, description) VALUES ('Reparo de Telhados', 'Conserto e substituição de telhas e estruturas danificadas em coberturas');
INSERT INTO assistances (name, description) VALUES ('Serviços de Jardinagem', 'Corte de grama, poda de árvores, manutenção de jardins');
INSERT INTO assistances (name, description) VALUES ('Instalação de Sistemas de Segurança', 'Colocação de câmeras, alarmes e controle de acesso em residências e empresas');
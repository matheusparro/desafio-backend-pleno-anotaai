# Product Catalog Management API Challenge

## Descrição

Este projeto é uma API desenvolvida em Java com Spring para gerenciar um sistema de catálogo de produtos em um aplicativo de marketplace. A API permite o registro, atualização, associação e exclusão de produtos e categorias, além de notificar mudanças no catálogo via AWS SQS e SNS, e armazenar o catálogo JSON no AWS S3 utilizando AWS Lambda para a criação do catálogo.

## Tecnologias Utilizadas

- Java
- Spring Framework
- MongoDB (localmente e na nuvem)
- AWS S3
- AWS SQS
- AWS SNS
- AWS Lambda

## Funcionalidades

- **Registrar Produto**: Permite registrar um produto com título, descrição, preço, categoria e ID do proprietário.
- **Registrar Categoria**: Permite registrar uma categoria com título, descrição e ID do proprietário.
- **Associar Produto a Categoria**: Permite associar um produto a uma categoria específica.
- **Atualizar Produto ou Categoria**: Permite atualizar os dados de um produto ou categoria existente.
- **Deletar Produto ou Categoria**: Permite deletar um produto ou categoria do catálogo.
- **Notificações de Mudança no Catálogo**: Publica mudanças no catálogo no tópico "catalog-emit" do AWS SQS.
- **Consumidor de Mudanças no Catálogo**: Escuta mensagens de mudanças no catálogo, busca o catálogo do proprietário no banco de dados, gera o JSON do catálogo e publica no bucket do AWS S3.

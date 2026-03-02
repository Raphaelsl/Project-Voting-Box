###🗳️ Sistema de Votação Eletrônica (Urna Eletrônica)
Este é um sistema de simulação de urna eletrônica desenvolvido em Java. O projeto foi concebido para aplicar conceitos avançados de Programação Orientada a Objetos (POO) e lógica de programação em um cenário prático de automação de processos eleitorais.

##🚀 Funcionalidades
Configuração Dinâmica: Permite cadastrar múltiplos cargos (ex: CDICEA) e seus respectivos candidatos.

Fluxo de Votação: Processamento de votos nominais, brancos e nulos com confirmação do usuário.

Encerramento Seguro: Sistema de interrupção da votação através de código sentinela (999).

Relatório Detalhado: Exibição completa da apuração por cargo, incluindo votos brancos, nulos e o total individual de cada candidato.

##🏗️ Arquitetura e Conceitos Aplicados
O projeto utiliza os pilares da POO para garantir um código limpo e extensível:

Abstração e Herança: Uso da classe abstrata Entidade como base para Candidato e Cargo, evitando repetição de código.

Interfaces: Implementação da interface Votavel para padronizar o comportamento de objetos que recebem votos.

Encapsulamento: Atributos protegidos e privados com métodos de acesso controlados.

Collections e Generics: Uso de ArrayList e List<Candidato> para gerenciamento dinâmico de dados.

Tratamento de Exceções: Robustez no input de dados com blocos try-catch e exceções personalizadas como VotoInvalidoException.

##🛠️ Tecnologias
Linguagem: Java

Ambiente: Console (Terminal)

Paradigma: Orientação a Objetos

#*Desenvolvido por Raphael Sousa Lameira.*
*Estudante de Sistemas de Informação - UFOP.*

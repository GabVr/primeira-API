 🚗 API de Cadastro e Validação de Carros

📌 Sobre o Projeto

Esta é uma API desenvolvida em **Spring Boot** para cadastro e validação de veículos.

A aplicação valida automaticamente:

* Marca
* Modelo (compatível com a marca)
* Cor
* Ano
* Placa (padrão Mercosul)

---

⚙️ Tecnologias utilizadas

* Java
* Spring Boot
* Maven
* Postman (para testes)

---

 🚀 Funcionalidades

✔ Cadastro de carros
✔ Validação de dados
✔ Verificação de compatibilidade entre marca e modelo
✔ Validação de placa no padrão Mercosul
✔ Tratamento de erros com mensagens personalizadas

---

📂 Estrutura do Projeto

```
Carros.primeira_API
│
├── Model
│   └── Carro.java
│
├── Validacoes
│   └── ValidarCarro.java
│
├── Excecoes
│   └── CampoPreenchimento.java
│
└── Controller (se aplicável)
```

---

📥 Exemplo de requisição (POST)

 Endpoint:

```
POST /carros
```

 Body (JSON):

```json
{
  "marca": "Chevrolet",
  "modelo": "Onix",
  "cor": "Preto",
  "ano": 2020,
  "placa": "ABC1D23"
}
```

---
 ✅ Exemplo de sucesso

```json
{
  "mensagem": "Carro cadastrado com sucesso!"
}
```

---

 ❌ Exemplos de erro

 Marca inválida:

```json
{
  "erro": "Marca do carro inválida!"
}
```

 Modelo incompatível:

```json
{
  "erro": "Modelo não pertence à marca informada!"
}
```

 Placa inválida:

```json
{
  "erro": "A placa do seu carro não segue os padrões do Mercosul"
}
```

---

 🔎 Regras de Validação

* **Marca:** deve existir na lista pré-definida
* **Modelo:** deve pertencer à marca informada
* **Ano:** não pode ser maior que o atual nem menor ou igual a 0
* **Placa:** deve seguir o padrão:

  * Antigo: `ABC1234`
  * Mercosul: `ABC1D23` (Lembrando que a validação não vai necessariamente dizer se a placa realmente existe ou não, mas ela vai dizer se a estrutura da placa do carro é verídico)

---

 🧪 Testes

A API pode ser testada utilizando:

* Postman
* Insomnia

---

 👨‍💻 Autor

Projeto desenvolvido para fins acadêmicos.


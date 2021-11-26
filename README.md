# ProjetoIntegrador

## Ana Carolina Ferreira Soares Wave - 3

### Requisito 6


### POST - NÍVEL - Insert

Para cadastrar o nivel no sistema é necessário efetuar uma requisição via postman

```
{
    "valorTotalDeCompra":600.00,
    "percentualDesconto":45,
    "beneficios":"Desconto, Frete Grátis, um Kit Hortifruti e um kit de Condimentos"
}
```

***Link para uso:***

http://localhost:8090/api/v1/nivel/insert


### PUT - NÍVEL - Update


Para atualizar o nível no sistema é necessário efetuar uma requisição via postman

```
{
    "valorTotalDeCompra":600.00,
    "percentualDesconto":45,
    "beneficios":"Desconto, Frete Grátis, um Kit Hortifruti e um kit de Condimentos"
}
```

***Link para uso:***

http://localhost:8090/api/v1/nivel/update/1


### GET - NÍVEL - list all

Para obter a lista de níveis cadastrados

***Link para uso:***

http://localhost:8090/api/v1/nivel/list/


Exemplo de lista 

```
[
    {
        "id": 1,
        "valorTotalDeCompra": 500.00,
        "percentualDesconto": 40,
        "beneficios": "Desconto, Frete Grátis, um Kit Hortifruti e um kit de Condimentos"
    },
    {
        "id": 2,
        "valorTotalDeCompra": 200.00,
        "percentualDesconto": 20,
        "beneficios": "Desconto + 20%"
    },
    {
        "id": 3,
        "valorTotalDeCompra": 300.00,
        "percentualDesconto": 30,
        "beneficios": "Desconto e Frete Grátis"
    },
    {
        "id": 4,
        "valorTotalDeCompra": 400.00,
        "percentualDesconto": 40,
        "beneficios": "Desconto, Frete Grátis e um Kit Hortifruti"
    },
    {
        "id": 5,
        "valorTotalDeCompra": 500.00,
        "percentualDesconto": 45,
        "beneficios": "Desconto, Frete Grátis, um Kit Hortifruti e um kit de Condimentos"
    },
    {
        "id": 14,
        "valorTotalDeCompra": 500.00,
        "percentualDesconto": 40,
        "beneficios": "Desconto, Frete Grátis, um Kit Hortifruti e um kit de Condimentos"
    },
    {
        "id": 15,
        "valorTotalDeCompra": 500.00,
        "percentualDesconto": 40,
        "beneficios": "Desconto, Frete Grátis, um Kit Hortifruti e um kit de Condimentos"
    }
]
```

### GET - NÍVEL - List level buyer

Para obter a lista de informações do cliente: 

<ul>
<li>Total Compras</li>
<li>Nível Atual</li>
<li>Próximo Nivel</li>
<li>Mensagem de quanto falta para atingir o próximo nível</li>
</ul>

***Link para uso:***

http://localhost:8090/api/v1/nivel/list/nivelBuyer/2


Exemplo de lista 

```
{
    "buyerName": "Alessandro",
    "totalCompras": 0,
    "nivelAtual": {
        "id": 1,
        "valorTotalDeCompra": 500.00,
        "percentualDesconto": 40,
        "beneficios": "Desconto, Frete Grátis, um Kit Hortifruti e um kit de Condimentos"
    },
    "proximoNivel": {
        "id": 2,
        "valorTotalDeCompra": 200.00,
        "percentualDesconto": 20,
        "beneficios": "Desconto + 20%"
    },
    "mensagem": "Falta 200.00 para o cliente atingir o próximo nível!"
}
```

### GET - PurchaseOrder - List Purchase By Buyer

Para obter a lista de informações do cliente: 

***Link para uso:***

http://localhost:8090/api/v1/product/orders/buyer/1

Exemplo de lista 

```
[
    {
        "date": "2021-10-31",
        "buyerId": 1,
        "orderStatus": {
            "orderStatusId": 1,
            "statusCode": "cart"
        },
        "products": [
            {
                "productId": "MLB-129",
                "quantity": 5
            },
            {
                "productId": "MLB-128",
                "quantity": 2
            }
        ]
    },
    {
        "date": "2021-10-31",
        "buyerId": 1,
        "orderStatus": {
            "orderStatusId": 1,
            "statusCode": "cart"
        },
        "products": [
            {
                "productId": "MLB-129",
                "quantity": 6
            }
        ]
    }
]
```

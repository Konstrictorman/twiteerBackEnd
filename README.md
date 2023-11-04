# twiteerBackEnd
Servicios para aplicación twitter  






## Acerca del proyecto
El proyecto consiste en servicios (métodos) que acceden datos de un archivo en excel, de acuerdo a la siguiente identificación de modelo de negocio:

![alt text](https://github.com/Konstrictorman/twiteerBackEnd/blob/master/src/main/resources/Business%20model.png?raw=true)  


## Arquitectura de la aplicación
A continuación se diagrama una abstracción de la arquitectura de la aplicación, modelando la entidad "Tweet"

![alt text](https://github.com/Konstrictorman/twiteerBackEnd/blob/master/src/main/resources/Architecture.png?raw=true)

Los métodos candidatos a ser mapeados como funciones Lambda, están identificados en las interfaces del paquete

> co.edu.escualing.twitter.services


## Metáfora de la arquitectura

![alt text](https://github.com/Konstrictorman/twiteerBackEnd/blob/master/src/main/resources/Restaurant.jpeg?raw=true)  

La aplicación se puede representar como un restaurante con varios tipos de comida.  

Las funciones Lambdas serían representadas en esta metáfora por los tipos de plato.  Una función lambda se especializa en carnes (procesar el listado de tweets), otra función lambda se especializa en pescados (procesar usuarios).  De esta forma cada función lambda tendría una sección clara en la cocina de este restaurante.  

La capa de servicios, serían los ítems del menú.  Acá se definen una lista de servicios y métodos que un cliente puede ordenar.  Cada servicio corresponde a un plato en particular o funcionalidad.  Por ejemplo, el servicio "Carnes" provee opciones para diferentes tipos de platos de carnes (bifé de chorizo, bifé de paleta, punta de anca, etc).  Esta
capa de servicios actúa como el menú al que los clientes (API gateway) acceden.  

La capa de acceso a datos DAO, se puede comparar con el staff de la cocina para cada tipo de platos.  De la misma forma que el staff de la cocina es responsable de preparar los platos, la capa DAO interactúa con la BD y administra operaciones de datos.  Recupera y almacena datos a demanda para satiasfacer las órdenes de servicios, tal cual
haría el staff de una cocina para asegurar que los platos son cicinados y servidos apropiadamente.  

El API Gateway es como el staff de meseros encargados de tomar las órdenes de los clientes y asignarlo a la apropiada rama de tipos de platos (Lambda function) del restaurante.  Actúa como la interface que los clientes tienen para acceder al menú y ordenar; llevando las solicitudes a la cocina especializada (carnes, aves, postres, pescados... etc).  

Los modelos o POJO actúan como las recetas de cada palta.  Definen la estructura y los ingredientes que se necesitan para cada plato.



## Built with

- Java 11
- AWS Lambda
- AWS ApiGateway


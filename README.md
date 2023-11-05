# twiteerBackEnd
Servicios para aplicación twitter  


<br><br><br>



## Acerca del proyecto
El proyecto consiste en servicios (métodos) que acceden datos de un archivo en excel, de acuerdo a la siguiente identificación de modelo de negocio:

![alt text](https://github.com/Konstrictorman/twiteerBackEnd/blob/master/src/main/resources/Business%20model.png?raw=true)  

<br><br><br>

## Arquitectura de la aplicación
A continuación se diagrama una abstracción de la arquitectura de la aplicación, modelando la entidad "Tweet"

![alt text](https://github.com/Konstrictorman/twiteerBackEnd/blob/master/src/main/resources/Architecture.png?raw=true)

Los métodos candidatos a ser mapeados como funciones Lambda, están identificados en las interfaces del paquete

> co.edu.escualing.twitter.services


<br><br><br>

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

<br><br><br>

## Recursos

Se han identificado los siguientes recursos para el REST API a exponerse vía API Gateway:

### User

- **/users**  - GET para obtener los perfiles de los usuarios
- **/users**  - POST para crear nuevos usuarios
- **/users/{userId}** -  GET | DELETE | PATCH para obtener, borrar o actualizar un usuario específico
- **/users/{userId}/followers** - GET para obtener los seguidores del usuario
- **/users/{userId}/following**  - GET para obtner el listado de usuarios que un usuario en particular sigue

### Tweet

- **/tweets** - GET para obtener un listado de tweets
- **/tweets** -  POST para crear un nuevo tweet
- **/tweets/{tweetId}** - GET | DELETE | PATCH para obtener, obrrar o actualizar un tweet específico
- **/tweets/{tweetId}/likes** - GET para obtener el listado de usuarios a quien les ha gustado el tweet
- **/tweets/{tweetId}/retweets** - GET para obtener el listado de usuarios que han hecho retweet
- **/tweets/pages?offset={m}&limit={n}** - GET para obtener un listado de usuarios paginado

### Like

- **/likes** - POST para crear un nuevo like
- **/likes/{likeId}** - DELETE para eliminar un like específico

### Follow

- **/follows** - POST para seguir un nuevo usuario
- **/follows/{folowwId}** - DELETE para eliminar un follow específico

### Retweet

- **/retweets** - POST para hacer un nuevo retweet
- **/retweets/{retweetId}** - DELETE para eliminar un retweet específico

<br><br><br>
## Stack de tecnologías

- Java 11
- AWS Lambda
- AWS ApiGateway

<br><br><br>
## Build

> mvn clean compile assembly:single

<br><br><br>
## Referencias

- https://docs.aws.amazon.com/es_es/apigateway/latest/developerguide/how-to-method-settings-execution-console.html
- https://www.baeldung.com/java-aws-lambda
- https://github.com/awsdocs/aws-lambda-developer-guide/tree/main
<br><br><br>

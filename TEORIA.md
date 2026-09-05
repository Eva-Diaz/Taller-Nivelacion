<h1 style="text-align: center;">Solución a la parte teórica del taller de nivelación</h1>

#### Que es Markdown? es un *método de escritura y lenguaje de marcado ligero* que permite dar formato a un texto plano usando solo símbolos y caracteres especiales de forma rápida y sencilla; destaca por su portabilidad, ya que se puede abrir en cualquier dispositivo, su simplicidad, que permite escribir sin usar el mouse, y su alta compatibilidad para convertirse fácilmente a formatos como HTML, es uno de los estandares actuales para documentar proyectos en plataformas como GitHub 
## Git
### 1. ¿Qué es un repositorio en Git y cómo se diferencia de un proyecto “normal”?  
 Un **repositorio Git** es un proyecto gestionado localmente mediante el comando git init, el cual crea una carpeta oculta llamada .git que almacena toda la información interna necesaria para controlar el historial, las ramas y los commits del código; esto permite que el sistema funcione de forma autónoma en nuestra computadora, ofreciendo un control de versiones completo sin depender de una conexión a internet ni de plataformas externas como GitHub, a diferencia de un proyecto **normal** que solamente va a tener almacenada solo los archivos en su estado actual sin registrar los cambios realizados a lo largo del desarrollo, perdiendo así de forma irreversible cualquier estado previo si se modifica o elimina el código.  
### 2. ¿Cuáles son las tres áreas principales de Git (working directory, staging area/index y repository) y qué papel cumple cada una? 
 **Las tres areas principales de Git**
* **Working Directory:**  Es la carpeta en la cual se esta trabajando el proyecto de forma fisica donde se ve,crea y modifican los archivos. 
* **Staging Area:** Hace referencia a un borrador donde preparamos los cambios que queremos incluir en un proximo commit, esto lo hacemos primero con un *git add*; el staging area es una zona intermedia que funciona como un filtro.
* **Repository** Es el area donde Git toma los cambios preparados en la zona del Staging Area y crea el historial de versiones mediante *git commit -m* 
### 3. ¿Cómo representa Git los cambios internamente? (objetos blob, tree, commit y tag). 
### **La forma en la que se representan los cambios internamente en Git** es mediante capturas o fotografías donde aparecen cuatro objetos:

* **Blob:** Guarda el contenido de un archivo, no su nombre o ruta. Esto lo hace mediante un hash, un algoritmo matemático que le asigna a ese contenido un código único.
* **Tree:** Hace referencia a la estructura del proyecto. Este nos dice qué archivos y qué carpetas contiene el directorio en ese instante.
* **Commit:** Es el contenedor principal. Guarda los metadatos (autor, fecha, mensaje) y apunta a un **Tree** específico para saber cómo lucía el proyecto en ese momento, además de conectar con el commit anterior para mantener la línea de tiempo.
* **Tag:** Es la etiqueta de versión (como v1.0.0) que apunta de forma estática a un commit específico para marcar un hito importante.
#### ¿Cómo interactúan entre sí?
Cuando haces un cambio, Git no guarda una lista de líneas modificadas; crea nuevos **Blobs** para los archivos que cambiaron, genera un nuevo **Tree** para actualizar el mapa de carpetas y finalmente sella todo con un **Commit**. Si un archivo no cambió, el nuevo Tree simplemente reutiliza el hash del Blob anterior, ahorrando espacio de forma masiva.
### 4. ¿Cómo se crea un commit y qué información almacena un objeto commit? 
 Normalmente el proceso es *git add*  que es aquel que coloca el contenido seleccionado en el staging area y luego *git commit -m "Archivo actualizado"* que crea un nuevo objeto commit y lo sube al repositorio.
### Un commit almacena,entre otras cosas:
* Tree: que representa el estado del proyecto
* Parent(padre): es aquel que indica que commit procede
* Autor y comitente: nombre y correo de quien lo creo 
* Fecha: cuando se realizo 
* Mensaje: descripcion del cambio 
### 5. ¿Cuál es la diferencia entre git pull y git fetch? 
 **Git fecth** descarga los nuevos commits y referencias del remoto sin modificar tu rama de trabajo actual. Mientras que el **git pull** 
 **Git fech** solo descarga los cambios del repositorio remoto al historial local de forma segura sin alterar el código, lo que permite revisarlos antes de integrarlos, mientras que **git pull** descarga los cambios y los fusiona de inmediato en la rama de trabajo actual, siendo equivalente a ejecutar un git fetch seguido de un git merge.
### 6. ¿Qué es un branch (rama) en Git y cómo Git gestiona los punteros a commits? 
 Un **branch o rama** en Git es una línea independiente de desarrollo que permite trabajar en cambios sin afectar directamente a la rama principal. Una rama es básicamente un puntero que señala a un commit específico. Cada vez que se realiza un nuevo commit, el puntero de la rama avanza hacia ese nuevo commit. Git también utiliza HEAD para indicar la rama o commit en el que se está trabajando actualmente.
### 7. ¿Cómo se realiza un merge y qué conflictos pueden surgir? ¿Cómo se resuelven?
 Un **merge se utiliza** para unir los cambios de una rama con otra. Por ejemplo, si se está trabajando en la rama principal y se quiere incorporar una rama de funcionalidades, se ejecuta un merge. Los conflictos aparecen cuando dos ramas modifican las mismas líneas de un archivo o cuando Git no puede determinar automáticamente qué cambios conservar. Para resolverlos, se debe abrir el archivo que presenta el conflicto, decidir qué cambios conservar, eliminar las marcas que Git coloca para señalar el conflicto y después confirmar la solución mediante un nuevo commit.
### 8. ¿Cómo funciona el área de staging (git add) y qué pasa si omito este paso? 
 El **área de staging** es una zona intermedia entre los archivos que se están modificando y el repositorio. Cuando se utiliza git add, se seleccionan los cambios que se quieren incluir en el próximo commit. Después, git commit guarda esos cambios en el historial. Si **se omite git add**, las modificaciones realizadas en los archivos no se incluyen en el commit, porque permanecen únicamente en el directorio de trabajo.
### 9. ¿Qué es el archivo .gitignore y cómo influye en el seguimiento de archivos? 
 El **archivo .gitignore** sirve para indicarle a Git qué archivos o carpetas no deben ser considerados para seguimiento. Se utiliza, por ejemplo, para ignorar archivos temporales, dependencias, archivos generados automáticamente, contraseñas, configuraciones privadas o archivos de registro. El .gitignore normalmente evita que Git empiece a rastrear un archivo nuevo, pero no elimina automáticamente del seguimiento un archivo que ya había sido agregado y confirmado anteriormente.
### 10. ¿Cuál es la diferencia entre un “commit amend” (--amend) y un nuevo commit?
 **git commit --amend** permite modificar el último commit realizado. Puede utilizarse para corregir el mensaje del commit o para incluir algún archivo que se olvidó agregar. En lugar de crear un nuevo commit, reemplaza el commit anterior por una nueva versión, por lo que cambia su identificador. En cambio, **realizar un nuevo commit** mantiene el anterior en el historial y agrega otro commit después.
### 11. ¿Cómo se utiliza git stash y en qué escenarios es útil?
 **git stash** permite guardar temporalmente los cambios que todavía no se quieren confirmar mediante un commit. Es útil, por ejemplo, cuando se está trabajando en una funcionalidad y se necesita cambiar rápidamente de rama para solucionar otro problema. Los cambios se guardan temporalmente y el directorio de trabajo queda limpio. Posteriormente, se pueden recuperar los cambios guardados utilizando *git stash pop* (aplica el último cambio guardado y lo elimina definitivamente de la lista de stashes.) o *git stash apply*(aplica el último cambio guardado sin borrarlo de la lista.).

### 12. ¿Qué mecanismos ofrece Git para deshacer cambios?
Git ofrece diferentes opciones según lo que queramos deshacer: *git restore* permite descartar cambios en archivos, *git reset* permite modificar el historial local y eliminar o mover commits, *git revert* deshace un commit creando uno nuevo y es recomendable cuando el commit ya fue compartido, y *git checkout* se utilizaba para cambiar de rama o restaurar archivos, aunque actualmente se prefieren *git switch* y *git restore*.

### 13. ¿Cómo funciona la configuración de remotos (origin, upstream) y qué comandos uso para gestión de forks?
Los remotos son repositorios externos relacionados con el repositorio local. *origin* es normalmente el nombre que Git asigna al repositorio remoto desde el cual se clonó el proyecto. Cuando se trabaja con un fork, normalmente origin representa el fork personal y upstream representa el repositorio original. De esta manera, se pueden obtener los cambios del proyecto original mediante upstream y enviar los propios cambios al fork mediante origin. Para gestionar estos remotos se utilizan comandos como git remote -v, git remote add, git fetch, git pull y git push.

### 14. ¿Cómo puedo inspeccionar el historial de commits?
Git proporciona diferentes comandos para consultar el historial: 
* *git log* permite visualizar los commits realizados y conocer información como el autor, la fecha y el mensaje. 
* *git log --oneline* muestra el historial de forma más resumida. 
* *git show* permite consultar los detalles de un commit específico, incluyendo los cambios realizados. 
* *git diff* permite comparar modificaciones entre archivos, commits o estados diferentes del proyecto. 
Estos comandos ayudan a conocer cómo ha evolucionado el proyecto y qué cambios se han realizado a lo largo del tiempo.

## Programacion 
### 15. ¿Cuáles son los tipos de datos primitivos en Java? 
Los pri­mi­ti­vos de Java se utilizan para crear variables que contienen números, ca­ra­c­te­res o valores lógicos in­di­vi­dua­les.
* Tipo de datos lógico (boolean)
* Tipo de datos in­te­gra­les (byte, short, int y long)
* Datos de coma flotante (float y double)
* Tipo de datos de ca­ra­c­te­res (char) 
### 16. ¿Cómo funcionan las estructuras de control de flujo como if, else, switch y bucles en  Java? 
Las estructuras de control permiten decidir y repetir acciones en un programa. 
 **if** ejecuta código cuando se cumple una condición, **else** permite ejecutar otra opción cuando no se cumple, **switch** permite seleccionar entre diferentes casos y los bucles como **for, while y do-while** permiten repetir instrucciones mientras se cumpla una condición o durante una cantidad determinada de veces.
### 17. ¿Por qué es importante usar nombres significativos para variables y métodos? 
Los nombres significativos hacen que el código sea más fácil de entender, mantener y modificar, tanto para quien lo escribe como para otros desarrolladores. Por ejemplo, es más claro usar nombreUsuario que x, porque el nombre permite saber inmediatamente qué información almacena la variable.
### 18. ¿Qué es la Programación Orientada a Objetos (POO)? 
La Programación Orientada a Objetos (POO) es un paradigma de programación que organiza el código mediante objetos, los cuales contienen datos y comportamientos. En Java, los objetos se crean a partir de clases y permiten representar elementos del mundo real o conceptos de un sistema.
### 19. ¿Cuáles son los cuatro pilares de la Programación Orientada a Objetos? 
* Encapsulamiento: es un mecanismo para agrupar los datos y el código como una sola unidad. 
* Herencia: es un proceso mediante el cual una clase adquiere las propiedades de otra.
* Polimorfismo: es la capacidad de una variable, función u objeto para adoptar múltiples formas.
* Abstraccion:permite mostrar lo importante de un objeto ocultando detalles innecesarios. 
### 20. ¿Qué es la herencia en POO y cómo se utiliza en Java? 
La herencia en Java es el concepto mediante el cual las propiedades de una clase pueden ser heredadas por otra. Ayuda a reutilizar el código y a establecer una relación entre diferentes clases.En Java se utiliza principalmente mediante la palabra clave extends, por ejemplo, class Perro extends Animal, donde Perro hereda las características de Animal
### 21. ¿Qué son los modificadores de acceso y cuáles son los más comunes en Java? 
Los modificadores de acceso determinan quién puede acceder a una clase, atributo o método. Los más comunes son **public**, que permite acceso desde cualquier lugar; **private**, que limita el acceso a la misma clase; **protected**, que permite acceso dentro del mismo paquete y desde clases hijas; y el **Default** acceso por defecto (sin modificador), que permite acceso dentro del mismo paquete.
### 22. ¿Qué es una variable de entorno y por qué son importantes para Java o la  programación en general? 
Una variable de entorno es un valor almacenado en el sistema operativo que puede ser utilizado por los programas para obtener información de configuración. En Java, por ejemplo, JAVA_HOME puede indicar dónde está instalada la JDK y PATH permite ejecutar comandos como java o javac desde la terminal. Son importantes porque permiten configurar programas sin tener que modificar directamente el código
========================
Descripcion del programa
========================
El programa consta de un modelo llamado MVC el cual esta estructurado en nuestro proyecto de la siguiente manera:
 * Modelo
	->Clientes.java

 * Vista 
	->Programa1.java(main)

 * Controlador
	->jsonConnector.java
	->interfaceController.java

Modelo: Se encuentra esta la clase de la entidad clientes con sus respectivos setters y getters y constructores.
Vista: Se encuentra archivo programa1.java el cual contiene el menú principal en terminal que se auxilia del Controlador para funcionar.
Controlador:
jsonConnector.java, esta clase se encarga de plasmar y obtener los datos del archivo json para mostrar al Gerente.
interfaceController.java En esta clase se encuentran las funciones que reciben los parámetros para mandarlos al json así como la una breve fase de verificación de estos datos.
+++++++++++++++++++++++
       Ejecución  
++++++++++++++++++++++
Para ejecutar el programa utilizaremos el comando  
Java -jar programa1.jar
Dentro de la carpeta bin , esto en la consola de comandos.
************************
        Compilar
************************* 
Para compilar el programa se puede usar netbeans(Recomendable) , o bien el comando con la siguiente estructura
ant -f "ruta del programa" -Dnb.internal.action.name=rebuild clean jar
sustituyendo “ruta del programa” por a la ruta que tenemos.

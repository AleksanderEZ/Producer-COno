# ProducerAndConsumer-problem

Simulación puesto de comida rápida
El problema consiste en que un puesto móvil de comida rápida se acerca diariamente a una obra para servir a sus trabajadores hamburguesas y raciones de papas. Cada trabajador, según el hambre que tenga, toma entre 1 y 3 hamburguesas, y entre 0 y 3 raciones de papas. El puesto móvil de comida rápida es pequeño y sólo puede trabajar en él un cocinero. El cocinero no espera a que haya pedidos, sino que se encarga de cocinar las hamburguesas y las raciones de papas en tandas para ponerlas en un mostrador. El cocinero no puede, simultáneamente, hacer hamburguesas y papas, por lo que, unas veces, hace 4 hamburguesas, y otras, 4 raciones de papas. Por otro lado, el trabajo del cocinero está limitado ya que debe cocinar sólo si hay suficiente espacio para la comida en el mostrador del puesto. El puesto es autoservicio, los clientes toman las hamburguesas y raciones de papas que quieren comer sin formar una cola. Sin embargo, cuando un cliente tiene la oportunidad de coger comida y encuentra que en el mostrador no hay suficientes hamburguesas y raciones de papas para satisfacer su hambre, no coge nada, sino que espera a tener otra oportunidad de coger todo lo que quiere.

El ejercicio consiste en desarrollar un programa Java que simule la actividad descrita de un puesto móvil de comida rápida, con un cocinero y varios clientes que quieren comer en el puesto. Cada cliente se identificará a través de un número entero asignado en su creación, junto con el número de hamburguesas y raciones de papas que desea comer. Cada cliente realiza el siguiente comportamiento: accede al puesto y cuando consigue la comida que quiere, se la come. Comer una hamburguesa o ración de papas llevan un tiempo de consumo asociada, definido en la clase Simulador. (Para más detalle vea la clase Simulador suministrada). Cuando el cliente termina de consumir toda la comida, finaliza su tarea. En ningún caso tomará la comida que quiere, parcialmente. Cada cliente deberá escribir en la pantalla mensajes indicando su comportamiento:

Al llegar al puesto.
Al esperar un (futuro) nuevo intento de tomar la comida.
Al conseguir tomar la comida que desea.
Al terminar de comer.
Para dar homogeneidad al formato de los mensajes, la representación del cliente y comida llegar/espera/consigue/come se ajustará al siguiente formato: “Cliente identidad [número de hamburguesas, números de raciones de papas] acción que realiza ”. Por ejemplo, “Cliente 2 [1,3] consigue la comida” representa que el cliente con identificador 2 consiguió 1 hamburguesa y 3 raciones de papas.

Hay que destacar que el puesto de comida rápida dispone de un número limitado de espacios para hamburguesas y raciones de papas en el mostrador (este número se establece en el constructor del puesto).

El cocinero realiza el siguiente comportamiento cíclico: basándose en el número actual de hamburguesas y papas aún presentes en el mostrador, cocina de lo que menos haya visto que queda (en caso de empate, hamburguesas), o bien 4 hamburguesas, o bien 4 raciones de papas, y las pone en el mostrador a disposición de los clientes. En caso de que no haya suficiente espacio en el mostrador para la tanda que habría de cocinar, no cocinará, sino que esperará a que haya suficiente espacio para reanudar su trabajo. El cocinero no trabaja indefinidamente, sino cocina un cierto número de tandas (tareas) hamburguesas o de raciones de papas definido al comienzo.

El puesto puede estar abierto o cerrado. Los clientes que llegan al puesto sólo intentan obtener comida del mismo si está abierto, en caso contrario, o si este se cierra, abandonan el puesto y terminan su actividad. El cocinero abre el puesto al comienzo de su actividad, y lo cierra cuando haya cocinado el número de tandas que corresponda.

Desarrollo de la simulación
Para desarrollar la simulación anterior, se han identificado tres clases:

La clase Puesto. Un monitor, parcialmente desarrollado, que gestiona la concurrencia en la obtención de la comida disponible en el puesto. Se tienen dos atributos privados que representen el número de hamburguesas y de raciones de papas disponibles, y tendrá que disponer de un método añadirHamburguesas, y otro, añadirPapas, a usar por por el cocinero, y otro, obtenerComida, por los clientes para que puedan retirar la comida. Cada objeto de la clase Puesto se podrá configurar fácilmente en cuanto a la cantidad de espacio inicialmente disponible. Esta clase dispone, además, de un método para abrir el puesto y otro para cerrarlo.

La clase Cocinero. Desarrollará un hilo de la simulación. El constructor de objetos de la clase Cocinero permite que el hilo principal indique el número de tandas de hamburguesas o raciones de papas a cocinar. El tiempo que dedica a cocinar una tanda viene dado por un método de la clase Simulador. EL cocinero es el encargado de abrir y cerrar el puesto.

La clase Cliente. Existirán varios hilos de esta clase en la simulación. Su constructor permite que el hilo principal indique la cantidad de hamburguesas y raciones de papas que quiere consumir. El tiempo (aleatorio) que precisa para consumir cada hamburguesa o cada ración de papas vienen dados por métodos de la clase Simulador.

Finalmente, la clase Simulador contiene el método main(), encargado de configurar y ejecutar el sistema. Creará y activará los elementos que participan en la simulación: puesto, cocinero y clientes. En la versión a entregar, configure 20 clientes. Se recomienda experimentar para comprobar cómo se comportaría el sistema con otras configuraciones alternativas con menos cantidad de clientes. El hilo principal terminará, y así lo visualizará, solo cuando hayan terminado todos los demás hilos.

package negocio.controlador.proyectos;

import negocio.Retorno;
import negocio.controlador.Command;
import negocio.proyectos.factoria.FactoriaSAProyectos;

public class CommandProyectoConsultarLista implements Command {

	@Override
	public Retorno execute() {
		return FactoriaSAProyectos.getInstancia().getInstanciaSAProyectos().listaProyectos();
	}

	@Override
	public void setContext(Object datos) {}

}

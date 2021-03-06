package negocio.controlador.command.departamentos;

import negocio.Retorno;
import negocio.controlador.command.Command;
import negocio.departamentos.Departamento;
import negocio.departamentos.factoria.FactoriaSADepartamentos;

public class CommandDepartamentoCrear implements Command {

	private Departamento dep = null;

	@Override
	public Retorno execute() {
		return FactoriaSADepartamentos.getInstancia()
				.getInstanciaSADepartamentos().crearDepartamento(dep);
	}

	@Override
	public void setContext(Object datos) {
		dep = (Departamento) datos;
	}

}

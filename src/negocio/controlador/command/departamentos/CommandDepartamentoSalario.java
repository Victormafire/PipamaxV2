package negocio.controlador.command.departamentos;

import negocio.Retorno;
import negocio.controlador.command.Command;
import negocio.departamentos.Departamento;
import negocio.departamentos.factoria.FactoriaSADepartamentos;

public class CommandDepartamentoSalario implements Command{
	
	private Departamento departamento = null;
	
	public Retorno execute() {
		return FactoriaSADepartamentos.getInstancia()
				.getInstanciaSADepartamentos().consultarSalarioDepartamento(departamento);
	}

	public void setContext(Object datos) {
		this.departamento = (Departamento) datos;
	}
	
	
}

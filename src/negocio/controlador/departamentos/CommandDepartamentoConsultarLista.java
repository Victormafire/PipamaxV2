package negocio.controlador.departamentos;

import negocio.Retorno;
import negocio.controlador.Command;
import negocio.departamentos.factoria.FactoriaSADepartamentos;

public class CommandDepartamentoConsultarLista implements Command {

	@Override
	public Retorno execute() {
		return FactoriaSADepartamentos.getInstancia()
				.getInstanciaSADepartamentos().consultarListaDepartamentos();
	}

	@Override
	public void setContext(Object datos) {
	}

}

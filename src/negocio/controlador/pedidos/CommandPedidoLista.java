package negocio.controlador.pedidos;

import negocio.Retorno;
import negocio.controlador.Command;
import negocio.pedidos.SAPedidos;
import negocio.pedidos.factoria.FactoriaSAPedidos;

public class CommandPedidoLista implements Command {



	@Override
	public Retorno execute() {
		SAPedidos SA = FactoriaSAPedidos.getInstancia().getInstanciaSAPedidos();
		return SA.principalPedidos();
	}

	@Override
	public void setContext(Object datos) {
	}

}

package negocio.controlador.empleados;

import negocio.Retorno;
import negocio.controlador.Command;
import negocio.empleados.Empleado;
import negocio.empleados.factoria.FactoriaSAEmpleados;

public class CommandEmpleadoEditar implements Command {

	private Empleado emp = null;

	@Override
	public Retorno execute() {
		return FactoriaSAEmpleados.getInstancia().getInstanciaSAEmpleados()
				.editaEmpleado(emp);
	}

	@Override
	public void setContext(Object datos) {
		emp = (Empleado) datos;
	}

}

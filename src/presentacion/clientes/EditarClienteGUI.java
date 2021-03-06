package presentacion.clientes;

/*
 * ----------
 * internal imports
 * ----------
 */

import constantes.Acciones;

/*
 * ----------
 * External libraries
 * ----------
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentacion.GUI;
import negocio.controlador.ControladorAplicacion;

import negocio.Retorno;
import negocio.clientes.TransferCliente;

public class EditarClienteGUI extends GUI {

	private static final long serialVersionUID = 1L;
	// Paneles de la ventana
	JPanel norte;
	JPanel centro;
	JPanel sur;

	// Componentes de la ventana
	JButton aceptar;
	JButton cancelar;
	JLabel labelId;
	JTextField cajaNombre;
	JTextField cajaApellido;
	JTextField cajaCiudad;
	JTextField cajaCodigoPostal;
	JTextField cajaDireccion;
	JTextField cajaTelefono;
	JTextField cajaEmail;
	JTextField cajaDNI;
	JTextField cajaDescuento;
	JComboBox<String> cajaTipo;

	private int id = 0;

	public EditarClienteGUI(Integer id, ClientesGUI padre) {
		super(padre);

		//create the frame
		this.requestFocusInWindow();
		this.setLayout(new BorderLayout());
		this.setResizable(false);

		norte = new JPanel();
		norte.setLayout(new FlowLayout());
		norte.add(new JLabel("Modifique los datos del cliente."));

		this.add(norte, BorderLayout.NORTH);

		centro = new JPanel();
		centro.setBorder(BorderFactory.createTitledBorder("Datos"));
		centro.setLayout(new GridLayout(11, 2, 10, 10));

		centro.add(new JLabel("Id: "));

		labelId = new JLabel();
		centro.add(labelId);

		centro.add(new JLabel("Nombre: "));
		cajaNombre = new JTextField();
		cajaNombre.setPreferredSize(new Dimension(300, 30));
		centro.add(cajaNombre);

		centro.add(new JLabel("DNI: "));
		cajaDNI = new JTextField();
		cajaDNI.setPreferredSize(new Dimension(310, 30));
		centro.add(cajaDNI);

		centro.add(new JLabel("Apellidos: "));
		cajaApellido = new JTextField();
		cajaApellido.setPreferredSize(new Dimension(300, 30));
		centro.add(cajaApellido);

		centro.add(new JLabel("Ciudad: "));
		cajaCiudad = new JTextField();
		cajaCiudad.setPreferredSize(new Dimension(300, 30));
		centro.add(cajaCiudad);

		centro.add(new JLabel("C�digo Postal: "));
		cajaCodigoPostal = new JTextField();
		cajaCodigoPostal.setPreferredSize(new Dimension(300, 30));
		centro.add(cajaCodigoPostal);

		centro.add(new JLabel("Direccion: "));
		cajaDireccion = new JTextField();
		cajaDireccion.setPreferredSize(new Dimension(300, 30));
		centro.add(cajaDireccion);

		centro.add(new JLabel("N� telefono: "));
		cajaTelefono = new JTextField();
		cajaTelefono.setPreferredSize(new Dimension(300, 30));
		centro.add(cajaTelefono);

		centro.add(new JLabel("Email: "));
		cajaEmail = new JTextField();
		cajaEmail.setPreferredSize(new Dimension(300, 30));
		centro.add(cajaEmail);

		centro.add(new JLabel("Tipo: "));
		cajaTipo = new JComboBox<String>();
		cajaTipo.addItem("VIP");
		cajaTipo.addItem("NoVIP");
		cajaTipo.setPreferredSize(new Dimension(300, 30));
		cajaTipo.addActionListener(new ListenerTipoCambia());
		centro.add(cajaTipo);

		centro.add(new JLabel("Descuento: "));
		cajaDescuento = new JTextField();
		cajaDescuento.setPreferredSize(new Dimension(320, 30));
		centro.add(cajaDescuento);

		this.add(centro, BorderLayout.CENTER);

		sur = new JPanel();
		sur.setLayout(new GridLayout(1, 2, 10, 10));

		aceptar = new JButton("Aceptar");
		aceptar.addActionListener(new ListenerAceptar());
		sur.add(aceptar);

		cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ListenerCancelar());
		sur.add(cancelar);

		this.add(sur, BorderLayout.SOUTH);

		//set the configurations of the window
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);

		// Consultamos los datos del cliente.
		TransferCliente cliente = new TransferCliente();
		cliente.setId(id);
		ControladorAplicacion.getInstancia().accion(Acciones.clientesConsultar,
				cliente);
	}

	class ListenerAceptar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				TransferCliente cliente = new TransferCliente();
				cliente.setId(id);

				cajaDNI.setBackground(Color.red);
				cliente.setDNI(Integer.parseInt(cajaDNI.getText()));
				if (cliente.getDNI() < 0)
					throw new NumberFormatException();
				cajaDNI.setBackground(Color.green);

				cajaNombre.setBackground(Color.red);
				if (cajaNombre.getText().equals(""))
					throw new InputMismatchException();
				cliente.setName(cajaNombre.getText());
				cajaNombre.setBackground(Color.green);

				cajaApellido.setBackground(Color.red);
				if (cajaApellido.getText().equals(""))
					throw new InputMismatchException();
				cliente.setLastName(cajaApellido.getText());
				cajaApellido.setBackground(Color.green);

				cajaCiudad.setBackground(Color.red);
				if (cajaCiudad.getText().equals(""))
					throw new InputMismatchException();
				cliente.setCity(cajaCiudad.getText());
				cajaCiudad.setBackground(Color.green);

				cajaCodigoPostal.setBackground(Color.red);
				cliente.setPostalCode(Integer.parseInt(cajaCodigoPostal
						.getText()));
				if (cliente.getPostalCode() < 0)
					throw new NumberFormatException();
				cajaCodigoPostal.setBackground(Color.green);

				cajaDireccion.setBackground(Color.red);
				if (cajaDireccion.getText().equals(""))
					throw new InputMismatchException();
				cliente.setAdress(cajaDireccion.getText());
				cajaDireccion.setBackground(Color.green);

				cajaTelefono.setBackground(Color.red);
				cliente.setTelephoneNumber(Long.parseLong(cajaTelefono
						.getText()));
				if (cliente.getTelephoneNumber() < 0)
					throw new NumberFormatException();
				cajaTelefono.setBackground(Color.green);

				cajaEmail.setBackground(Color.red);
				if (cajaEmail.getText().equals(""))
					throw new InputMismatchException();
				cliente.setEmail(cajaEmail.getText());
				cajaEmail.setBackground(Color.green);

				cajaTipo.setBackground(Color.red);
				cliente.setTipo(cajaTipo.getSelectedItem().toString());
				cajaTipo.setBackground(Color.green);

				cajaDescuento.setBackground(Color.red);
				if (cajaDescuento.isEnabled()) {
					cliente.setDescuento(Float.parseFloat(cajaDescuento
							.getText()));
					if (cliente.getDescuento() >= 1
							|| cliente.getDescuento() < 0) {
						JOptionPane
								.showMessageDialog(EditarClienteGUI.this,
										"Solo se admiten valores entre [0,1) para el descuento.");
						cliente.setDescuento(-1);
					}
				} else {
					cliente.setDescuento(0);
				}
				cajaDescuento.setBackground(Color.green);

				if (cliente.getDescuento() != -1)
					ControladorAplicacion.getInstancia().accion(
							Acciones.clientesEditar, cliente);
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(EditarClienteGUI.this,
						"Debes introducir n�meros");
			} catch (InputMismatchException ex) {
				JOptionPane.showMessageDialog(EditarClienteGUI.this,
						"No se permiten campos vacios");
			}

		}
	}

	class ListenerCancelar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			EditarClienteGUI.this.setVisible(false);
			EditarClienteGUI.this.dispose();
		}
	}

	class ListenerTipoCambia implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cajaDescuento.setEnabled(cajaTipo.getSelectedItem().toString()
					.equals("VIP"));
		}
	}

	@Override
	public void actualiza(Acciones evento, Retorno datos) {

		switch (evento) {
		case clientesConsultar:
			if (!datos.tieneErrores()) {
				TransferCliente cliente = (TransferCliente) datos.getDatos();

				labelId.setText("" + cliente.getId());
				id = cliente.getId();
				cajaNombre.setText(cliente.getName());
				cajaApellido.setText(cliente.getLastName());
				cajaCiudad.setText(cliente.getCity());
				cajaCodigoPostal.setText("" + cliente.getPostalCode());
				cajaDireccion.setText(cliente.getAdress());
				cajaTelefono.setText("" + cliente.getTelephoneNumber());
				cajaEmail.setText(cliente.getEmail());
				cajaDNI.setText("" + cliente.getDNI());
				if (cliente.getTipo().equals("VIP")) {
					cajaTipo.setSelectedIndex(0);
					cajaDescuento.setText("" + cliente.getDescuento());
				} else
					cajaTipo.setSelectedIndex(1);

			} else {
				JOptionPane.showMessageDialog(this,
						"Error al consultar cliente");
				this.dispose();
			}
			break;
		case clientesEditar:
			if (!datos.tieneErrores()) {
				JOptionPane.showMessageDialog(this,
						"Cliente editado Correctamente");
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this, "Error al editar cliente");
				this.dispose();
			}
			break;
		}

	}

	@Override
	public void alVolver(GUI who) {
	}
}

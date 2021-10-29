package ejerciciosFicherosObj;

import java.io.Serializable;

public class Clientes implements Serializable{

	private String nombre;
	private String DNI;
	private String direccion;
	private double saldo;
	private String estadoCuenta;
	
	public Clientes(String DNI, String nombre, String direccion, double saldo) {
		this.DNI=DNI;
		this.nombre=nombre;
		this.direccion=direccion;
		this.saldo=saldo;
		if(this.saldo<0)
			estadoCuenta="Deudor";
		if(this.saldo==0)
			estadoCuenta="Al dia";
		if(this.saldo>0)
			estadoCuenta="Positivo";
	}
	
	public void setDni(String dni) {
		this.DNI=dni;
	}
	public String getDni() {
		return DNI;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public String getNombre() {
		return nombre;
	}
	
	public void setDireccion(String direccion) {
		this.direccion=direccion;
	}
	public String getDireccion() {
		return direccion;
	}
	
	public void setSaldo(double saldo) {
		this.saldo=saldo;
	}
	public double getSaldo() {
		return saldo;
	}
	
	public void setEstado(String estado) {
		this.estadoCuenta=estado;
	}
	public String getEstado() {
		return estadoCuenta;
	}
	
	public String[] getArrayDatos() {
		String[] datos=new String[5];
		datos[0]=this.DNI;
		datos[1]=this.nombre;
		datos[2]=this.direccion;
		datos[3]=this.saldo+"";
		datos[4]=this.estadoCuenta;
		return datos;
	}
}

package ejerciciosFicherosObj;

public class Clientes {

	private String nombre;
	private String DNI;
	private String direccion;
	private double saldo;
	private String estadoCuenta;
	
	public Clientes(String DNI, String nombre, String direccion, double saldo, String estadoCuenta) {
		this.DNI=DNI;
		this.nombre=nombre;
		this.direccion=direccion;
		this.saldo=saldo;
		this.estadoCuenta=estadoCuenta;
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
}

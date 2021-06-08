import javax.swing.JOptionPane;

public class Principal {
	public static int x = 100; //instancia
	public static int nm = 100;
	public static int m = 100;
	
	
	
	public static String matricula[] = new String[100];
	public static String nomealuno[] = new String[100];
	public static String materia[] = new String[100];	
	
	public static float mat_nota[][][] = new float[x][nm][4];
	public static float mediaMat[]   = new float[nm];
	public static float media[] = new float[x];
	
	public static String buscamat[] = new String[100];
	public static String buscanome[] = new String[100];
	
	public static int ultimamatricula = 0;	
	public static int ultimamateria = 0;
	
	public static int opcMenu = 0;
	public static int i,j,k;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Procedimentos pc = new Procedimentos();
		
		String cont_sistema = "S";
		String cont_aluno = "S";
		x = 0;
		
		while(cont_sistema.equals("S")) {
			
			if (x == 0) {
				x = Integer.parseInt(JOptionPane.
					showInputDialog("Insira o número de Alunos: "));
				nm = Integer.parseInt(JOptionPane.
						showInputDialog("Insira o número de Matérias: "));
			}
			
			pc.menu();
			
			do {
				cont_sistema = JOptionPane.
				showInputDialog("Deseja Continuar do Sistema (S)im - (N)ão: ");
				cont_sistema = cont_sistema.toUpperCase();
			}while((!cont_sistema.equals("S")) && (!cont_sistema.equals("N")));
		} //while(contsistema.equals("S"))
		
	}

}

import javax.swing.JOptionPane;

public class Procedimentos {
	public static int i,j,k;
	
	Principal pm = new Principal();
	/////////////////////////////////////////////////////////////////////////////////
	// M E N U   P R I N C I P A L
	/////////////////////////////////////////////////////////////////////////////////
	
	public void menu() {
		
		
		do {
			pm.opcMenu = 0;
			pm.opcMenu = Integer.parseInt(JOptionPane.
					showInputDialog("▓░▓░▓░▓░▓░▓░▓░▓░▓░▓\n"+
							        "  M E N U   D O   S I S T E M A"+"\n"+
							        "▓░▓░▓░▓░▓░▓░▓░▓░▓░▓\n\n"+
									"1.  C A D A S T R O S "+"\n"+
									"2.  C O N S U L T A S "+"\n"+
									"3.  L I S T A S  DE  M A T É R I A S"+"\n"+
									"4.  L I S T A S  DE  A L U N O S"+"\n"+
									"5.  N O T A S  D E  A L U N O S  P O R  M A T É R I A"+"\n"+
									"6.  S A I R   D O   M E N U "));
			
			switch(pm.opcMenu) {
				case 1 : {
					Cadastros();	
					break;
				}
				case 2 : {
					Consultas();
					break;
				}
				case 3 : {
					listadematerias();
					break;
				}
				case 4 : {
					listadealunos();
					break;
				}
				
				case 5 : {
					
					notasdealunospormateria();
					break;
				}
				
				case 6: {
					JOptionPane.showMessageDialog(null,"Tecle  [E N T E R]  para sair do Sistema!!!");
					break;
				}
				default : {
					JOptionPane.showMessageDialog(null,"Escolha Inválida!!!");
				}
					
			}// switch(pm.opcMenu)
			
		}while((pm.opcMenu<= 0) || (pm.opcMenu>6));
	}
	/////////////////////////////////////////////////////////////////////////////////	
	// N O T A S  D E  A L U N O S  P O R  M A T É R I A
	/////////////////////////////////////////////////////////////////////////////////
	public void notasdealunospormateria() {
		
        boolean cont = true;	
		String OutraBusca = "S";
		String NomeBusca ="", detalhe;	
		int alunoencontrado = -1;
		
		while(OutraBusca.equals("S")) {
			detalhe = ""; 
			int encontrou = 0; //  0 = não ; 1 = sim ;
			float acmnotas = 0, acmmedmat = 0;
			
			NomeBusca = JOptionPane.showInputDialog("Digite o Nome do Aluno:");
			
			
			for (i = 0; i < pm.x; i++) {
				if (NomeBusca.equals(pm.nomealuno[i])) {
					
					alunoencontrado = i;
					detalhe = "Matrícula: "+pm.matricula[i]+"\n"+
				              "Aluno....: "+pm.nomealuno[i];
				    JOptionPane.showMessageDialog(null, detalhe);
					encontrou = 1;
					i = pm.x;
				}else {
					encontrou = 0;
				}		
				
			} //for (i = 0; i < pm.x; i ++) {
			
			if (encontrou == 0) {
				JOptionPane.showMessageDialog(null, "Dados Referidos Não Encontrados!!!");
				alunoencontrado = -1;
			}
			
			if (encontrou == 1) {
				for (j = 0; j < pm.nm; j++ ) {
					
				    JOptionPane.showMessageDialog(null,"Matéria["+(j+1)+"]: "+pm.materia[j]);
					for (k = 0 ; k < 4; k++){
						pm.mat_nota[alunoencontrado][j][k] = 
						Float.parseFloat(JOptionPane.showInputDialog(
								"Matricula: "+pm.matricula[alunoencontrado]+"\n"+
								"Aluno: "+pm.nomealuno[alunoencontrado]+"\n\n"+
								"Matéria: "+pm.materia[j]+"\n\n"+
								"Nota["+(k+1)+"]: "));
						acmnotas = acmnotas + pm.mat_nota[alunoencontrado][j][k];
					}
					
				pm.mediaMat[j] = acmnotas/4;
				acmmedmat = acmmedmat + pm.mediaMat[j];
				acmnotas = 0;
				
				JOptionPane.showMessageDialog(null,
						"Matricula: "+pm.matricula[alunoencontrado]+"\n"+
						"Aluno: "+pm.nomealuno[alunoencontrado]+"\n\n"+
						"Matéria: "+pm.materia[j]+"\n"+
						"Média da Matéria: "+pm.mediaMat[j]);
				
				}
				
				pm.media[alunoencontrado] = acmmedmat / pm.nm;
				acmmedmat = 0;
			}
			
			
			do {
				OutraBusca = JOptionPane.showInputDialog("Deseja outra Busca: (S)im - (N)ão:");
				OutraBusca = OutraBusca.toUpperCase();
			}while((!OutraBusca.equals("S")) && (!OutraBusca.equals("N")));
			
		
		}//while(OutraBusca.equals("S")) 
		
	} //public void notasdealunospormateria() 
	
	
	
	
	/////////////////////////////////////////////////////////////////////////////////	
	// C A D A S T R O S
	/////////////////////////////////////////////////////////////////////////////////
	public void Cadastros() {
		int opcCad = 0;
		do {
			opcCad = Integer.parseInt(JOptionPane.
					showInputDialog("▓░▓░▓░▓░▓░▓░▓░▓░▓░▓\n"+
									"    C A D A S T R O S \n"+
									"▓░▓░▓░▓░▓░▓░▓░▓░▓░▓"+"\n\n"+
									"1. A l u n o s"+"\n"+
									"2. M a t é r i a s"+"\n"+
									"3. V o l t a r  ao  M e n u  P r i n c i p  a l"));
			switch(opcCad) {
				case 1 : {
					cadAlunos();
					break;
				}
				case 2 : {
					cadMaterias();
					break;
				}
				case 3 :{
					menu();
					break;
				}
				default :{
					JOptionPane.showMessageDialog(null,"Escolha Inválida!!!");
				}			
			}//switch(opcCad)
		}while((opcCad<= 0) || (opcCad>4));
			
	}
	
	public void cadAlunos() {
		//JOptionPane.showMessageDialog(null,"Em fase de Construção... Aguarde!");
		String Sair = "N";
		//x = 3;
		//ultimamatricula= 0;
		
		for (i = pm.ultimamatricula; i < pm.x ; i++ ) {
			pm.matricula[i] = JOptionPane.showInputDialog("Número da Matricula ["+(i+1)+"]:");
			pm.nomealuno[i] = JOptionPane.showInputDialog("Nome do Aluno ["+(i+1)+"]:");
			
			pm.ultimamatricula = i+1;
			
			do {
				Sair = JOptionPane.
				showInputDialog("Deseja Sair do Cadastro (S)im - (N)ão: ");
				Sair = Sair.toUpperCase();
			}while((!Sair.equals("S")) && (!Sair.equals("N")));
			
			if (Sair.equals("S")) {
				i = pm.x;
			}
		}
		
		if (pm.ultimamatricula == pm.x) {
			JOptionPane.
			showMessageDialog(null,"Número de Mátriculas Já excedeu o limite de: "+pm.x);			
		}
		Cadastros();
		
	}
	
	public void cadMaterias() {
		
		String Sair = "N";
			
		for (k = pm.ultimamateria; k < pm.nm; k++) {
			pm.materia[k] = JOptionPane.showInputDialog("Matéria:["+(k+1)+"]");			
			
			pm.ultimamateria = k+1;
			
			do {
				Sair = JOptionPane.
				showInputDialog("Deseja Sair do Cadastro (S)im - (N)ão: ");
				Sair = Sair.toUpperCase();
			}while((!Sair.equals("S")) && (!Sair.equals("N")));
			
			
			if (Sair.equals("S")) {
				i = pm.nm;
			}
		}
			
		if (pm.ultimamateria == pm.nm) {
			JOptionPane.
			showMessageDialog(null,"Número de Matérias Já excedeu o limite de: "+pm.nm);			
		}
		
		Cadastros();
	}
	
	/////////////////////////////////////////////////////////////////////////////////	
	//C O N S U L T A S
	/////////////////////////////////////////////////////////////////////////////////
	public void Consultas() {
		int opcCad = 0;
		do {
			opcCad = Integer.parseInt(JOptionPane.
					showInputDialog("▓░▓░▓░▓░▓░▓░▓░▓░▓░▓\n"+
									"     C O N S U L T A S \n"+
									"▓░▓░▓░▓░▓░▓░▓░▓░▓░▓"+"\n\n"+
									"1. A l u n o s"+"\n"+
									"2. M a t é r i a s"+"\n"+
									"3. V o l t a r  ao  M e n u   P r i n c i p a l"));
			switch(opcCad) {
				case 1 : {
					ConsAlunos();
					break;
				}
				case 2 : {
					ConsMaterias();
					break;
				}
				case 3 :{
					menu();
					break;
				}
				default :{
					JOptionPane.showMessageDialog(null,"Escolha Inválida!!!");
				}			
			}//switch(opcCad)
		}while((opcCad<= 0) || (opcCad>4));
	}
	
		
	
	public void ConsAlunos() {
		String OutraBusca = "S";
		String NomeBusca ="", detalhe;	
		
		
		while(OutraBusca.equals("S")) {
			detalhe = ""; 
			int alunoencontrado = -1;
			int encontrou = 0; //  0 = não ; 1 = sim ;
			NomeBusca = JOptionPane.showInputDialog("Digite o Nome do Aluno:");
			
			for (i = 0; i < pm.x; i++) {
				if (NomeBusca.equals(pm.nomealuno[i])) {
					alunoencontrado = i;					
					encontrou = 1;
					i = pm.x;
				}else {
					encontrou = 0;
				}		
				
			} //for (i = 0; i < pm.x; i ++) {
			
			if (encontrou == 0) {
				JOptionPane.showMessageDialog(null, "Dados Referidos Não Encontrados!!!");
			}
			
			if (encontrou == 1) {
				detalhe = "Matrícula: "+pm.matricula[alunoencontrado]+"\n"+
			              "Aluno....: "+pm.nomealuno[alunoencontrado]+"\n";
				
				
				for (j = 0; j < pm.nm; j++ ) {					
				    
					detalhe = detalhe +"Matéria["+(j+1)+"]: "+pm.materia[j]+"\n";					
					for (k = 0 ; k < 4; k++){						
						detalhe = detalhe +	"  Nota["+(k+1)+"]: "+ pm.mat_nota[alunoencontrado][j][k]+"\n";
					}
					
					detalhe = detalhe +	"Média da Matéria: "+pm.mediaMat[j]+"\n\n";
				
				}
				
				detalhe = detalhe +	"Média Geral do Aluno:  "+pm.media[alunoencontrado]; 
				
				
				
			    JOptionPane.showMessageDialog(null, detalhe);
			}
			
			do {
				OutraBusca = JOptionPane.showInputDialog("Deseja outra Busca: (S)im - (N)ão:");
				OutraBusca = OutraBusca.toUpperCase();
			}while((!OutraBusca.equals("S")) && (!OutraBusca.equals("N")));
			
			
		} //while(OutraBusca.equals("S")) 
		
		
		Consultas();
	}
	
	public void ConsMaterias() {
		String OutraBusca = "S";
		String NomeBusca ="", detalhe;	
		
		
		while(OutraBusca.equals("S")) {
			detalhe = ""; 
			int alunoencontrado = -1;
			int encontrou = 0; //  0 = não ; 1 = sim ;
			NomeBusca = JOptionPane.showInputDialog("Digite o Nome da Materia:");
			
			for (i = 0; i < pm.nm; i++) {
				if (NomeBusca.equals(pm.materia[i])) {
					alunoencontrado = i;					
					encontrou = 1;
					i = pm.nm;
				}else {
					encontrou = 0;
				}		
				
			} //for (i = 0; i < pm.x; i ++) {
			
			if (encontrou == 0) {
				JOptionPane.showMessageDialog(null, "Dados Referidos Não Encontrados!!!");
			}
			
			if (encontrou == 1) {
				detalhe = "Matéria :"+pm.materia[alunoencontrado]+"\n"+
						  "---------------------------\n";
						  
				
				for (j = 0; j < pm.x; j++) {
					
					detalhe = detalhe +"Matrícula: "+pm.matricula[j]+"\n"+
									   "Aluno: "+pm.nomealuno[j]+"\n";
					for (k = 0; k < 4; k++) {
						detalhe = detalhe + " Nota["+(k+1)+"]: "+pm.mat_nota[alunoencontrado][j][k]+"\n";
					}
					
					detalhe = detalhe + "Média: "+pm.mediaMat[j]+"\n\n";
				}
				
				JOptionPane.showMessageDialog(null, detalhe);
			} 
			
			
			do {
				OutraBusca = JOptionPane.showInputDialog("Deseja outra Busca: (S)im - (N)ão:");
				OutraBusca = OutraBusca.toUpperCase();
			}while((!OutraBusca.equals("S")) && (!OutraBusca.equals("N")));
			
			
		} //while(OutraBusca.equals("S")) 
		Consultas();
	}

	//////////////////////////////////////////////////////////////////////////////		
	// L I S T A   D E   M A T É R I A  S
	//////////////////////////////////////////////////////////////////////////////
	public void listadematerias() {
		//JOptionPane.showMessageDialog(null,"Em fase de Construção... Aguarde!");
		String detalhe = "";
		for(i = 0; i < pm.nm; i++) {
			detalhe = detalhe +  "Matéria["+(i+1)+"]: "+pm.materia[i]+"\n";
		}
		JOptionPane.showMessageDialog(null, detalhe);
		
		menu();
	}
	
	//////////////////////////////////////////////////////////////////////////////			
	// L I S T A   D E   A L U N O S
	//////////////////////////////////////////////////////////////////////////////
	public void listadealunos() {
		String detalhe = "";
		for(i = 0; i < pm.x; i++) {
			detalhe = detalhe +  "Matrícula["+(i+1)+"]: "+pm.matricula[i]+"     "+ 
		                         "Nome Aluno["+(i+1)+"]: "+pm.nomealuno[i]+"\n";
		}
		JOptionPane.showMessageDialog(null, detalhe);
		menu();
	}
	
	
} //fim do procedimento

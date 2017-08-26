package reveilleMatin;

public class User implements Runnable {
	private ReveilMatin myRM;
	public User(ReveilMatin m){
		myRM = m;
	}
	public void run(){
		System.out.println("Cas de test 1: Changement du temps courant");
		myRM.bouton("temps");
		myRM.bouton("10 minutes");
		myRM.bouton("heure");
		myRM.bouton("heure");
		for(int i=0;i<5;i++){
			myRM.bouton("minute");
		}
		myRM.bouton("temps");
		
		System.out.println("Cas de test 2: Changement du temps de l'alarme");
		myRM.bouton("alarme");
		myRM.bouton("10 minutes");
		myRM.bouton("heure");
		myRM.bouton("heure");
		for(int i=0;i<8;i++){
			myRM.bouton("minute");
		}
		myRM.bouton("alarme");
		
		System.out.println("Cas de test 3: L'alarme sonne et l'usager ne l'éteint pas");
		Main.minuteur(3, myRM);
		Main.minuteur(2, myRM);
		
		System.out.println("\nL'usager change encore le temps de l'alarme");
		myRM.bouton("alarme");
		for(int i=0;i<5;i++){
			myRM.bouton("minute");
		}
		myRM.bouton("alarme");
		System.out.println("Cas de test 4:L'alarme sonne et l'usager l'éteint");
		
		Main.minuteur(3, myRM);
		myRM.bouton("alarme");
		
		System.out.println("\nL'usager change encore le temps de l'alarme");
		myRM.bouton("alarme");
		myRM.bouton("10 minutes");
		myRM.bouton("10 minutes");
		myRM.bouton("heure");
		myRM.bouton("heure");
		for(int i=0;i<5;i++){
			myRM.bouton("minute");
		}
		myRM.bouton("alarme");
		
		System.out.println("Cas de test 5: L'alarme sonne et l'usager appui sur snooze");
		Main.minuteur(2, myRM);
		myRM.bouton("snooze");
		Main.minuteur(5, myRM);
		myRM.bouton("alarme");
		
		System.out.println("Cas de test 6: L'usager change l'intensite de l'alarme");
		myRM.bouton("volume");
		
		System.out.println("Cas de test 7:L'usager change le son de l'alarme");
		myRM.bouton("son");
	}
}
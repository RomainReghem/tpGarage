package garages;

import java.io.PrintStream;
import java.util.*;

public class Voiture {

	private final String immatriculation;
	private final List<Stationnement> myStationnements = new LinkedList<>();
        private final Set<Garage> myGarages = new LinkedHashSet<>();

	public Voiture(String i) {
		if (null == i) {
			throw new IllegalArgumentException("Une voiture doit avoir une immatriculation");
		}

		immatriculation = i;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	/**
	 * Fait rentrer la voiture au garage 
         * Précondition : la voiture ne doit pas être déjà dans un garage
	 *
	 * @param g le garage où la voiture va stationner
	 * @throws java.lang.Exception Si déjà dans un garage
	 */
	public void entreAuGarage(Garage g) throws Exception {
		if(!estDansUnGarage()){
                    Stationnement s = new Stationnement(this, g);
                    myStationnements.add(s);
                    garagesVisites();
                }
                else{
                    throw new java.lang.Exception("Déjà dans un garage");
                }
	}

	/**
	 * Fait sortir la voiture du garage 
         * Précondition : la voiture doit être dans un garage
	 *
	 * @throws java.lang.Exception si la voiture n'est pas dans un garage
	 */
	public void sortDuGarage() throws Exception {
            int t = myStationnements.size();
            if (myStationnements.get(t-1).estEnCours()){
                myStationnements.get(t-1).terminer();      
            }
            else {
                throw new java.lang.Exception("La voiture n'est pas au dans un garage");
            }
		
		// TODO: Implémenter cette méthode
		// Trouver le dernier stationnement de la voiture
		// Terminer ce stationnement
	}

	/**
	 * @return l'ensemble des garages visités par cette voiture
	 */
	public Set<Garage> garagesVisites() {
		// TODO: Implémenter cette méthode
                int t = myStationnements.size();
                if(t>0){
                    myGarages.add(myStationnements.get(t-1).getGarage());
                }
                return myGarages;
		
	}

	/**
	 * @return vrai si la voiture est dans un garage, faux sinon
	 */
	public boolean estDansUnGarage() {
		// TODO: Implémenter cette méthode
		int t = myStationnements.size();
                if(t>0 && myStationnements.get(t-1).estEnCours()){
                    return true;
                }
                return false;
		// Vrai si le dernier stationnement est en cours
	}

	/**
	 * Pour chaque garage visité, imprime le nom de ce garage suivi de la liste des dates d'entrée / sortie dans ce
	 * garage
	 * <br>Exemple :
	 * <pre>
	 * Garage Castres:
	 *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
	 *		Stationnement{ entree=28/01/2019, en cours }
	 *  Garage Albi:
	 *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
	 * </pre>
	 *
	 * @param out l'endroit où imprimer (ex: System.out)
	 */
	public void imprimeStationnements(PrintStream out) {
		// TODO: Implémenter cette méthode
		for (int i=0; i<myStationnements.size();i++){                    
                    out.println(myStationnements.get(i).getGarage());
                    out.println(myStationnements.get(i).getEntree() +","+ myStationnements.get(i).getEntree());
                }
              
               
	}

}

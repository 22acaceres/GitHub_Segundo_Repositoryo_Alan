public class EstrategiaFactory {
    public static ActualitzadorEstrategia obtenirEstrategia(String nom) {
        switch (nom) {
            case "Formatge Gidurat":
                return new EstrategiaFormatge();
            case "Entrades per al Concert del Trobador":
                return new EstrategiaEntrades();
            case "Martell de Thor (Llegendari)":
                return new EstrategiaLlegendari();
            default:
                return new EstrategiaNormal();
        }
    }
}
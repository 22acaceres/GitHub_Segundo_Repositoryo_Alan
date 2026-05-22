// 1. Añadimos 'public' para que la clase se pueda usar desde tus archivos de Test sin errores
public class Article {

    // Dejamos los atributos públicos tal como los tenías para que tus tests actuales no rompan
    public String nom;
    public int diesPerVendre;
    public int qualitat;

    // El constructor original (está perfecto)
    public Article(String nom, int diesPerVendre, int qualitat) {
        this.nom = nom;
        this.diesPerVendre = diesPerVendre;
        this.qualitat = qualitat;
    }

    // 2. AÑADIDO EXTRA: Método toString para que cuando un test falle, 
    // IntelliJ te diga exactamente qué valores tenía el artículo (ej: "Poma, dies: 9, qualitat: 19")
    @Override
    public String toString() {
        return this.nom + ", " + this.diesPerVendre + ", " + this.qualitat;
    }
}
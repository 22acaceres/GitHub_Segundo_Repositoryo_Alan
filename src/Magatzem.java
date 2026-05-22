public class Magatzem {
    public Article[] articles;

    public Magatzem(Article[] articles) {
        this.articles = articles;
    }

    public void actualitzarEstat() {
        for (Article article : articles) {
            // La factoría nos da la estrategia correcta y esta actualiza el artículo
            ActualitzadorEstrategia estrategia = EstrategiaFactory.obtenirEstrategia(article.nom);
            estrategia.actualitzar(article);
        }
    }
}
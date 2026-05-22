public class EstrategiaEntrades implements ActualitzadorEstrategia {
    @Override
    public void actualitzar(Article article) {
        if (article.qualitat < 50) {
            article.qualitat++;
            if (article.diesPerVendre < 11 && article.qualitat < 50) {
                article.qualitat++;
            }
            if (article.diesPerVendre < 6 && article.qualitat < 50) {
                article.qualitat++;
            }
        }
        article.diesPerVendre--;
        if (article.diesPerVendre < 0) {
            article.qualitat = 0; // Caducadas no valen nada
        }
    }
}
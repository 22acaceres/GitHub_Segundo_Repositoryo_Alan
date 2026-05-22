public class EstrategiaFormatge implements ActualitzadorEstrategia {
    @Override
    public void actualitzar(Article article) {
        if (article.qualitat < 50) {
            article.qualitat++;
        }
        article.diesPerVendre--;
        if (article.diesPerVendre < 0 && article.qualitat < 50) {
            article.qualitat++;
        }
    }
}
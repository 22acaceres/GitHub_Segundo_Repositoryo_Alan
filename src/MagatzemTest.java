import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class MagatzemTest {

    @Test
    void testDegradacioNormal() {
        Article[] art = { new Article("Poma", 10, 20) };
        new Magatzem(art).actualitzarEstat();
        assertEquals(9, art[0].diesPerVendre, "Els dies haurien de baixar en 1");
        assertEquals(19, art[0].qualitat, "La qualitat hauria de baixar en 1");
    }

    @Test
    void testFormatgeMilloraAmbElTemps() {
        Article[] art = { new Article("Formatge Gidurat", 10, 20) };
        new Magatzem(art).actualitzarEstat();
        assertTrue(art[0].qualitat > 20, "El formatge hauria de millorar la seva qualitat");
    }

    @Test
    void testMartellDeThorNoEsDegrada() {
        // Los objetos legendarios suelen tener calidad 80 y no varían
        Article[] art = { new Article("Martell de Thor (Llegendari)", 0, 80) };
        new Magatzem(art).actualitzarEstat();
        assertEquals(80, art[0].qualitat, "La qualitat del Martell de Thor ha de seguir sent 80");
        assertEquals(0, art[0].diesPerVendre, "Els dies per vendre del Martell de Thor no han de canviar");
    }

    @Test
    void testEntradesConcertMesDe10Dies() {
        Article[] art = { new Article("Entrades per al Concert del Trobador", 15, 20) };
        new Magatzem(art).actualitzarEstat();
        assertEquals(21, art[0].qualitat, "Amb més de 10 dies, la qualitat puja de 1 en 1");
    }

    @Test
    void testEntradesConcertMenysDe10Dies() {
        Article[] art = { new Article("Entrades per al Concert del Trobador", 9, 20) };
        new Magatzem(art).actualitzarEstat();
        assertEquals(22, art[0].qualitat, "Amb 10 dies o menys, la qualitat puja de 2 en 2");
    }

    @Test
    void testEntradesConcertMenysDe5Dies() {
        Article[] art = { new Article("Entrades per al Concert del Trobador", 4, 20) };
        new Magatzem(art).actualitzarEstat();
        assertEquals(23, art[0].qualitat, "Amb 5 dies o menys, la qualitat puja de 3 en 3");
    }

    @Test
    void testEntradesConcertCaducades() {
        Article[] art = { new Article("Entrades per al Concert del Trobador", 0, 20) };
        new Magatzem(art).actualitzarEstat();
        assertEquals(0, art[0].qualitat, "Un cop passat el concert, la qualitat cau a 0");
    }
}
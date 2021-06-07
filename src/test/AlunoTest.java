package test;

import model.Aluno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AlunoTest {

    private Aluno a1;

    @BeforeEach
    private void instanciar() {
        a1 = new Aluno();
    }

    /**
     * Testar nome do aluno vazio
     */
    @Test
    public void avaliaNomeAlunoVazio() {
        assertThrows(RuntimeException.class, () -> a1.setNome(""));
    }

    /**
     * Testar nome do aluno com mais de 100 caracteres
     */
    @Test
    public void avaliaNomeAlunoMaisCemCaracteres() {
        String entrada = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has " +
                "been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of " +
                "type and scrambled it to make a type specimen book. It has survived not only five centuries, but also " +
                "the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s " +
                "with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop" +
                " publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        assertThrows(RuntimeException.class, ()-> a1.setNome(entrada));
    }

    /**
     * Testar entrada de nota menor do que 0
     */
    @Test
    public void avaliaEntradaNotaMenorZero() {
        assertThrows(RuntimeException.class, ()-> a1.entraNota(-1.0));
    }

    /**
     * Testar entrada de nota maior do que 30
     */
    @Test
    public void avaliaEntradaNotaMaiorTrinta() {
        assertThrows(RuntimeException.class, ()-> a1.entraNota(50.0));
    }

    /**
     * Testar retorno de nota iqual a 0 se o aluno não tem nota lançada
     */
    @Test
    public void avaliaAlunoSemNotaLancada() {
        assertEquals(0.0, a1.retornaNotaTotal());
    }

    /**
     * Testar entrada de nota, valor total iqual a 100
     */
    @Test
    public void avaliaEntradaNotaTotalIqualCem() {
        for (int i = 0; i < 4; i++) a1.entraNota(25.0);
        assertThrows(RuntimeException.class, ()-> a1.entraNota(10.0));
    }

    /**
     * Testar entrada de nota, valor total maior que 100
     */
    @Test
    public void avaliaEntradaNotaTotalMaiorCem() {
        for (int i = 0; i < 4; i++) a1.entraNota(20.0);
        assertThrows(RuntimeException.class, ()-> a1.entraNota(25.0));
    }
}

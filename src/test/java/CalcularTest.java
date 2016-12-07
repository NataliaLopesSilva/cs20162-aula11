
import com.github.natalialopessilva.calcular.Calcular;
import static com.github.natalialopessilva.calcular.Calcular.exprPara;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class CalcularTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void entradaInvalida() throws Exception {
        exit.expectSystemExitWithStatus(1);
        Calcular.main(new String[]{});
    }

    @Test
    public void entradaInvalida2() throws Exception {
        exit.expectSystemExitWithStatus(1);
        Calcular.main(new String[]{"+"});
    }

    @Test
    public void entradaValida() throws Exception {
        exit.expectSystemExitWithStatus(0);
        Calcular.main(new String[]{"2+1"});
    }

    @Test
    public void comparaResultadoParser() throws Exception {
        Assert.assertEquals(2.0f, exprPara("1+1").valor(), 0.001f);

    }
}

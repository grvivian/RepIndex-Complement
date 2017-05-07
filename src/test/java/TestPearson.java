
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author glaucio
 */
public class TestPearson {

  double[] xb = {20, 23, 8, 29, 14, 11, 11, 20, 17, 17};
  double[] yb = {30, 35, 21, 33, 33, 26, 22, 31, 33, 36};

  double[] x = {20, 23, 8, 29, 14, 11, 11, 20, 17, 17};
  double[] y = {30, 35, 21, 33, 33, 26, 22, 31, 33, 36};

  double[] xd = {20, 23, 8, 29, 14, 11, 11, 20, 17, 17};
  double[] yd = {30, 35, 21, 33, 33, 26, 22, 31, 33, 36};

  @Test
  public void testar() throws Exception {
    PearsonsCorrelation p = new PearsonsCorrelation();
    double r = p.correlation(x, y); //0.71
    assertTrue(r == 0.71);

    r = p.correlation(xd, yd); //0.71
    assertTrue(r == 0.71);

    r = p.correlation(xb, yb); //0.71
    assertTrue(r == 0.71);

    r = p.correlation(xd, yd);
    assertTrue(r == 0.71);
  }

}

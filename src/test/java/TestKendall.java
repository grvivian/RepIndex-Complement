
import org.apache.commons.math3.stat.correlation.KendallsCorrelation;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author glaucio
 */
public class TestKendall {

  double[] xb = {4, 10, 3, 1, 9, 2, 6, 7, 8, 5};
  double[] yb = {5, 8, 6, 2, 10, 3, 9, 4, 7, 1};

  double[] x = {4, 10, 3, 1, 9, 2, 6, 7, 8, 5};
  double[] y = {5, 8, 6, 2, 10, 3, 9, 4, 7, 1};

  double[] xD = {4, 10, 3, 1, 9, 2, 6, 7, 8, 5};
  double[] yD = {5, 8, 6, 2, 10, 3, 9, 4, 7, 1};

  @Test
  public void testar() throws Exception {
    KendallsCorrelation k = new KendallsCorrelation();
    double r = k.correlation(x, y);
    assertTrue(r == 0.5111111111111111);

    r = k.correlation(xD, yD); //0.51111111
    assertTrue(r == 0.5111111111111111);

    r = k.correlation(xb, yb); //0.51111111
    assertTrue(r == 0.5111111111111111);
  }

}

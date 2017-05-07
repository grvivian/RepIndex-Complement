
import org.apache.commons.math3.stat.correlation.SpearmansCorrelation;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author glaucio
 */
public class TestSperman {

  @BeforeClass
  public static void setUpClass() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  @Test
  public void testar() throws Exception {
    SpearmansCorrelation s = new SpearmansCorrelation();

    double[] xb = {2, 9, 1, 3, 10, 4, 6, 8, 5, 7};
    double[] yb = {6, 9, 2, 1, 8, 4, 3, 10, 7, 5};

    double[] x = {2, 9, 1, 3, 10, 4, 6, 8, 5, 7};
    double[] y = {6, 9, 2, 1, 8, 4, 3, 10, 7, 5};

    double[] xd = {2, 9, 1, 3, 10, 4, 6, 8, 5, 7};
    double[] yd = {6, 9, 2, 1, 8, 4, 3, 10, 7, 5};

    double r = s.correlation(x, y);//0.721
    assertTrue(r == 0.7212121212121212);

    r = s.correlation(xd, yd);//0.721
    assertTrue(r == 0.7212121212121212);

    r = s.correlation(xb, yb);//0.721
    assertTrue(r == 0.7212121212121212);

    double[] p = {1, 2, 2, 5, 4, 6, 7, 8};
    double[] q = {1, 3, 4, 2, 5, 6, 6, 6};
    r = s.correlation(p, q);
    assertTrue(r == 0.8222251619036417);
  }

}

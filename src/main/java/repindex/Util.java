package repindex;

/**
 *
 * @author glaucio
 */
public class Util {

  public static byte repIndexInt5(double repIndex) {
    if ((repIndex >= 0) && (repIndex < 20)) {
      return 1;
    } else if ((repIndex >= 20) && (repIndex < 40)) {
      return 2;
    } else if ((repIndex >= 40) && (repIndex < 60)) {
      return 3;
    } else if ((repIndex >= 60) && (repIndex < 80)) {
      return 4;
    } else if ((repIndex >= 80) && (repIndex < 100)) {
      return 5;
    }

    return 0;
  }

  public static byte converCnpqToInt5(String v) {
    if (v.equals("1A")) {
      return 5;
    } else if (v.equals("1B")) {
      return 4;
    } else if (v.equals("1C")) {
      return 3;
    } else if (v.equals("1D")) {
      return 2;
    } else if (v.equals("2")) {
      return 1;
    }

    return 0;
  }

  public static double converCnpqToNominalWeka(String v) {
    if (v.equals("2")) {
      return 0D;
    } else if (v.equals("1D")) {
      return 1D;
    } else if (v.equals("1C")) {
      return 2D;
    } else if (v.equals("1B")) {
      return 3D;
    } else if (v.equals("1A")) {
      return 4D;
    } else if (v.equals("SR")) {
      return 5D;
    }

    return -1D;
  }

}

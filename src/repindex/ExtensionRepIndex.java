package repindex;

import java.util.List;
import model.Research;
import repindex.enums.TypeAttributeSelection;
import weka.attributeSelection.AttributeSelection;
import weka.attributeSelection.ChiSquaredAttributeEval;
import weka.attributeSelection.GainRatioAttributeEval;
import weka.attributeSelection.InfoGainAttributeEval;
import weka.attributeSelection.Ranker;
import weka.attributeSelection.ReliefFAttributeEval;
import weka.attributeSelection.SymmetricalUncertAttributeEval;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;

/**
 *
 * @author glaucio
 */
public class ExtensionRepIndex {

  private final static AttributeSelection AS = new AttributeSelection();
  private final static GainRatioAttributeEval GAIN_RATIO = new GainRatioAttributeEval();
  private final static ReliefFAttributeEval RELIEF_F = new ReliefFAttributeEval();
  private final static ChiSquaredAttributeEval CHI_SQUARED = new ChiSquaredAttributeEval();
  private final static InfoGainAttributeEval INFO_GAIN = new InfoGainAttributeEval();
  private final static SymmetricalUncertAttributeEval SYMMETRICAL_UNCERT = new SymmetricalUncertAttributeEval();

  static {
    RELIEF_F.setNumNeighbours(28);
  }

  public static final Weigths REP_INDEX_WEIGTHS = new Weigths("Rep-Index Original", 0, 15, 5, 8, 4, 3, 6, 7, 5, 6, 5, 8, 4, 2, 1, 3, 2, 1, 15);

  private static Weigths setWeigth(String nome, double value, double score, Weigths w) {
    switch (nome) {
      case "ASJ":
        w.setASJ(value);
        w.setScoreASJ(score);
        break;
      case "PTA":
        w.setPTA(value);
        w.setScorePTA(score);
        break;
      case "CWCP":
        w.setCWCP(value);
        w.setScoreCWCP(score);
        break;
      case "MDA":
        w.setMDA(value);
        w.setScoreMDA(score);
        break;
      case "NC":
        w.setNC(value);
        w.setScoreNC(score);
        break;
      case "PEBPT":
        w.setPEBPT(value);
        w.setScorePEBPT(score);
        break;
      case "HI":
        w.setHI(value);
        w.setScoreHI(score);
        break;
      case "EBM":
        w.setEBM(value);
        w.setScoreEBM(score);
        break;
      case "PA":
        w.setPA(value);
        w.setScorePA(score);
        break;
      case "BC":
        w.setBC(value);
        w.setScoreBC(score);
        break;
      case "BK":
        w.setBK(value);
        w.setScoreBK(score);
        break;
      case "PEBMD":
        w.setPEBMD(value);
        w.setScorePEBMD(score);
        break;
      case "SOFT":
        w.setSOFT(value);
        w.setScoreSOFT(score);
        break;
      case "TPCCC":
        w.setTPCCC(value);
        w.setScoreTPCCC(score);
        break;
      case "RJP":
        w.setRJP(value);
        w.setScoreRJP(score);
        break;
      case "RP":
        w.setRP(value);
        w.setScoreRP(score);
        break;
      case "TPCCM":
        w.setTPCCM(value);
        w.setScoreTPCCM(score);
        break;
      case "ED":
        w.setED(value);
        w.setScoreED(score);
        break;
      default:
        break;
    }

    return w;
  }

  /*
  * Convert a Research list to Weka Instances
   */
  public static Instances pesquisadorToInstances(List<Research> pesq) {
    FastVector niveis = new FastVector();
    niveis.addElement("2");
    niveis.addElement("1D");
    niveis.addElement("1C");
    niveis.addElement("1B");
    niveis.addElement("1A");
    niveis.addElement("SR");

    FastVector fastVector = new FastVector(19);
    fastVector.addElement(new Attribute("Nível", niveis));
    fastVector.addElement(new Attribute("ED"));
    fastVector.addElement(new Attribute("MDA"));
    fastVector.addElement(new Attribute("PTA"));
    fastVector.addElement(new Attribute("PA"));
    fastVector.addElement(new Attribute("PEBMD"));
    fastVector.addElement(new Attribute("PEBPT"));
    fastVector.addElement(new Attribute("TPCCC"));
    fastVector.addElement(new Attribute("TPCCM"));
    fastVector.addElement(new Attribute("EBM"));
    fastVector.addElement(new Attribute("RJP"));
    fastVector.addElement(new Attribute("ASJ"));
    fastVector.addElement(new Attribute("BK"));
    fastVector.addElement(new Attribute("BC"));
    fastVector.addElement(new Attribute("CWCP"));
    fastVector.addElement(new Attribute("HI"));
    fastVector.addElement(new Attribute("NC"));
    fastVector.addElement(new Attribute("RP"));
    fastVector.addElement(new Attribute("SOFT"));

    Instances data = new Instances("Data", fastVector, pesq.size());

    for (Research p : pesq) {
      Instance in = new Instance(19);

      in.setValue(0, Util.converCnpqToNominalWeka(p.getCnpq()));
      in.setValue(1, p.getED());
      in.setValue(2, p.getMDA());
      in.setValue(3, p.getPTA());
      in.setValue(4, p.getPA());
      in.setValue(5, p.getPEBMD());
      in.setValue(6, p.getPEBPT());
      in.setValue(7, p.getTPCCC());
      in.setValue(8, p.getTPCCM());
      in.setValue(9, p.getEBM());
      in.setValue(10, p.getRJP());
      in.setValue(11, p.getASJ());
      in.setValue(12, p.getBK());
      in.setValue(13, p.getBC());
      in.setValue(14, p.getCWCP());
      in.setValue(15, p.getHI());
      in.setValue(16, p.getNC());
      in.setValue(17, p.getRP());
      in.setValue(18, p.getSOFT());

      data.add(in);
    }

    // setting class attribute
    if (data.classIndex() == -1) {
      data.setClassIndex(0);//Level
    }

    return data;
  }

  /*
  * Calcule the weights from Weka score
   */
  public static Weigths computeWeights(Instances data, TypeAttributeSelection type) throws Exception {
    Weigths ret = new Weigths();

    Ranker r = new Ranker();
    r.setNumToSelect(-1);
    r.setGenerateRanking(true);
    r.setThreshold(-1.7976931348623157E308);
    AS.setSearch(r);

    switch (type) {
      case GAIN_RATIO:
        AS.setEvaluator(GAIN_RATIO);
        break;
      case INFO_GAIN:
        AS.setEvaluator(INFO_GAIN);
        break;
      case CHI_SQUARED:
        AS.setEvaluator(CHI_SQUARED);
        break;
      case RELIEF_F:
        AS.setEvaluator(RELIEF_F);
        break;
      case SYMMETRICAL_UNCERT:
        AS.setEvaluator(SYMMETRICAL_UNCERT);
        break;
      default:
        break;
    }

    AS.setRanking(true);
    AS.SelectAttributes(data);

    double[][] scores = AS.rankedAttributes();
    //scores summary
    double sum = 0;
    for (double[] score : scores) {
      sum += (score[1]);
    }

    //compute the weigths peso to Rep-Index
    for (double[] score : scores) {
      double pond = score[1] * 100 / sum;

      int pos = (int) score[0];
      String nome = data.attribute(pos).name();
      ret = setWeigth(nome, pond, score[1], ret);
      ///System.out.println(nome + " -> " + score[1] + " (" + pond + "%)");
    }

    return ret;
  }

}

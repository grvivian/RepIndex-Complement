package view;

import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapArrayDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import repindex.Weigths;

/**
 *
 * @author glaucio
 */
public class Print {

  private static HashMap dataFromAproach(Weigths w, String name) {
    HashMap data = new HashMap();
    data.put("Aproach", name);
    data.put("ED", w.getED());
    data.put("sED", w.getScoreED());
    data.put("PA", w.getPA());
    data.put("sPA", w.getScorePA());
    data.put("PTA", w.getPTA());
    data.put("sPTA", w.getScorePTA());
    data.put("MDA", w.getMDA());
    data.put("sMDA", w.getScoreMDA());
    data.put("PEBPT", w.getPEBPT());
    data.put("sPEBPT", w.getScorePEBPT());
    data.put("PEBMD", w.getPEBMD());
    data.put("sPEBMD", w.getScorePEBMD());
    data.put("EBM", w.getEBM());
    data.put("sEBM", w.getScoreEBM());
    data.put("RJP", w.getRJP());
    data.put("sRJP", w.getScoreRJP());
    data.put("TPCCC", w.getTPCCC());
    data.put("sTPCCC", w.getScoreTPCCC());
    data.put("TPCCM", w.getTPCCM());
    data.put("sTPCCM", w.getScoreTPCCM());
    data.put("ASJ", w.getASJ());
    data.put("sASJ", w.getScoreASJ());
    data.put("BK", w.getBK());
    data.put("sBK", w.getScoreBK());
    data.put("BC", w.getBC());
    data.put("sBC", w.getScoreBC());
    data.put("CWCP", w.getCWCP());
    data.put("sCWCP", w.getScoreCWCP());
    data.put("HI", w.getHI());
    data.put("sHI", w.getScoreHI());
    data.put("NC", w.getNC());
    data.put("sNC", w.getScoreNC());
    data.put("RP", w.getRP());
    data.put("sRP", w.getScoreRP());
    data.put("SOFT", w.getSOFT());
    data.put("sSOFT", w.getScoreSOFT());

    System.out.println(name
            + "|" + w.getScoreED()
            + "|" + w.getScorePA()
            + "|" + w.getScorePTA()
            + "|" + w.getScoreMDA()
            + "|" + w.getScorePEBPT()
            + "|" + w.getScorePEBMD()
            + "|" + w.getScoreEBM()
            + "|" + w.getScoreRJP()
            + "|" + w.getScoreTPCCC()
            + "|" + w.getScoreTPCCM()
            + "|" + w.getScoreASJ()
            + "|" + w.getScoreBK()
            + "|" + w.getScoreBC()
            + "|" + w.getScoreCWCP()
            + "|" + w.getScoreHI()
            + "|" + w.getScoreNC()
            + "|" + w.getScoreRP()
            + "|" + w.getScoreSOFT());

    System.out.println(name
            + "|" + w.getED() / 100
            + "|" + w.getPA() / 100
            + "|" + w.getPTA() / 100
            + "|" + w.getMDA() / 100
            + "|" + w.getPEBPT() / 100
            + "|" + w.getPEBMD() / 100
            + "|" + w.getEBM() / 100
            + "|" + w.getRJP() / 100
            + "|" + w.getTPCCC() / 100
            + "|" + w.getTPCCM() / 100
            + "|" + w.getASJ() / 100
            + "|" + w.getBK() / 100
            + "|" + w.getBC() / 100
            + "|" + w.getCWCP() / 100
            + "|" + w.getHI() / 100
            + "|" + w.getNC() / 100
            + "|" + w.getRP() / 100
            + "|" + w.getSOFT() / 100);

    return data;
  }

  public static void repIndexWeigths(Weigths wChiSquared, Weigths wGainRatio, Weigths wInfoGain, Weigths wReliefF, Weigths wSymmetricalUncert) throws Exception {
    URL arquivo = FrmMain.class.getResource("repIndex.jasper");
    if (arquivo == null) {
      throw new Exception("Fail in Find the Jasper File!");
    }

    Map<String, Object> param = new HashMap<>();
    param.put("ReportTitle", "Rep-Index");

    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(arquivo);

    LinkedList<Map> lista = new LinkedList<>();
    lista.add(dataFromAproach(wChiSquared, "ChiSquared"));
    lista.add(dataFromAproach(wGainRatio, "GainRatio"));
    lista.add(dataFromAproach(wInfoGain, "InfoGain"));
    lista.add(dataFromAproach(wReliefF, "ReliefF"));
    lista.add(dataFromAproach(wSymmetricalUncert, "SymmetricalUncert"));

    JRDataSource ds = new JRMapArrayDataSource(lista.toArray());
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, ds);
    JasperViewer jrviewer = new JasperViewer(jasperPrint, false);
    jrviewer.setVisible(true);
  }

  private static HashMap dataFromAproach(double w, String name, String element) {
    HashMap data = new HashMap();
    data.put("aproach", name);
    data.put("element", element);
    data.put("weigth", w);

    return data;
  }

  private static void dataFromAproachElement(LinkedList<Map> lista, Weigths w, String aproach) {
    lista.add(dataFromAproach(w.getED(), aproach, "ED"));
    lista.add(dataFromAproach(w.getPA(), aproach, "PA"));
    lista.add(dataFromAproach(w.getPTA(), aproach, "PTA"));
    lista.add(dataFromAproach(w.getMDA(), aproach, "MDA"));
    lista.add(dataFromAproach(w.getPEBPT(), aproach, "PEBPT"));
    lista.add(dataFromAproach(w.getPEBMD(), aproach, "PEBMD"));
    lista.add(dataFromAproach(w.getEBM(), aproach, "EBM"));
    lista.add(dataFromAproach(w.getRJP(), aproach, "RJP"));
    lista.add(dataFromAproach(w.getTPCCC(), aproach, "TPCCC"));
    lista.add(dataFromAproach(w.getTPCCM(), aproach, "TPCCM"));
    lista.add(dataFromAproach(w.getASJ(), aproach, "ASJ"));
    lista.add(dataFromAproach(w.getBK(), aproach, "BK"));
    lista.add(dataFromAproach(w.getBC(), aproach, "BC"));
    lista.add(dataFromAproach(w.getCWCP(), aproach, "CWCP"));
    lista.add(dataFromAproach(w.getHI(), aproach, "HI"));
    lista.add(dataFromAproach(w.getNC(), aproach, "NC"));
    lista.add(dataFromAproach(w.getRP(), aproach, "RP"));
    lista.add(dataFromAproach(w.getSOFT(), aproach, "SOFT"));
  }

  public static void repIndexBarChartWeigths(Weigths wChiSquared, Weigths wGainRatio, Weigths wInfoGain, Weigths wReliefF, Weigths wSymmetricalUncert) throws Exception {
    URL arquivo = FrmMain.class.getResource("repIndexBarChart.jasper");
    if (arquivo == null) {
      throw new Exception("Fail in Find Jasper File!");
    }

    Map<String, Object> param = new HashMap<>();
    param.put("ReportTitle", "Rep-Index");

    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(arquivo);

    LinkedList<Map> lista = new LinkedList<>();

    dataFromAproachElement(lista, wChiSquared, "ChiSquared");
    dataFromAproachElement(lista, wGainRatio, "GainRatio");
    dataFromAproachElement(lista, wInfoGain, "InfoGain");
    dataFromAproachElement(lista, wReliefF, "ReliefF");
    dataFromAproachElement(lista, wSymmetricalUncert, "SymmetricalUncert");
    //dataFromAproachElement(lista, wSVM, "SVM");

    JRDataSource ds = new JRMapArrayDataSource(lista.toArray());
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, ds);
    JasperViewer jrviewer = new JasperViewer(jasperPrint, false);
    jrviewer.setVisible(true);
  }

  private static HashMap dataFromCorellation(String name, String corellation, double value) {
    HashMap data = new HashMap();
    data.put("aproach", name);
    data.put("corelation", corellation);
    data.put("value", value);

    return data;
  }

  public static void corelationsBarChar(double[] s, double[] p, double[] k) throws Exception {
    URL arquivo = FrmMain.class.getResource("corellations.jasper");
    if (arquivo == null) {
      throw new Exception("Fail in Find Jasper File!");
    }

    Map<String, Object> param = new HashMap<>();
    param.put("ReportTitle", "Corellations");

    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(arquivo);

    LinkedList<Map> lista = new LinkedList<>();
    lista.add(dataFromCorellation("Rep-Index", "Sperman", s[FrmMain.REP_INDEX_ORIGINAL]));
    lista.add(dataFromCorellation("Rep-Index", "Pearson", p[FrmMain.REP_INDEX_ORIGINAL]));
    lista.add(dataFromCorellation("Rep-Index", "Kendall", k[FrmMain.REP_INDEX_ORIGINAL]));

    lista.add(dataFromCorellation("ChiSquared", "Sperman", s[FrmMain.CHI_SQUARED]));
    lista.add(dataFromCorellation("ChiSquared", "Pearson", p[FrmMain.CHI_SQUARED]));
    lista.add(dataFromCorellation("ChiSquared", "Kendall", k[FrmMain.CHI_SQUARED]));

    lista.add(dataFromCorellation("GainRatio", "Sperman", s[FrmMain.GAIN_RATIO]));
    lista.add(dataFromCorellation("GainRatio", "Pearson", p[FrmMain.GAIN_RATIO]));
    lista.add(dataFromCorellation("GainRatio", "Kendall", k[FrmMain.GAIN_RATIO]));

    lista.add(dataFromCorellation("InfoGain", "Sperman", s[FrmMain.INFO_GAIN]));
    lista.add(dataFromCorellation("InfoGain", "Pearson", p[FrmMain.INFO_GAIN]));
    lista.add(dataFromCorellation("InfoGain", "Kendall", k[FrmMain.INFO_GAIN]));

    lista.add(dataFromCorellation("ReliefF", "Sperman", s[FrmMain.RELIEF_F]));
    lista.add(dataFromCorellation("ReliefF", "Pearson", p[FrmMain.RELIEF_F]));
    lista.add(dataFromCorellation("ReliefF", "Kendall", k[FrmMain.RELIEF_F]));

    lista.add(dataFromCorellation("SymmetricalUncert", "Sperman", s[FrmMain.SYMMETRICAL_UNCERT]));
    lista.add(dataFromCorellation("SymmetricalUncert", "Pearson", p[FrmMain.SYMMETRICAL_UNCERT]));
    lista.add(dataFromCorellation("SymmetricalUncert", "Kendall", k[FrmMain.SYMMETRICAL_UNCERT]));

    JRDataSource ds = new JRMapArrayDataSource(lista.toArray());
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, ds);
    JasperViewer jrviewer = new JasperViewer(jasperPrint, false);
    jrviewer.setVisible(true);
  }

}

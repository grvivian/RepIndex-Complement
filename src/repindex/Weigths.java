package repindex;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 *
 * @author glaucio
 */
public class Weigths {

  private String name;
  private double correlation;
  private double ASJ; //Articles in Scientific Journals
  private double scoreASJ;
  private double PTA; //PhD Thesis Advisor
  private double scoreCWCP;
  private double CWCP; //Complete Work in Conference Proceedings
  private double scorePTA;
  private double MDA; //Master Dissertation Advisor
  private double scoreMDA;
  private double NC; //Network Co-authorship
  private double scoreNC;
  private double PEBPT; //Participation in Examination Boards PhD Thesis
  private double scorePEBPT;
  private double HI; //H-Index
  private double scoreHI;
  private double EBM; //Editorial Board Member
  private double scoreEBM;
  private double PA; //Postdoctoral Advisor
  private double scorePA;
  private double BC; //Book Chapter Published
  private double scoreBC;
  private double BK; //Books Published
  private double scoreBK;
  private double PEBMD; //Participation in Examination Boards Master Dissertation
  private double scorePEBMD;
  private double SOFT; //Software
  private double scoreSOFT;
  private double TPCCC; //Conference Committee Coordinator
  private double scoreTPCCC;
  private double RJP; //Reviewer of Journals
  private double scoreRJP;
  private double RP; //Research Projects
  private double scoreRP;
  private double TPCCM; //Conference Committee Member
  private double scoreTPCCM;
  private double ED; //Education Degree
  private double scoreED;

  public Weigths() {
  }

  public Weigths(String name, double correlation, double ASJ, double PTA, double CWCP, double MDA, double NC, double PEBPT, double HI, double EBM, double PA, double BC, double BK, double PEBMD, double SOFT, double TPCCC, double RJP, double RP, double TPCCM, double ED) {
    this.name = name;
    this.correlation = correlation;
    this.ASJ = ASJ;
    this.PTA = PTA;
    this.CWCP = CWCP;
    this.MDA = MDA;
    this.NC = NC;
    this.PEBPT = PEBPT;
    this.HI = HI;
    this.EBM = EBM;
    this.PA = PA;
    this.BC = BC;
    this.BK = BK;
    this.PEBMD = PEBMD;
    this.SOFT = SOFT;
    this.TPCCC = TPCCC;
    this.RJP = RJP;
    this.RP = RP;
    this.TPCCM = TPCCM;
    this.ED = ED;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getCorrelation() {
    return correlation;
  }

  public void setCorrelation(double correlation) {
    this.correlation = correlation;
  }

  public double getASJ() {
    return ASJ;
  }

  public void setASJ(double ASJ) {
    this.ASJ = ASJ;
  }

  public double getScoreASJ() {
    return scoreASJ;
  }

  public void setScoreASJ(double scoreASJ) {
    this.scoreASJ = scoreASJ;
  }

  public double getPTA() {
    return PTA;
  }

  public void setPTA(double PTA) {
    this.PTA = PTA;
  }

  public double getScoreCWCP() {
    return scoreCWCP;
  }

  public void setScoreCWCP(double scoreCWCP) {
    this.scoreCWCP = scoreCWCP;
  }

  public double getCWCP() {
    return CWCP;
  }

  public void setCWCP(double CWCP) {
    this.CWCP = CWCP;
  }

  public double getScorePTA() {
    return scorePTA;
  }

  public void setScorePTA(double scorePTA) {
    this.scorePTA = scorePTA;
  }

  public double getMDA() {
    return MDA;
  }

  public void setMDA(double MDA) {
    this.MDA = MDA;
  }

  public double getScoreMDA() {
    return scoreMDA;
  }

  public void setScoreMDA(double scoreMDA) {
    this.scoreMDA = scoreMDA;
  }

  public double getNC() {
    return NC;
  }

  public void setNC(double NC) {
    this.NC = NC;
  }

  public double getScoreNC() {
    return scoreNC;
  }

  public void setScoreNC(double scoreNC) {
    this.scoreNC = scoreNC;
  }

  public double getPEBPT() {
    return PEBPT;
  }

  public void setPEBPT(double PEBPT) {
    this.PEBPT = PEBPT;
  }

  public double getScorePEBPT() {
    return scorePEBPT;
  }

  public void setScorePEBPT(double scorePEBPT) {
    this.scorePEBPT = scorePEBPT;
  }

  public double getHI() {
    return HI;
  }

  public void setHI(double HI) {
    this.HI = HI;
  }

  public double getScoreHI() {
    return scoreHI;
  }

  public void setScoreHI(double scoreHI) {
    this.scoreHI = scoreHI;
  }

  public double getEBM() {
    return EBM;
  }

  public void setEBM(double EBM) {
    this.EBM = EBM;
  }

  public double getScoreEBM() {
    return scoreEBM;
  }

  public void setScoreEBM(double scoreEBM) {
    this.scoreEBM = scoreEBM;
  }

  public double getPA() {
    return PA;
  }

  public void setPA(double PA) {
    this.PA = PA;
  }

  public double getScorePA() {
    return scorePA;
  }

  public void setScorePA(double scorePA) {
    this.scorePA = scorePA;
  }

  public double getBC() {
    return BC;
  }

  public void setBC(double BC) {
    this.BC = BC;
  }

  public double getScoreBC() {
    return scoreBC;
  }

  public void setScoreBC(double scoreBC) {
    this.scoreBC = scoreBC;
  }

  public double getBK() {
    return BK;
  }

  public void setBK(double BK) {
    this.BK = BK;
  }

  public double getScoreBK() {
    return scoreBK;
  }

  public void setScoreBK(double scoreBK) {
    this.scoreBK = scoreBK;
  }

  public double getPEBMD() {
    return PEBMD;
  }

  public void setPEBMD(double PEBMD) {
    this.PEBMD = PEBMD;
  }

  public double getScorePEBMD() {
    return scorePEBMD;
  }

  public void setScorePEBMD(double scorePEBMD) {
    this.scorePEBMD = scorePEBMD;
  }

  public double getSOFT() {
    return SOFT;
  }

  public void setSOFT(double SOFT) {
    this.SOFT = SOFT;
  }

  public double getScoreSOFT() {
    return scoreSOFT;
  }

  public void setScoreSOFT(double scoreSOFT) {
    this.scoreSOFT = scoreSOFT;
  }

  public double getTPCCC() {
    return TPCCC;
  }

  public void setTPCCC(double TPCCC) {
    this.TPCCC = TPCCC;
  }

  public double getScoreTPCCC() {
    return scoreTPCCC;
  }

  public void setScoreTPCCC(double scoreTPCCC) {
    this.scoreTPCCC = scoreTPCCC;
  }

  public double getRJP() {
    return RJP;
  }

  public void setRJP(double RJP) {
    this.RJP = RJP;
  }

  public double getScoreRJP() {
    return scoreRJP;
  }

  public void setScoreRJP(double scoreRJP) {
    this.scoreRJP = scoreRJP;
  }

  public double getRP() {
    return RP;
  }

  public void setRP(double RP) {
    this.RP = RP;
  }

  public double getScoreRP() {
    return scoreRP;
  }

  public void setScoreRP(double scoreRP) {
    this.scoreRP = scoreRP;
  }

  public double getTPCCM() {
    return TPCCM;
  }

  public void setTPCCM(double TPCCM) {
    this.TPCCM = TPCCM;
  }

  public double getScoreTPCCM() {
    return scoreTPCCM;
  }

  public void setScoreTPCCM(double scoreTPCCM) {
    this.scoreTPCCM = scoreTPCCM;
  }

  public double getED() {
    return ED;
  }

  public void setED(double ED) {
    this.ED = ED;
  }

  public double getScoreED() {
    return scoreED;
  }

  public void setScoreED(double scoreED) {
    this.scoreED = scoreED;
  }

  @Override
  public String toString() {
    DecimalFormat df = new DecimalFormat("###.00");
    df.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.ENGLISH));

    return df.format(ASJ) + ", "
            + df.format(BC) + ", "
            + df.format(BK) + ", "
            + df.format(TPCCC) + ", "
            + df.format(TPCCM) + ", "
            + df.format(CWCP) + ", "
            + df.format(EBM) + ", "
            + df.format(ED) + ", "
            + df.format(HI) + ", "
            + df.format(MDA) + ", "
            + df.format(NC) + ", "
            + df.format(PA) + ", "
            + df.format(PEBMD) + ", "
            + df.format(PEBPT) + ", "
            + df.format(PTA) + ", "
            + df.format(RJP) + ", "
            + df.format(RP) + ", "
            + df.format(SOFT);
  }

}

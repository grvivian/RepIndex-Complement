package repindex;

/**
 *
 * @author glaucio
 */
public class Item {

  //valores
  private String nivel;
  private double ASJ; //Articles in Scientific Journals
  private double PTA; //PhD Thesis Advisor
  private double CWCP; //Complete Work in Conference Proceedings
  private double MDA; //Master Dissertation Advisor
  private double NC; //Network Co-authorship
  private double PEBPT; //Participation in Examination Boards PhD Thesis
  private double HI; //H-Index
  private double EBM; //Editorial Board Member
  private double PA; //Postdoctoral Advisor
  private double BC; //Book Chapter Published
  private double BK; //Books Published
  private double PEBMD; //Participation in Examination Boards Master Dissertation
  private double SOFT; //Software
  private double TPCCC; //Conference Committee Coordinator
  private double RJP; //Reviewer of Journals
  private double RP; //Research Projects
  private double TPCCM; //Conference Committee Member
  private double ED; //Education Degree

  public void setNivel(String nivel) {
    this.nivel = nivel;
  }

  public String getNivel() {
    return nivel;
  }

  public void setASJ(double ASJ) {
    this.ASJ = ASJ;
    if (ASJ > Max.maxASJ) {
      Max.maxASJ = ASJ;
    }
  }

  public void setPTA(double PTA) {
    this.PTA = PTA;
    if (PTA > Max.maxPTA) {
      Max.maxPTA = PTA;
    }
  }

  public void setCWCP(double CWCP) {
    this.CWCP = CWCP;
    if (CWCP > Max.maxCWCP) {
      Max.maxCWCP = CWCP;
    }
  }

  public void setMDA(double MDA) {
    this.MDA = MDA;
    if (MDA > Max.maxMDA) {
      Max.maxMDA = MDA;
    }
  }

  public void setNC(double NC) {
    this.NC = NC;
    if (NC > Max.maxNC) {
      Max.maxNC = NC;
    }
  }

  public void setPEBPT(double PEBPT) {
    this.PEBPT = PEBPT;
    if (PEBPT > Max.maxPEBPT) {
      Max.maxPEBPT = PEBPT;
    }
  }

  public void setHI(double HI) {
    this.HI = HI;
    if (HI > Max.maxHI) {
      Max.maxHI = HI;
    }
  }

  public void setEBM(double EBM) {
    this.EBM = EBM;
    if (EBM > Max.maxEBM) {
      Max.maxEBM = EBM;
    }
  }

  public void setPA(double PA) {
    this.PA = PA;
    if (PA > Max.maxPA) {
      Max.maxPA = PA;
    }
  }

  public double getBC() {
    return BC;
  }

  public void setBC(double BC) {
    this.BC = BC;
  }

  public double getBK() {
    return BK;
  }

  public void setBK(double BK) {
    this.BK = BK;
  }

  public void setPEBMD(double PEBMD) {
    this.PEBMD = PEBMD;
    if (PEBMD > Max.maxPEBMD) {
      Max.maxPEBMD = PEBMD;
    }
  }

  public void setSOFT(double SOFT) {
    this.SOFT = SOFT;
    if (SOFT > Max.maxSOFT) {
      Max.maxSOFT = SOFT;
    }
  }

  public void setTPCCC(double TPCCC) {
    this.TPCCC = TPCCC;
    if (TPCCC > Max.maxTPCCC) {
      Max.maxTPCCC = TPCCC;
    }
  }

  public void setRJP(double RJP) {
    this.RJP = RJP;
    if (RJP > Max.maxRJP) {
      Max.maxRJP = RJP;
    }
  }

  public void setRP(double RP) {
    this.RP = RP;
    if (RP > Max.maxRP) {
      Max.maxRP = RP;
    }
  }

  public void setTPCCM(double TPCCM) {
    this.TPCCM = TPCCM;
    if (TPCCM > Max.maxTPCCM) {
      Max.maxTPCCM = TPCCM;
    }
  }

  public void setED(double ED) {
    this.ED = ED;
    if (ED > Max.maxED) {
      Max.maxED = ED;
    }
  }

  private static double calc(double element, double weigth, double max) {
    if (max == 0D) {
      return 0D;
    }

    if (element > max) {
      //System.out.println("Element: " + element + " greater then Max: " + max + "!");
      return weigth;
    }

    return element * weigth / max;
  }

  /*
  * Compute the rep-Index from atributes of this class.
  * The max values are automatic computeds.
   */
  public double repIndex(Weigths w) throws Exception {
    Double sum = w.getED() + w.getPA() + w.getPTA() + w.getMDA() + w.getPEBPT()
            + w.getPEBMD() + w.getEBM() + w.getRJP() + w.getTPCCC() + w.getTPCCM()
            + w.getASJ() + w.getBK() + w.getBC() + w.getCWCP() + w.getHI()
            + w.getNC() + w.getRP() + w.getSOFT();

    if (Math.abs(sum - 100D) > 0.1) {
      throw new Exception("Sum of Weigths is diferent of 100!");
    }

    return Item.calc(ASJ, w.getASJ(), Max.maxASJ)
            + Item.calc(PTA, w.getPTA(), Max.maxPTA)
            + Item.calc(CWCP, w.getCWCP(), Max.maxCWCP)
            + Item.calc(MDA, w.getMDA(), Max.maxMDA)
            + Item.calc(NC, w.getNC(), Max.maxNC)
            + Item.calc(PEBPT, w.getPEBPT(), Max.maxPEBPT)
            + Item.calc(HI, w.getHI(), Max.maxHI)
            + Item.calc(EBM, w.getEBM(), Max.maxEBM)
            + Item.calc(PA, w.getPA(), Max.maxPA)
            + Item.calc(BC, w.getBC(), Max.maxBC)
            + Item.calc(BK, w.getBK(), Max.maxBK)
            + Item.calc(PEBMD, w.getPEBMD(), Max.maxPEBMD)
            + Item.calc(SOFT, w.getSOFT(), Max.maxSOFT)
            + Item.calc(TPCCC, w.getTPCCC(), Max.maxTPCCC)
            + Item.calc(RJP, w.getRJP(), Max.maxRJP)
            + Item.calc(RP, w.getRP(), Max.maxRP)
            + Item.calc(TPCCM, w.getTPCCM(), Max.maxTPCCM)
            + Item.calc(ED, w.getED(), Max.maxED);
  }

}

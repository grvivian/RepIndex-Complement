package view;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.TableModel;
import model.Research;
import org.apache.commons.io.FileUtils;
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;
import org.apache.commons.math3.stat.correlation.SpearmansCorrelation;
import org.apache.commons.math3.stat.correlation.KendallsCorrelation;
import repindex.ExtensionRepIndex;
import repindex.Item;
import repindex.Max;
import repindex.Util;
import repindex.Weigths;
import repindex.enums.TypeAttributeSelection;
import weka.core.Instances;

/**
 *
 * @author glaucio
 */
public class FrmMain extends javax.swing.JFrame {

  /**
   * Creates new form FrmMain
   */
  public FrmMain() {
    initComponents();
    setLocationRelativeTo(null);
    setColumnSize();
  }

  private static final int CNPQ = 0;
  private static final int ED = 1;
  private static final int PA = 2;
  private static final int PTA = 3;
  private static final int MDA = 4;
  private static final int PEBPT = 5;
  private static final int PEBMD = 6;
  private static final int EBM = 7;
  private static final int RJP = 8;
  private static final int TPCCC = 9;
  private static final int TPCCM = 10;
  private static final int ASJ = 11;
  private static final int BK = 12;
  private static final int BC = 13;
  private static final int CWCP = 14;
  private static final int HI = 15;
  private static final int NC = 16;
  private static final int RP = 17;
  private static final int SOFT = 18;
  private static final int REPINDEX = 19;
  private static final int REPINDEX_INT5 = 20;

  public static final int REP_INDEX_ORIGINAL = 0;
  public static final int GAIN_RATIO = 1;
  public static final int INFO_GAIN = 2;
  public static final int CHI_SQUARED = 3;
  public static final int RELIEF_F = 4;
  public static final int SYMMETRICAL_UNCERT = 5;

  private final List<Research> l = new ArrayList<>();
  private static final Object[] COLUNAS = new String[]{"CNPq", "ED", "PA", "PTA", "MDA", "PEBPT", "PEBMD", "EBM", "RJP", "CCC", "CCM", "ASJ", "BP", "BCP", "CWCP", "HI", "NC", "RP", "SOFT", "Rep-Index", "Rep-Index Int"};
  private static final Class[] TYPES = new Class[]{java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Integer.class};
  private static final boolean[] CAN_EDIT = new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

  private static final SpearmansCorrelation SC = new SpearmansCorrelation();
  private static final PearsonsCorrelation PC = new PearsonsCorrelation();
  private static final KendallsCorrelation KC = new KendallsCorrelation();

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    mmTabela = new javax.swing.JPopupMenu();
    jLabel1 = new javax.swing.JLabel();
    cbArea = new javax.swing.JComboBox();
    jScrollPane2 = new javax.swing.JScrollPane();
    tabela = new javax.swing.JTable();
    lbTotal = new javax.swing.JLabel();
    btCalcPesosRepIndex = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jLabel1.setText("Área:");

    cbArea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select...", "Computer Science", "Economics", "Dentistry" }));
    cbArea.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cbAreaActionPerformed(evt);
      }
    });

    tabela.setAutoCreateRowSorter(true);
    tabela.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "CNPQ", "ED", "PA", "PTA", "MDA", "PEBPT", "PEBMD", "EBM", "RJ", "TPCCC", "TPCCM", "ASJ", "BK", "BC", "CWCP", "HI", "NC", "RP", "SOFT", "Rep-Index", "Rep-Index Int"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Integer.class
      };
      boolean[] canEdit = new boolean [] {
        false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    tabela.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    tabela.setComponentPopupMenu(mmTabela);
    jScrollPane2.setViewportView(tabela);

    lbTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    lbTotal.setText("0 Registro(s)");

    btCalcPesosRepIndex.setText("Pesos Rep-index");
    btCalcPesosRepIndex.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btCalcPesosRepIndexActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1043, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addComponent(btCalcPesosRepIndex)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(cbArea, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(cbArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lbTotal)
          .addComponent(btCalcPesosRepIndex))
        .addContainerGap())
    );

    pack();
    setLocationRelativeTo(null);
  }// </editor-fold>//GEN-END:initComponents

  private void setColumnSize() {
    tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

    tabela.getColumnModel().getColumn(CNPQ).setPreferredWidth(50);

    tabela.getColumnModel().getColumn(ED).setPreferredWidth(30);
    tabela.getColumnModel().getColumn(PA).setPreferredWidth(30);
    tabela.getColumnModel().getColumn(BK).setPreferredWidth(30);
    tabela.getColumnModel().getColumn(HI).setPreferredWidth(30);
    tabela.getColumnModel().getColumn(NC).setPreferredWidth(30);
    tabela.getColumnModel().getColumn(RP).setPreferredWidth(30);
    tabela.getColumnModel().getColumn(BC).setPreferredWidth(30);

    tabela.getColumnModel().getColumn(PTA).setPreferredWidth(35);
    tabela.getColumnModel().getColumn(MDA).setPreferredWidth(35);
    tabela.getColumnModel().getColumn(EBM).setPreferredWidth(35);
    tabela.getColumnModel().getColumn(RJP).setPreferredWidth(35);
    tabela.getColumnModel().getColumn(ASJ).setPreferredWidth(35);

    tabela.getColumnModel().getColumn(SOFT).setPreferredWidth(40);
    tabela.getColumnModel().getColumn(CWCP).setPreferredWidth(50);

    tabela.getColumnModel().getColumn(PEBPT).setPreferredWidth(50);
    tabela.getColumnModel().getColumn(PEBMD).setPreferredWidth(50);
    tabela.getColumnModel().getColumn(TPCCC).setPreferredWidth(50);
    tabela.getColumnModel().getColumn(TPCCM).setPreferredWidth(50);

    tabela.getColumnModel().getColumn(REPINDEX).setPreferredWidth(70);
    
    tabela.getColumnModel().getColumn(REPINDEX_INT5).setPreferredWidth(90);
  }

  private List<Item> pesquisadorToItens(List<Research> pl) {
    ArrayList<Item> ret = new ArrayList<>();

    Iterator<Research> itr = pl.iterator();
    while (itr.hasNext()) {
      Research p = itr.next();

      Item it = new Item();

      it.setNivel(p.getCnpq());

      //find the max values
      it.setED(p.getED());
      it.setMDA(p.getMDA());
      it.setPTA(p.getPTA());
      it.setPA(p.getPA());
      it.setPEBMD(p.getPEBMD());
      it.setPEBPT(p.getPEBPT());
      it.setTPCCC(p.getTPCCC());
      it.setTPCCM(p.getTPCCM());
      it.setEBM(p.getEBM());
      it.setRJP(p.getRJP());
      it.setASJ(p.getASJ());
      it.setBK(p.getBK());
      it.setBC(p.getBC());
      it.setCWCP(p.getCWCP());
      it.setHI(p.getHI());
      it.setNC(p.getNC());
      it.setRP(p.getRP());
      it.setSOFT(p.getSOFT());

      ret.add(it);
    }

    return ret;
  }

  private void btCalcPesosRepIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCalcPesosRepIndexActionPerformed
    try {     
      Max.cleanMax();

      TableModel m = tabela.getModel();

      Instances data = ExtensionRepIndex.pesquisadorToInstances(l);
      List<Item> itens = pesquisadorToItens(l);
      Weigths w = calcularRepIndexIndividual(itens, data);

      int i = 0;
      Iterator<Item> itr = itens.iterator();
      while (itr.hasNext()) {
        Item p = itr.next();

        double r = p.repIndex(w);//compute the Rep-Index to current Research
        int ri = Util.repIndexInt5(r);//Rep-Index integer
        m.setValueAt(r, i, REPINDEX);
        m.setValueAt(ri, i, REPINDEX_INT5);
        i++;
      }
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null, ex.getMessage());
      Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
    }
  }//GEN-LAST:event_btCalcPesosRepIndexActionPerformed

  private void cbAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAreaActionPerformed
    try {
      String a = (String) cbArea.getSelectedItem();
      File f = null;

      switch (a) {
        case "Computer Science": {
          f = new File("Computer Science.csv");
          break;
        }
        case "Economics": {
          f = new File("Economics.csv");
          break;
        }
        case "Dentistry": {
          f = new File("Dentistry.csv");
          break;
        }
      }

      if ((f == null) || (!f.exists())) {
        return;
      }

      l.clear();
      String tx = FileUtils.readFileToString(f, "UTF-8");
      String[] lines = tx.split("\n");
      lbTotal.setText((lines.length - 1) + " Register(s).");
      Object[][] dados = new Object[lines.length - 1][COLUNAS.length];

      for (int i = 1; i < lines.length; i++) {
        String[] v = lines[i].split(",");
        int linha = (i - 1);
        Research p = new Research();
        //CNPq,CNPqInt,ED,PA,PTA,MDA,PEBPT,PEBMD,EBM,RJP,CCC,CCM,ASJ,BK,BC,CWCP,HI,NC,RP,SOFT
        dados[linha][CNPQ] = v[0];
        p.setCnpq(v[0]);

        dados[linha][ED] = v[2];
        p.setED(Integer.parseInt(v[2]));

        dados[linha][PA] = v[3];
        p.setPA(Integer.parseInt(v[3]));

        dados[linha][PTA] = v[4];
        p.setPTA(Integer.parseInt(v[4]));

        dados[linha][MDA] = v[5];
        p.setMDA(Integer.parseInt(v[5]));

        dados[linha][PEBPT] = v[6];
        p.setPEBPT(Integer.parseInt(v[6]));

        dados[linha][PEBMD] = v[7];
        p.setPEBMD(Integer.parseInt(v[7]));

        dados[linha][EBM] = v[8];
        p.setEBM(Integer.parseInt(v[8]));

        dados[linha][RJP] = v[9];
        p.setRJP(Integer.parseInt(v[9]));

        dados[linha][TPCCC] = v[10];
        p.setTPCCC(Integer.parseInt(v[10]));

        dados[linha][TPCCM] = v[11];
        p.setTPCCM(Integer.parseInt(v[11]));

        dados[linha][ASJ] = v[12];
        p.setASJ(Integer.parseInt(v[12]));

        dados[linha][BK] = v[13];
        p.setBK(Integer.parseInt(v[13]));

        dados[linha][BC] = v[14];
        p.setBC(Integer.parseInt(v[14]));

        dados[linha][CWCP] = v[15];
        p.setCWCP(Integer.parseInt(v[15]));

        dados[linha][HI] = v[16];
        p.setHI(Integer.parseInt(v[16]));

        dados[linha][NC] = v[17];
        p.setNC(Integer.parseInt(v[17]));

        dados[linha][RP] = v[18];
        p.setRP(Integer.parseInt(v[18]));

        dados[linha][SOFT] = v[19];
        p.setSOFT(Integer.parseInt(v[19]));

        dados[linha][REPINDEX] = 0;
        dados[linha][REPINDEX_INT5] = 0;
        l.add(p);
      }

      tabela.setModel(new javax.swing.table.DefaultTableModel(dados, COLUNAS) {

        @Override
        public Class getColumnClass(int columnIndex) {
          return TYPES[columnIndex];
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
          return CAN_EDIT[columnIndex];
        }
      });

      setColumnSize();
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null, ex.getMessage());
      Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
    }
  }//GEN-LAST:event_cbAreaActionPerformed

  private Weigths calcularRepIndexIndividual(List<Item> itens, Instances data) throws Exception {
    double[] cnpq = new double[itens.size()];
    double[] RepIndex = new double[itens.size()];
    double[] ChiSquared = new double[itens.size()];
    double[] GainRatio = new double[itens.size()];
    double[] InfoGain = new double[itens.size()];
    double[] ReliefF = new double[itens.size()];
    double[] SymmetricalUncert = new double[itens.size()];

    //Compute de Weigths with Rep-Index Extension
    Weigths wChiSquared = ExtensionRepIndex.computeWeights(data, TypeAttributeSelection.CHI_SQUARED);
    wChiSquared.setName("ChiSquared");

    Weigths wGainRatio = ExtensionRepIndex.computeWeights(data, TypeAttributeSelection.GAIN_RATIO);
    wGainRatio.setName("GainRatio");

    Weigths wInfoGain = ExtensionRepIndex.computeWeights(data, TypeAttributeSelection.INFO_GAIN);
    wInfoGain.setName("InfoGain");

    Weigths wReliefF = ExtensionRepIndex.computeWeights(data, TypeAttributeSelection.RELIEF_F);
    wReliefF.setName("ReliefF");

    Weigths wSymmetricalUncert = ExtensionRepIndex.computeWeights(data, TypeAttributeSelection.SYMMETRICAL_UNCERT);
    wSymmetricalUncert.setName("SymmetricalUncert");

    System.out.println("elements|ED|PA|PTA|MDA|PEBPT|PEBMD|EBM|RJP|TPCCC|TPCCM|ASJ|BP|BCP|CWCP|HI|NC|RP|SOFT");
    System.out.println("scores|sED|sPA|sPTA|sMDA|sPEBPT|sPEBMD|sEBM|sRJP|sTPCCC|sTPCCM|sASJ|sBP|sBCP|sCWCP|sHI|sNC|sRP|sSOFT");
    Print.repIndexWeigths(wChiSquared, wGainRatio, wInfoGain, wReliefF, wSymmetricalUncert/*, wSVM*/);
    Print.repIndexBarChartWeigths(wChiSquared, wGainRatio, wInfoGain, wReliefF, wSymmetricalUncert/*, wSVM*/);

    System.out.println();
    System.out.println("CNPq|repIndex|ChiSquared|GainRatio|InfoGain|ReliefF|SymmetricalUncert");
    for (int i = 0; i < itens.size(); i++) {
      Item p = itens.get(i);

      cnpq[i] = Util.converCnpqToInt5(p.getNivel());
      ChiSquared[i] = Util.repIndexInt5(p.repIndex(wChiSquared));
      GainRatio[i] = Util.repIndexInt5(p.repIndex(wGainRatio));
      InfoGain[i] = Util.repIndexInt5(p.repIndex(wInfoGain));
      ReliefF[i] = Util.repIndexInt5(p.repIndex(wReliefF));
      SymmetricalUncert[i] = Util.repIndexInt5(p.repIndex(wSymmetricalUncert));
      RepIndex[i] = Util.repIndexInt5(p.repIndex(ExtensionRepIndex.REP_INDEX_WEIGTHS));

      System.out.println((int) cnpq[i] + "|"
              + (int) RepIndex[i] + "|"
              + (int) ChiSquared[i] + "|"
              + (int) GainRatio[i] + "|"
              + (int) InfoGain[i] + "|"
              + (int) ReliefF[i] + "|"
              + (int) SymmetricalUncert[i]);
    }

    //Find the best option
    double[] s = new double[6];
    double[] p = new double[6];
    double[] k = new double[6];

    s[REP_INDEX_ORIGINAL] = SC.correlation(cnpq, RepIndex);
    p[REP_INDEX_ORIGINAL] = PC.correlation(cnpq, RepIndex);
    k[REP_INDEX_ORIGINAL] = KC.correlation(cnpq, RepIndex);
    System.out.println();
    System.out.println("Rep-Index|" + s[REP_INDEX_ORIGINAL] + "|" + p[REP_INDEX_ORIGINAL] + "|" + k[REP_INDEX_ORIGINAL]);

    double maxS = s[REP_INDEX_ORIGINAL];
    Weigths best = ExtensionRepIndex.REP_INDEX_WEIGTHS;

    s[CHI_SQUARED] = SC.correlation(cnpq, ChiSquared);
    p[CHI_SQUARED] = PC.correlation(cnpq, ChiSquared);
    k[CHI_SQUARED] = KC.correlation(cnpq, ChiSquared);
    System.out.println("ChiSquared|" + s[CHI_SQUARED] + "|" + p[CHI_SQUARED] + "|" + k[CHI_SQUARED]);

    if (s[CHI_SQUARED] > maxS) {
      maxS = s[CHI_SQUARED];
      best = wChiSquared;
    }

    s[GAIN_RATIO] = SC.correlation(cnpq, GainRatio);
    p[GAIN_RATIO] = PC.correlation(cnpq, GainRatio);
    k[GAIN_RATIO] = KC.correlation(cnpq, GainRatio);
    System.out.println("GainRatio|" + s[GAIN_RATIO] + "|" + p[GAIN_RATIO] + "|" + k[GAIN_RATIO]);

    if (s[GAIN_RATIO] > maxS) {
      maxS = s[GAIN_RATIO];
      best = wGainRatio;
    }

    s[INFO_GAIN] = SC.correlation(cnpq, InfoGain);
    p[INFO_GAIN] = PC.correlation(cnpq, InfoGain);
    k[INFO_GAIN] = KC.correlation(cnpq, InfoGain);
    System.out.println("InfoGain|" + s[INFO_GAIN] + "|" + p[INFO_GAIN] + "|" + k[INFO_GAIN]);

    if (s[INFO_GAIN] > maxS) {
      maxS = s[INFO_GAIN];
      best = wInfoGain;
    }

    s[RELIEF_F] = SC.correlation(cnpq, ReliefF);
    p[RELIEF_F] = PC.correlation(cnpq, ReliefF);
    k[RELIEF_F] = KC.correlation(cnpq, ReliefF);
    System.out.println("ReliefF|" + s[RELIEF_F] + "|" + p[RELIEF_F] + "|" + k[RELIEF_F]);

    if (s[RELIEF_F] > maxS) {
      maxS = s[RELIEF_F];
      best = wReliefF;
    }

    s[SYMMETRICAL_UNCERT] = SC.correlation(cnpq, SymmetricalUncert);
    p[SYMMETRICAL_UNCERT] = PC.correlation(cnpq, SymmetricalUncert);
    k[SYMMETRICAL_UNCERT] = KC.correlation(cnpq, SymmetricalUncert);
    System.out.println("SymmetricalUncert|" + s[SYMMETRICAL_UNCERT] + "|" + p[SYMMETRICAL_UNCERT] + "|" + k[SYMMETRICAL_UNCERT]);

    if (s[SYMMETRICAL_UNCERT] > maxS) {
      maxS = s[SYMMETRICAL_UNCERT];
      best = wSymmetricalUncert;
    }

    best.setCorrelation(maxS);

    Print.corelationsBarChar(s, p, k);

    return best;
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Windows".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
        if ("GTK+".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
      JOptionPane.showMessageDialog(null, ex.getMessage());
      Logger
              .getLogger(FrmMain.class
                      .getName()).log(Level.SEVERE, null, ex);
    }

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        FrmMain f = new FrmMain();
        f.setVisible(true);
        f.setExtendedState(FrmMain.MAXIMIZED_BOTH);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btCalcPesosRepIndex;
  private javax.swing.JComboBox cbArea;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JLabel lbTotal;
  private javax.swing.JPopupMenu mmTabela;
  private javax.swing.JTable tabela;
  // End of variables declaration//GEN-END:variables
}

package supisGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.JTable;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Component;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.ComponentOrientation;
import javax.swing.AbstractListModel;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import fi.jyu.mit.gui.EditPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author majosalo : Maarit Salo
 * @version 31.1.2013
 * @version 7.2.2013
 *
 */
public class Supis extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelSisalto;
	private final JPanel panelNappulat = new JPanel();
	private final JSplitPane splitpanelListaSupisTiedot = new JSplitPane();
	private final JPanel panelLista = new JPanel();
	private final JSplitPane splitPanelTiedotJaKyvyt = new JSplitPane();
	private final JPanel panelHaku = new JPanel();
	private final JScrollPane scrollSupikset = new JScrollPane();
	private final JPanel panelKyvyt = new JPanel();
	private final JPanel panelSupiksenTiedot = new JPanel();

	private final JLabel labelKyvyt = new JLabel(" Valitun supersankarin kyvyt");
	private final JScrollPane scrollVoimaTable = new JScrollPane();
	private final JPanel supisNappulat = new JPanel();
	private final JPanel kykyNappulat = new JPanel();
	private final JComboBox cbKentat = new JComboBox();
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JTextField txtHaku = new JTextField();
	private final JButton btnTallennaSupis = new JButton(
			"Tallenna supersankarin tiedot");
	private final JButton tallennaKyKy = new JButton(
			"Palauta alkuper\u00E4iset");
	private final JLabel lblNewLabel = new JLabel("Supersankarit");
	private final JLabel labelHakuehto = new JLabel("Hakuehto");
	private final JList list = new JList();
	private final JSplitPane splitPaneSupisTiedot = new JSplitPane();
	private final JPanel panelSupisTiedot = new JPanel();
	private final JPanel panelVahvemmat = new JPanel();
	private final JLabel label = new JLabel("Supersankarin tiedot");
	private final JScrollPane scrollPaneSupisTiedot = new JScrollPane();
	private final JScrollPane scrollPanelVahvemmat = new JScrollPane();
	private final JList listVahvemmat = new JList();
	private final JLabel lblVahvemmat = new JLabel("Vahvemmat supersankarit");
	private final JPanel panelTiedot = new JPanel();
	private final JPanel panelEditPanelit = new JPanel();
	private final EditPanel editPanel = new EditPanel();
	private final EditPanel editPanel_1 = new EditPanel();
	private final EditPanel editPanel_2 = new EditPanel();
	private final EditPanel editPanel_3 = new EditPanel();
	private final EditPanel editPanel_4 = new EditPanel();
	private final EditPanel editPanel_5 = new EditPanel();
	private final JPanel panelKyky = new JPanel();
	private final JPanel panelKykyeditit = new JPanel();
	private final EditPanel editPanel_6 = new EditPanel();
	private final EditPanel editPanel_7 = new EditPanel();
	private final EditPanel editPanel_8 = new EditPanel();
	private final EditPanel editPanel_9 = new EditPanel();
	private final EditPanel editPanel_10 = new EditPanel();
	private final EditPanel editPanel_11 = new EditPanel();
	private final EditPanel editPanel_12 = new EditPanel();
	private final EditPanel editPanel_13 = new EditPanel();
	private final JMenuBar menuValikko = new JMenuBar();
	private final JMenu menudropTiedosto = new JMenu("Tiedosto");
	private final JMenuItem menuItem = new JMenuItem("Tallenna");
	private final JMenuItem menuItem_1 = new JMenuItem("Valitse supersankarin\u00E4kym\u00E4");
	private final JMenuItem menuItem_2 = new JMenuItem("Valitse kykyn\u00E4kym\u00E4");
	private final JMenuItem menuItem_3 = new JMenuItem("You'll be back");
	private final JMenu menudropMuokkaa = new JMenu("Muokkaa");
	private final JMenuItem menuItem_4 = new JMenuItem("Lis\u00E4\u00E4 uusi supersankari");
	private final JMenuItem menuItem_5 = new JMenuItem("Lis\u00E4\u00E4 uusi kyky");
	private final JMenuItem menuItem_6 = new JMenuItem("Poista supersankari...");
	private final JMenuItem menuItem_7 = new JMenuItem("Poista kyky...");
	private final JMenu menudropOhje = new JMenu("Ohje");
	private final JMenuItem menuItem_8 = new JMenuItem("K\u00E4ytt\u00F6ohjeet");
	private final JMenuItem menuItem_9 = new JMenuItem("About Batmanin supersankarirekisteri");


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supis frame = new Supis();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Supis() {
		txtHaku.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				JOptionPane
						.showMessageDialog(
								null,
								"Kun ohjelma toimii voit kirjoittaa t�h�n esim 'cap' \nja hakutuloksena pit�isi ilmesty� Captain American tiedot. Et viel�.",
								"Tba", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		txtHaku.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 626);

		setJMenuBar(menuValikko);

		menuValikko.add(menudropTiedosto);
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane
				.showMessageDialog(
						null,
						"Kun ohjelma toimii, t�st� tallennat tiedot. Et viel�",
						"Tba", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		menudropTiedosto.add(menuItem);
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane
				.showMessageDialog(
						null,
						"Olet jo supisn�kym�ss�!",
						"Tba", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		menudropTiedosto.add(menuItem_1);
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kyky();
			}
		});

		menudropTiedosto.add(menuItem_2);
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		menudropTiedosto.add(menuItem_3);

		menuValikko.add(menudropMuokkaa);
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				uusiSupis();
			}
		});

		menudropMuokkaa.add(menuItem_4);
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uusiKyky();
			}
		});

		menudropMuokkaa.add(menuItem_5);
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				poistaSup();
			}
		});

		menudropMuokkaa.add(menuItem_6);
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				poistaKyk();
			}
		});

		menudropMuokkaa.add(menuItem_7);
		menudropOhje.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		menuValikko.add(menudropOhje);
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ohje();
			}
		});

		menudropOhje.add(menuItem_8);
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aboutti();
			}
		});

		menudropOhje.add(menuItem_9);
		panelSisalto = new JPanel();
		panelSisalto.setPreferredSize(new Dimension(300, 200));
		panelSisalto.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelSisalto.setLayout(new BorderLayout(0, 0));
		setContentPane(panelSisalto);

		panelSisalto.add(panelNappulat, BorderLayout.SOUTH);

		panelNappulat.add(supisNappulat);
		supisNappulat.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		btnTallennaSupis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane
						.showMessageDialog(
								null,
								"Kun ohjelma toimii, t�t� painamalla tallennat\nmahdollisesti muuttamasi supiksen tiedot. Et viel�.",
								"Tba", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		supisNappulat.add(btnTallennaSupis);
		FlowLayout fl_kykyNappulat = (FlowLayout) kykyNappulat.getLayout();
		fl_kykyNappulat.setAlignment(FlowLayout.RIGHT);

		panelNappulat.add(kykyNappulat);
		tallennaKyKy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane
						.showMessageDialog(
								null,
								"Kun ohjelma toimii t�m� palauttaa alkuper�iset tiedot. Ei viel�.",
								"Tba", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		kykyNappulat.add(tallennaKyKy);

		panelSisalto.add(splitpanelListaSupisTiedot, BorderLayout.CENTER);

		splitpanelListaSupisTiedot.setLeftComponent(panelLista);
		panelLista.setLayout(new BorderLayout(0, 0));
		panelLista.add(panelHaku, BorderLayout.NORTH);
		panelHaku.setLayout(new BoxLayout(panelHaku, BoxLayout.Y_AXIS));
		labelHakuehto.setAlignmentX(Component.RIGHT_ALIGNMENT);

		panelHaku.add(labelHakuehto);
		cbKentat.setModel(new DefaultComboBoxModel(new String[] { "Stage Name",
				"Nimi", "Puoliso", "Kotikaupunki", "JLU yhteysnumero" }));

		panelHaku.add(cbKentat);

		panelHaku.add(txtHaku);
		lblNewLabel.setAlignmentX(0.8f);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);

		panelHaku.add(lblNewLabel);

		panelLista.add(scrollSupikset, BorderLayout.CENTER);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane
						.showMessageDialog(
								null,
								"Kun ohjelma toimii voit klikata yht� nime� ja saada sen tiedot. Et viel�.",
								"Tba", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		list.setModel(new AbstractListModel() {
			String[] values = new String[] { "Batman", "Captain America",
					"Iron Man" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});

		scrollSupikset.setViewportView(list);
		splitPanelTiedotJaKyvyt.setResizeWeight(1.0);

		splitpanelListaSupisTiedot.setRightComponent(splitPanelTiedotJaKyvyt);
		panelKyvyt.setMaximumSize(new Dimension(200, 14));

		splitPanelTiedotJaKyvyt.setRightComponent(panelKyvyt);
		panelKyvyt.setLayout(new BorderLayout(0, 0));

		panelKyvyt.add(labelKyvyt, BorderLayout.NORTH);
		scrollVoimaTable.setMaximumSize(new Dimension(200, 14));

		panelKyvyt.add(scrollVoimaTable, BorderLayout.CENTER);

		scrollVoimaTable.setViewportView(panelKyky);
		panelKyky.setLayout(new BorderLayout(0, 0));

		panelKyky.add(panelKykyeditit, BorderLayout.NORTH);
		panelKykyeditit.setLayout(new BoxLayout(panelKykyeditit,
				BoxLayout.Y_AXIS));
		editPanel_6.getLabel().setText("Supervoimat");
		editPanel_6.getEdit().setText("750");

		panelKykyeditit.add(editPanel_6);
		editPanel_7.getLabel().setText("Gadgets");
		editPanel_7.getEdit().setText("680");

		panelKykyeditit.add(editPanel_7);
		editPanel_8.getLabel().setText("Long range");
		editPanel_8.getEdit().setText("550");

		panelKykyeditit.add(editPanel_8);
		editPanel_9.getLabel().setText("Melee");
		editPanel_9.getEdit().setText("350");

		panelKykyeditit.add(editPanel_9);
		editPanel_10.getLabel().setText("Projektiilit");
		editPanel_10.getEdit().setText("150");

		panelKykyeditit.add(editPanel_10);
		editPanel_11.getLabel().setText("Tuli");
		editPanel_11.getEdit().setText("0");

		panelKykyeditit.add(editPanel_11);
		editPanel_12.getLabel().setText("J\u00E4\u00E4");
		editPanel_12.getEdit().setText("0");

		panelKykyeditit.add(editPanel_12);
		editPanel_13.getLabel().setText("Taikuus");
		editPanel_13.getEdit().setText("0");

		panelKykyeditit.add(editPanel_13);
		panelSupiksenTiedot.setPreferredSize(new Dimension(200, 10));
		splitPanelTiedotJaKyvyt.setLeftComponent(panelSupiksenTiedot);
		panelSupiksenTiedot.setLayout(new BorderLayout(0, 0));
		splitPaneSupisTiedot.setResizeWeight(1.0);
		splitPaneSupisTiedot.setOrientation(JSplitPane.VERTICAL_SPLIT);

		panelSupiksenTiedot.add(splitPaneSupisTiedot, BorderLayout.CENTER);

		splitPaneSupisTiedot.setLeftComponent(panelSupisTiedot);
		panelSupisTiedot.setLayout(new BorderLayout(0, 0));

		panelSupisTiedot.add(label, BorderLayout.NORTH);
		scrollPaneSupisTiedot.setToolTipText("");
		scrollPaneSupisTiedot.setPreferredSize(new Dimension(200, 14));

		panelSupisTiedot.add(scrollPaneSupisTiedot, BorderLayout.CENTER);

		scrollPaneSupisTiedot.setViewportView(panelTiedot);
		panelTiedot.setLayout(new BorderLayout(0, 0));

		panelTiedot.add(panelEditPanelit, BorderLayout.NORTH);
		panelEditPanelit.setLayout(new BoxLayout(panelEditPanelit,
				BoxLayout.Y_AXIS));
		editPanel.getEdit().setText("Captain America");
		editPanel.setCaption("Stage name");

		panelEditPanelit.add(editPanel);
		editPanel_1.getEdit().setText("Rogers Steve");
		editPanel_1.setCaption("Sukunimi Etunimi");

		panelEditPanelit.add(editPanel_1);
		editPanel_2.getLabel().setText("Puoliso");
		editPanel_2.getEdit().setText("Stark Tony");

		panelEditPanelit.add(editPanel_2);
		editPanel_3.getLabel().setText("Kotikaupunki");
		editPanel_3.getEdit().setText("Brooklyn");

		panelEditPanelit.add(editPanel_3);
		editPanel_4.getLabel().setText("JLU yhteysnumero");
		editPanel_4.getEdit().setText("2");

		panelEditPanelit.add(editPanel_4);
		editPanel_5.getLabel().setText("Voimanumero");
		editPanel_5.getEdit().setText("800");

		panelEditPanelit.add(editPanel_5);

		splitPaneSupisTiedot.setRightComponent(panelVahvemmat);
		panelVahvemmat.setLayout(new BorderLayout(0, 0));
		scrollPanelVahvemmat
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		panelVahvemmat.add(scrollPanelVahvemmat, BorderLayout.CENTER);
		listVahvemmat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane
						.showMessageDialog(
								null,
								"Kun ohjelma toimii voit klikata yht� nime� ja saada sen tiedot. Et viel�.",
								"Tba", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		listVahvemmat.setModel(new AbstractListModel() {
			String[] values = new String[] { "Batman", "Rorscach", "Deadpool",
					"Spiderman", "Superman" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});

		scrollPanelVahvemmat.setViewportView(listVahvemmat);

		panelVahvemmat.add(lblVahvemmat, BorderLayout.NORTH);

		panel.setLayout(new BorderLayout(0, 0));

		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
	}

	public String getLabelHakuehtoText() {
		return labelHakuehto.getText();
	}

	public void setLabelHakuehtoText(String text) {
		labelHakuehto.setText(text);
	}


    // ///////////////////////////////////
    // //siirtyy muualle
    /**
     * Luo uuden ja laittaa Kyvyt-dialogin n�kyviin
     */
    protected void kyky() {

            Kyvyt kykynakyma = new Kyvyt();
            kykynakyma.setVisible(true);
    }

    /**
     * Luo uuden ja laittaa UusiSupis-dialogin n�kyviin
     */
    protected void uusiSupis() {
            UusiSupis uusSupis = new UusiSupis();
            uusSupis.setVisible(true);

    }

    /**
     * Luo uuden ja laittaa UusiKyky-dialogin n�kyviin
     */
    protected void uusiKyky() {
            UusiKyky uuskyk = new UusiKyky();
            uuskyk.setVisible(true);

    }

    /**
     * Luo uuden ja laittaa PoistaSupis-dialogin n�kyviin
     */
    protected void poistaSup() {
            PoistaSupis poisSup = new PoistaSupis();
            poisSup.setVisible(true);

    }

    /**
     * Luo uuden ja laittaa PoistaKyky-dialogin n�kyviin
     */
    protected void poistaKyk() {
            PoistaKyky poisKyk = new PoistaKyky();
            poisKyk.setVisible(true);

    }

    /**Luo uuden ja
     * Luo uuden ja laittaa SupisOhje-dialogin n�kyviin
     */
    protected void ohje() {
            SupisOhje ohjeet = new SupisOhje();
            ohjeet.setVisible(true);

    }

    /**Luo uuden ja
     * Luo uuden ja laittaa SupisAbout-dialogin n�kyviin
     */
    protected void aboutti() {
            SupisAbout aboutt = new SupisAbout();
            aboutt.setVisible(true);

    }
}

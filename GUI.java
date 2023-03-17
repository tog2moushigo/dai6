import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private JButton buttonCopy;
    private JLabel labInp, labKey, labRes, labInfo;
    private JTextField texInput, texKey, texResult;
    private JRadioButton RButtonEnc, RButtonDec;
    private ButtonGroup groupCip;
    private JComboBox dropCiphers;
    private JPanel panelInp, panelKey, panelMenu, panelRadio, panelResult, panelInfo;

    // dropdown menu
    String ciphers[] = {"Caesar", "Scytale"};

    public GUI(){
        setTitle("Let's make ciphers!");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* input text field */
        texInput = new JTextField();
        texInput.setColumns(10);
        labInp = new JLabel("Input");
        panelInp = new JPanel();
        panelInp.setLayout(new GridLayout(1,2));
        panelInp.add(labInp);
        panelInp.add(texInput);

        /* key text field */
        texKey = new JTextField();
        texKey.setColumns(10);
        labKey = new JLabel("Key");
        panelKey = new JPanel();
        panelKey.setLayout(new GridLayout(1,2));
        panelKey.add(labKey);
        panelKey.add(texKey);

        /* dropdown menu */
        dropCiphers = new JComboBox(ciphers);
        panelMenu = new JPanel();
        panelMenu.setLayout(new BorderLayout());
        panelMenu.add(dropCiphers, BorderLayout.CENTER);

        /* radio button */
        RButtonEnc = new JRadioButton("Encrypt", true); // default selected button
        RButtonDec = new JRadioButton("Decrypt");
        groupCip = new ButtonGroup();
        groupCip.add(RButtonEnc);
        groupCip.add(RButtonDec);
        panelRadio = new JPanel();
        panelRadio.setLayout(new GridLayout(1,2));
        panelRadio.add(RButtonEnc);
        panelRadio.add(RButtonDec);

        /* result text field */
        texResult = new JTextField();
        texResult.setColumns(10);
        labRes = new JLabel("Result");
        buttonCopy = new JButton(); // the button which copies result text to clipboard
        buttonCopy.setText("Copy");
        panelResult = new JPanel();
        panelResult.setLayout(new GridLayout(1,3));
        panelResult.add(labRes);
        panelResult.add(texResult);
        panelResult.add(buttonCopy);

        /* info field */
        labInfo = new JLabel("Use box named \"Input\" to write text you want to change.");
        panelInfo = new JPanel();
        panelInfo.setLayout(new GridLayout(1,1));
        panelInfo.add(labInfo);

        /* components */
        Container cont = getContentPane();
        cont.setLayout(new GridLayout(6,1));
        cont.add(panelInp);
        cont.add(panelKey);
        cont.add(panelMenu);
        cont.add(panelRadio);
        cont.add(panelResult);
        cont.add(panelInfo);
    }

}

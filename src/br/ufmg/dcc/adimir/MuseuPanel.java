package br.ufmg.dcc.adimir;

import sun.java2d.pipe.SpanShapeRenderer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MuseuPanel extends JFrame {
    private JList galleryJList;
    private JButton addWorkArt; private JButton removeWorkArt;
    private JLabel searchLabel; private JTextField searchField;
    private JButton btnByNumber; private JButton btnByName;
    private JButton btnByAutor; private JButton btnFilterSculpture;
    private JButton btnFilterPainting; private JButton btnFilterMusic;
    private JFrame mainFrame; private JFrame frame;
    private WorkArt workArt;

    Gallery gallery = new Gallery();

    public MuseuPanel() {
        prepareGUI();
//        addWorkArt.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                SimpleFrame sFrame = new SimpleFrame(waFrame);
//            }
//        });

//        removeWorkArt.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int index = galleryJList.getSelectedIndex();
//                WorkArt wa = gallery.elementAt(index);
//                if (wa != null) gallery.remove(wa.getNumOfArtWork());
//                galleryJList.setListData(gallery.toListModel());
//            }
//        });
    }

    private void showJFrameDemo(){
        final WorkArt[] wa = new WorkArt[1];
        JLabel number;
        JTextField textNumber;
        JLabel name;
        JTextField textName;
        JLabel author;
        JTextField textAuthor;
        JLabel desc;
        JTextField textDesc;
        JLabel typeOfWorkArt;
        JComboBox comboType;
        JButton btnSave;

        frame = new JFrame();

        frame.setLayout( new FlowLayout());
        frame.setTitle("Criar Obra de Arte");
        frame.setSize(300, 300);
        String names[] = {"Pintura", "Escultura", "Musica"};

        number = new JLabel("Número da Obra:");
        textNumber = new JTextField(15);
        name = new JLabel("Nome da Obra:");
        textName = new JTextField(15);
        author = new JLabel("Autor:");
        textAuthor = new JTextField(15);
        desc = new JLabel("Descrição:");
        textDesc = new JTextField(15);
        typeOfWorkArt = new JLabel("Tipo de Obra");
        comboType = new JComboBox(names);

        frame.add(typeOfWorkArt);
        frame.add(comboType);
        frame.add(number);
        frame.add(textNumber);
        frame.add(name);
        frame.add(textName);
        frame.add(author);
        frame.add(textAuthor);
        frame.add(desc);
        frame.add(textDesc);

        btnSave = new JButton("Adicionar Obra");

        frame.add(btnSave);
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Selecionado: " + comboType.getSelectedItem());
                int number = Integer.parseInt(textNumber.getText());
                switch (comboType.getSelectedItem().toString()){
                    case "Escultura":
                        workArt = new Sculpture(number, textAuthor.getText(), textName.getText(), textDesc.getText(), new Dimension(1f,2f), "material");
                        break;
                    case "Pintura":
                        workArt = new Painting(number, textName.getText(), textAuthor.getText(), textDesc.getText(), new Dimension(1f,2f));
                        break;
                    case "Musica":
                        workArt = new Music(number, textName.getText(), textAuthor.getText(), textDesc.getText(), "00:00", "Fita", Integer.parseInt("1"));
                        break;
                }
                System.out.println("Formulario: "+textNumber.getText() + " name: " + textName.getText() + " autor: " + textAuthor.getText());
                System.out.println(workArt);
                gallery.add(workArt);
                galleryJList.setListData(gallery.toListModel());
                frame.dispose();
            }
        });

        mainFrame.setVisible(true);
    }

    private void prepareGUI(){
        mainFrame = new JFrame("Museu Adimir Colen");
        mainFrame.setLayout( new FlowLayout());
        mainFrame.setSize( 600, 300 );
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        galleryJList = new JList();
        galleryJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        addWorkArt = new JButton( "Adicionar Obra" );
        removeWorkArt = new JButton( "Remover Obra" );
        searchLabel = new JLabel("Procurar obra");
        searchField = new JTextField(15);
        btnByNumber = new JButton("por número");
        btnByName = new JButton("por nome");
        btnByAutor = new JButton("por autor");
        btnFilterMusic = new JButton("Músicas");
        btnFilterPainting = new JButton("Pinturas");
        btnFilterSculpture = new JButton("Esculturas");

        mainFrame.add(searchLabel);
        mainFrame.add(searchField);
        mainFrame.add(btnByNumber);
        mainFrame.add(btnByName);
        mainFrame.add(btnByAutor);
        mainFrame.add(btnFilterMusic);
        mainFrame.add(btnFilterPainting);
        mainFrame.add(btnFilterSculpture);
        mainFrame.add( new JScrollPane( galleryJList ) );
        mainFrame.add(addWorkArt);
        mainFrame.add(removeWorkArt);

        addWorkArt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
            }
        });
    }

//    public void repaint() {
//        super.repaint();
//        System.out.println("Gallery On Main: "+ gallery);
//        galleryJList.setListData(gallery.toListModel());
//    }

    public static void main( String args[] ) {
        MuseuPanel  museuPanel = new MuseuPanel();
        museuPanel.showJFrameDemo();
    }
}

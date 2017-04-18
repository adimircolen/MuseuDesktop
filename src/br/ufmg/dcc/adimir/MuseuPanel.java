package br.ufmg.dcc.adimir;

import sun.java2d.pipe.SpanShapeRenderer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MuseuPanel extends JFrame {
    JList galleryJList;
    JButton addWorkArt;
    JButton removeWorkArt;
    JLabel searchLabel;
    JTextField searchField;
    JButton btnByNumber;
    JButton btnByName;
    JButton btnByAutor;
    JButton btnFilterSculpture;
    JButton btnFilterPainting;
    JButton btnFilterMusic;
    JDialog waFrame;

    Gallery gallery = new Gallery();

    public MuseuPanel() {
        super( "Sistema de Gerenciamento de Arte" );
        Container c = getContentPane();
        c.setLayout( new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        waFrame = new JDialog(this, "Criar Obra de Arte", true);

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

        this.setName("001");

        c.add(searchLabel);
        c.add(searchField);
        c.add(btnByNumber);
        c.add(btnByName);
        c.add(btnByAutor);

        c.add(btnFilterMusic);
        c.add(btnFilterPainting);
        c.add(btnFilterSculpture);


        c.add( new JScrollPane( galleryJList ) );
        c.add(addWorkArt);
        c.add(removeWorkArt);

        this.setSize( 600, 300 );
        this.setVisible(true);

        addWorkArt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleFrame sFrame = new SimpleFrame(waFrame);
            }
        });

        removeWorkArt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = galleryJList.getSelectedIndex();
                WorkArt wa = gallery.elementAt(index);
                if (wa != null) gallery.remove(wa.getNumOfArtWork());
                galleryJList.setListData(gallery.toListModel());
            }
        });
    }

//    public void repaint() {
//        super.repaint();
//        System.out.println("Gallery On Main: "+ gallery);
//        galleryJList.setListData(gallery.toListModel());
//    }

    class SimpleFrame {
        WorkArt wa;
        JDialog frame;
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

        public SimpleFrame(JDialog f) {
            frame = f;
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

            frame.setName("002");

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
                    System.out.println("Formulario: "+textNumber.getText() + " name: " + textName.getText() + " autor: " + textAuthor.getText());
                    int number = Integer.parseInt(textNumber.getText());
                    wa = new Sculpture(number, textAuthor.getText(), textName.getText(), textDesc.getText(), new Dimension(1f,2f));
                    System.out.println(wa);
                    System.out.println(frame.getRootPane().getName());

//                    dispose();
                }
            });
            frame.setVisible(true);
        }
        public WorkArt getWorkArt() {
            return wa;
        }
    }

    public static void main( String args[] ) {
        new MuseuPanel();
    }
}

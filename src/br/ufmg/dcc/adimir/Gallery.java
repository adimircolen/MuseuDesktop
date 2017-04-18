package br.ufmg.dcc.adimir;

import java.util.ArrayList;
import java.util.Vector;

public class Gallery implements IGallery {
    private Vector<WorkArt> collection = new Vector<WorkArt>();

    public String toString() {
        String result = "";
        for (WorkArt workArt : getCollection()) {
            result += workArt +"\n";
        }
        return result;
    }

    public String[] toListModel() {
        int collSize = collection.size();
        String[] result = new String[collSize];
        for (int i=0;i<collSize;i++){
            result[i] = collection.elementAt(i).toString();
        }
        return result;
    }

    @Override
    public void add(WorkArt wa) {
        if (indexOf(wa) < 0)
            collection.add(wa);
    }

    public WorkArt elementAt(int index) {
        WorkArt result;
        try {
            result = collection.elementAt(index);
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
            return null;
        }
        return result;
    }

    public int indexOf(WorkArt wa) {
        for (WorkArt workArt : collection) {
            try {
                Class<? extends WorkArt> cls = workArt.getClass();
                if ( cls.isInstance(wa) && workArt.equals(wa) ){
                    return collection.indexOf(workArt);
                }
            }catch (ClassCastException e) {
                return -1;
            }
        }
        return -1;
    }

    @Override
    public boolean remove(int numOfArtWork) {
        boolean result = false;
        for (WorkArt workArt : getCollection()) {
            if (workArt.getNumOfArtWork() == numOfArtWork) {
                result = collection.remove(workArt);
                break;
            }
        }
        return result;
    }

    @Override
    public void remove(String name) {
        WorkArt wa = findBy(name);
        if (wa != null)
            collection.remove(wa);
    }

    @Override
    public void list() {
        for (WorkArt workArt : getCollection()) {
            System.out.println(workArt);
        }
    }

    @Override
    public WorkArt findBy(String name) {
        WorkArt wa = null;
        for (WorkArt workArt : getCollection()) {
            if ( workArt.getName().equals(name) ) {
                wa = workArt;
                break;
            }
        }
        return wa;
    }

    @Override
    public WorkArt findBy(int number) {
        WorkArt wa = null;
        for (WorkArt workArt : getCollection()) {
            if ( workArt.getNumOfArtWork() == number ) {
                wa = workArt;
                break;
            }
        }
        return wa;
    }

    @Override
    public Gallery findByAuthor(String author) {
        ArrayList<WorkArt> was = new ArrayList<WorkArt>();
        Gallery byAuthor = new Gallery();
        for (WorkArt workArt : getCollection()) {
            if ( workArt.getAuthor().equals(author) ) {
                byAuthor.add(workArt);
            }
        }
        return byAuthor;
    }

    public Vector<WorkArt> getCollection() {
        return collection;
    }

    public void setCollection(Vector<WorkArt> collection) {
        this.collection = collection;
    }

    public static void main(String[] args) {
        Gallery g = new Gallery();
        WorkArt[] outOfGallery = {
            new Sculpture(1, "Moisés", "Michelangelo", "desc", new Dimension(1f, 3.7f), "mármore"),
            new Painting(2, "Os Girassóis", "Van Gogh", "desc", new Dimension(1f, 1f)),
            new Painting(3, "Guernica", "Picasso", "desc", new Dimension(1f, 1f)),
            new Painting(4, "A última ceia", "Leonardo da Vince", "desc", new Dimension(1f, 2f)),
            new Music(5, "Brasil Pandeiro", "Assis Valente", "desc", "3:40", Music.CD, 1),
            new Sculpture(6, "O Pensador", "Rodin", "desc", new Dimension(1f, 2f) ,"bronze"),
            new Music(7, "O Mundo é um Moinho", "Cartola", "desc", "3:53", Music.VINIL, 1),
            new Sculpture(8, "David", "Michelangelo", "desc", new Dimension(1f, 4.1f), "mármore"),
        };

        for (int i = 0; i < outOfGallery.length; i++) {
            g.add(outOfGallery[i]);
        }
        System.out.println("Listagem de todas as Obras");
        g.list();
        System.out.println("Listagem de com uma remoção das " + g.getCollection().size() + " Obras");
        boolean r = g.remove(3);
        g.list();
        System.out.println("Ficando um numero de " + g.getCollection().size() + " Obras");
        System.out.println("Listagem por Autor\n"+ g.findByAuthor("Michelangelo"));
        System.out.println("Remover obra 'O Pensador' estou usando o pesquisa pelo numero 6 \n" + g.findBy(6) + "\n");
        g.remove("O Pensador");
        g.list();
    }
}

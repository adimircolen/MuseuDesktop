package br.ufmg.dcc.adimir;

import java.util.ArrayList;

/**
 * @author adimircolen
 *
 */
public interface IGallery {
    public void add(WorkArt wa);
    public boolean remove(int numOfArtWork);
    public void remove(String name);
    public void list();
    public WorkArt findBy(String name);
    public WorkArt findBy(int number);
    public Gallery findByAuthor(String author);
}

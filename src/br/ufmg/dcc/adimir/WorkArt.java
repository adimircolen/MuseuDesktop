package br.ufmg.dcc.adimir;

public class WorkArt implements IArt{
    Integer numOfArtWork;
    String author;
    String name;
    String description;
    public WorkArt() {}
    public WorkArt(Integer num, String name, String authour, String description) {
        this.numOfArtWork = num;
        this.author = authour;
        this.name = name;
        this.description = description;
    }
    public String toString() {
        String result = String.format("No. Id: %1$d| Nome: %2$-30s| Autor: %3$-20s| Desc: %4$-10s", numOfArtWork, name, author, description);
        return result;
    }
    public boolean equals(WorkArt wa) {
        if (wa == null)
            return false;
        return (wa.numOfArtWork.equals(numOfArtWork) &&
            wa.author.equals(author) &&
            wa.name.equals(name) &&
            wa.description.equals(description) );
    }
    public Integer getNumOfArtWork() {
        return numOfArtWork;
    }
    public void setNumOfArtWork(Integer numOfArtWork) {
        this.numOfArtWork = numOfArtWork;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}

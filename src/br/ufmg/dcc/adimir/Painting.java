package br.ufmg.dcc.adimir;
/**
 * @author adimircolen
 *
 */
public class Painting extends WorkArt {
    Dimension dimension;

    public Painting () {}
    public Painting (Integer num, String name, String authour, String description, Dimension dimension) {
        super(num, name, authour, description);
        this.dimension = dimension;
    }

    public boolean equals(WorkArt wa) {
        if (getClass() != wa.getClass())
            return false;
        return ( super.equals(wa) &&
                dimension.equals( ((Painting)wa).dimension ) );
    }

    public String toString() {
        String result = super.toString();
        result += "| " + dimension;
        return result;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

}

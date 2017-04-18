package br.ufmg.dcc.adimir;

public class Sculpture extends WorkArt {
    Dimension dimension;
    String material;

    public Sculpture () {}
    public Sculpture (Integer num, String authour, String name, String description, Dimension dimension) {
        super(num, authour, name, description);
        this.dimension = dimension;
    }
    public Sculpture (Integer num, String name, String authour, String description, Dimension dimension, String material) {
        super(num, name, authour, description);
        this.dimension = dimension;
        this.material = material;
    }
    public String toString() {
        String result = super.toString();
        result += "| " + dimension;
        result += String.format(" | Material: %1$-10s", material);
        return result;
    }
    public boolean equals(WorkArt wa) {
        if (getClass() != wa.getClass())
            return false;
        return ( super.equals(wa) &&
                dimension.equals( ((Sculpture)wa).dimension ) &&
                material.equals( ((Sculpture)wa).material )
                );
    }
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public Dimension getDimension() {
        return dimension;
    }
    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

}

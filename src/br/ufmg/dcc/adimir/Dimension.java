package br.ufmg.dcc.adimir;

public class Dimension {
    private Float width;
    private Float height;

    public Dimension() {}
    public Dimension(Float width, Float height) {
        this.width = width;
        this.height = height;
    }

    public boolean equals(Dimension d) {
        if (d == null)
            return false;
        return (width.equals(d.getWidth()) &&
                height.equals(d.getHeight()));
    }

    public String toString() {
        String result = String.format("Largura: %1$f| Altura: %2$f", width, height);
        return result;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

}

package br.ufmg.dcc.adimir;
/**
 * @author adimircolen
 *
 */
public class Music extends WorkArt {
    String duration;
    String mediaType;
    Integer mediaNumber;
    static String K7 = "fita";
    static String CD = "cd";
    static String VINIL = "vinil";

    public Music(Integer num, String name, String authour, String description, String duration, String mediaType, Integer mediaNumger) {
        super(num, name, authour, description);
        this.duration = duration;
        this.mediaType = mediaType;
        this.mediaNumber = mediaNumger;
    }

    public boolean equals(WorkArt wa) {
        if (getClass() != wa.getClass())
            return false;
        return ( super.equals(wa) &&
                duration.equals( ((Music)wa).getDuration() ) &&
                mediaType.equals( ((Music)wa).getMediaType() ) &&
                mediaNumber.equals( ((Music)wa).getMediaType() ) );
    }

    public String toString() {
        String result = super.toString();
        result += "| Duração: " + duration + "m";
        result += " | Media: " + mediaType;
        result += " | Faixa: " + mediaNumber;
        return result;
    }

    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public String getMediaType() {
        return mediaType;
    }
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }
    public Integer getMediaNumber() {
        return mediaNumber;
    }
    public void setMediaNumber(Integer mediaNumber) {
        this.mediaNumber = mediaNumber;
    }

}

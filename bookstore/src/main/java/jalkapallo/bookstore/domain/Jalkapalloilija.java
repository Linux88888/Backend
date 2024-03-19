package jalkapallo.bookstore.domain;

public class Jalkapalloilija {

    private Long id;
    private String etunimi;
    private String sukunimi;
    private int maalit;
    private int keltaisetKortit;
    private int punaisetKortit;

    // Oletuskonstruktori
    public Jalkapalloilija() {}

    // Getterit ja setterit
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getEtunimi() { return etunimi; }
    public void setEtunimi(String etunimi) { this.etunimi = etunimi; }
    public String getSukunimi() { return sukunimi; }
    public void setSukunimi(String sukunimi) { this.sukunimi = sukunimi; }
    public int getMaalit() { return maalit; }
    public void setMaalit(int maalit) { this.maalit = maalit; }
    public int getKeltaisetKortit() { return keltaisetKortit; }
    public void setKeltaisetKortit(int keltaisetKortit) { this.keltaisetKortit = keltaisetKortit; }
    public int getPunaisetKortit() { return punaisetKortit; }
    public void setPunaisetKortit(int punaisetKortit) { this.punaisetKortit = punaisetKortit; }
}
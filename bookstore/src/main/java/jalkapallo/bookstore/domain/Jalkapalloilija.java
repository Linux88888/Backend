package jalkapallo.bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Jalkapalloilija {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotBlank(message = "Etunimi ei saa olla tyhjä")
    @Size(min = 2, max = 30, message = "Etunimen pitää olla 2-30 merkkiä pitkä")
    private String etunimi;
    
    @NotBlank(message = "Sukunimi ei saa olla tyhjä")
    @Size(min = 2, max = 30, message = "Sukunimen pitää olla 2-30 merkkiä pitkä")
    private String sukunimi;
    
    @Min(value = 0, message = "Maalien määrän pitää olla vähintään 0")
    private int maalit;
    
    @Min(value = 0, message = "Keltaisten korttien määrän pitää olla vähintään 0")
    private int keltaisetKortit;
    
    @Min(value = 0, message = "Punaisten korttien määrän pitää olla vähintään 0")
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

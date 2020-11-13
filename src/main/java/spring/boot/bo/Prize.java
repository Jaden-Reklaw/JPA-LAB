package spring.boot.bo;

import javax.persistence.*;

@Entity
public class Prize {
    //region Properties
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @Version
    private Integer version;

    private String Match;
    private String Win;
    private String Odds;
    //endregion

    //region Constructors
    public Prize() {}
    public Prize(String match, String win, String odds) {
        this.setMatch(match);
        this.setWin(win);
        this.setOdds(odds);
    }

    //endregion

    //region Setters and Getters
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getMatch() {
        return Match;
    }

    public void setMatch(String match) {
        Match = match;
    }

    public String getWin() {
        return Win;
    }

    public void setWin(String win) {
        Win = win;
    }

    public String getOdds() {
        return Odds;
    }

    public void setOdds(String odds) {
        Odds = odds;
    }
    //endregion
}

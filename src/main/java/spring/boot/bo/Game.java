package spring.boot.bo;

import javax.persistence.*;

@Entity
public class Game {
    //region Properties
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "game_id")
    private Integer Id;

    @Version
    private Integer version;

    private String GameName;
    //endregion

    //region Constructors
    public Game() {}
    public Game(String gameName) {
        this.setGameName(gameName);
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

    public String getGameName() {
        return GameName;
    }

    public void setGameName(String gameName) {
        GameName = gameName;
    }
    //endregion
}

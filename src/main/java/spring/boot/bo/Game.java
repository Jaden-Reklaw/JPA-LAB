package spring.boot.bo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Game {
    //region Properties
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @Version
    private Integer version;

    private String GameName;

    //Create relationship One Game Many Prizes
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Prize> prizeList;

    //Created relationship Many Games Many States
    @ManyToMany(fetch = FetchType.EAGER)
    private List<State> stateList;
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

    public List<Prize> getPrizeList() {
        return prizeList;
    }

    public void setPrizeList(List<Prize> prizeList) {
        this.prizeList = prizeList;
    }

    public List<State> getStateList() {
        return stateList;
    }

    public void setStateList(List<State> stateList) {
        this.stateList = stateList;
    }
    //endregion
}

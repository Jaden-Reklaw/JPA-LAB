package spring.boot.bo;

import javax.persistence.*;
import java.util.List;

@Entity
public class State {
    //region Properties
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @Version
    private Integer version;

    private String StateName;
    private String StateInitials;

    //Created relationship Many States Many Games
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Game> gameList;
    //endregion

    //region Constructors
    public State() {}
    public State(String stateName, String stateInitials) {
        this.setStateName(stateName);
        this.setStateInitials(stateInitials);
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

    public String getStateName() {
        return StateName;
    }

    public void setStateName(String stateName) {
        StateName = stateName;
    }

    public String getStateInitials() {
        return StateInitials;
    }

    public void setStateInitials(String stateInitials) {
        StateInitials = stateInitials;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }
    //endregion

}

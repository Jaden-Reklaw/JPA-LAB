package spring.boot.bo;

import javax.persistence.*;

@Entity
public class State {
    //region Properties
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "state_id")
    private Integer Id;

    @Version
    private Integer version;

    private String StateName;
    private String StateInitials;
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
    //endregion

}

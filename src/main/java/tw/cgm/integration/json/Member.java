package tw.cgm.integration.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import tw.cgm.integration.enums.ChurchDepartment;
import tw.cgm.integration.enums.Country;

import java.util.Date;

/**
 * sample member object.
 */
public class Member {
    private long id;

    private String nameReal;

    private String nameChanged;

    private String namePassport;

    private Country country;

    private String church;

    private ChurchDepartment department;

    private Date birthday;

    private Date baptismday;

    public Member() {
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty
    public String getNameReal() {
        return nameReal;
    }

    public void setNameReal(String nameReal) {
        this.nameReal = nameReal;
    }

    @JsonProperty
    public String getNameChanged() {
        return nameChanged;
    }

    public void setNameChanged(String nameChanged) {
        this.nameChanged = nameChanged;
    }

    @JsonProperty
    public String getNamePassport() {
        return namePassport;
    }

    public void setNamePassport(String namePassport) {
        this.namePassport = namePassport;
    }

    @JsonProperty
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @JsonProperty
    public String getChurch() {
        return church;
    }

    public void setChurch(String church) {
        this.church = church;
    }

    @JsonProperty
    public ChurchDepartment getDepartment() {
        return department;
    }

    public void setDepartment(ChurchDepartment department) {
        this.department = department;
    }

    @JsonProperty
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @JsonProperty
    public Date getBaptismday() {
        return baptismday;
    }

    public void setBaptismday(Date baptismday) {
        this.baptismday = baptismday;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("nameReal", nameReal)
                .add("namePassport", namePassport)
                .toString();
    }
}

package tw.cgm.integration.model;

import tw.cgm.integration.enums.ChurchDepartment;
import tw.cgm.integration.enums.Country;

import javax.persistence.*;
import java.sql.Date;

/**
 * Member Profile Model
 */
@Entity
@Table(name = "member")
//@NamedQueries(
//        {
//                @NamedQuery(
//                        name = "tw.cgm.integration.model.MemberData.findAll",
//                        query = "SELECT * FROM member m"
//                )
//        }
//)
public class MemberData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nameReal", nullable = false)
    private String nameReal;

    @Column(name = "nameChanged", nullable = false)
    private String nameChanged;

    @Column(name = "namePassport", nullable = false)
    private String namePassport;

    @Column(name = "country", nullable = false)
    private Country country;

    @Column(name = "church", nullable = false)
    private String church;

    @Column(name = "department", nullable = false)
    private ChurchDepartment department;

    @Column(name = "birthday", nullable = false)
    private Date birthday;

    @Column(name = "baptismday", nullable = false)
    private Date baptismday;

    public MemberData() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameReal() {
        return nameReal;
    }

    public void setNameReal(String nameReal) {
        this.nameReal = nameReal;
    }

    public String getNameChanged() {
        return nameChanged;
    }

    public void setNameChanged(String nameChanged) {
        this.nameChanged = nameChanged;
    }

    public String getNamePassport() {
        return namePassport;
    }

    public void setNamePassport(String namePassport) {
        this.namePassport = namePassport;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getChurch() {
        return church;
    }

    public void setChurch(String church) {
        this.church = church;
    }

    public ChurchDepartment getDepartment() {
        return department;
    }

    public void setDepartment(ChurchDepartment department) {
        this.department = department;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getBaptismday() {
        return baptismday;
    }

    public void setBaptismday(Date baptismday) {
        this.baptismday = baptismday;
    }
}

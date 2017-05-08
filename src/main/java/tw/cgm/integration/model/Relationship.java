package tw.cgm.integration.model;

import javax.persistence.*;

/**
 * Relationship Model
 */
@Entity
@Table(name = "relationship")
//@NamedQueries(
//        {
//                @NamedQuery(
//                        name = "tw.cgm.integration.model.Relationship.findAll",
//                        query = "SELECT * FROM relationship r"
//                )
//        }
//)
public class Relationship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "relation", nullable = false)
    private String relation;

    @Column(name = "master", nullable = false)
    private long master;

    @Column(name = "slave", nullable = false)
    private long slave;

    @Column(name = "sequence")
    private int sequence;

    public Relationship() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public long getMaster() {
        return master;
    }

    public void setMaster(long master) {
        this.master = master;
    }

    public long getSlave() {
        return slave;
    }

    public void setSlave(long slave) {
        this.slave = slave;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
}

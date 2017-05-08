package tw.cgm.integration.dao;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import tw.cgm.integration.model.Relationship;

import java.util.List;
import java.util.Optional;

/**
 * Created by chonh on 5/8/2017.
 */
public class RelationshipDao extends AbstractDAO<Relationship> {
    public RelationshipDao(SessionFactory factory) {
        super(factory);
    }

    public Optional<Relationship> findById(Long id) {
        return Optional.ofNullable(get(id));
    }

    public Relationship create(Relationship mData) {
        return persist(mData);
    }

    public List<Relationship> findAll() {
        return list(namedQuery("tw.cgm.integration.model.Relationship.findAll"));
    }
}

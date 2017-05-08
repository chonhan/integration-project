package tw.cgm.integration.dao;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import tw.cgm.integration.model.MemberData;

import java.util.List;
import java.util.Optional;

/**
 * MemberData DAO
 */
public class MemberDataDao extends AbstractDAO<MemberData> {
    public MemberDataDao(SessionFactory factory) {
        super(factory);
    }

    public Optional<MemberData> findById(Long id) {
        return Optional.ofNullable(get(id));
    }

    public MemberData create(MemberData mData) {
        return persist(mData);
    }

    public List<MemberData> findAll() {
        return list(namedQuery("tw.cgm.integration.model.MemberData.findAll"));
    }
}


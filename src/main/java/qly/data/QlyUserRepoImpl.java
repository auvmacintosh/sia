package qly.data;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QlyUserRepoImpl implements QlyUserRepo {
    @Autowired
    private QlyUserMapper qlyUserMapper;

    @Override
    public QlyUser save(QlyUser unsaved) {
        return null;
    }

    @Override
    public QlyUser modify(QlyUser modified) {
        return null;
    }

    @Override
    public List<QlyUser> findUserByName(String name) {
        return null;
    }

    @Override
    public QlyUser findUserById(long id) {
        return qlyUserMapper.selectById(id);
    }

}

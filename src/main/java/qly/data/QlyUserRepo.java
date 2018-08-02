package qly.data;

import java.util.List;

public interface QlyUserRepo {

    QlyUser save(QlyUser unsaved);

    QlyUser modify(QlyUser modified);

    QlyUser findUserById(long id);
    List<QlyUser> findUserByName(String name);

}

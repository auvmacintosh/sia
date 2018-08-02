package qly.data;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface QlyUserMapper {

    @Select( "SELECT id,name FROM QlyUser WHERE id = #{userId}" )
    QlyUser selectById (@Param("userId") long id);

}

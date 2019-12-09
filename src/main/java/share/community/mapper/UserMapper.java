package share.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import share.community.model.User;

@Mapper
public interface UserMapper {
    @Insert("insert into user (name, accountId, Token, gmtCreateTime, gmtModifiedTime) values (#{name},#{accountId}, #{Token}, #{gmtCreateTime}, #{gmtModifiedTime},)")
    void insert(User user);
}

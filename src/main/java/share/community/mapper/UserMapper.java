package share.community.mapper;

import org.apache.ibatis.annotations.*;
import share.community.model.User;

@Mapper
public interface UserMapper {
    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified, avatar_Url) values (#{name},#{account_id},#{token},#{gmt_create},#{gmt_modified},#{avatarUrl})")
    void insert(User user);
    
    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);
}

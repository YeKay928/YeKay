package com.example.exam.mapper;

import com.example.exam.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    @Select("select Student_id,Student_sex,Student_pwd,Student_age,Student_name,Student_phone from student_info")
    List<User>getUserSList();
    @Select("select Student_id,Student_sex,Student_pwd,Student_age,Student_name,Student_phone\n"+
            "from student_info where Student_id='${user_name}' and Student_pwd='${user_pwd}'"
    )
    User checkSLogin(@Param("user_name")String user_name,
                    @Param("user_pwd")String user_pwd);
    @Select("select Student_name\n" +
            "from student_info\n" +
            "where Student_id='${user_name}'")
    User showSName(@Param("user_name")String user_name);
    @Select("select Teacher_id,Teacher_name,Teacher_pwd,Teacher_age,Teacher_sex,Teacher_phone\n" +
            "from teacher_info")
    List<User>getUserTList();
    @Select("select Teacher_id,Teacher_sex,Teacher_pwd,Teacher_age,Teacher_name,Teacher_phone\n"+
            "from teacher_info where Teacher_id='${user_name}' and Teacher_pwd='${user_pwd}'"
    )
    User checkTLogin(@Param("user_name")String user_name,
                     @Param("user_pwd")String user_pwd);
    @Select("select Teacher_name\n" +
            "from teacher_info\n" +
            "where Teacher_id='${user_name}'")
    User showTName(@Param("user_name")String user_name);
    @Select("select admin_id,admin_pwd\n"+
            "from admin_info where admin_id='${user_name}' and admin_pwd='${user_pwd}'"
    )
    User checkALogin(@Param("user_name")String user_name,
                     @Param("user_pwd")String user_pwd);
    @Insert("INSERT into student_info(Student_id,Student_name,Student_pwd,Student_sex,Student_age,Student_phone) \n" +
            "VALUES('user_id','user_name','user_pwd','user_sex','user_age','user_phone')")
    int insertSUser(@Param("user_id")String user_id,
                    @Param("user_name")String user_name,
                    @Param("user_pwd")String user_pwd,
                    @Param("user_sex")String user_sex,
                    @Param("user_age")String user_age,
                    @Param("user_phone")String user_phone);
    @Insert("INSERT into teacher_info(Teacher_id,Teacher_name,Teacher_pwd,Teacher_sex,Teacher_age,Teacher_phone) \n" +
            "VALUES('${user_id}','${user_name}','${user_pwd}','${user_sex}','${user_age}','${user_phone}')")
    int insertTUser(@Param("user_id")String user_id,
                    @Param("user_name")String user_name,
                    @Param("user_pwd")String user_pwd,
                    @Param("user_sex")String user_sex,
                    @Param("user_age")String user_age,
                    @Param("user_phone")String user_phone);

}

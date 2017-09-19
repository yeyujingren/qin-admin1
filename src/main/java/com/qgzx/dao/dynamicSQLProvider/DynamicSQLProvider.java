package com.qgzx.dao.dynamicSQLProvider;

import org.apache.ibatis.jdbc.SQL;

import com.qgzx.entity.BringInfo;
/**
 * 提供动态SQL
 * 
 * @author zhangzhengan
 * @version  
 * @since JDK 1.7
 */
public class DynamicSQLProvider {
	public String update(BringInfo bringInfo){
        return new SQL() {
        	{  
                UPDATE("bringInfo");
                if (bringInfo.getName()!= null)  
                {  
                    SET("name = #{bringInfo.name}");  
                }  
                if (bringInfo.getLocation() != null)  
                {  
                    SET("location = #{bringInfo.location}");  
                }  
                if (bringInfo.getNeed() != null)  
                {  
                    SET("need = #{bringInfo.need}");  
                }  
                if (bringInfo.getPay() != null)  
                {  
                    SET("pay = #{bringInfo.pay}");  
                }  
                if (bringInfo.getPeople() != null)  
                {  
                    SET("people = #{bringInfo.people}");  
                }  
                if (bringInfo.getPlace() != null)  
                {  
                    SET("place = #{bringInfo.place}");  
                }  
                if (bringInfo.getSex() != null)  
                {  
                    SET("sex = #{bringInfo.sex}");  
                }  
                if (bringInfo.getTime() != null)  
                {  
                    SET("time = NOW()");  
                }  
                if (bringInfo.getTitle()!= null)  
                {  
                    SET("title = #{bringInfo.title}");  
                }  
                if (bringInfo.getType()!= null)  
                {  
                    SET("type = #{bringInfo.type}");  
                }  
                if (bringInfo.getWorkplace()!= null)  
                {  
                    SET("workplace = #{bringInfo.workplace}");  
                }  
                if (bringInfo.getWorktime()!= null)  
                {  
                    SET("worktime = #{bringInfo.worktime}");  
                }  
                if (bringInfo.getDeadline()!= null)  
                {  
                    SET("deadline = #{bringInfo.deadline}");  
                }  
                if (bringInfo.getGrade()!= null)  
                {  
                    SET("grade = #{bringInfo.grade}");  
                }
                
                WHERE("id = #{bringInfo.id}");  
            }  
        }.toString();
                
    }
}

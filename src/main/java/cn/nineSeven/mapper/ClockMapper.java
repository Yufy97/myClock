package cn.nineSeven.mapper;

import cn.nineSeven.entity.pojo.Clock;
import cn.nineSeven.entity.vo.ClockInfoVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * (Clock)表数据库访问层
 *
 * @author makejava
 * @since 2023-03-14 16:02:03
 */
public interface ClockMapper extends BaseMapper<Clock> {
    @Select("select nickname, avatar, status, begin_time, total_duration, target_duration\n" +
            "from user left join clock on user.id = clock.id\n" +
            "where grade = #{grade} and clock.del_flag = 0\n" +
            "order by total_duration DESC\n" +
            "limit #{pageNum}, #{pageSize}")
    List<ClockInfoVo> selectAllClock(@Param("grade") Integer grade, @Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
}


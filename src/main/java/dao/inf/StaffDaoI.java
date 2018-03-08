package dao.inf;

import pojo.StaffEntity;

import java.util.List;
import java.util.Map;

/**
 * @author Jiang
 */
public interface StaffDaoI {

    /**
     *
     * @return staffEntityList
     */
    List<StaffEntity> getAllStaff();

    /**
     *
     * @param conditions
     * @param equalCondition
     * @return staffEntityList
     */
    List<StaffEntity> findAllStaffByConditions(Map<String,Object> conditions, Boolean... equalCondition);
    //这是一种进阶写法，可以传两个参数覆盖多变的筛选条件
}

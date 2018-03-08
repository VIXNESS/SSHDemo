package service.intf;

import pojo.StaffEntity;

import java.util.List;

/**
 * @author Jiang
 */
public interface StaffServiceI {
    /**
     *
     * @return A list consisting all staffs
     */
    List<StaffEntity> getAllStaff();
}

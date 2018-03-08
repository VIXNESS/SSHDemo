package service.impl;

import dao.inf.StaffDaoI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import pojo.StaffEntity;
import service.intf.StaffServiceI;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Jiang
 */
@Service(value = "staffService")
public class StaffServiceImp implements StaffServiceI {
    private StaffDaoI staffDaoI;//DAO interface used
    //private otherDaoI otherDaoI;

    @Resource(name = "staffDao")//It matches the @Repository annotations in DAO implement
    public void setStaffDaoI(StaffDaoI staffDaoI) {
        this.staffDaoI = staffDaoI;
    }

    @Override
    @Transactional(readOnly = true,isolation = Isolation.READ_COMMITTED)
    //if it's a insert or update method, readOnly = false
    public List<StaffEntity> getAllStaff() {
        return staffDaoI.getAllStaff();
    }
}

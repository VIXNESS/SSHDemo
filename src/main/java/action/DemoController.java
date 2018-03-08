package action;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import pojo.StaffEntity;
import service.intf.StaffServiceI;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

import static com.opensymphony.xwork2.Action.SUCCESS;

@Namespace("/staff")
@ParentPackage("project-default")//It matches the package name in struts.xml
@Controller
@Scope(value = "prototype")
public class DemoController extends ActionSupport implements SessionAware {
    private StaffServiceI staffServiceI;
    private String rsp;//It's used by json transportation
    private Map<String,Object> session;//used to access to sessions
    @Resource(name = "staffService")//It must match @Service in the service implement
    public void setStaffServiceI(StaffServiceI staffServiceI) {
        this.staffServiceI = staffServiceI;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String getRsp() {
        return rsp;
    }

    public void setRsp(String rsp) {
        this.rsp = rsp;
    }


    @Action(value = "getAll", results = @Result(type = "json",params={"root","rsp"}))
    public String getAllStaff(){
        List<StaffEntity> staffEntityList = staffServiceI.getAllStaff();
        rsp = JSON.toJSONString(staffEntityList); //json transportation
        return SUCCESS;
    }

}

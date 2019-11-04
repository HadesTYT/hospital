package com.aaa.controller;

import com.aaa.entity.Baoque;
import com.aaa.entity.Ypharmacy;
import com.aaa.service.PharmacyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("pharmacy")
public class PharmacyController {
    @Autowired
    private   PharmacyService pharmacyService;

    //查询药品仓库
    @RequestMapping("selectpharmacy")
    @ResponseBody
    public Object selectpharmary(Ypharmacy ypharmacy, Integer page, Integer limit) {
        System.out.print("进去查询药房方法");
        PageHelper.startPage(page, limit);
        List<Ypharmacy> drugstores = pharmacyService.selpharmacy(ypharmacy);
        PageInfo pageInfo = new PageInfo(drugstores);
        Map<String, Object> drugstoresData = new HashMap<String, Object>();
        //这是layui要求返回的json数据格式
        drugstoresData.put("code", 0);
        drugstoresData.put("msg", "");
        //将全部数据的条数作为count传给前台（一共多少条）
        drugstoresData.put("count", pageInfo.getTotal());
        //将分页后的数据返回（每页要显示的数据）
        drugstoresData.put("data", pageInfo.getList());
        return drugstoresData;
    }
    //添加一条药品采到报缺单
    @RequestMapping("addbaoque")
    @ResponseBody
    public Integer addbaoque( Baoque baoque) {
        Integer selbaoqueName = pharmacyService.selbaoqueName(baoque);
        if(selbaoqueName==0){
            int addbaoque =pharmacyService.addbaoque(baoque);
            return addbaoque;
        }else {
            int upbaoquenum = pharmacyService.upbaoquenum(baoque);
            return upbaoquenum;
        }

    }
}

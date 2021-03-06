package cn.iselab.inventory.site.web.data.wrapper;

import cn.iselab.inventory.site.model.PurchaseOrder;
import cn.iselab.inventory.site.service.CustomService;
import cn.iselab.inventory.site.web.data.PurchaseOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午6:02 2017/12/5
 * @Modified By:
 */
@Service
public class PurchaseOrderVOWrapper extends BaseWrapper<PurchaseOrderVO,PurchaseOrder>{

    @Autowired
    CustomService customService;

    @Override
    public PurchaseOrderVO wrap(PurchaseOrder order){
        PurchaseOrderVO vo=new PurchaseOrderVO();
        vo.setExtra(order.getExtra());
        vo.setNumber(order.getNumber());
        vo.setOperator(order.getOperator());
        vo.setRepository(order.getRepository());
        vo.setStatus(order.getStatus());
        vo.setCreateTime(order.getCreateTime().getTime());
        vo.setCustomId(order.getSupplier());
        vo.setSupplier(customService.getCustom(order.getSupplier()).getName());
        vo.setTotal(order.getTotal());
        vo.setType(order.isType());
        return vo;
    }

    @Override
    public PurchaseOrder unwrap(PurchaseOrderVO vo){
        PurchaseOrder order=new PurchaseOrder();
        order.setOperator(vo.getOperator());
        order.setRepository(vo.getRepository());
        order.setSupplier(vo.getCustomId());
        order.setExtra(vo.getExtra());
        order.setTotal(vo.getTotal());
        order.setType(vo.getType());
        return order;
    }
}

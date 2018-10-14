package com.imooc.api;

import com.googlecode.jsonrpc4j.JsonRpcService;
import com.imooc.api.domain.ParamInf;
import com.imooc.api.domain.ProductRpcReq;
import com.imooc.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 产品相关的rpc服务
 */
@JsonRpcService("/products")
public interface ProductRpc {
    /**
     * 查询多个产品
     *接口参数经常变化的，则传入请求对象即可
     * 那样增加字段，修改请求参数对象就ok了
     * @param req
     * @return
     */
    List<Product> query(ParamInf req);
    //Page<Product> query(ProductRpc req);
    /**
     * 查询单个产品
     *
     * @param id
     * @return
     */
    Product findOne(String id);
}

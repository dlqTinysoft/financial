package com.imooc.manager.configuration;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImplExporter;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 董乐强 on 2018/10/14.
 * rpc相关配置
 */
@Configuration
public class RpcConfiguration {

    public AutoJsonRpcServiceImplExporter rpcServiceImplExporter(){
        return new AutoJsonRpcServiceImplExporter();
    }
}

package junmeng.config;

import junmeng.common.IUserService;
import junmeng.common.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.remoting.support.RemoteExporter;

/**
 * @author james
 * @date 2020/3/23
 */
@Configuration
public class RmiConfig {

    /**
     * 将userService暴露为远程服务
     * @return
     */
    @Bean
    RemoteExporter registerRMIExporter() {
        RmiServiceExporter exporter = new RmiServiceExporter();
        //这里的服务名必须和客户端调用协议rmi://hostname:1199/*** 的***相同
        exporter.setServiceName("userRmiService");
        exporter.setServiceInterface(IUserService.class);
        exporter.setService(new UserService());
        //端口号，默认为1099
        exporter.setRegistryPort(1199);
        return exporter;
    }

}

package com.yy.hiidostatis.message.provider;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.message.MessageMonitor;
import com.yy.hiidostatis.message.monitor.MessageMonitorImpl;
import com.yy.hiidostatis.provider.MessageConfig;
import com.yy.hiidostatis.provider.Provider;
/* loaded from: classes8.dex */
public class MessageMonitorProvider implements Provider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MessageMonitor monitor;

    public MessageMonitorProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.yy.hiidostatis.provider.Provider
    public MessageMonitor generate(MessageConfig messageConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, messageConfig)) == null) {
            MessageMonitor messageMonitor = this.monitor;
            if (messageMonitor != null) {
                return messageMonitor;
            }
            synchronized (this) {
                if (this.monitor != null) {
                    return this.monitor;
                }
                MessageMonitorImpl messageMonitorImpl = new MessageMonitorImpl(messageConfig);
                this.monitor = messageMonitorImpl;
                return messageMonitorImpl;
            }
        }
        return (MessageMonitor) invokeL.objValue;
    }
}

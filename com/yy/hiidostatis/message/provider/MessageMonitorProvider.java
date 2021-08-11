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
/* loaded from: classes10.dex */
public class MessageMonitorProvider implements Provider<MessageMonitor> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MessageMonitor monitor;

    public MessageMonitorProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
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

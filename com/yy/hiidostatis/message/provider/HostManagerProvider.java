package com.yy.hiidostatis.message.provider;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.message.HostManager;
import com.yy.hiidostatis.message.sender.HostInfo;
import com.yy.hiidostatis.provider.MessageConfig;
import com.yy.hiidostatis.provider.Provider;
/* loaded from: classes10.dex */
public class HostManagerProvider implements Provider<HostManager> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HostInfo hostInfo;

    public HostManagerProvider() {
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
    public HostManager generate(MessageConfig messageConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, messageConfig)) == null) {
            HostInfo hostInfo = this.hostInfo;
            if (hostInfo != null) {
                return hostInfo;
            }
            synchronized (this) {
                if (this.hostInfo != null) {
                    return this.hostInfo;
                }
                HostInfo hostInfo2 = new HostInfo();
                this.hostInfo = hostInfo2;
                return hostInfo2;
            }
        }
        return (HostManager) invokeL.objValue;
    }
}

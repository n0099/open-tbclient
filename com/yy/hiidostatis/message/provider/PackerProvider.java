package com.yy.hiidostatis.message.provider;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.message.MessageMonitor;
import com.yy.hiidostatis.message.Packer;
import com.yy.hiidostatis.message.hiidoapi.MessagePacker;
import com.yy.hiidostatis.provider.GlobalProvider;
import com.yy.hiidostatis.provider.MessageConfig;
import com.yy.hiidostatis.provider.Provider;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class PackerProvider implements Provider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap caches;

    public PackerProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.caches = new ConcurrentHashMap();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.yy.hiidostatis.provider.Provider
    public Packer generate(MessageConfig messageConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, messageConfig)) == null) {
            Packer packer = (Packer) this.caches.get(messageConfig.getAppkey());
            if (packer != null) {
                return packer;
            }
            synchronized (this) {
                Packer packer2 = (Packer) this.caches.get(messageConfig.getAppkey());
                if (packer2 != null) {
                    return packer2;
                }
                MessagePacker messagePacker = new MessagePacker(messageConfig, (MessageMonitor) GlobalProvider.instance.get(MessageMonitor.class, messageConfig));
                this.caches.put(messageConfig.getAppkey(), messagePacker);
                return messagePacker;
            }
        }
        return (Packer) invokeL.objValue;
    }
}

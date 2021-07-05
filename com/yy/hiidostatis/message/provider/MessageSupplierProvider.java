package com.yy.hiidostatis.message.provider;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.implementation.TaskDataSqLiteCacheManager;
import com.yy.hiidostatis.message.MessageMonitor;
import com.yy.hiidostatis.message.MessageSupplier;
import com.yy.hiidostatis.message.storage.MessageSupplierProxy;
import com.yy.hiidostatis.provider.GlobalProvider;
import com.yy.hiidostatis.provider.MessageConfig;
import com.yy.hiidostatis.provider.Provider;
/* loaded from: classes8.dex */
public class MessageSupplierProvider implements Provider<MessageSupplier> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MessageSupplier cache;

    public MessageSupplierProvider() {
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
    public MessageSupplier generate(MessageConfig messageConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, messageConfig)) == null) {
            MessageSupplier messageSupplier = this.cache;
            if (messageSupplier != null) {
                return messageSupplier;
            }
            synchronized (this) {
                if (this.cache != null) {
                    return this.cache;
                }
                MessageSupplierProxy messageSupplierProxy = new MessageSupplierProxy(messageConfig.getApplicationContext(), messageConfig, (TaskDataSqLiteCacheManager) GlobalProvider.instance.get(TaskDataSqLiteCacheManager.class, messageConfig), (MessageMonitor) GlobalProvider.instance.get(MessageMonitor.class, messageConfig));
                this.cache = messageSupplierProxy;
                return messageSupplierProxy;
            }
        }
        return (MessageSupplier) invokeL.objValue;
    }
}

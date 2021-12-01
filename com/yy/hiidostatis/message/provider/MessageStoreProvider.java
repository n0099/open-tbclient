package com.yy.hiidostatis.message.provider;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.implementation.TaskDataSqLiteCacheManager;
import com.yy.hiidostatis.message.MessageStore;
import com.yy.hiidostatis.message.storage.MessageStoreProxy;
import com.yy.hiidostatis.provider.GlobalProvider;
import com.yy.hiidostatis.provider.MessageConfig;
import com.yy.hiidostatis.provider.Provider;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class MessageStoreProvider implements Provider<MessageStore> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<String, MessageStore> caches;

    public MessageStoreProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.caches = new ConcurrentHashMap<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.yy.hiidostatis.provider.Provider
    public MessageStore generate(MessageConfig messageConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, messageConfig)) == null) {
            MessageStore messageStore = this.caches.get(messageConfig.getAppkey());
            if (messageStore != null) {
                return messageStore;
            }
            synchronized (this) {
                MessageStore messageStore2 = this.caches.get(messageConfig.getAppkey());
                if (messageStore2 != null) {
                    return messageStore2;
                }
                MessageStoreProxy messageStoreProxy = new MessageStoreProxy(messageConfig.getApplicationContext(), (TaskDataSqLiteCacheManager) GlobalProvider.instance.get(TaskDataSqLiteCacheManager.class, messageConfig));
                this.caches.put(messageConfig.getCacheFileName(), messageStoreProxy);
                return messageStoreProxy;
            }
        }
        return (MessageStore) invokeL.objValue;
    }
}

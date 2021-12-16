package com.yy.hiidostatis.message.provider;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.implementation.TaskDataSqLiteCacheManager;
import com.yy.hiidostatis.message.MessageMonitor;
import com.yy.hiidostatis.provider.GlobalProvider;
import com.yy.hiidostatis.provider.MessageConfig;
import com.yy.hiidostatis.provider.Provider;
/* loaded from: classes4.dex */
public class CacheManagerProvider implements Provider<TaskDataSqLiteCacheManager> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TaskDataSqLiteCacheManager cache;

    public CacheManagerProvider() {
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
    public TaskDataSqLiteCacheManager generate(MessageConfig messageConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, messageConfig)) == null) {
            TaskDataSqLiteCacheManager taskDataSqLiteCacheManager = this.cache;
            if (taskDataSqLiteCacheManager != null) {
                return taskDataSqLiteCacheManager;
            }
            synchronized (this) {
                if (this.cache != null) {
                    return this.cache;
                }
                TaskDataSqLiteCacheManager taskDataSqLiteCacheManager2 = new TaskDataSqLiteCacheManager(messageConfig.getApplicationContext(), messageConfig.getCacheFileName(), (MessageMonitor) GlobalProvider.instance.get(MessageMonitor.class, messageConfig));
                this.cache = taskDataSqLiteCacheManager2;
                return taskDataSqLiteCacheManager2;
            }
        }
        return (TaskDataSqLiteCacheManager) invokeL.objValue;
    }
}

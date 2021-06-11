package com.yy.hiidostatis.message.provider;

import com.yy.hiidostatis.inner.implementation.TaskDataSqLiteCacheManager;
import com.yy.hiidostatis.message.MessageMonitor;
import com.yy.hiidostatis.provider.GlobalProvider;
import com.yy.hiidostatis.provider.MessageConfig;
import com.yy.hiidostatis.provider.Provider;
/* loaded from: classes7.dex */
public class CacheManagerProvider implements Provider<TaskDataSqLiteCacheManager> {
    public TaskDataSqLiteCacheManager cache;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.yy.hiidostatis.provider.Provider
    public TaskDataSqLiteCacheManager generate(MessageConfig messageConfig) {
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
}

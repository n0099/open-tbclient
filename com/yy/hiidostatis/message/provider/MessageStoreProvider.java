package com.yy.hiidostatis.message.provider;

import com.yy.hiidostatis.inner.implementation.TaskDataSqLiteCacheManager;
import com.yy.hiidostatis.message.MessageStore;
import com.yy.hiidostatis.message.storage.MessageStoreProxy;
import com.yy.hiidostatis.provider.GlobalProvider;
import com.yy.hiidostatis.provider.MessageConfig;
import com.yy.hiidostatis.provider.Provider;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class MessageStoreProvider implements Provider<MessageStore> {
    public ConcurrentHashMap<String, MessageStore> caches = new ConcurrentHashMap<>();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.yy.hiidostatis.provider.Provider
    public MessageStore generate(MessageConfig messageConfig) {
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
}

package com.yy.hiidostatis.message.provider;

import com.yy.hiidostatis.inner.implementation.TaskDataSqLiteCacheManager;
import com.yy.hiidostatis.message.MessageMonitor;
import com.yy.hiidostatis.message.MessageSupplier;
import com.yy.hiidostatis.message.storage.MessageSupplierProxy;
import com.yy.hiidostatis.provider.GlobalProvider;
import com.yy.hiidostatis.provider.MessageConfig;
import com.yy.hiidostatis.provider.Provider;
/* loaded from: classes10.dex */
public class MessageSupplierProvider implements Provider<MessageSupplier> {
    public MessageSupplier cache;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.yy.hiidostatis.provider.Provider
    public MessageSupplier generate(MessageConfig messageConfig) {
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
}

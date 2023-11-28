package com.yy.hiidostatis.message.provider;

import com.yy.hiidostatis.message.MessageMonitor;
import com.yy.hiidostatis.message.Packer;
import com.yy.hiidostatis.message.hiidoapi.MessagePacker;
import com.yy.hiidostatis.provider.GlobalProvider;
import com.yy.hiidostatis.provider.MessageConfig;
import com.yy.hiidostatis.provider.Provider;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class PackerProvider implements Provider<Packer> {
    public ConcurrentHashMap<String, Packer> caches = new ConcurrentHashMap<>();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.yy.hiidostatis.provider.Provider
    public Packer generate(MessageConfig messageConfig) {
        Packer packer = this.caches.get(messageConfig.getAppkey());
        if (packer != null) {
            return packer;
        }
        synchronized (this) {
            Packer packer2 = this.caches.get(messageConfig.getAppkey());
            if (packer2 != null) {
                return packer2;
            }
            MessagePacker messagePacker = new MessagePacker(messageConfig, (MessageMonitor) GlobalProvider.instance.get(MessageMonitor.class, messageConfig));
            this.caches.put(messageConfig.getAppkey(), messagePacker);
            return messagePacker;
        }
    }
}

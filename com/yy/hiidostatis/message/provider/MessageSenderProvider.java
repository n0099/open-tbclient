package com.yy.hiidostatis.message.provider;

import com.yy.hiidostatis.message.AppInfo;
import com.yy.hiidostatis.message.HostManager;
import com.yy.hiidostatis.message.MessageSender;
import com.yy.hiidostatis.message.sender.OKSender;
import com.yy.hiidostatis.provider.GlobalProvider;
import com.yy.hiidostatis.provider.MessageConfig;
import com.yy.hiidostatis.provider.Provider;
/* loaded from: classes2.dex */
public class MessageSenderProvider implements Provider<MessageSender> {
    public MessageSender sender;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.yy.hiidostatis.provider.Provider
    public MessageSender generate(MessageConfig messageConfig) {
        MessageSender messageSender = this.sender;
        if (messageSender != null) {
            return messageSender;
        }
        synchronized (this) {
            if (this.sender != null) {
                return this.sender;
            }
            OKSender oKSender = new OKSender((HostManager) GlobalProvider.instance.get(HostManager.class, messageConfig), (AppInfo) GlobalProvider.instance.get(AppInfo.class, messageConfig));
            this.sender = oKSender;
            return oKSender;
        }
    }
}

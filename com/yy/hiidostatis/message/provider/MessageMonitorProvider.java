package com.yy.hiidostatis.message.provider;

import com.yy.hiidostatis.message.MessageMonitor;
import com.yy.hiidostatis.message.monitor.MessageMonitorImpl;
import com.yy.hiidostatis.provider.MessageConfig;
import com.yy.hiidostatis.provider.Provider;
/* loaded from: classes8.dex */
public class MessageMonitorProvider implements Provider<MessageMonitor> {
    public MessageMonitor monitor;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.yy.hiidostatis.provider.Provider
    public MessageMonitor generate(MessageConfig messageConfig) {
        MessageMonitor messageMonitor = this.monitor;
        if (messageMonitor != null) {
            return messageMonitor;
        }
        synchronized (this) {
            if (this.monitor != null) {
                return this.monitor;
            }
            MessageMonitorImpl messageMonitorImpl = new MessageMonitorImpl(messageConfig);
            this.monitor = messageMonitorImpl;
            return messageMonitorImpl;
        }
    }
}

package com.yy.hiidostatis.message.provider;

import com.yy.hiidostatis.message.HostManager;
import com.yy.hiidostatis.message.sender.HostInfo;
import com.yy.hiidostatis.provider.MessageConfig;
import com.yy.hiidostatis.provider.Provider;
/* loaded from: classes9.dex */
public class HostManagerProvider implements Provider<HostManager> {
    public HostInfo hostInfo;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.yy.hiidostatis.provider.Provider
    public HostManager generate(MessageConfig messageConfig) {
        HostInfo hostInfo = this.hostInfo;
        if (hostInfo != null) {
            return hostInfo;
        }
        synchronized (this) {
            if (this.hostInfo != null) {
                return this.hostInfo;
            }
            HostInfo hostInfo2 = new HostInfo();
            this.hostInfo = hostInfo2;
            return hostInfo2;
        }
    }
}

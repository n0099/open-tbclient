package org.chromium.net;

import java.net.InetAddress;
import java.util.List;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
@JNINamespace("net::android")
/* loaded from: classes2.dex */
public class DnsStatus {
    public final List<InetAddress> mDnsServers;
    public final boolean mPrivateDnsActive;
    public final String mPrivateDnsServerName;

    public DnsStatus(List<InetAddress> list, boolean z, String str) {
        this.mDnsServers = list;
        this.mPrivateDnsActive = z;
        this.mPrivateDnsServerName = str == null ? "" : str;
    }

    @CalledByNative
    public byte[][] getDnsServers() {
        byte[][] bArr = new byte[this.mDnsServers.size()];
        for (int i = 0; i < this.mDnsServers.size(); i++) {
            bArr[i] = this.mDnsServers.get(i).getAddress();
        }
        return bArr;
    }

    @CalledByNative
    public boolean getPrivateDnsActive() {
        return this.mPrivateDnsActive;
    }

    @CalledByNative
    public String getPrivateDnsServerName() {
        return this.mPrivateDnsServerName;
    }
}

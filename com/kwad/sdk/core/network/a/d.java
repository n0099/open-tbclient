package com.kwad.sdk.core.network.a;

import android.text.TextUtils;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;
import okhttp3.Dns;
/* loaded from: classes10.dex */
public final class d implements Dns {
    public static final Dns SYSTEM = Dns.SYSTEM;

    @Override // okhttp3.Dns
    public final List<InetAddress> lookup(String str) {
        String fo = com.kwad.sdk.ip.direct.a.fo(str);
        if (!TextUtils.isEmpty(fo)) {
            List<InetAddress> asList = Arrays.asList(InetAddress.getAllByName(fo));
            if (asList != null && !asList.isEmpty()) {
                com.kwad.sdk.core.e.c.d("IpDirect_OkHttpDns", "inetAddresses:" + asList);
                return asList;
            }
            return SYSTEM.lookup(str);
        }
        com.kwad.sdk.core.e.c.d("IpDirect_OkHttpDns", "Dns.SYSTEM.lookup(hostname):" + Dns.SYSTEM.lookup(str));
        return SYSTEM.lookup(str);
    }
}

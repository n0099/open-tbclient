package com.kwad.sdk.core.network.kwai;

import android.text.TextUtils;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;
import okhttp3.Dns;
/* loaded from: classes5.dex */
public final class c implements Dns {
    public static final Dns a = Dns.SYSTEM;

    @Override // okhttp3.Dns
    public final List<InetAddress> lookup(String str) {
        String a2 = com.kwad.sdk.f.kwai.a.a(str);
        if (TextUtils.isEmpty(a2)) {
            com.kwad.sdk.core.d.b.a("IpDirect_OkHttpDns", "Dns.SYSTEM.lookup(hostname):" + Dns.SYSTEM.lookup(str));
        } else {
            List<InetAddress> asList = Arrays.asList(InetAddress.getAllByName(a2));
            if (asList != null && !asList.isEmpty()) {
                com.kwad.sdk.core.d.b.a("IpDirect_OkHttpDns", "inetAddresses:" + asList);
                return asList;
            }
        }
        return a.lookup(str);
    }
}

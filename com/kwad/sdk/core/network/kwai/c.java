package com.kwad.sdk.core.network.kwai;

import android.text.TextUtils;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;
import okhttp3.Dns;
/* loaded from: classes7.dex */
public final class c implements Dns {
    public static final Dns SYSTEM = Dns.SYSTEM;

    @Override // okhttp3.Dns
    public final List lookup(String str) {
        String dj = com.kwad.sdk.ip.direct.a.dj(str);
        if (TextUtils.isEmpty(dj)) {
            com.kwad.sdk.core.e.b.d("IpDirect_OkHttpDns", "Dns.SYSTEM.lookup(hostname):" + Dns.SYSTEM.lookup(str));
        } else {
            List asList = Arrays.asList(InetAddress.getAllByName(dj));
            if (asList != null && !asList.isEmpty()) {
                com.kwad.sdk.core.e.b.d("IpDirect_OkHttpDns", "inetAddresses:" + asList);
                return asList;
            }
        }
        return SYSTEM.lookup(str);
    }
}

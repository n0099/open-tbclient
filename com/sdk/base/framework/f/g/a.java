package com.sdk.base.framework.f.g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f35763a = "com.sdk.base.framework.f.g.a";

    /* renamed from: b  reason: collision with root package name */
    public static final Boolean f35764b = Boolean.valueOf(com.sdk.base.framework.c.f.f35733b);

    public static c a(Context context) {
        c cVar = c.f35767c;
        if (context == null) {
            return cVar;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                String typeName = activeNetworkInfo.getTypeName();
                if ("MOBILE".equalsIgnoreCase(typeName)) {
                    cVar = c.f35766b;
                } else if (CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING.equalsIgnoreCase(typeName)) {
                    cVar = c.f35765a;
                }
            }
        } catch (Throwable th) {
            com.sdk.base.framework.a.a.c.b(f35763a, th.getMessage(), f35764b);
        }
        return cVar;
    }

    public static void a() {
    }
}

package com.sdk.base.framework.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import java.net.HttpURLConnection;
import java.net.URL;
@SuppressLint({"NewApi"})
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7601a = a.class.getName();
    private static Boolean b = Boolean.valueOf(com.sdk.base.framework.c.f.b);
    private static ConnectivityManager.NetworkCallback d;
    private HttpURLConnection c;

    public a(Context context, URL url) {
        try {
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            builder.addCapability(12);
            builder.addTransportType(0);
            NetworkRequest build = builder.build();
            d = new b(this, url);
            ((ConnectivityManager) context.getSystemService("connectivity")).requestNetwork(build, d);
        } catch (Exception e) {
            com.sdk.base.framework.a.a.c.b(f7601a, e.toString(), b);
        }
    }

    public final HttpURLConnection a() {
        c cVar = new c(this, 2000L);
        while (!cVar.a()) {
            if (this.c != null) {
                return this.c;
            }
        }
        return null;
    }
}

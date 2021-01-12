package com.sdk.base.framework.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import java.net.HttpURLConnection;
import java.net.URL;
@SuppressLint({"NewApi"})
/* loaded from: classes14.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12763a = a.class.getName();

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f12764b = Boolean.valueOf(com.sdk.base.framework.c.f.f12819b);
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
            com.sdk.base.framework.a.a.c.b(f12763a, e.toString(), f12764b);
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

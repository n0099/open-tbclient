package com.sdk.base.framework.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import java.net.HttpURLConnection;
import java.net.URL;
@SuppressLint({"NewApi"})
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f39220a = "com.sdk.base.framework.a.a";

    /* renamed from: b  reason: collision with root package name */
    public static Boolean f39221b = Boolean.valueOf(com.sdk.base.framework.c.f.f39341b);

    /* renamed from: d  reason: collision with root package name */
    public static ConnectivityManager.NetworkCallback f39222d;

    /* renamed from: c  reason: collision with root package name */
    public HttpURLConnection f39223c;

    public a(Context context, URL url) {
        try {
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            builder.addCapability(12);
            builder.addTransportType(0);
            NetworkRequest build = builder.build();
            b bVar = new b(this, url);
            f39222d = bVar;
            ((ConnectivityManager) context.getSystemService("connectivity")).requestNetwork(build, bVar);
        } catch (Exception e2) {
            com.sdk.base.framework.a.a.c.b(f39220a, e2.toString(), f39221b);
        }
    }

    public final HttpURLConnection a() {
        c cVar = new c(this, 2000L);
        while (!cVar.a()) {
            HttpURLConnection httpURLConnection = this.f39223c;
            if (httpURLConnection != null) {
                return httpURLConnection;
            }
        }
        return null;
    }
}

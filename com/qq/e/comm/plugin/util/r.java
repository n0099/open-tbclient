package com.qq.e.comm.plugin.util;

import android.net.http.SslError;
/* loaded from: classes15.dex */
public class r {
    public static void a(SslError sslError) {
        if (sslError == null || !as.d()) {
            return;
        }
        com.qq.e.comm.plugin.y.d dVar = new com.qq.e.comm.plugin.y.d();
        dVar.a("sslError", sslError.toString());
        com.qq.e.comm.plugin.y.u.a(90032, 0, null, dVar);
    }
}

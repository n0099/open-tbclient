package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import java.net.HttpURLConnection;
/* loaded from: classes3.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    public HttpURLConnection f13849a = null;

    /* renamed from: b  reason: collision with root package name */
    public boolean f13850b = false;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f13851a = new a("CONN_WIFI", 0);

        /* renamed from: b  reason: collision with root package name */
        public static final a f13852b = new a("CONN_CMWAP", 1);
        public static final a c = new a("CONN_CMNET", 2);
        public static final a d = new a("CONN_NONE", 3);

        static {
            a aVar = f13851a;
            a aVar2 = f13852b;
            a aVar3 = c;
            a aVar4 = d;
        }

        public a(String str, int i) {
        }
    }

    public static String a(Context context) {
        return Build.VERSION.SDK_INT >= 14 ? System.getProperty("http.proxyHost") : Proxy.getHost(context);
    }

    public static int b(Context context) {
        if (Build.VERSION.SDK_INT >= 14) {
            try {
                return Integer.parseInt(System.getProperty("http.proxyPort"));
            } catch (NumberFormatException e) {
                return -1;
            }
        }
        return Proxy.getPort(context);
    }
}

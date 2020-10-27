package com.sdk.base.framework.f.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import com.baidubce.http.Headers;
import com.sdk.base.framework.c.f;
import com.sdk.base.framework.f.h.c;
import com.sdk.base.module.manager.SDKManager;
import java.net.HttpURLConnection;
/* loaded from: classes16.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4495a = a.class.getName();
    private static final Boolean b = Boolean.valueOf(f.b);

    static {
        c.c.a();
    }

    @SuppressLint({"DefaultLocale", "NewApi"})
    public static String a(Context context) {
        String userAgent = SDKManager.getUserAgent();
        if (com.sdk.base.framework.a.a.c.a(userAgent).booleanValue()) {
            if (context != null) {
                try {
                    userAgent = b(context);
                } catch (Throwable th) {
                }
            }
            return com.sdk.base.framework.a.a.c.a(userAgent).booleanValue() ? "Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 %sSafari/533.1" : userAgent;
        }
        return userAgent;
    }

    public static boolean a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return false;
        }
        String headerField = httpURLConnection.getHeaderField("Accept-Ranges");
        if (com.sdk.base.framework.a.a.c.b(headerField).booleanValue()) {
            return "bytes".equals(headerField);
        }
        if (com.sdk.base.framework.a.a.c.b(httpURLConnection.getHeaderField(Headers.CONTENT_RANGE)).booleanValue()) {
            return headerField.startsWith("bytes");
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String b(Context context) {
        String defaultUserAgent;
        int length;
        int i;
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                defaultUserAgent = WebSettings.getDefaultUserAgent(context);
            } catch (Exception e) {
            }
            StringBuilder sb = new StringBuilder();
            length = defaultUserAgent.length();
            for (i = 0; i < length; i++) {
                char charAt = defaultUserAgent.charAt(i);
                if (charAt <= 31 || charAt >= 127) {
                    sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                } else {
                    sb.append(charAt);
                }
            }
            return sb.toString();
        }
        defaultUserAgent = System.getProperty("http.agent");
        StringBuilder sb2 = new StringBuilder();
        length = defaultUserAgent.length();
        while (i < length) {
        }
        return sb2.toString();
    }

    public static String b(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                String headerField = httpURLConnection.getHeaderField("Content-Disposition");
                if (com.sdk.base.framework.a.a.c.b(headerField).booleanValue()) {
                    String str = new String(headerField.getBytes("ISO-8859-1"), "GBK");
                    if (com.sdk.base.framework.a.a.c.b(str).booleanValue()) {
                        return str.substring(str.indexOf(34) + 1, str.lastIndexOf("\""));
                    }
                    return null;
                }
                return null;
            } catch (Throwable th) {
                com.sdk.base.framework.a.a.c.b(f4495a, th.getMessage(), b);
                return null;
            }
        }
        return null;
    }
}

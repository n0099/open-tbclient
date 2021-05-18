package com.sdk.base.framework.f.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.c.f;
import com.sdk.base.module.manager.SDKManager;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.util.Enumeration;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f35758a = "com.sdk.base.framework.f.d.a";

    /* renamed from: b  reason: collision with root package name */
    public static final Boolean f35759b = Boolean.valueOf(f.f35733b);

    public static String a() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        return nextElement.getHostAddress();
                    }
                }
            }
            return null;
        } catch (SocketException unused) {
            return null;
        }
    }

    @SuppressLint({"DefaultLocale", "NewApi"})
    public static String a(Context context) {
        String userAgent = SDKManager.getUserAgent();
        if (c.a(userAgent).booleanValue()) {
            if (context != null) {
                try {
                    userAgent = b(context);
                } catch (Throwable unused) {
                }
            }
            return c.a(userAgent).booleanValue() ? "Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 %sSafari/533.1" : userAgent;
        }
        return userAgent;
    }

    public static boolean a(String str) {
        String[] split;
        try {
            for (String str2 : new URL(str).getHost().split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX)) {
                for (int i2 = 0; i2 < str2.length(); i2++) {
                    if (!Character.isDigit(str2.charAt(i2))) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return false;
        }
        String headerField = httpURLConnection.getHeaderField(Util.ACCEPT_RANGES);
        if (c.b(headerField).booleanValue()) {
            return "bytes".equals(headerField);
        }
        if (c.b(httpURLConnection.getHeaderField("Content-Range")).booleanValue()) {
            return headerField.startsWith("bytes");
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Context context) {
        String defaultUserAgent;
        int length;
        int i2;
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                defaultUserAgent = WebSettings.getDefaultUserAgent(context);
            } catch (Exception unused) {
            }
            StringBuilder sb = new StringBuilder();
            length = defaultUserAgent.length();
            for (i2 = 0; i2 < length; i2++) {
                char charAt = defaultUserAgent.charAt(i2);
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
        while (i2 < length) {
        }
        return sb2.toString();
    }

    public static String b(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                String headerField = httpURLConnection.getHeaderField("Content-Disposition");
                if (c.b(headerField).booleanValue()) {
                    String str = new String(headerField.getBytes("ISO-8859-1"), "GBK");
                    if (c.b(str).booleanValue()) {
                        return str.substring(str.indexOf(34) + 1, str.lastIndexOf("\""));
                    }
                }
            } catch (Throwable th) {
                c.b(f35758a, th.getMessage(), f35759b);
            }
        }
        return null;
    }
}

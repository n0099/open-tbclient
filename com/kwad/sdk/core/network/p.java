package com.kwad.sdk.core.network;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.y;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
/* loaded from: classes10.dex */
public final class p {
    public static String auk = "";
    public static String aul = "";

    public static String CD() {
        try {
            if (!TextUtils.isEmpty(auk)) {
                return auk;
            }
            String property = System.getProperty("http.agent");
            auk = property;
            if (TextUtils.isEmpty(property)) {
                return auk;
            }
            StringBuffer stringBuffer = new StringBuffer();
            int length = auk.length();
            for (int i = 0; i < length; i++) {
                char charAt = auk.charAt(i);
                if (charAt > 31 && charAt < 127) {
                    stringBuffer.append(charAt);
                }
                stringBuffer.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            }
            String stringBuffer2 = stringBuffer.toString();
            auk = stringBuffer2;
            return stringBuffer2;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String CE() {
        String cg;
        if (!TextUtils.isEmpty(aul)) {
            return aul;
        }
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return "";
        }
        try {
            cg = y.cg(context);
            aul = cg;
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(cg)) {
            return aul;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            aul = WebSettings.getDefaultUserAgent(context);
        } else {
            aul = System.getProperty("http.agent");
        }
        String encode = URLEncoder.encode(aul, "UTF-8");
        aul = encode;
        y.ai(context, encode);
        return aul;
    }

    public static void b(HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestProperty("User-Agent", getUserAgent());
        httpURLConnection.setRequestProperty("BrowserUa", CE());
        httpURLConnection.setRequestProperty("SystemUa", CD());
    }

    public static String getDefaultUserAgent() {
        return CD() + "-ksad-android-3.3.55";
    }

    public static String getUserAgent() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).getUserAgent();
    }
}

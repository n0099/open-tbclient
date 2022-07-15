package com.kwad.sdk.core.network;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.as;
import java.net.URLEncoder;
/* loaded from: classes5.dex */
public final class n {
    public static String a = "";
    public static String b = "";

    public static String a() {
        if (TextUtils.isEmpty(a)) {
            String property = System.getProperty("http.agent");
            a = property;
            if (TextUtils.isEmpty(property)) {
                return a;
            }
            StringBuffer stringBuffer = new StringBuffer();
            int length = a.length();
            for (int i = 0; i < length; i++) {
                char charAt = a.charAt(i);
                if (charAt <= 31 || charAt >= 127) {
                    stringBuffer.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                } else {
                    stringBuffer.append(charAt);
                }
            }
            String stringBuffer2 = stringBuffer.toString();
            a = stringBuffer2;
            return stringBuffer2;
        }
        return a;
    }

    public static String b() {
        return a() + "-ksad-android-3.3.24";
    }

    public static String c() {
        return ((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).h();
    }

    public static String d() {
        String e;
        if (TextUtils.isEmpty(b)) {
            Context a2 = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a();
            if (a2 == null) {
                return "";
            }
            try {
                e = as.e(a2);
                b = e;
            } catch (Exception unused) {
            }
            if (TextUtils.isEmpty(e)) {
                b = Build.VERSION.SDK_INT >= 17 ? WebSettings.getDefaultUserAgent(a2) : System.getProperty("http.agent");
                String encode = URLEncoder.encode(b, "UTF-8");
                b = encode;
                as.l(a2, encode);
                return b;
            }
            return b;
        }
        return b;
    }
}

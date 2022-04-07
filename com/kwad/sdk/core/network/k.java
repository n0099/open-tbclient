package com.kwad.sdk.core.network;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.as;
import java.net.URLEncoder;
/* loaded from: classes5.dex */
public final class k {
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
        return a() + "-ksad-android-3.3.17.4";
    }

    public static String c() {
        return com.kwad.sdk.core.config.b.an();
    }

    public static String d() {
        String f;
        if (TextUtils.isEmpty(b)) {
            Context context = KsAdSDKImpl.get().getContext();
            if (context == null) {
                return "";
            }
            try {
                f = as.f(context);
                b = f;
            } catch (Exception unused) {
            }
            if (TextUtils.isEmpty(f)) {
                b = Build.VERSION.SDK_INT >= 17 ? WebSettings.getDefaultUserAgent(context) : System.getProperty("http.agent");
                String encode = URLEncoder.encode(b, "UTF-8");
                b = encode;
                as.j(context, encode);
                return b;
            }
            return b;
        }
        return b;
    }
}

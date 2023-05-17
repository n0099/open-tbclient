package com.kwad.sdk.core.network;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.w;
import java.net.URLEncoder;
/* loaded from: classes9.dex */
public final class o {
    public static String YT = "";
    public static String YU = "";

    public static String getDefaultUserAgent() {
        return tC() + "-ksad-android-3.3.26";
    }

    public static String getUserAgent() {
        return ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).getUserAgent();
    }

    public static String tC() {
        if (TextUtils.isEmpty(YT)) {
            String property = System.getProperty("http.agent");
            YT = property;
            if (TextUtils.isEmpty(property)) {
                return YT;
            }
            StringBuffer stringBuffer = new StringBuffer();
            int length = YT.length();
            for (int i = 0; i < length; i++) {
                char charAt = YT.charAt(i);
                if (charAt <= 31 || charAt >= 127) {
                    stringBuffer.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                } else {
                    stringBuffer.append(charAt);
                }
            }
            String stringBuffer2 = stringBuffer.toString();
            YT = stringBuffer2;
            return stringBuffer2;
        }
        return YT;
    }

    public static String tD() {
        String cq;
        if (TextUtils.isEmpty(YU)) {
            Context context = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext();
            if (context == null) {
                return "";
            }
            try {
                cq = w.cq(context);
                YU = cq;
            } catch (Exception unused) {
            }
            if (TextUtils.isEmpty(cq)) {
                YU = Build.VERSION.SDK_INT >= 17 ? WebSettings.getDefaultUserAgent(context) : System.getProperty("http.agent");
                String encode = URLEncoder.encode(YU, "UTF-8");
                YU = encode;
                w.M(context, encode);
                return YU;
            }
            return YU;
        }
        return YU;
    }
}

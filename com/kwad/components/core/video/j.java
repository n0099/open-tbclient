package com.kwad.components.core.video;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ad;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public final class j {
    public static Map<String, Integer> UN = new ConcurrentHashMap();

    public static String a(Context context, int i, String str) {
        if (i < 0) {
            File bO = com.kwad.sdk.core.diskcache.b.a.BS().bO(str);
            if (bO != null && bO.exists()) {
                return bO.getAbsolutePath();
            }
            return str;
        } else if (i > 0) {
            return com.kwad.sdk.core.videocache.c.a.bl(context).ef(str);
        } else {
            return str;
        }
    }

    public static boolean a(@NonNull String str, String str2, a.C0709a c0709a) {
        String bn = ad.bn(str2);
        long currentTimeMillis = System.currentTimeMillis();
        com.kwad.sdk.core.e.c.i("VideoCacheHelper", "start cache video key:" + bn + "--url:" + str);
        boolean b = com.kwad.sdk.core.diskcache.b.a.BS().b(str, str2, c0709a);
        long currentTimeMillis2 = System.currentTimeMillis();
        com.kwad.sdk.core.e.c.i("VideoCacheHelper", "finish cache video key:" + bn + "--cache time:" + (currentTimeMillis2 - currentTimeMillis) + "--success:" + b);
        return b;
    }

    public static int aw(String str) {
        Integer num = UN.get(str);
        if (num != null) {
            return num.intValue();
        }
        return com.kwad.sdk.core.config.d.yE();
    }

    public static boolean ax(@NonNull AdTemplate adTemplate) {
        File bO = com.kwad.sdk.core.diskcache.b.a.BS().bO(com.kwad.sdk.core.response.b.a.K(com.kwad.sdk.core.response.b.e.dP(adTemplate)));
        if (bO != null && bO.exists()) {
            return true;
        }
        return false;
    }

    public static String f(Context context, @NonNull AdTemplate adTemplate) {
        return a(context, com.kwad.sdk.core.response.b.e.ef(adTemplate), com.kwad.sdk.core.response.b.a.K(com.kwad.sdk.core.response.b.e.dP(adTemplate)));
    }

    public static void n(String str, int i) {
        UN.put(str, Integer.valueOf(i));
    }

    public static String f(Context context, String str) {
        return a(context, aw(str), str);
    }
}

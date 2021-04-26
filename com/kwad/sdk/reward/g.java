package com.kwad.sdk.reward;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.diskcache.b.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.r;
import java.io.File;
/* loaded from: classes6.dex */
public class g {
    public static boolean a(@NonNull AdTemplate adTemplate) {
        if (b(adTemplate)) {
            return true;
        }
        String a2 = com.kwad.sdk.core.response.b.a.a(com.kwad.sdk.core.response.b.c.g(adTemplate));
        String a3 = r.a(a2);
        long currentTimeMillis = System.currentTimeMillis();
        com.kwad.sdk.core.d.a.c("VideoCacheHelper", "start cache video key:" + a3 + "--url:" + a2);
        c.a aVar = new c.a();
        boolean a4 = com.kwad.sdk.core.diskcache.b.a.a().a(a2, aVar);
        long currentTimeMillis2 = System.currentTimeMillis();
        com.kwad.sdk.core.d.a.c("VideoCacheHelper", "finish cache video key:" + a3 + "--cache time:" + (currentTimeMillis2 - currentTimeMillis) + "--success:" + a4);
        if (a4) {
            com.kwad.sdk.core.report.e.a(adTemplate, 1);
        } else {
            com.kwad.sdk.core.report.e.a(adTemplate, 1, aVar.f32930a);
        }
        return a4;
    }

    public static boolean a(@NonNull String str, String str2, c.a aVar) {
        String a2 = r.a(str2);
        long currentTimeMillis = System.currentTimeMillis();
        com.kwad.sdk.core.d.a.c("VideoCacheHelper", "start cache video key:" + a2 + "--url:" + str);
        boolean a3 = com.kwad.sdk.core.diskcache.b.a.a().a(str, str2, aVar);
        long currentTimeMillis2 = System.currentTimeMillis();
        com.kwad.sdk.core.d.a.c("VideoCacheHelper", "finish cache video key:" + a2 + "--cache time:" + (currentTimeMillis2 - currentTimeMillis) + "--success:" + a3);
        return a3;
    }

    public static boolean b(@NonNull AdTemplate adTemplate) {
        File b2 = com.kwad.sdk.core.diskcache.b.a.a().b(com.kwad.sdk.core.response.b.a.a(com.kwad.sdk.core.response.b.c.g(adTemplate)));
        return b2 != null && b2.exists();
    }
}

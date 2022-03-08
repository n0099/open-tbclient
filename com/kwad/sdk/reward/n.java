package com.kwad.sdk.reward;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.diskcache.a.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aa;
import java.io.File;
/* loaded from: classes8.dex */
public class n {
    public static boolean a(@NonNull AdTemplate adTemplate) {
        if (b(adTemplate)) {
            return true;
        }
        String a = com.kwad.sdk.core.response.a.a.a(com.kwad.sdk.core.response.a.d.j(adTemplate));
        String a2 = aa.a(a);
        long currentTimeMillis = System.currentTimeMillis();
        com.kwad.sdk.core.d.a.c("VideoCacheHelper", "start cache video key:" + a2 + "--url:" + a);
        c.a aVar = new c.a();
        boolean a3 = com.kwad.sdk.core.diskcache.a.a.a().a(a, aVar);
        long currentTimeMillis2 = System.currentTimeMillis();
        com.kwad.sdk.core.d.a.c("VideoCacheHelper", "finish cache video key:" + a2 + "--cache time:" + (currentTimeMillis2 - currentTimeMillis) + "--success:" + a3);
        if (a3) {
            com.kwad.sdk.core.report.d.a(adTemplate, 1);
        } else {
            com.kwad.sdk.core.report.d.a(adTemplate, 1, aVar.a);
        }
        return a3;
    }

    public static boolean a(@NonNull String str, String str2, c.a aVar) {
        String a = aa.a(str2);
        long currentTimeMillis = System.currentTimeMillis();
        com.kwad.sdk.core.d.a.c("VideoCacheHelper", "start cache video key:" + a + "--url:" + str);
        boolean a2 = com.kwad.sdk.core.diskcache.a.a.a().a(str, str2, aVar);
        long currentTimeMillis2 = System.currentTimeMillis();
        com.kwad.sdk.core.d.a.c("VideoCacheHelper", "finish cache video key:" + a + "--cache time:" + (currentTimeMillis2 - currentTimeMillis) + "--success:" + a2);
        return a2;
    }

    public static boolean b(@NonNull AdTemplate adTemplate) {
        File b2 = com.kwad.sdk.core.diskcache.a.a.a().b(com.kwad.sdk.core.response.a.a.a(com.kwad.sdk.core.response.a.d.j(adTemplate)));
        return b2 != null && b2.exists();
    }
}

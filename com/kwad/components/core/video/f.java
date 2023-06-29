package com.kwad.components.core.video;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.diskcache.a.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ab;
import java.io.File;
/* loaded from: classes10.dex */
public final class f {
    public static boolean a(@NonNull String str, String str2, c.a aVar) {
        String dI = ab.dI(str2);
        long currentTimeMillis = System.currentTimeMillis();
        com.kwad.sdk.core.e.b.i("VideoCacheHelper", "start cache video key:" + dI + "--url:" + str);
        boolean b = com.kwad.sdk.core.diskcache.a.a.sS().b(str, str2, aVar);
        long currentTimeMillis2 = System.currentTimeMillis();
        com.kwad.sdk.core.e.b.i("VideoCacheHelper", "finish cache video key:" + dI + "--cache time:" + (currentTimeMillis2 - currentTimeMillis) + "--success:" + b);
        return b;
    }

    public static boolean h(@NonNull AdTemplate adTemplate) {
        File ad = com.kwad.sdk.core.diskcache.a.a.sS().ad(com.kwad.sdk.core.response.a.a.A(com.kwad.sdk.core.response.a.d.bQ(adTemplate)));
        return ad != null && ad.exists();
    }
}

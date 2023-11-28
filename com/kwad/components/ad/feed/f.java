package com.kwad.components.ad.feed;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class f {
    public static String c(@NonNull AdTemplate adTemplate) {
        String str;
        String au = com.kwad.sdk.core.response.b.a.au(com.kwad.sdk.core.response.b.e.dP(adTemplate));
        if (com.kwad.components.core.c.b.mp()) {
            if (adTemplate.fromCache) {
                str = "【cache】";
            } else {
                str = "";
            }
            return str + au;
        }
        return au;
    }
}

package com.kwad.components.ad.feed;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes9.dex */
public final class f {
    public static String d(@NonNull AdTemplate adTemplate) {
        String ad = com.kwad.sdk.core.response.a.a.ad(com.kwad.sdk.core.response.a.d.bQ(adTemplate));
        if (com.kwad.components.core.a.b.lR()) {
            String str = adTemplate.fromCache ? "【cache】" : "";
            return str + ad;
        }
        return ad;
    }
}

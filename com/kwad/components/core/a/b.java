package com.kwad.components.core.a;

import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.utils.t;
/* loaded from: classes10.dex */
public final class b {
    public static void ag(String str) {
        if (!lR() || KsAdSDKImpl.get() == null || KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        t.z(KsAdSDKImpl.get().getContext(), str);
    }

    public static void b(e eVar) {
        int lX = eVar.lX();
        ag("使用缓存策略: " + lX);
    }

    public static boolean lR() {
        DevelopMangerComponents developMangerComponents = (DevelopMangerComponents) com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return false;
    }
}

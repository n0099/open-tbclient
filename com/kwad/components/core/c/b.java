package com.kwad.components.core.c;

import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.utils.v;
/* loaded from: classes10.dex */
public final class b {
    public static void Y(String str) {
        if (mp() && KsAdSDKImpl.get() != null && KsAdSDKImpl.get().getContext() != null) {
            v.O(KsAdSDKImpl.get().getContext(), str);
        }
    }

    public static void b(e eVar) {
        int mx = eVar.mx();
        Y("使用缓存策略: " + mx);
    }

    public static boolean mp() {
        if (((DevelopMangerComponents) com.kwad.sdk.components.c.f(DevelopMangerComponents.class)) == null) {
        }
        return false;
    }
}

package com.kwad.sdk.core.network.b;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
/* loaded from: classes10.dex */
public final class c {
    public static b CY() {
        h hVar = (h) ServiceProvider.get(h.class);
        if (hVar != null && hVar.yt()) {
            return new d();
        }
        return new a();
    }
}

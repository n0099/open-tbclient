package com.kwad.sdk.core.network.a;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.f;
/* loaded from: classes7.dex */
public final class c {
    public static b tT() {
        f fVar = (f) ServiceProvider.get(f.class);
        return (fVar == null || !fVar.lH()) ? new a() : new d();
    }
}

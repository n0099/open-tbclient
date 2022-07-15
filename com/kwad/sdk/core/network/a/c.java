package com.kwad.sdk.core.network.a;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.f;
/* loaded from: classes5.dex */
public final class c {
    public static b a() {
        f fVar = (f) ServiceProvider.a(f.class);
        return (fVar == null || !fVar.m()) ? new a() : new d();
    }
}

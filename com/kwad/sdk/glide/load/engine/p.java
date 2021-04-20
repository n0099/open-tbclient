package com.kwad.sdk.glide.load.engine;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public final Map<com.kwad.sdk.glide.load.c, j<?>> f35883a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final Map<com.kwad.sdk.glide.load.c, j<?>> f35884b = new HashMap();

    private Map<com.kwad.sdk.glide.load.c, j<?>> a(boolean z) {
        return z ? this.f35884b : this.f35883a;
    }

    public j<?> a(com.kwad.sdk.glide.load.c cVar, boolean z) {
        return a(z).get(cVar);
    }

    public void a(com.kwad.sdk.glide.load.c cVar, j<?> jVar) {
        a(jVar.a()).put(cVar, jVar);
    }

    public void b(com.kwad.sdk.glide.load.c cVar, j<?> jVar) {
        Map<com.kwad.sdk.glide.load.c, j<?>> a2 = a(jVar.a());
        if (jVar.equals(a2.get(cVar))) {
            a2.remove(cVar);
        }
    }
}

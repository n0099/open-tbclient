package com.kwad.sdk.glide.load.engine;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
final class p {

    /* renamed from: a  reason: collision with root package name */
    private final Map<com.kwad.sdk.glide.load.c, j<?>> f10242a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<com.kwad.sdk.glide.load.c, j<?>> f10243b = new HashMap();

    private Map<com.kwad.sdk.glide.load.c, j<?>> a(boolean z) {
        return z ? this.f10243b : this.f10242a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j<?> a(com.kwad.sdk.glide.load.c cVar, boolean z) {
        return a(z).get(cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.kwad.sdk.glide.load.c cVar, j<?> jVar) {
        a(jVar.a()).put(cVar, jVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(com.kwad.sdk.glide.load.c cVar, j<?> jVar) {
        Map<com.kwad.sdk.glide.load.c, j<?>> a2 = a(jVar.a());
        if (jVar.equals(a2.get(cVar))) {
            a2.remove(cVar);
        }
    }
}

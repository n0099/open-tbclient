package com.kwad.sdk.glide.c;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes7.dex */
public final class o implements i {

    /* renamed from: a  reason: collision with root package name */
    public final Set<com.kwad.sdk.glide.request.a.j<?>> f35900a = Collections.newSetFromMap(new WeakHashMap());

    @NonNull
    public List<com.kwad.sdk.glide.request.a.j<?>> a() {
        return com.kwad.sdk.glide.g.k.a(this.f35900a);
    }

    public void a(@NonNull com.kwad.sdk.glide.request.a.j<?> jVar) {
        this.f35900a.add(jVar);
    }

    public void b() {
        this.f35900a.clear();
    }

    public void b(@NonNull com.kwad.sdk.glide.request.a.j<?> jVar) {
        this.f35900a.remove(jVar);
    }

    @Override // com.kwad.sdk.glide.c.i
    public void c() {
        for (com.kwad.sdk.glide.request.a.j jVar : com.kwad.sdk.glide.g.k.a(this.f35900a)) {
            jVar.c();
        }
    }

    @Override // com.kwad.sdk.glide.c.i
    public void d() {
        for (com.kwad.sdk.glide.request.a.j jVar : com.kwad.sdk.glide.g.k.a(this.f35900a)) {
            jVar.d();
        }
    }

    @Override // com.kwad.sdk.glide.c.i
    public void e() {
        for (com.kwad.sdk.glide.request.a.j jVar : com.kwad.sdk.glide.g.k.a(this.f35900a)) {
            jVar.e();
        }
    }
}

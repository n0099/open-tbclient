package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.kwad.sdk.glide.g.a.a;
/* loaded from: classes7.dex */
public final class r<Z> implements a.c, s<Z> {

    /* renamed from: a  reason: collision with root package name */
    public static final Pools.Pool<r<?>> f36291a = com.kwad.sdk.glide.g.a.a.a(20, new a.InterfaceC0410a<r<?>>() { // from class: com.kwad.sdk.glide.load.engine.r.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.g.a.a.InterfaceC0410a
        /* renamed from: a */
        public r<?> b() {
            return new r<>();
        }
    });

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.g.a.c f36292b = com.kwad.sdk.glide.g.a.c.a();

    /* renamed from: c  reason: collision with root package name */
    public s<Z> f36293c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36294d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f36295e;

    @NonNull
    public static <Z> r<Z> a(s<Z> sVar) {
        r<Z> rVar = (r) com.kwad.sdk.glide.g.j.a(f36291a.acquire());
        rVar.b(sVar);
        return rVar;
    }

    private void b(s<Z> sVar) {
        this.f36295e = false;
        this.f36294d = true;
        this.f36293c = sVar;
    }

    private void f() {
        this.f36293c = null;
        f36291a.release(this);
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Class<Z> a() {
        return this.f36293c.a();
    }

    public synchronized void b() {
        this.f36292b.b();
        if (!this.f36294d) {
            throw new IllegalStateException("Already unlocked");
        }
        this.f36294d = false;
        if (this.f36295e) {
            d_();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public int c() {
        return this.f36293c.c();
    }

    @Override // com.kwad.sdk.glide.g.a.a.c
    @NonNull
    public com.kwad.sdk.glide.g.a.c d() {
        return this.f36292b;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public synchronized void d_() {
        this.f36292b.b();
        this.f36295e = true;
        if (!this.f36294d) {
            this.f36293c.d_();
            f();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Z e() {
        return this.f36293c.e();
    }
}

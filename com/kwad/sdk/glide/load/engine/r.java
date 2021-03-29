package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.kwad.sdk.glide.g.a.a;
/* loaded from: classes6.dex */
public final class r<Z> implements a.c, s<Z> {

    /* renamed from: a  reason: collision with root package name */
    public static final Pools.Pool<r<?>> f35600a = com.kwad.sdk.glide.g.a.a.a(20, new a.InterfaceC0410a<r<?>>() { // from class: com.kwad.sdk.glide.load.engine.r.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.g.a.a.InterfaceC0410a
        /* renamed from: a */
        public r<?> b() {
            return new r<>();
        }
    });

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.g.a.c f35601b = com.kwad.sdk.glide.g.a.c.a();

    /* renamed from: c  reason: collision with root package name */
    public s<Z> f35602c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35603d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f35604e;

    @NonNull
    public static <Z> r<Z> a(s<Z> sVar) {
        r<Z> rVar = (r) com.kwad.sdk.glide.g.j.a(f35600a.acquire());
        rVar.b(sVar);
        return rVar;
    }

    private void b(s<Z> sVar) {
        this.f35604e = false;
        this.f35603d = true;
        this.f35602c = sVar;
    }

    private void f() {
        this.f35602c = null;
        f35600a.release(this);
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Class<Z> a() {
        return this.f35602c.a();
    }

    public synchronized void b() {
        this.f35601b.b();
        if (!this.f35603d) {
            throw new IllegalStateException("Already unlocked");
        }
        this.f35603d = false;
        if (this.f35604e) {
            d_();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public int c() {
        return this.f35602c.c();
    }

    @Override // com.kwad.sdk.glide.g.a.a.c
    @NonNull
    public com.kwad.sdk.glide.g.a.c d() {
        return this.f35601b;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public synchronized void d_() {
        this.f35601b.b();
        this.f35604e = true;
        if (!this.f35603d) {
            this.f35602c.d_();
            f();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Z e() {
        return this.f35602c.e();
    }
}

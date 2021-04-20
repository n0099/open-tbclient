package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.kwad.sdk.glide.g.a.a;
/* loaded from: classes6.dex */
public final class r<Z> implements a.c, s<Z> {

    /* renamed from: a  reason: collision with root package name */
    public static final Pools.Pool<r<?>> f35889a = com.kwad.sdk.glide.g.a.a.a(20, new a.InterfaceC0424a<r<?>>() { // from class: com.kwad.sdk.glide.load.engine.r.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.g.a.a.InterfaceC0424a
        /* renamed from: a */
        public r<?> b() {
            return new r<>();
        }
    });

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.g.a.c f35890b = com.kwad.sdk.glide.g.a.c.a();

    /* renamed from: c  reason: collision with root package name */
    public s<Z> f35891c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35892d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f35893e;

    @NonNull
    public static <Z> r<Z> a(s<Z> sVar) {
        r<Z> rVar = (r) com.kwad.sdk.glide.g.j.a(f35889a.acquire());
        rVar.b(sVar);
        return rVar;
    }

    private void b(s<Z> sVar) {
        this.f35893e = false;
        this.f35892d = true;
        this.f35891c = sVar;
    }

    private void f() {
        this.f35891c = null;
        f35889a.release(this);
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Class<Z> a() {
        return this.f35891c.a();
    }

    public synchronized void b() {
        this.f35890b.b();
        if (!this.f35892d) {
            throw new IllegalStateException("Already unlocked");
        }
        this.f35892d = false;
        if (this.f35893e) {
            d_();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public int c() {
        return this.f35891c.c();
    }

    @Override // com.kwad.sdk.glide.g.a.a.c
    @NonNull
    public com.kwad.sdk.glide.g.a.c d() {
        return this.f35890b;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public synchronized void d_() {
        this.f35890b.b();
        this.f35893e = true;
        if (!this.f35892d) {
            this.f35891c.d_();
            f();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Z e() {
        return this.f35891c.e();
    }
}

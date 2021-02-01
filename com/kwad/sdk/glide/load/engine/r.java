package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.kwad.sdk.glide.g.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class r<Z> implements a.c, s<Z> {

    /* renamed from: a  reason: collision with root package name */
    private static final Pools.Pool<r<?>> f10248a = com.kwad.sdk.glide.g.a.a.a(20, new a.InterfaceC1123a<r<?>>() { // from class: com.kwad.sdk.glide.load.engine.r.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.g.a.a.InterfaceC1123a
        /* renamed from: a */
        public r<?> b() {
            return new r<>();
        }
    });

    /* renamed from: b  reason: collision with root package name */
    private final com.kwad.sdk.glide.g.a.c f10249b = com.kwad.sdk.glide.g.a.c.a();
    private s<Z> c;
    private boolean d;
    private boolean e;

    r() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static <Z> r<Z> a(s<Z> sVar) {
        r<Z> rVar = (r) com.kwad.sdk.glide.g.j.a(f10248a.acquire());
        rVar.b(sVar);
        return rVar;
    }

    private void b(s<Z> sVar) {
        this.e = false;
        this.d = true;
        this.c = sVar;
    }

    private void f() {
        this.c = null;
        f10248a.release(this);
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Class<Z> a() {
        return this.c.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b() {
        this.f10249b.b();
        if (!this.d) {
            throw new IllegalStateException("Already unlocked");
        }
        this.d = false;
        if (this.e) {
            d_();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public int c() {
        return this.c.c();
    }

    @Override // com.kwad.sdk.glide.g.a.a.c
    @NonNull
    public com.kwad.sdk.glide.g.a.c d() {
        return this.f10249b;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public synchronized void d_() {
        this.f10249b.b();
        this.e = true;
        if (!this.d) {
            this.c.d_();
            f();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Z e() {
        return this.c.e();
    }
}

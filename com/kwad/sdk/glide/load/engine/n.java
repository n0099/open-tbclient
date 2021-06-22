package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
/* loaded from: classes7.dex */
public class n<Z> implements s<Z> {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f36376a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f36377b;

    /* renamed from: c  reason: collision with root package name */
    public final s<Z> f36378c;

    /* renamed from: d  reason: collision with root package name */
    public a f36379d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.glide.load.c f36380e;

    /* renamed from: f  reason: collision with root package name */
    public int f36381f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36382g;

    /* loaded from: classes7.dex */
    public interface a {
        void a(com.kwad.sdk.glide.load.c cVar, n<?> nVar);
    }

    public n(s<Z> sVar, boolean z, boolean z2) {
        this.f36378c = (s) com.kwad.sdk.glide.g.j.a(sVar);
        this.f36376a = z;
        this.f36377b = z2;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Class<Z> a() {
        return this.f36378c.a();
    }

    public synchronized void a(com.kwad.sdk.glide.load.c cVar, a aVar) {
        this.f36380e = cVar;
        this.f36379d = aVar;
    }

    public s<Z> b() {
        return this.f36378c;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public int c() {
        return this.f36378c.c();
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public synchronized void d_() {
        if (this.f36381f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f36382g) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f36382g = true;
        if (this.f36377b) {
            this.f36378c.d_();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Z e() {
        return this.f36378c.e();
    }

    public boolean f() {
        return this.f36376a;
    }

    public synchronized void g() {
        if (this.f36382g) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f36381f++;
    }

    public void h() {
        synchronized (this.f36379d) {
            synchronized (this) {
                if (this.f36381f <= 0) {
                    throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
                }
                int i2 = this.f36381f - 1;
                this.f36381f = i2;
                if (i2 == 0) {
                    this.f36379d.a(this.f36380e, this);
                }
            }
        }
    }

    public synchronized String toString() {
        return "EngineResource{isCacheable=" + this.f36376a + ", listener=" + this.f36379d + ", key=" + this.f36380e + ", acquired=" + this.f36381f + ", isRecycled=" + this.f36382g + ", resource=" + this.f36378c + '}';
    }
}

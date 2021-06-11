package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
/* loaded from: classes7.dex */
public class n<Z> implements s<Z> {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f36278a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f36279b;

    /* renamed from: c  reason: collision with root package name */
    public final s<Z> f36280c;

    /* renamed from: d  reason: collision with root package name */
    public a f36281d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.glide.load.c f36282e;

    /* renamed from: f  reason: collision with root package name */
    public int f36283f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36284g;

    /* loaded from: classes7.dex */
    public interface a {
        void a(com.kwad.sdk.glide.load.c cVar, n<?> nVar);
    }

    public n(s<Z> sVar, boolean z, boolean z2) {
        this.f36280c = (s) com.kwad.sdk.glide.g.j.a(sVar);
        this.f36278a = z;
        this.f36279b = z2;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Class<Z> a() {
        return this.f36280c.a();
    }

    public synchronized void a(com.kwad.sdk.glide.load.c cVar, a aVar) {
        this.f36282e = cVar;
        this.f36281d = aVar;
    }

    public s<Z> b() {
        return this.f36280c;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public int c() {
        return this.f36280c.c();
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public synchronized void d_() {
        if (this.f36283f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f36284g) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f36284g = true;
        if (this.f36279b) {
            this.f36280c.d_();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Z e() {
        return this.f36280c.e();
    }

    public boolean f() {
        return this.f36278a;
    }

    public synchronized void g() {
        if (this.f36284g) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f36283f++;
    }

    public void h() {
        synchronized (this.f36281d) {
            synchronized (this) {
                if (this.f36283f <= 0) {
                    throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
                }
                int i2 = this.f36283f - 1;
                this.f36283f = i2;
                if (i2 == 0) {
                    this.f36281d.a(this.f36282e, this);
                }
            }
        }
    }

    public synchronized String toString() {
        return "EngineResource{isCacheable=" + this.f36278a + ", listener=" + this.f36281d + ", key=" + this.f36282e + ", acquired=" + this.f36283f + ", isRecycled=" + this.f36284g + ", resource=" + this.f36280c + '}';
    }
}

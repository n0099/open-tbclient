package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class n<Z> implements s<Z> {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f35971a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f35972b;

    /* renamed from: c  reason: collision with root package name */
    public final s<Z> f35973c;

    /* renamed from: d  reason: collision with root package name */
    public a f35974d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.glide.load.c f35975e;

    /* renamed from: f  reason: collision with root package name */
    public int f35976f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f35977g;

    /* loaded from: classes6.dex */
    public interface a {
        void a(com.kwad.sdk.glide.load.c cVar, n<?> nVar);
    }

    public n(s<Z> sVar, boolean z, boolean z2) {
        this.f35973c = (s) com.kwad.sdk.glide.g.j.a(sVar);
        this.f35971a = z;
        this.f35972b = z2;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Class<Z> a() {
        return this.f35973c.a();
    }

    public synchronized void a(com.kwad.sdk.glide.load.c cVar, a aVar) {
        this.f35975e = cVar;
        this.f35974d = aVar;
    }

    public s<Z> b() {
        return this.f35973c;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public int c() {
        return this.f35973c.c();
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public synchronized void d_() {
        if (this.f35976f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f35977g) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f35977g = true;
        if (this.f35972b) {
            this.f35973c.d_();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Z e() {
        return this.f35973c.e();
    }

    public boolean f() {
        return this.f35971a;
    }

    public synchronized void g() {
        if (this.f35977g) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f35976f++;
    }

    public void h() {
        synchronized (this.f35974d) {
            synchronized (this) {
                if (this.f35976f <= 0) {
                    throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
                }
                int i = this.f35976f - 1;
                this.f35976f = i;
                if (i == 0) {
                    this.f35974d.a(this.f35975e, this);
                }
            }
        }
    }

    public synchronized String toString() {
        return "EngineResource{isCacheable=" + this.f35971a + ", listener=" + this.f35974d + ", key=" + this.f35975e + ", acquired=" + this.f35976f + ", isRecycled=" + this.f35977g + ", resource=" + this.f35973c + '}';
    }
}

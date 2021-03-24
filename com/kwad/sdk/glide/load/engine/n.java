package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class n<Z> implements s<Z> {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f35586a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f35587b;

    /* renamed from: c  reason: collision with root package name */
    public final s<Z> f35588c;

    /* renamed from: d  reason: collision with root package name */
    public a f35589d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.glide.load.c f35590e;

    /* renamed from: f  reason: collision with root package name */
    public int f35591f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f35592g;

    /* loaded from: classes6.dex */
    public interface a {
        void a(com.kwad.sdk.glide.load.c cVar, n<?> nVar);
    }

    public n(s<Z> sVar, boolean z, boolean z2) {
        this.f35588c = (s) com.kwad.sdk.glide.g.j.a(sVar);
        this.f35586a = z;
        this.f35587b = z2;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Class<Z> a() {
        return this.f35588c.a();
    }

    public synchronized void a(com.kwad.sdk.glide.load.c cVar, a aVar) {
        this.f35590e = cVar;
        this.f35589d = aVar;
    }

    public s<Z> b() {
        return this.f35588c;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public int c() {
        return this.f35588c.c();
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public synchronized void d_() {
        if (this.f35591f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f35592g) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f35592g = true;
        if (this.f35587b) {
            this.f35588c.d_();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Z e() {
        return this.f35588c.e();
    }

    public boolean f() {
        return this.f35586a;
    }

    public synchronized void g() {
        if (this.f35592g) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f35591f++;
    }

    public void h() {
        synchronized (this.f35589d) {
            synchronized (this) {
                if (this.f35591f <= 0) {
                    throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
                }
                int i = this.f35591f - 1;
                this.f35591f = i;
                if (i == 0) {
                    this.f35589d.a(this.f35590e, this);
                }
            }
        }
    }

    public synchronized String toString() {
        return "EngineResource{isCacheable=" + this.f35586a + ", listener=" + this.f35589d + ", key=" + this.f35590e + ", acquired=" + this.f35591f + ", isRecycled=" + this.f35592g + ", resource=" + this.f35588c + '}';
    }
}

package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class n<Z> implements s<Z> {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f35587a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f35588b;

    /* renamed from: c  reason: collision with root package name */
    public final s<Z> f35589c;

    /* renamed from: d  reason: collision with root package name */
    public a f35590d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.glide.load.c f35591e;

    /* renamed from: f  reason: collision with root package name */
    public int f35592f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f35593g;

    /* loaded from: classes6.dex */
    public interface a {
        void a(com.kwad.sdk.glide.load.c cVar, n<?> nVar);
    }

    public n(s<Z> sVar, boolean z, boolean z2) {
        this.f35589c = (s) com.kwad.sdk.glide.g.j.a(sVar);
        this.f35587a = z;
        this.f35588b = z2;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Class<Z> a() {
        return this.f35589c.a();
    }

    public synchronized void a(com.kwad.sdk.glide.load.c cVar, a aVar) {
        this.f35591e = cVar;
        this.f35590d = aVar;
    }

    public s<Z> b() {
        return this.f35589c;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public int c() {
        return this.f35589c.c();
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public synchronized void d_() {
        if (this.f35592f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f35593g) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f35593g = true;
        if (this.f35588b) {
            this.f35589c.d_();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Z e() {
        return this.f35589c.e();
    }

    public boolean f() {
        return this.f35587a;
    }

    public synchronized void g() {
        if (this.f35593g) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f35592f++;
    }

    public void h() {
        synchronized (this.f35590d) {
            synchronized (this) {
                if (this.f35592f <= 0) {
                    throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
                }
                int i = this.f35592f - 1;
                this.f35592f = i;
                if (i == 0) {
                    this.f35590d.a(this.f35591e, this);
                }
            }
        }
    }

    public synchronized String toString() {
        return "EngineResource{isCacheable=" + this.f35587a + ", listener=" + this.f35590d + ", key=" + this.f35591e + ", acquired=" + this.f35592f + ", isRecycled=" + this.f35593g + ", resource=" + this.f35589c + '}';
    }
}

package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class n<Z> implements s<Z> {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f35876a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f35877b;

    /* renamed from: c  reason: collision with root package name */
    public final s<Z> f35878c;

    /* renamed from: d  reason: collision with root package name */
    public a f35879d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.glide.load.c f35880e;

    /* renamed from: f  reason: collision with root package name */
    public int f35881f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f35882g;

    /* loaded from: classes6.dex */
    public interface a {
        void a(com.kwad.sdk.glide.load.c cVar, n<?> nVar);
    }

    public n(s<Z> sVar, boolean z, boolean z2) {
        this.f35878c = (s) com.kwad.sdk.glide.g.j.a(sVar);
        this.f35876a = z;
        this.f35877b = z2;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Class<Z> a() {
        return this.f35878c.a();
    }

    public synchronized void a(com.kwad.sdk.glide.load.c cVar, a aVar) {
        this.f35880e = cVar;
        this.f35879d = aVar;
    }

    public s<Z> b() {
        return this.f35878c;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public int c() {
        return this.f35878c.c();
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public synchronized void d_() {
        if (this.f35881f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f35882g) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f35882g = true;
        if (this.f35877b) {
            this.f35878c.d_();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Z e() {
        return this.f35878c.e();
    }

    public boolean f() {
        return this.f35876a;
    }

    public synchronized void g() {
        if (this.f35882g) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f35881f++;
    }

    public void h() {
        synchronized (this.f35879d) {
            synchronized (this) {
                if (this.f35881f <= 0) {
                    throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
                }
                int i = this.f35881f - 1;
                this.f35881f = i;
                if (i == 0) {
                    this.f35879d.a(this.f35880e, this);
                }
            }
        }
    }

    public synchronized String toString() {
        return "EngineResource{isCacheable=" + this.f35876a + ", listener=" + this.f35879d + ", key=" + this.f35880e + ", acquired=" + this.f35881f + ", isRecycled=" + this.f35882g + ", resource=" + this.f35878c + '}';
    }
}

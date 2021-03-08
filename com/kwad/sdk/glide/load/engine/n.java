package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
class n<Z> implements s<Z> {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f6768a;
    private final boolean b;
    private final s<Z> c;
    private a d;
    private com.kwad.sdk.glide.load.c e;
    private int f;
    private boolean g;

    /* loaded from: classes3.dex */
    interface a {
        void a(com.kwad.sdk.glide.load.c cVar, n<?> nVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(s<Z> sVar, boolean z, boolean z2) {
        this.c = (s) com.kwad.sdk.glide.g.j.a(sVar);
        this.f6768a = z;
        this.b = z2;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Class<Z> a() {
        return this.c.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(com.kwad.sdk.glide.load.c cVar, a aVar) {
        this.e = cVar;
        this.d = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s<Z> b() {
        return this.c;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public int c() {
        return this.c.c();
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public synchronized void d_() {
        if (this.f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.g) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.g = true;
        if (this.b) {
            this.c.d_();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Z e() {
        return this.c.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return this.f6768a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void g() {
        if (this.g) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        synchronized (this.d) {
            synchronized (this) {
                if (this.f <= 0) {
                    throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
                }
                int i = this.f - 1;
                this.f = i;
                if (i == 0) {
                    this.d.a(this.e, this);
                }
            }
        }
    }

    public synchronized String toString() {
        return "EngineResource{isCacheable=" + this.f6768a + ", listener=" + this.d + ", key=" + this.e + ", acquired=" + this.f + ", isRecycled=" + this.g + ", resource=" + this.c + '}';
    }
}

package com.kwad.sdk.glide.request;

import androidx.annotation.Nullable;
/* loaded from: classes7.dex */
public final class b implements c, d {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final d f36492a;

    /* renamed from: b  reason: collision with root package name */
    public c f36493b;

    /* renamed from: c  reason: collision with root package name */
    public c f36494c;

    public b(@Nullable d dVar) {
        this.f36492a = dVar;
    }

    private boolean g(c cVar) {
        return cVar.equals(this.f36493b) || (this.f36493b.g() && cVar.equals(this.f36494c));
    }

    private boolean j() {
        d dVar = this.f36492a;
        return dVar == null || dVar.b(this);
    }

    private boolean k() {
        d dVar = this.f36492a;
        return dVar == null || dVar.d(this);
    }

    private boolean l() {
        d dVar = this.f36492a;
        return dVar == null || dVar.c(this);
    }

    private boolean m() {
        d dVar = this.f36492a;
        return dVar != null && dVar.i();
    }

    @Override // com.kwad.sdk.glide.request.c
    public void a() {
        if (this.f36493b.c()) {
            return;
        }
        this.f36493b.a();
    }

    public void a(c cVar, c cVar2) {
        this.f36493b = cVar;
        this.f36494c = cVar2;
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean a(c cVar) {
        if (cVar instanceof b) {
            b bVar = (b) cVar;
            return this.f36493b.a(bVar.f36493b) && this.f36494c.a(bVar.f36494c);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.request.c
    public void b() {
        this.f36493b.b();
        if (this.f36494c.c()) {
            this.f36494c.b();
        }
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean b(c cVar) {
        return j() && g(cVar);
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean c() {
        return (this.f36493b.g() ? this.f36494c : this.f36493b).c();
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean c(c cVar) {
        return l() && g(cVar);
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean d(c cVar) {
        return k() && g(cVar);
    }

    @Override // com.kwad.sdk.glide.request.d
    public void e(c cVar) {
        d dVar = this.f36492a;
        if (dVar != null) {
            dVar.e(this);
        }
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean e() {
        return (this.f36493b.g() ? this.f36494c : this.f36493b).e();
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean e_() {
        return (this.f36493b.g() ? this.f36494c : this.f36493b).e_();
    }

    @Override // com.kwad.sdk.glide.request.d
    public void f(c cVar) {
        if (!cVar.equals(this.f36494c)) {
            if (this.f36494c.c()) {
                return;
            }
            this.f36494c.a();
            return;
        }
        d dVar = this.f36492a;
        if (dVar != null) {
            dVar.f(this);
        }
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean f() {
        return (this.f36493b.g() ? this.f36494c : this.f36493b).f();
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean g() {
        return this.f36493b.g() && this.f36494c.g();
    }

    @Override // com.kwad.sdk.glide.request.c
    public void h() {
        this.f36493b.h();
        this.f36494c.h();
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean i() {
        return m() || e();
    }
}

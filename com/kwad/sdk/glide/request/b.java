package com.kwad.sdk.glide.request;

import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public final class b implements c, d {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final d f35794a;

    /* renamed from: b  reason: collision with root package name */
    public c f35795b;

    /* renamed from: c  reason: collision with root package name */
    public c f35796c;

    public b(@Nullable d dVar) {
        this.f35794a = dVar;
    }

    private boolean g(c cVar) {
        return cVar.equals(this.f35795b) || (this.f35795b.g() && cVar.equals(this.f35796c));
    }

    private boolean j() {
        d dVar = this.f35794a;
        return dVar == null || dVar.b(this);
    }

    private boolean k() {
        d dVar = this.f35794a;
        return dVar == null || dVar.d(this);
    }

    private boolean l() {
        d dVar = this.f35794a;
        return dVar == null || dVar.c(this);
    }

    private boolean m() {
        d dVar = this.f35794a;
        return dVar != null && dVar.i();
    }

    @Override // com.kwad.sdk.glide.request.c
    public void a() {
        if (this.f35795b.c()) {
            return;
        }
        this.f35795b.a();
    }

    public void a(c cVar, c cVar2) {
        this.f35795b = cVar;
        this.f35796c = cVar2;
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean a(c cVar) {
        if (cVar instanceof b) {
            b bVar = (b) cVar;
            return this.f35795b.a(bVar.f35795b) && this.f35796c.a(bVar.f35796c);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.request.c
    public void b() {
        this.f35795b.b();
        if (this.f35796c.c()) {
            this.f35796c.b();
        }
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean b(c cVar) {
        return j() && g(cVar);
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean c() {
        return (this.f35795b.g() ? this.f35796c : this.f35795b).c();
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
        d dVar = this.f35794a;
        if (dVar != null) {
            dVar.e(this);
        }
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean e() {
        return (this.f35795b.g() ? this.f35796c : this.f35795b).e();
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean e_() {
        return (this.f35795b.g() ? this.f35796c : this.f35795b).e_();
    }

    @Override // com.kwad.sdk.glide.request.d
    public void f(c cVar) {
        if (!cVar.equals(this.f35796c)) {
            if (this.f35796c.c()) {
                return;
            }
            this.f35796c.a();
            return;
        }
        d dVar = this.f35794a;
        if (dVar != null) {
            dVar.f(this);
        }
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean f() {
        return (this.f35795b.g() ? this.f35796c : this.f35795b).f();
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean g() {
        return this.f35795b.g() && this.f35796c.g();
    }

    @Override // com.kwad.sdk.glide.request.c
    public void h() {
        this.f35795b.h();
        this.f35796c.h();
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean i() {
        return m() || e();
    }
}

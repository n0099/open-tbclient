package com.kwad.sdk.glide.request;

import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public final class b implements c, d {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final d f36178a;

    /* renamed from: b  reason: collision with root package name */
    public c f36179b;

    /* renamed from: c  reason: collision with root package name */
    public c f36180c;

    public b(@Nullable d dVar) {
        this.f36178a = dVar;
    }

    private boolean g(c cVar) {
        return cVar.equals(this.f36179b) || (this.f36179b.g() && cVar.equals(this.f36180c));
    }

    private boolean j() {
        d dVar = this.f36178a;
        return dVar == null || dVar.b(this);
    }

    private boolean k() {
        d dVar = this.f36178a;
        return dVar == null || dVar.d(this);
    }

    private boolean l() {
        d dVar = this.f36178a;
        return dVar == null || dVar.c(this);
    }

    private boolean m() {
        d dVar = this.f36178a;
        return dVar != null && dVar.i();
    }

    @Override // com.kwad.sdk.glide.request.c
    public void a() {
        if (this.f36179b.c()) {
            return;
        }
        this.f36179b.a();
    }

    public void a(c cVar, c cVar2) {
        this.f36179b = cVar;
        this.f36180c = cVar2;
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean a(c cVar) {
        if (cVar instanceof b) {
            b bVar = (b) cVar;
            return this.f36179b.a(bVar.f36179b) && this.f36180c.a(bVar.f36180c);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.request.c
    public void b() {
        this.f36179b.b();
        if (this.f36180c.c()) {
            this.f36180c.b();
        }
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean b(c cVar) {
        return j() && g(cVar);
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean c() {
        return (this.f36179b.g() ? this.f36180c : this.f36179b).c();
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
        d dVar = this.f36178a;
        if (dVar != null) {
            dVar.e(this);
        }
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean e() {
        return (this.f36179b.g() ? this.f36180c : this.f36179b).e();
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean e_() {
        return (this.f36179b.g() ? this.f36180c : this.f36179b).e_();
    }

    @Override // com.kwad.sdk.glide.request.d
    public void f(c cVar) {
        if (!cVar.equals(this.f36180c)) {
            if (this.f36180c.c()) {
                return;
            }
            this.f36180c.a();
            return;
        }
        d dVar = this.f36178a;
        if (dVar != null) {
            dVar.f(this);
        }
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean f() {
        return (this.f36179b.g() ? this.f36180c : this.f36179b).f();
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean g() {
        return this.f36179b.g() && this.f36180c.g();
    }

    @Override // com.kwad.sdk.glide.request.c
    public void h() {
        this.f36179b.h();
        this.f36180c.h();
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean i() {
        return m() || e();
    }
}

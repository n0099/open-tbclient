package com.kwad.sdk.glide.request;

import androidx.annotation.Nullable;
/* loaded from: classes4.dex */
public final class b implements c, d {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final d f10350a;

    /* renamed from: b  reason: collision with root package name */
    private c f10351b;
    private c c;

    public b(@Nullable d dVar) {
        this.f10350a = dVar;
    }

    private boolean g(c cVar) {
        return cVar.equals(this.f10351b) || (this.f10351b.g() && cVar.equals(this.c));
    }

    private boolean j() {
        return this.f10350a == null || this.f10350a.b(this);
    }

    private boolean k() {
        return this.f10350a == null || this.f10350a.d(this);
    }

    private boolean l() {
        return this.f10350a == null || this.f10350a.c(this);
    }

    private boolean m() {
        return this.f10350a != null && this.f10350a.i();
    }

    @Override // com.kwad.sdk.glide.request.c
    public void a() {
        if (this.f10351b.c()) {
            return;
        }
        this.f10351b.a();
    }

    public void a(c cVar, c cVar2) {
        this.f10351b = cVar;
        this.c = cVar2;
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean a(c cVar) {
        if (cVar instanceof b) {
            b bVar = (b) cVar;
            return this.f10351b.a(bVar.f10351b) && this.c.a(bVar.c);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.request.c
    public void b() {
        this.f10351b.b();
        if (this.c.c()) {
            this.c.b();
        }
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean b(c cVar) {
        return j() && g(cVar);
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean c() {
        return this.f10351b.g() ? this.c.c() : this.f10351b.c();
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
        if (this.f10350a != null) {
            this.f10350a.e(this);
        }
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean e() {
        return this.f10351b.g() ? this.c.e() : this.f10351b.e();
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean e_() {
        return this.f10351b.g() ? this.c.e_() : this.f10351b.e_();
    }

    @Override // com.kwad.sdk.glide.request.d
    public void f(c cVar) {
        if (cVar.equals(this.c)) {
            if (this.f10350a != null) {
                this.f10350a.f(this);
            }
        } else if (this.c.c()) {
        } else {
            this.c.a();
        }
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean f() {
        return this.f10351b.g() ? this.c.f() : this.f10351b.f();
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean g() {
        return this.f10351b.g() && this.c.g();
    }

    @Override // com.kwad.sdk.glide.request.c
    public void h() {
        this.f10351b.h();
        this.c.h();
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean i() {
        return m() || e();
    }
}

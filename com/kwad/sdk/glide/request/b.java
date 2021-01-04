package com.kwad.sdk.glide.request;

import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public final class b implements c, d {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final d f10649a;

    /* renamed from: b  reason: collision with root package name */
    private c f10650b;
    private c c;

    public b(@Nullable d dVar) {
        this.f10649a = dVar;
    }

    private boolean g(c cVar) {
        return cVar.equals(this.f10650b) || (this.f10650b.g() && cVar.equals(this.c));
    }

    private boolean j() {
        return this.f10649a == null || this.f10649a.b(this);
    }

    private boolean k() {
        return this.f10649a == null || this.f10649a.d(this);
    }

    private boolean l() {
        return this.f10649a == null || this.f10649a.c(this);
    }

    private boolean m() {
        return this.f10649a != null && this.f10649a.i();
    }

    @Override // com.kwad.sdk.glide.request.c
    public void a() {
        if (this.f10650b.c()) {
            return;
        }
        this.f10650b.a();
    }

    public void a(c cVar, c cVar2) {
        this.f10650b = cVar;
        this.c = cVar2;
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean a(c cVar) {
        if (cVar instanceof b) {
            b bVar = (b) cVar;
            return this.f10650b.a(bVar.f10650b) && this.c.a(bVar.c);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.request.c
    public void b() {
        this.f10650b.b();
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
        return this.f10650b.g() ? this.c.c() : this.f10650b.c();
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
        if (this.f10649a != null) {
            this.f10649a.e(this);
        }
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean e() {
        return this.f10650b.g() ? this.c.e() : this.f10650b.e();
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean e_() {
        return this.f10650b.g() ? this.c.e_() : this.f10650b.e_();
    }

    @Override // com.kwad.sdk.glide.request.d
    public void f(c cVar) {
        if (cVar.equals(this.c)) {
            if (this.f10649a != null) {
                this.f10649a.f(this);
            }
        } else if (this.c.c()) {
        } else {
            this.c.a();
        }
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean f() {
        return this.f10650b.g() ? this.c.f() : this.f10650b.f();
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean g() {
        return this.f10650b.g() && this.c.g();
    }

    @Override // com.kwad.sdk.glide.request.c
    public void h() {
        this.f10650b.h();
        this.c.h();
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean i() {
        return m() || e();
    }
}

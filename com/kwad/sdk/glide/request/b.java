package com.kwad.sdk.glide.request;

import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public final class b implements c, d {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final d f6830a;
    private c b;
    private c c;

    public b(@Nullable d dVar) {
        this.f6830a = dVar;
    }

    private boolean g(c cVar) {
        return cVar.equals(this.b) || (this.b.g() && cVar.equals(this.c));
    }

    private boolean j() {
        return this.f6830a == null || this.f6830a.b(this);
    }

    private boolean k() {
        return this.f6830a == null || this.f6830a.d(this);
    }

    private boolean l() {
        return this.f6830a == null || this.f6830a.c(this);
    }

    private boolean m() {
        return this.f6830a != null && this.f6830a.i();
    }

    @Override // com.kwad.sdk.glide.request.c
    public void a() {
        if (this.b.c()) {
            return;
        }
        this.b.a();
    }

    public void a(c cVar, c cVar2) {
        this.b = cVar;
        this.c = cVar2;
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean a(c cVar) {
        if (cVar instanceof b) {
            b bVar = (b) cVar;
            return this.b.a(bVar.b) && this.c.a(bVar.c);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.request.c
    public void b() {
        this.b.b();
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
        return this.b.g() ? this.c.c() : this.b.c();
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
        if (this.f6830a != null) {
            this.f6830a.e(this);
        }
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean e() {
        return this.b.g() ? this.c.e() : this.b.e();
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean e_() {
        return this.b.g() ? this.c.e_() : this.b.e_();
    }

    @Override // com.kwad.sdk.glide.request.d
    public void f(c cVar) {
        if (cVar.equals(this.c)) {
            if (this.f6830a != null) {
                this.f6830a.f(this);
            }
        } else if (this.c.c()) {
        } else {
            this.c.a();
        }
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean f() {
        return this.b.g() ? this.c.f() : this.b.f();
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean g() {
        return this.b.g() && this.c.g();
    }

    @Override // com.kwad.sdk.glide.request.c
    public void h() {
        this.b.h();
        this.c.h();
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean i() {
        return m() || e();
    }
}

package com.kwad.sdk.glide.request;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
/* loaded from: classes6.dex */
public class h implements c, d {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final d f35798a;

    /* renamed from: b  reason: collision with root package name */
    public c f35799b;

    /* renamed from: c  reason: collision with root package name */
    public c f35800c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35801d;

    @VisibleForTesting
    public h() {
        this(null);
    }

    public h(@Nullable d dVar) {
        this.f35798a = dVar;
    }

    private boolean j() {
        d dVar = this.f35798a;
        return dVar == null || dVar.b(this);
    }

    private boolean k() {
        d dVar = this.f35798a;
        return dVar == null || dVar.d(this);
    }

    private boolean l() {
        d dVar = this.f35798a;
        return dVar == null || dVar.c(this);
    }

    private boolean m() {
        d dVar = this.f35798a;
        return dVar != null && dVar.i();
    }

    @Override // com.kwad.sdk.glide.request.c
    public void a() {
        this.f35801d = true;
        if (!this.f35799b.e_() && !this.f35800c.c()) {
            this.f35800c.a();
        }
        if (!this.f35801d || this.f35799b.c()) {
            return;
        }
        this.f35799b.a();
    }

    public void a(c cVar, c cVar2) {
        this.f35799b = cVar;
        this.f35800c = cVar2;
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean a(c cVar) {
        if (cVar instanceof h) {
            h hVar = (h) cVar;
            c cVar2 = this.f35799b;
            if (cVar2 == null) {
                if (hVar.f35799b != null) {
                    return false;
                }
            } else if (!cVar2.a(hVar.f35799b)) {
                return false;
            }
            c cVar3 = this.f35800c;
            c cVar4 = hVar.f35800c;
            if (cVar3 == null) {
                if (cVar4 != null) {
                    return false;
                }
            } else if (!cVar3.a(cVar4)) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.request.c
    public void b() {
        this.f35801d = false;
        this.f35800c.b();
        this.f35799b.b();
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean b(c cVar) {
        return j() && (cVar.equals(this.f35799b) || !this.f35799b.e());
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean c() {
        return this.f35799b.c();
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean c(c cVar) {
        return l() && cVar.equals(this.f35799b) && !i();
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean d(c cVar) {
        return k() && cVar.equals(this.f35799b);
    }

    @Override // com.kwad.sdk.glide.request.d
    public void e(c cVar) {
        if (cVar.equals(this.f35800c)) {
            return;
        }
        d dVar = this.f35798a;
        if (dVar != null) {
            dVar.e(this);
        }
        if (this.f35800c.e_()) {
            return;
        }
        this.f35800c.b();
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean e() {
        return this.f35799b.e() || this.f35800c.e();
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean e_() {
        return this.f35799b.e_() || this.f35800c.e_();
    }

    @Override // com.kwad.sdk.glide.request.d
    public void f(c cVar) {
        d dVar;
        if (cVar.equals(this.f35799b) && (dVar = this.f35798a) != null) {
            dVar.f(this);
        }
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean f() {
        return this.f35799b.f();
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean g() {
        return this.f35799b.g();
    }

    @Override // com.kwad.sdk.glide.request.c
    public void h() {
        this.f35799b.h();
        this.f35800c.h();
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean i() {
        return m() || e();
    }
}

package com.kwad.sdk.glide.request;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
/* loaded from: classes3.dex */
public class h implements c, d {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final d f6832a;
    private c b;
    private c c;
    private boolean d;

    @VisibleForTesting
    h() {
        this(null);
    }

    public h(@Nullable d dVar) {
        this.f6832a = dVar;
    }

    private boolean j() {
        return this.f6832a == null || this.f6832a.b(this);
    }

    private boolean k() {
        return this.f6832a == null || this.f6832a.d(this);
    }

    private boolean l() {
        return this.f6832a == null || this.f6832a.c(this);
    }

    private boolean m() {
        return this.f6832a != null && this.f6832a.i();
    }

    @Override // com.kwad.sdk.glide.request.c
    public void a() {
        this.d = true;
        if (!this.b.e_() && !this.c.c()) {
            this.c.a();
        }
        if (!this.d || this.b.c()) {
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
        if (cVar instanceof h) {
            h hVar = (h) cVar;
            if (this.b == null) {
                if (hVar.b != null) {
                    return false;
                }
            } else if (!this.b.a(hVar.b)) {
                return false;
            }
            if (this.c == null) {
                if (hVar.c != null) {
                    return false;
                }
            } else if (!this.c.a(hVar.c)) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.request.c
    public void b() {
        this.d = false;
        this.c.b();
        this.b.b();
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean b(c cVar) {
        return j() && (cVar.equals(this.b) || !this.b.e());
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean c() {
        return this.b.c();
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean c(c cVar) {
        return l() && cVar.equals(this.b) && !i();
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean d(c cVar) {
        return k() && cVar.equals(this.b);
    }

    @Override // com.kwad.sdk.glide.request.d
    public void e(c cVar) {
        if (cVar.equals(this.c)) {
            return;
        }
        if (this.f6832a != null) {
            this.f6832a.e(this);
        }
        if (this.c.e_()) {
            return;
        }
        this.c.b();
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean e() {
        return this.b.e() || this.c.e();
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean e_() {
        return this.b.e_() || this.c.e_();
    }

    @Override // com.kwad.sdk.glide.request.d
    public void f(c cVar) {
        if (cVar.equals(this.b) && this.f6832a != null) {
            this.f6832a.f(this);
        }
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean f() {
        return this.b.f();
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean g() {
        return this.b.g();
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

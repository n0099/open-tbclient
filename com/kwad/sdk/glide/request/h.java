package com.kwad.sdk.glide.request;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
/* loaded from: classes3.dex */
public class h implements c, d {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final d f10356a;

    /* renamed from: b  reason: collision with root package name */
    private c f10357b;
    private c c;
    private boolean d;

    @VisibleForTesting
    h() {
        this(null);
    }

    public h(@Nullable d dVar) {
        this.f10356a = dVar;
    }

    private boolean j() {
        return this.f10356a == null || this.f10356a.b(this);
    }

    private boolean k() {
        return this.f10356a == null || this.f10356a.d(this);
    }

    private boolean l() {
        return this.f10356a == null || this.f10356a.c(this);
    }

    private boolean m() {
        return this.f10356a != null && this.f10356a.i();
    }

    @Override // com.kwad.sdk.glide.request.c
    public void a() {
        this.d = true;
        if (!this.f10357b.e_() && !this.c.c()) {
            this.c.a();
        }
        if (!this.d || this.f10357b.c()) {
            return;
        }
        this.f10357b.a();
    }

    public void a(c cVar, c cVar2) {
        this.f10357b = cVar;
        this.c = cVar2;
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean a(c cVar) {
        if (cVar instanceof h) {
            h hVar = (h) cVar;
            if (this.f10357b == null) {
                if (hVar.f10357b != null) {
                    return false;
                }
            } else if (!this.f10357b.a(hVar.f10357b)) {
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
        this.f10357b.b();
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean b(c cVar) {
        return j() && (cVar.equals(this.f10357b) || !this.f10357b.e());
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean c() {
        return this.f10357b.c();
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean c(c cVar) {
        return l() && cVar.equals(this.f10357b) && !i();
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean d(c cVar) {
        return k() && cVar.equals(this.f10357b);
    }

    @Override // com.kwad.sdk.glide.request.d
    public void e(c cVar) {
        if (cVar.equals(this.c)) {
            return;
        }
        if (this.f10356a != null) {
            this.f10356a.e(this);
        }
        if (this.c.e_()) {
            return;
        }
        this.c.b();
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean e() {
        return this.f10357b.e() || this.c.e();
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean e_() {
        return this.f10357b.e_() || this.c.e_();
    }

    @Override // com.kwad.sdk.glide.request.d
    public void f(c cVar) {
        if (cVar.equals(this.f10357b) && this.f10356a != null) {
            this.f10356a.f(this);
        }
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean f() {
        return this.f10357b.f();
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean g() {
        return this.f10357b.g();
    }

    @Override // com.kwad.sdk.glide.request.c
    public void h() {
        this.f10357b.h();
        this.c.h();
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean i() {
        return m() || e();
    }
}

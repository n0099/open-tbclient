package com.kwad.sdk.glide.request;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
/* loaded from: classes7.dex */
public class h implements c, d {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final d f36497a;

    /* renamed from: b  reason: collision with root package name */
    public c f36498b;

    /* renamed from: c  reason: collision with root package name */
    public c f36499c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36500d;

    @VisibleForTesting
    public h() {
        this(null);
    }

    public h(@Nullable d dVar) {
        this.f36497a = dVar;
    }

    private boolean j() {
        d dVar = this.f36497a;
        return dVar == null || dVar.b(this);
    }

    private boolean k() {
        d dVar = this.f36497a;
        return dVar == null || dVar.d(this);
    }

    private boolean l() {
        d dVar = this.f36497a;
        return dVar == null || dVar.c(this);
    }

    private boolean m() {
        d dVar = this.f36497a;
        return dVar != null && dVar.i();
    }

    @Override // com.kwad.sdk.glide.request.c
    public void a() {
        this.f36500d = true;
        if (!this.f36498b.e_() && !this.f36499c.c()) {
            this.f36499c.a();
        }
        if (!this.f36500d || this.f36498b.c()) {
            return;
        }
        this.f36498b.a();
    }

    public void a(c cVar, c cVar2) {
        this.f36498b = cVar;
        this.f36499c = cVar2;
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean a(c cVar) {
        if (cVar instanceof h) {
            h hVar = (h) cVar;
            c cVar2 = this.f36498b;
            if (cVar2 == null) {
                if (hVar.f36498b != null) {
                    return false;
                }
            } else if (!cVar2.a(hVar.f36498b)) {
                return false;
            }
            c cVar3 = this.f36499c;
            c cVar4 = hVar.f36499c;
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
        this.f36500d = false;
        this.f36499c.b();
        this.f36498b.b();
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean b(c cVar) {
        return j() && (cVar.equals(this.f36498b) || !this.f36498b.e());
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean c() {
        return this.f36498b.c();
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean c(c cVar) {
        return l() && cVar.equals(this.f36498b) && !i();
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean d(c cVar) {
        return k() && cVar.equals(this.f36498b);
    }

    @Override // com.kwad.sdk.glide.request.d
    public void e(c cVar) {
        if (cVar.equals(this.f36499c)) {
            return;
        }
        d dVar = this.f36497a;
        if (dVar != null) {
            dVar.e(this);
        }
        if (this.f36499c.e_()) {
            return;
        }
        this.f36499c.b();
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean e() {
        return this.f36498b.e() || this.f36499c.e();
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean e_() {
        return this.f36498b.e_() || this.f36499c.e_();
    }

    @Override // com.kwad.sdk.glide.request.d
    public void f(c cVar) {
        d dVar;
        if (cVar.equals(this.f36498b) && (dVar = this.f36497a) != null) {
            dVar.f(this);
        }
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean f() {
        return this.f36498b.f();
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean g() {
        return this.f36498b.g();
    }

    @Override // com.kwad.sdk.glide.request.c
    public void h() {
        this.f36498b.h();
        this.f36499c.h();
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean i() {
        return m() || e();
    }
}

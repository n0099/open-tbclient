package com.kwad.sdk.glide.request;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
/* loaded from: classes6.dex */
public class h implements c, d {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final d f36088a;

    /* renamed from: b  reason: collision with root package name */
    public c f36089b;

    /* renamed from: c  reason: collision with root package name */
    public c f36090c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36091d;

    @VisibleForTesting
    public h() {
        this(null);
    }

    public h(@Nullable d dVar) {
        this.f36088a = dVar;
    }

    private boolean j() {
        d dVar = this.f36088a;
        return dVar == null || dVar.b(this);
    }

    private boolean k() {
        d dVar = this.f36088a;
        return dVar == null || dVar.d(this);
    }

    private boolean l() {
        d dVar = this.f36088a;
        return dVar == null || dVar.c(this);
    }

    private boolean m() {
        d dVar = this.f36088a;
        return dVar != null && dVar.i();
    }

    @Override // com.kwad.sdk.glide.request.c
    public void a() {
        this.f36091d = true;
        if (!this.f36089b.e_() && !this.f36090c.c()) {
            this.f36090c.a();
        }
        if (!this.f36091d || this.f36089b.c()) {
            return;
        }
        this.f36089b.a();
    }

    public void a(c cVar, c cVar2) {
        this.f36089b = cVar;
        this.f36090c = cVar2;
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean a(c cVar) {
        if (cVar instanceof h) {
            h hVar = (h) cVar;
            c cVar2 = this.f36089b;
            if (cVar2 == null) {
                if (hVar.f36089b != null) {
                    return false;
                }
            } else if (!cVar2.a(hVar.f36089b)) {
                return false;
            }
            c cVar3 = this.f36090c;
            c cVar4 = hVar.f36090c;
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
        this.f36091d = false;
        this.f36090c.b();
        this.f36089b.b();
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean b(c cVar) {
        return j() && (cVar.equals(this.f36089b) || !this.f36089b.e());
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean c() {
        return this.f36089b.c();
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean c(c cVar) {
        return l() && cVar.equals(this.f36089b) && !i();
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean d(c cVar) {
        return k() && cVar.equals(this.f36089b);
    }

    @Override // com.kwad.sdk.glide.request.d
    public void e(c cVar) {
        if (cVar.equals(this.f36090c)) {
            return;
        }
        d dVar = this.f36088a;
        if (dVar != null) {
            dVar.e(this);
        }
        if (this.f36090c.e_()) {
            return;
        }
        this.f36090c.b();
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean e() {
        return this.f36089b.e() || this.f36090c.e();
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean e_() {
        return this.f36089b.e_() || this.f36090c.e_();
    }

    @Override // com.kwad.sdk.glide.request.d
    public void f(c cVar) {
        d dVar;
        if (cVar.equals(this.f36089b) && (dVar = this.f36088a) != null) {
            dVar.f(this);
        }
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean f() {
        return this.f36089b.f();
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean g() {
        return this.f36089b.g();
    }

    @Override // com.kwad.sdk.glide.request.c
    public void h() {
        this.f36089b.h();
        this.f36090c.h();
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean i() {
        return m() || e();
    }
}

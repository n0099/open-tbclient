package com.kwad.sdk.core.video.kwai;

import com.kwad.sdk.core.video.kwai.c;
/* loaded from: classes5.dex */
public abstract class a implements c {
    public c.e a;
    public c.b b;
    public c.a c;
    public c.f d;
    public c.h e;
    public c.InterfaceC0547c f;
    public c.d g;
    public c.g h;

    public final void a() {
        this.a = null;
        this.c = null;
        this.b = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
    }

    public final void a(int i) {
        c.a aVar = this.c;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public final void a(int i, int i2) {
        c.h hVar = this.e;
        if (hVar != null) {
            hVar.a(i, i2);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(c.a aVar) {
        this.c = aVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(c.b bVar) {
        this.b = bVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(c.InterfaceC0547c interfaceC0547c) {
        this.f = interfaceC0547c;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(c.d dVar) {
        this.g = dVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(c.e eVar) {
        this.a = eVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(c.f fVar) {
        this.d = null;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(c.h hVar) {
        this.e = hVar;
    }

    public final void b() {
        c.e eVar = this.a;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    public final boolean b(int i, int i2) {
        c.InterfaceC0547c interfaceC0547c = this.f;
        if (interfaceC0547c != null) {
            interfaceC0547c.a(i, i2);
            return true;
        }
        return false;
    }

    public final void c() {
        c.b bVar = this.b;
        if (bVar != null) {
            bVar.a();
        }
    }

    public final boolean c(int i, int i2) {
        c.d dVar = this.g;
        if (dVar != null) {
            dVar.a(i, i2);
            return true;
        }
        return false;
    }
}

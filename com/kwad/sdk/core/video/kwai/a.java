package com.kwad.sdk.core.video.kwai;

import android.media.TimedText;
import com.kwad.sdk.core.video.kwai.c;
/* loaded from: classes5.dex */
public abstract class a implements c {
    public c.e a;
    public c.b b;
    public c.a c;
    public c.f d;
    public c.h e;
    public c.InterfaceC0315c f;
    public c.d g;
    public c.g h;

    public void a() {
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
            aVar.a(this, i);
        }
    }

    public final void a(int i, int i2) {
        c.h hVar = this.e;
        if (hVar != null) {
            hVar.a(this, i, i2);
        }
    }

    public final void a(TimedText timedText) {
        c.g gVar = this.h;
        if (gVar != null) {
            gVar.a(this, timedText);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.a aVar) {
        this.c = aVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.b bVar) {
        this.b = bVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.InterfaceC0315c interfaceC0315c) {
        this.f = interfaceC0315c;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.d dVar) {
        this.g = dVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.e eVar) {
        this.a = eVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.f fVar) {
        this.d = fVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.h hVar) {
        this.e = hVar;
    }

    public final void b() {
        c.e eVar = this.a;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    public final boolean b(int i, int i2) {
        c.InterfaceC0315c interfaceC0315c = this.f;
        return interfaceC0315c != null && interfaceC0315c.a(this, i, i2);
    }

    public final void c() {
        c.b bVar = this.b;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public final boolean c(int i, int i2) {
        c.d dVar = this.g;
        return dVar != null && dVar.a(this, i, i2);
    }

    public final void d() {
        c.f fVar = this.d;
        if (fVar != null) {
            fVar.a(this);
        }
    }
}

package com.kwad.sdk.core.video.kwai;

import android.media.TimedText;
import com.kwad.sdk.core.video.kwai.c;
/* loaded from: classes3.dex */
public abstract class a implements c {
    public c.e a;

    /* renamed from: b  reason: collision with root package name */
    public c.b f58417b;

    /* renamed from: c  reason: collision with root package name */
    public c.a f58418c;

    /* renamed from: d  reason: collision with root package name */
    public c.f f58419d;

    /* renamed from: e  reason: collision with root package name */
    public c.h f58420e;

    /* renamed from: f  reason: collision with root package name */
    public c.InterfaceC2094c f58421f;

    /* renamed from: g  reason: collision with root package name */
    public c.d f58422g;

    /* renamed from: h  reason: collision with root package name */
    public c.g f58423h;

    public void a() {
        this.a = null;
        this.f58418c = null;
        this.f58417b = null;
        this.f58419d = null;
        this.f58420e = null;
        this.f58421f = null;
        this.f58422g = null;
        this.f58423h = null;
    }

    public final void a(int i2) {
        c.a aVar = this.f58418c;
        if (aVar != null) {
            aVar.a(this, i2);
        }
    }

    public final void a(int i2, int i3) {
        c.h hVar = this.f58420e;
        if (hVar != null) {
            hVar.a(this, i2, i3);
        }
    }

    public final void a(TimedText timedText) {
        c.g gVar = this.f58423h;
        if (gVar != null) {
            gVar.a(this, timedText);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.a aVar) {
        this.f58418c = aVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.b bVar) {
        this.f58417b = bVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.InterfaceC2094c interfaceC2094c) {
        this.f58421f = interfaceC2094c;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.d dVar) {
        this.f58422g = dVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.e eVar) {
        this.a = eVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.f fVar) {
        this.f58419d = fVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.h hVar) {
        this.f58420e = hVar;
    }

    public final void b() {
        c.e eVar = this.a;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    public final boolean b(int i2, int i3) {
        c.InterfaceC2094c interfaceC2094c = this.f58421f;
        return interfaceC2094c != null && interfaceC2094c.a(this, i2, i3);
    }

    public final void c() {
        c.b bVar = this.f58417b;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public final boolean c(int i2, int i3) {
        c.d dVar = this.f58422g;
        return dVar != null && dVar.a(this, i2, i3);
    }

    public final void d() {
        c.f fVar = this.f58419d;
        if (fVar != null) {
            fVar.a(this);
        }
    }
}

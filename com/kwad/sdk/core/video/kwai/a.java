package com.kwad.sdk.core.video.kwai;

import android.media.TimedText;
import com.kwad.sdk.core.video.kwai.c;
/* loaded from: classes8.dex */
public abstract class a implements c {
    public c.e a;

    /* renamed from: b  reason: collision with root package name */
    public c.b f54774b;

    /* renamed from: c  reason: collision with root package name */
    public c.a f54775c;

    /* renamed from: d  reason: collision with root package name */
    public c.f f54776d;

    /* renamed from: e  reason: collision with root package name */
    public c.h f54777e;

    /* renamed from: f  reason: collision with root package name */
    public c.InterfaceC2106c f54778f;

    /* renamed from: g  reason: collision with root package name */
    public c.d f54779g;

    /* renamed from: h  reason: collision with root package name */
    public c.g f54780h;

    public void a() {
        this.a = null;
        this.f54775c = null;
        this.f54774b = null;
        this.f54776d = null;
        this.f54777e = null;
        this.f54778f = null;
        this.f54779g = null;
        this.f54780h = null;
    }

    public final void a(int i2) {
        c.a aVar = this.f54775c;
        if (aVar != null) {
            aVar.a(this, i2);
        }
    }

    public final void a(int i2, int i3) {
        c.h hVar = this.f54777e;
        if (hVar != null) {
            hVar.a(this, i2, i3);
        }
    }

    public final void a(TimedText timedText) {
        c.g gVar = this.f54780h;
        if (gVar != null) {
            gVar.a(this, timedText);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.a aVar) {
        this.f54775c = aVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.b bVar) {
        this.f54774b = bVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.InterfaceC2106c interfaceC2106c) {
        this.f54778f = interfaceC2106c;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.d dVar) {
        this.f54779g = dVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.e eVar) {
        this.a = eVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.f fVar) {
        this.f54776d = fVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.h hVar) {
        this.f54777e = hVar;
    }

    public final void b() {
        c.e eVar = this.a;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    public final boolean b(int i2, int i3) {
        c.InterfaceC2106c interfaceC2106c = this.f54778f;
        return interfaceC2106c != null && interfaceC2106c.a(this, i2, i3);
    }

    public final void c() {
        c.b bVar = this.f54774b;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public final boolean c(int i2, int i3) {
        c.d dVar = this.f54779g;
        return dVar != null && dVar.a(this, i2, i3);
    }

    public final void d() {
        c.f fVar = this.f54776d;
        if (fVar != null) {
            fVar.a(this);
        }
    }
}

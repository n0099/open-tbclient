package com.kwad.sdk.core.video.kwai;

import android.media.TimedText;
import com.kwad.sdk.core.video.kwai.c;
/* loaded from: classes7.dex */
public abstract class a implements c {
    public c.e a;

    /* renamed from: b  reason: collision with root package name */
    public c.b f39875b;

    /* renamed from: c  reason: collision with root package name */
    public c.a f39876c;

    /* renamed from: d  reason: collision with root package name */
    public c.f f39877d;

    /* renamed from: e  reason: collision with root package name */
    public c.h f39878e;

    /* renamed from: f  reason: collision with root package name */
    public c.InterfaceC1967c f39879f;

    /* renamed from: g  reason: collision with root package name */
    public c.d f39880g;

    /* renamed from: h  reason: collision with root package name */
    public c.g f39881h;

    public void a() {
        this.a = null;
        this.f39876c = null;
        this.f39875b = null;
        this.f39877d = null;
        this.f39878e = null;
        this.f39879f = null;
        this.f39880g = null;
        this.f39881h = null;
    }

    public final void a(int i) {
        c.a aVar = this.f39876c;
        if (aVar != null) {
            aVar.a(this, i);
        }
    }

    public final void a(int i, int i2) {
        c.h hVar = this.f39878e;
        if (hVar != null) {
            hVar.a(this, i, i2);
        }
    }

    public final void a(TimedText timedText) {
        c.g gVar = this.f39881h;
        if (gVar != null) {
            gVar.a(this, timedText);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.a aVar) {
        this.f39876c = aVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.b bVar) {
        this.f39875b = bVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.InterfaceC1967c interfaceC1967c) {
        this.f39879f = interfaceC1967c;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.d dVar) {
        this.f39880g = dVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.e eVar) {
        this.a = eVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.f fVar) {
        this.f39877d = fVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.h hVar) {
        this.f39878e = hVar;
    }

    public final void b() {
        c.e eVar = this.a;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    public final boolean b(int i, int i2) {
        c.InterfaceC1967c interfaceC1967c = this.f39879f;
        return interfaceC1967c != null && interfaceC1967c.a(this, i, i2);
    }

    public final void c() {
        c.b bVar = this.f39875b;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public final boolean c(int i, int i2) {
        c.d dVar = this.f39880g;
        return dVar != null && dVar.a(this, i, i2);
    }

    public final void d() {
        c.f fVar = this.f39877d;
        if (fVar != null) {
            fVar.a(this);
        }
    }
}

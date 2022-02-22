package com.kwad.sdk.core.video.kwai;

import android.media.TimedText;
import com.kwad.sdk.core.video.kwai.c;
/* loaded from: classes4.dex */
public abstract class a implements c {
    public c.e a;

    /* renamed from: b  reason: collision with root package name */
    public c.b f56424b;

    /* renamed from: c  reason: collision with root package name */
    public c.a f56425c;

    /* renamed from: d  reason: collision with root package name */
    public c.f f56426d;

    /* renamed from: e  reason: collision with root package name */
    public c.h f56427e;

    /* renamed from: f  reason: collision with root package name */
    public c.InterfaceC2127c f56428f;

    /* renamed from: g  reason: collision with root package name */
    public c.d f56429g;

    /* renamed from: h  reason: collision with root package name */
    public c.g f56430h;

    public void a() {
        this.a = null;
        this.f56425c = null;
        this.f56424b = null;
        this.f56426d = null;
        this.f56427e = null;
        this.f56428f = null;
        this.f56429g = null;
        this.f56430h = null;
    }

    public final void a(int i2) {
        c.a aVar = this.f56425c;
        if (aVar != null) {
            aVar.a(this, i2);
        }
    }

    public final void a(int i2, int i3) {
        c.h hVar = this.f56427e;
        if (hVar != null) {
            hVar.a(this, i2, i3);
        }
    }

    public final void a(TimedText timedText) {
        c.g gVar = this.f56430h;
        if (gVar != null) {
            gVar.a(this, timedText);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.a aVar) {
        this.f56425c = aVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.b bVar) {
        this.f56424b = bVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.InterfaceC2127c interfaceC2127c) {
        this.f56428f = interfaceC2127c;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.d dVar) {
        this.f56429g = dVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.e eVar) {
        this.a = eVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.f fVar) {
        this.f56426d = fVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.h hVar) {
        this.f56427e = hVar;
    }

    public final void b() {
        c.e eVar = this.a;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    public final boolean b(int i2, int i3) {
        c.InterfaceC2127c interfaceC2127c = this.f56428f;
        return interfaceC2127c != null && interfaceC2127c.a(this, i2, i3);
    }

    public final void c() {
        c.b bVar = this.f56424b;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public final boolean c(int i2, int i3) {
        c.d dVar = this.f56429g;
        return dVar != null && dVar.a(this, i2, i3);
    }

    public final void d() {
        c.f fVar = this.f56426d;
        if (fVar != null) {
            fVar.a(this);
        }
    }
}

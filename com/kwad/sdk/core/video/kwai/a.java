package com.kwad.sdk.core.video.kwai;

import android.media.TimedText;
import com.kwad.sdk.core.video.kwai.c;
/* loaded from: classes3.dex */
public abstract class a implements c {
    public c.e a;

    /* renamed from: b  reason: collision with root package name */
    public c.b f56257b;

    /* renamed from: c  reason: collision with root package name */
    public c.a f56258c;

    /* renamed from: d  reason: collision with root package name */
    public c.f f56259d;

    /* renamed from: e  reason: collision with root package name */
    public c.h f56260e;

    /* renamed from: f  reason: collision with root package name */
    public c.InterfaceC2117c f56261f;

    /* renamed from: g  reason: collision with root package name */
    public c.d f56262g;

    /* renamed from: h  reason: collision with root package name */
    public c.g f56263h;

    public void a() {
        this.a = null;
        this.f56258c = null;
        this.f56257b = null;
        this.f56259d = null;
        this.f56260e = null;
        this.f56261f = null;
        this.f56262g = null;
        this.f56263h = null;
    }

    public final void a(int i2) {
        c.a aVar = this.f56258c;
        if (aVar != null) {
            aVar.a(this, i2);
        }
    }

    public final void a(int i2, int i3) {
        c.h hVar = this.f56260e;
        if (hVar != null) {
            hVar.a(this, i2, i3);
        }
    }

    public final void a(TimedText timedText) {
        c.g gVar = this.f56263h;
        if (gVar != null) {
            gVar.a(this, timedText);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.a aVar) {
        this.f56258c = aVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.b bVar) {
        this.f56257b = bVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.InterfaceC2117c interfaceC2117c) {
        this.f56261f = interfaceC2117c;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.d dVar) {
        this.f56262g = dVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.e eVar) {
        this.a = eVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.f fVar) {
        this.f56259d = fVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.h hVar) {
        this.f56260e = hVar;
    }

    public final void b() {
        c.e eVar = this.a;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    public final boolean b(int i2, int i3) {
        c.InterfaceC2117c interfaceC2117c = this.f56261f;
        return interfaceC2117c != null && interfaceC2117c.a(this, i2, i3);
    }

    public final void c() {
        c.b bVar = this.f56257b;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public final boolean c(int i2, int i3) {
        c.d dVar = this.f56262g;
        return dVar != null && dVar.a(this, i2, i3);
    }

    public final void d() {
        c.f fVar = this.f56259d;
        if (fVar != null) {
            fVar.a(this);
        }
    }
}

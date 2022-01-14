package com.kwad.sdk.core.video.kwai;

import android.media.TimedText;
import com.kwad.sdk.core.video.kwai.c;
/* loaded from: classes3.dex */
public abstract class a implements c {
    public c.e a;

    /* renamed from: b  reason: collision with root package name */
    public c.b f56212b;

    /* renamed from: c  reason: collision with root package name */
    public c.a f56213c;

    /* renamed from: d  reason: collision with root package name */
    public c.f f56214d;

    /* renamed from: e  reason: collision with root package name */
    public c.h f56215e;

    /* renamed from: f  reason: collision with root package name */
    public c.InterfaceC2111c f56216f;

    /* renamed from: g  reason: collision with root package name */
    public c.d f56217g;

    /* renamed from: h  reason: collision with root package name */
    public c.g f56218h;

    public void a() {
        this.a = null;
        this.f56213c = null;
        this.f56212b = null;
        this.f56214d = null;
        this.f56215e = null;
        this.f56216f = null;
        this.f56217g = null;
        this.f56218h = null;
    }

    public final void a(int i2) {
        c.a aVar = this.f56213c;
        if (aVar != null) {
            aVar.a(this, i2);
        }
    }

    public final void a(int i2, int i3) {
        c.h hVar = this.f56215e;
        if (hVar != null) {
            hVar.a(this, i2, i3);
        }
    }

    public final void a(TimedText timedText) {
        c.g gVar = this.f56218h;
        if (gVar != null) {
            gVar.a(this, timedText);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.a aVar) {
        this.f56213c = aVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.b bVar) {
        this.f56212b = bVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.InterfaceC2111c interfaceC2111c) {
        this.f56216f = interfaceC2111c;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.d dVar) {
        this.f56217g = dVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.e eVar) {
        this.a = eVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.f fVar) {
        this.f56214d = fVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(c.h hVar) {
        this.f56215e = hVar;
    }

    public final void b() {
        c.e eVar = this.a;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    public final boolean b(int i2, int i3) {
        c.InterfaceC2111c interfaceC2111c = this.f56216f;
        return interfaceC2111c != null && interfaceC2111c.a(this, i2, i3);
    }

    public final void c() {
        c.b bVar = this.f56212b;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public final boolean c(int i2, int i3) {
        c.d dVar = this.f56217g;
        return dVar != null && dVar.a(this, i2, i3);
    }

    public final void d() {
        c.f fVar = this.f56214d;
        if (fVar != null) {
            fVar.a(this);
        }
    }
}

package com.kwad.sdk.core.video.a;

import android.media.TimedText;
import com.kwad.sdk.core.video.a.c;
/* loaded from: classes6.dex */
public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public c.e f34089a;

    /* renamed from: b  reason: collision with root package name */
    public c.b f34090b;

    /* renamed from: c  reason: collision with root package name */
    public c.a f34091c;

    /* renamed from: d  reason: collision with root package name */
    public c.f f34092d;

    /* renamed from: e  reason: collision with root package name */
    public c.h f34093e;

    /* renamed from: f  reason: collision with root package name */
    public c.InterfaceC0390c f34094f;

    /* renamed from: g  reason: collision with root package name */
    public c.d f34095g;

    /* renamed from: h  reason: collision with root package name */
    public c.g f34096h;

    public void a() {
        this.f34089a = null;
        this.f34091c = null;
        this.f34090b = null;
        this.f34092d = null;
        this.f34093e = null;
        this.f34094f = null;
        this.f34095g = null;
        this.f34096h = null;
    }

    public final void a(int i) {
        c.a aVar = this.f34091c;
        if (aVar != null) {
            aVar.a(this, i);
        }
    }

    public final void a(int i, int i2) {
        c.h hVar = this.f34093e;
        if (hVar != null) {
            hVar.a(this, i, i2);
        }
    }

    public final void a(TimedText timedText) {
        c.g gVar = this.f34096h;
        if (gVar != null) {
            gVar.a(this, timedText);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.a aVar) {
        this.f34091c = aVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.b bVar) {
        this.f34090b = bVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.InterfaceC0390c interfaceC0390c) {
        this.f34094f = interfaceC0390c;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.d dVar) {
        this.f34095g = dVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.e eVar) {
        this.f34089a = eVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.f fVar) {
        this.f34092d = fVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.h hVar) {
        this.f34093e = hVar;
    }

    public final void b() {
        c.e eVar = this.f34089a;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    public final boolean b(int i, int i2) {
        c.InterfaceC0390c interfaceC0390c = this.f34094f;
        return interfaceC0390c != null && interfaceC0390c.a(this, i, i2);
    }

    public final void c() {
        c.b bVar = this.f34090b;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public final boolean c(int i, int i2) {
        c.d dVar = this.f34095g;
        return dVar != null && dVar.a(this, i, i2);
    }

    public final void d() {
        c.f fVar = this.f34092d;
        if (fVar != null) {
            fVar.a(this);
        }
    }
}

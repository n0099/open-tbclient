package com.kwad.sdk.core.video.a;

import android.media.TimedText;
import com.kwad.sdk.core.video.a.c;
/* loaded from: classes6.dex */
public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public c.e f34090a;

    /* renamed from: b  reason: collision with root package name */
    public c.b f34091b;

    /* renamed from: c  reason: collision with root package name */
    public c.a f34092c;

    /* renamed from: d  reason: collision with root package name */
    public c.f f34093d;

    /* renamed from: e  reason: collision with root package name */
    public c.h f34094e;

    /* renamed from: f  reason: collision with root package name */
    public c.InterfaceC0391c f34095f;

    /* renamed from: g  reason: collision with root package name */
    public c.d f34096g;

    /* renamed from: h  reason: collision with root package name */
    public c.g f34097h;

    public void a() {
        this.f34090a = null;
        this.f34092c = null;
        this.f34091b = null;
        this.f34093d = null;
        this.f34094e = null;
        this.f34095f = null;
        this.f34096g = null;
        this.f34097h = null;
    }

    public final void a(int i) {
        c.a aVar = this.f34092c;
        if (aVar != null) {
            aVar.a(this, i);
        }
    }

    public final void a(int i, int i2) {
        c.h hVar = this.f34094e;
        if (hVar != null) {
            hVar.a(this, i, i2);
        }
    }

    public final void a(TimedText timedText) {
        c.g gVar = this.f34097h;
        if (gVar != null) {
            gVar.a(this, timedText);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.a aVar) {
        this.f34092c = aVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.b bVar) {
        this.f34091b = bVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.InterfaceC0391c interfaceC0391c) {
        this.f34095f = interfaceC0391c;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.d dVar) {
        this.f34096g = dVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.e eVar) {
        this.f34090a = eVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.f fVar) {
        this.f34093d = fVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.h hVar) {
        this.f34094e = hVar;
    }

    public final void b() {
        c.e eVar = this.f34090a;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    public final boolean b(int i, int i2) {
        c.InterfaceC0391c interfaceC0391c = this.f34095f;
        return interfaceC0391c != null && interfaceC0391c.a(this, i, i2);
    }

    public final void c() {
        c.b bVar = this.f34091b;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public final boolean c(int i, int i2) {
        c.d dVar = this.f34096g;
        return dVar != null && dVar.a(this, i, i2);
    }

    public final void d() {
        c.f fVar = this.f34093d;
        if (fVar != null) {
            fVar.a(this);
        }
    }
}

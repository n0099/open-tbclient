package com.kwad.sdk.core.video.a;

import android.media.TimedText;
import com.kwad.sdk.core.video.a.c;
/* loaded from: classes6.dex */
public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public c.e f32706a;

    /* renamed from: b  reason: collision with root package name */
    public c.b f32707b;

    /* renamed from: c  reason: collision with root package name */
    public c.a f32708c;

    /* renamed from: d  reason: collision with root package name */
    public c.f f32709d;

    /* renamed from: e  reason: collision with root package name */
    public c.h f32710e;

    /* renamed from: f  reason: collision with root package name */
    public c.InterfaceC0369c f32711f;

    /* renamed from: g  reason: collision with root package name */
    public c.d f32712g;

    /* renamed from: h  reason: collision with root package name */
    public c.g f32713h;

    public void a() {
        this.f32706a = null;
        this.f32708c = null;
        this.f32707b = null;
        this.f32709d = null;
        this.f32710e = null;
        this.f32711f = null;
        this.f32712g = null;
        this.f32713h = null;
    }

    public final void a(int i2) {
        c.a aVar = this.f32708c;
        if (aVar != null) {
            aVar.a(this, i2);
        }
    }

    public final void a(int i2, int i3) {
        c.h hVar = this.f32710e;
        if (hVar != null) {
            hVar.a(this, i2, i3);
        }
    }

    public final void a(TimedText timedText) {
        c.g gVar = this.f32713h;
        if (gVar != null) {
            gVar.a(this, timedText);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.a aVar) {
        this.f32708c = aVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.b bVar) {
        this.f32707b = bVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.InterfaceC0369c interfaceC0369c) {
        this.f32711f = interfaceC0369c;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.d dVar) {
        this.f32712g = dVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.e eVar) {
        this.f32706a = eVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.f fVar) {
        this.f32709d = fVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.h hVar) {
        this.f32710e = hVar;
    }

    public final void b() {
        c.e eVar = this.f32706a;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    public final boolean b(int i2, int i3) {
        c.InterfaceC0369c interfaceC0369c = this.f32711f;
        return interfaceC0369c != null && interfaceC0369c.a(this, i2, i3);
    }

    public final void c() {
        c.b bVar = this.f32707b;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public final boolean c(int i2, int i3) {
        c.d dVar = this.f32712g;
        return dVar != null && dVar.a(this, i2, i3);
    }

    public final void d() {
        c.f fVar = this.f32709d;
        if (fVar != null) {
            fVar.a(this);
        }
    }
}

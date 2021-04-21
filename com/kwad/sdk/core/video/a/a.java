package com.kwad.sdk.core.video.a;

import android.media.TimedText;
import com.kwad.sdk.core.video.a.c;
/* loaded from: classes6.dex */
public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public c.e f34474a;

    /* renamed from: b  reason: collision with root package name */
    public c.b f34475b;

    /* renamed from: c  reason: collision with root package name */
    public c.a f34476c;

    /* renamed from: d  reason: collision with root package name */
    public c.f f34477d;

    /* renamed from: e  reason: collision with root package name */
    public c.h f34478e;

    /* renamed from: f  reason: collision with root package name */
    public c.InterfaceC0408c f34479f;

    /* renamed from: g  reason: collision with root package name */
    public c.d f34480g;

    /* renamed from: h  reason: collision with root package name */
    public c.g f34481h;

    public void a() {
        this.f34474a = null;
        this.f34476c = null;
        this.f34475b = null;
        this.f34477d = null;
        this.f34478e = null;
        this.f34479f = null;
        this.f34480g = null;
        this.f34481h = null;
    }

    public final void a(int i) {
        c.a aVar = this.f34476c;
        if (aVar != null) {
            aVar.a(this, i);
        }
    }

    public final void a(int i, int i2) {
        c.h hVar = this.f34478e;
        if (hVar != null) {
            hVar.a(this, i, i2);
        }
    }

    public final void a(TimedText timedText) {
        c.g gVar = this.f34481h;
        if (gVar != null) {
            gVar.a(this, timedText);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.a aVar) {
        this.f34476c = aVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.b bVar) {
        this.f34475b = bVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.InterfaceC0408c interfaceC0408c) {
        this.f34479f = interfaceC0408c;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.d dVar) {
        this.f34480g = dVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.e eVar) {
        this.f34474a = eVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.f fVar) {
        this.f34477d = fVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.h hVar) {
        this.f34478e = hVar;
    }

    public final void b() {
        c.e eVar = this.f34474a;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    public final boolean b(int i, int i2) {
        c.InterfaceC0408c interfaceC0408c = this.f34479f;
        return interfaceC0408c != null && interfaceC0408c.a(this, i, i2);
    }

    public final void c() {
        c.b bVar = this.f34475b;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public final boolean c(int i, int i2) {
        c.d dVar = this.f34480g;
        return dVar != null && dVar.a(this, i, i2);
    }

    public final void d() {
        c.f fVar = this.f34477d;
        if (fVar != null) {
            fVar.a(this);
        }
    }
}

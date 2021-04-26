package com.kwad.sdk.core.video.a;

import android.media.TimedText;
import com.kwad.sdk.core.video.a.c;
/* loaded from: classes6.dex */
public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public c.e f33461a;

    /* renamed from: b  reason: collision with root package name */
    public c.b f33462b;

    /* renamed from: c  reason: collision with root package name */
    public c.a f33463c;

    /* renamed from: d  reason: collision with root package name */
    public c.f f33464d;

    /* renamed from: e  reason: collision with root package name */
    public c.h f33465e;

    /* renamed from: f  reason: collision with root package name */
    public c.InterfaceC0382c f33466f;

    /* renamed from: g  reason: collision with root package name */
    public c.d f33467g;

    /* renamed from: h  reason: collision with root package name */
    public c.g f33468h;

    public void a() {
        this.f33461a = null;
        this.f33463c = null;
        this.f33462b = null;
        this.f33464d = null;
        this.f33465e = null;
        this.f33466f = null;
        this.f33467g = null;
        this.f33468h = null;
    }

    public final void a(int i2) {
        c.a aVar = this.f33463c;
        if (aVar != null) {
            aVar.a(this, i2);
        }
    }

    public final void a(int i2, int i3) {
        c.h hVar = this.f33465e;
        if (hVar != null) {
            hVar.a(this, i2, i3);
        }
    }

    public final void a(TimedText timedText) {
        c.g gVar = this.f33468h;
        if (gVar != null) {
            gVar.a(this, timedText);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.a aVar) {
        this.f33463c = aVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.b bVar) {
        this.f33462b = bVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.InterfaceC0382c interfaceC0382c) {
        this.f33466f = interfaceC0382c;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.d dVar) {
        this.f33467g = dVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.e eVar) {
        this.f33461a = eVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.f fVar) {
        this.f33464d = fVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.h hVar) {
        this.f33465e = hVar;
    }

    public final void b() {
        c.e eVar = this.f33461a;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    public final boolean b(int i2, int i3) {
        c.InterfaceC0382c interfaceC0382c = this.f33466f;
        return interfaceC0382c != null && interfaceC0382c.a(this, i2, i3);
    }

    public final void c() {
        c.b bVar = this.f33462b;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public final boolean c(int i2, int i3) {
        c.d dVar = this.f33467g;
        return dVar != null && dVar.a(this, i2, i3);
    }

    public final void d() {
        c.f fVar = this.f33464d;
        if (fVar != null) {
            fVar.a(this);
        }
    }
}

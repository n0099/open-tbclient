package com.kwad.sdk.core.video.a;

import android.media.TimedText;
import com.kwad.sdk.core.video.a.c;
/* loaded from: classes6.dex */
public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public c.e f34379a;

    /* renamed from: b  reason: collision with root package name */
    public c.b f34380b;

    /* renamed from: c  reason: collision with root package name */
    public c.a f34381c;

    /* renamed from: d  reason: collision with root package name */
    public c.f f34382d;

    /* renamed from: e  reason: collision with root package name */
    public c.h f34383e;

    /* renamed from: f  reason: collision with root package name */
    public c.InterfaceC0405c f34384f;

    /* renamed from: g  reason: collision with root package name */
    public c.d f34385g;

    /* renamed from: h  reason: collision with root package name */
    public c.g f34386h;

    public void a() {
        this.f34379a = null;
        this.f34381c = null;
        this.f34380b = null;
        this.f34382d = null;
        this.f34383e = null;
        this.f34384f = null;
        this.f34385g = null;
        this.f34386h = null;
    }

    public final void a(int i) {
        c.a aVar = this.f34381c;
        if (aVar != null) {
            aVar.a(this, i);
        }
    }

    public final void a(int i, int i2) {
        c.h hVar = this.f34383e;
        if (hVar != null) {
            hVar.a(this, i, i2);
        }
    }

    public final void a(TimedText timedText) {
        c.g gVar = this.f34386h;
        if (gVar != null) {
            gVar.a(this, timedText);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.a aVar) {
        this.f34381c = aVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.b bVar) {
        this.f34380b = bVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.InterfaceC0405c interfaceC0405c) {
        this.f34384f = interfaceC0405c;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.d dVar) {
        this.f34385g = dVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.e eVar) {
        this.f34379a = eVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.f fVar) {
        this.f34382d = fVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.h hVar) {
        this.f34383e = hVar;
    }

    public final void b() {
        c.e eVar = this.f34379a;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    public final boolean b(int i, int i2) {
        c.InterfaceC0405c interfaceC0405c = this.f34384f;
        return interfaceC0405c != null && interfaceC0405c.a(this, i, i2);
    }

    public final void c() {
        c.b bVar = this.f34380b;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public final boolean c(int i, int i2) {
        c.d dVar = this.f34385g;
        return dVar != null && dVar.a(this, i, i2);
    }

    public final void d() {
        c.f fVar = this.f34382d;
        if (fVar != null) {
            fVar.a(this);
        }
    }
}

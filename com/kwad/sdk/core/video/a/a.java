package com.kwad.sdk.core.video.a;

import android.media.TimedText;
import com.kwad.sdk.core.video.a.c;
/* loaded from: classes7.dex */
public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public c.e f34825a;

    /* renamed from: b  reason: collision with root package name */
    public c.b f34826b;

    /* renamed from: c  reason: collision with root package name */
    public c.a f34827c;

    /* renamed from: d  reason: collision with root package name */
    public c.f f34828d;

    /* renamed from: e  reason: collision with root package name */
    public c.h f34829e;

    /* renamed from: f  reason: collision with root package name */
    public c.InterfaceC0394c f34830f;

    /* renamed from: g  reason: collision with root package name */
    public c.d f34831g;

    /* renamed from: h  reason: collision with root package name */
    public c.g f34832h;

    public void a() {
        this.f34825a = null;
        this.f34827c = null;
        this.f34826b = null;
        this.f34828d = null;
        this.f34829e = null;
        this.f34830f = null;
        this.f34831g = null;
        this.f34832h = null;
    }

    public final void a(int i2) {
        c.a aVar = this.f34827c;
        if (aVar != null) {
            aVar.a(this, i2);
        }
    }

    public final void a(int i2, int i3) {
        c.h hVar = this.f34829e;
        if (hVar != null) {
            hVar.a(this, i2, i3);
        }
    }

    public final void a(TimedText timedText) {
        c.g gVar = this.f34832h;
        if (gVar != null) {
            gVar.a(this, timedText);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.a aVar) {
        this.f34827c = aVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.b bVar) {
        this.f34826b = bVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.InterfaceC0394c interfaceC0394c) {
        this.f34830f = interfaceC0394c;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.d dVar) {
        this.f34831g = dVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.e eVar) {
        this.f34825a = eVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.f fVar) {
        this.f34828d = fVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.h hVar) {
        this.f34829e = hVar;
    }

    public final void b() {
        c.e eVar = this.f34825a;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    public final boolean b(int i2, int i3) {
        c.InterfaceC0394c interfaceC0394c = this.f34830f;
        return interfaceC0394c != null && interfaceC0394c.a(this, i2, i3);
    }

    public final void c() {
        c.b bVar = this.f34826b;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public final boolean c(int i2, int i3) {
        c.d dVar = this.f34831g;
        return dVar != null && dVar.a(this, i2, i3);
    }

    public final void d() {
        c.f fVar = this.f34828d;
        if (fVar != null) {
            fVar.a(this);
        }
    }
}

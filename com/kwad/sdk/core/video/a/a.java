package com.kwad.sdk.core.video.a;

import android.media.TimedText;
import com.kwad.sdk.core.video.a.c;
/* loaded from: classes7.dex */
public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public c.e f34727a;

    /* renamed from: b  reason: collision with root package name */
    public c.b f34728b;

    /* renamed from: c  reason: collision with root package name */
    public c.a f34729c;

    /* renamed from: d  reason: collision with root package name */
    public c.f f34730d;

    /* renamed from: e  reason: collision with root package name */
    public c.h f34731e;

    /* renamed from: f  reason: collision with root package name */
    public c.InterfaceC0391c f34732f;

    /* renamed from: g  reason: collision with root package name */
    public c.d f34733g;

    /* renamed from: h  reason: collision with root package name */
    public c.g f34734h;

    public void a() {
        this.f34727a = null;
        this.f34729c = null;
        this.f34728b = null;
        this.f34730d = null;
        this.f34731e = null;
        this.f34732f = null;
        this.f34733g = null;
        this.f34734h = null;
    }

    public final void a(int i2) {
        c.a aVar = this.f34729c;
        if (aVar != null) {
            aVar.a(this, i2);
        }
    }

    public final void a(int i2, int i3) {
        c.h hVar = this.f34731e;
        if (hVar != null) {
            hVar.a(this, i2, i3);
        }
    }

    public final void a(TimedText timedText) {
        c.g gVar = this.f34734h;
        if (gVar != null) {
            gVar.a(this, timedText);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.a aVar) {
        this.f34729c = aVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.b bVar) {
        this.f34728b = bVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.InterfaceC0391c interfaceC0391c) {
        this.f34732f = interfaceC0391c;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.d dVar) {
        this.f34733g = dVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.e eVar) {
        this.f34727a = eVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.f fVar) {
        this.f34730d = fVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.h hVar) {
        this.f34731e = hVar;
    }

    public final void b() {
        c.e eVar = this.f34727a;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    public final boolean b(int i2, int i3) {
        c.InterfaceC0391c interfaceC0391c = this.f34732f;
        return interfaceC0391c != null && interfaceC0391c.a(this, i2, i3);
    }

    public final void c() {
        c.b bVar = this.f34728b;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public final boolean c(int i2, int i3) {
        c.d dVar = this.f34733g;
        return dVar != null && dVar.a(this, i2, i3);
    }

    public final void d() {
        c.f fVar = this.f34730d;
        if (fVar != null) {
            fVar.a(this);
        }
    }
}

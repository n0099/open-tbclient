package com.kwad.sdk.core.video.a;

import android.media.TimedText;
import com.kwad.sdk.core.video.a.c;
/* loaded from: classes6.dex */
public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public c.e f32635a;

    /* renamed from: b  reason: collision with root package name */
    public c.b f32636b;

    /* renamed from: c  reason: collision with root package name */
    public c.a f32637c;

    /* renamed from: d  reason: collision with root package name */
    public c.f f32638d;

    /* renamed from: e  reason: collision with root package name */
    public c.h f32639e;

    /* renamed from: f  reason: collision with root package name */
    public c.InterfaceC0370c f32640f;

    /* renamed from: g  reason: collision with root package name */
    public c.d f32641g;

    /* renamed from: h  reason: collision with root package name */
    public c.g f32642h;

    public void a() {
        this.f32635a = null;
        this.f32637c = null;
        this.f32636b = null;
        this.f32638d = null;
        this.f32639e = null;
        this.f32640f = null;
        this.f32641g = null;
        this.f32642h = null;
    }

    public final void a(int i2) {
        c.a aVar = this.f32637c;
        if (aVar != null) {
            aVar.a(this, i2);
        }
    }

    public final void a(int i2, int i3) {
        c.h hVar = this.f32639e;
        if (hVar != null) {
            hVar.a(this, i2, i3);
        }
    }

    public final void a(TimedText timedText) {
        c.g gVar = this.f32642h;
        if (gVar != null) {
            gVar.a(this, timedText);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.a aVar) {
        this.f32637c = aVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.b bVar) {
        this.f32636b = bVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.InterfaceC0370c interfaceC0370c) {
        this.f32640f = interfaceC0370c;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.d dVar) {
        this.f32641g = dVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.e eVar) {
        this.f32635a = eVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.f fVar) {
        this.f32638d = fVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.h hVar) {
        this.f32639e = hVar;
    }

    public final void b() {
        c.e eVar = this.f32635a;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    public final boolean b(int i2, int i3) {
        c.InterfaceC0370c interfaceC0370c = this.f32640f;
        return interfaceC0370c != null && interfaceC0370c.a(this, i2, i3);
    }

    public final void c() {
        c.b bVar = this.f32636b;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public final boolean c(int i2, int i3) {
        c.d dVar = this.f32641g;
        return dVar != null && dVar.a(this, i2, i3);
    }

    public final void d() {
        c.f fVar = this.f32638d;
        if (fVar != null) {
            fVar.a(this);
        }
    }
}

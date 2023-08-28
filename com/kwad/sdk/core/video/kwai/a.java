package com.kwad.sdk.core.video.kwai;

import android.media.TimedText;
import com.kwad.sdk.core.video.kwai.c;
/* loaded from: classes10.dex */
public abstract class a implements c {
    public c.e JR;
    public c.h JS;
    public c.b JT;
    public c.InterfaceC0689c JU;
    public c.d JV;
    public c.a JW;
    public c.f adC;
    public c.g adD;

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(c.a aVar) {
        this.JW = aVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(c.b bVar) {
        this.JT = bVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(c.InterfaceC0689c interfaceC0689c) {
        this.JU = interfaceC0689c;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(c.f fVar) {
        this.adC = fVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(c.g gVar) {
        this.adD = gVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(c.h hVar) {
        this.JS = hVar;
    }

    public final void b(TimedText timedText) {
        c.g gVar = this.adD;
        if (gVar != null) {
            gVar.a(timedText);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void b(c.e eVar) {
        this.JR = eVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void c(c.d dVar) {
        this.JV = dVar;
    }

    public final void n(int i, int i2) {
        c.h hVar = this.JS;
        if (hVar != null) {
            hVar.i(i, i2);
        }
    }

    public final void notifyOnBufferingUpdate(int i) {
        c.a aVar = this.JW;
        if (aVar != null) {
            aVar.ai(i);
        }
    }

    public final void notifyOnCompletion() {
        c.b bVar = this.JT;
        if (bVar != null) {
            bVar.ns();
        }
    }

    public final boolean notifyOnError(int i, int i2) {
        c.InterfaceC0689c interfaceC0689c = this.JU;
        return interfaceC0689c != null && interfaceC0689c.j(i, i2);
    }

    public final boolean notifyOnInfo(int i, int i2) {
        c.d dVar = this.JV;
        return dVar != null && dVar.k(i, i2);
    }

    public final void notifyOnPrepared() {
        c.e eVar = this.JR;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    public final void notifyOnSeekComplete() {
        c.f fVar = this.adC;
        if (fVar != null) {
            fVar.nt();
        }
    }

    public final void resetListeners() {
        this.JR = null;
        this.JW = null;
        this.JT = null;
        this.adC = null;
        this.JS = null;
        this.JU = null;
        this.JV = null;
        this.adD = null;
    }
}

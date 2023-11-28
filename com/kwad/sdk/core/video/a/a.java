package com.kwad.sdk.core.video.a;

import android.media.TimedText;
import com.kwad.sdk.core.video.a.c;
/* loaded from: classes10.dex */
public abstract class a implements c {
    public c.e TR;
    public c.i TS;
    public c.b TT;
    public c.InterfaceC0713c TU;
    public c.d TV;
    public c.a TW;
    public c.f azV;
    public c.g azW;
    public c.h azX;

    public final void EO() {
        c.f fVar = this.azV;
        if (fVar != null) {
            fVar.rl();
        }
    }

    public final void notifyOnCompletion() {
        c.b bVar = this.TT;
        if (bVar != null) {
            bVar.oO();
        }
    }

    public final void notifyOnPrepared() {
        c.e eVar = this.TR;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    public final void notifyOnSeekComplete() {
        c.g gVar = this.azW;
        if (gVar != null) {
            gVar.oP();
        }
    }

    public final void resetListeners() {
        this.azV = null;
        this.TR = null;
        this.TW = null;
        this.TT = null;
        this.azW = null;
        this.TS = null;
        this.TU = null;
        this.TV = null;
        this.azX = null;
    }

    public static void f(float f) {
        if (f == 0.0f) {
            com.kwad.sdk.core.video.a.a.a.ea("autoMute");
        } else {
            com.kwad.sdk.core.video.a.a.a.ea("autoVoice");
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.a aVar) {
        this.TW = aVar;
    }

    public final void b(TimedText timedText) {
        c.h hVar = this.azX;
        if (hVar != null) {
            hVar.a(timedText);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void c(c.d dVar) {
        this.TV = dVar;
    }

    public final void notifyOnBufferingUpdate(int i) {
        c.a aVar = this.TW;
        if (aVar != null) {
            aVar.au(i);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.b bVar) {
        this.TT = bVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void b(c.e eVar) {
        this.TR = eVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.InterfaceC0713c interfaceC0713c) {
        this.TU = interfaceC0713c;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.f fVar) {
        this.azV = fVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.g gVar) {
        this.azW = gVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.h hVar) {
        this.azX = hVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.i iVar) {
        this.TS = iVar;
    }

    public final boolean notifyOnError(int i, int i2) {
        com.kwad.sdk.core.video.a.a.a.ea("videoPlayError");
        c.InterfaceC0713c interfaceC0713c = this.TU;
        if (interfaceC0713c != null && interfaceC0713c.n(i, i2)) {
            return true;
        }
        return false;
    }

    public final boolean notifyOnInfo(int i, int i2) {
        c.d dVar = this.TV;
        if (dVar != null && dVar.o(i, i2)) {
            return true;
        }
        return false;
    }

    public final void y(int i, int i2) {
        c.i iVar = this.TS;
        if (iVar != null) {
            iVar.m(i, i2);
        }
    }
}

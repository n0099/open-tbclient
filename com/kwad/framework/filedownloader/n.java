package com.kwad.framework.filedownloader;

import android.content.Context;
import com.kwad.framework.filedownloader.services.e;
import com.kwad.sdk.api.proxy.app.FileDownloadService;
/* loaded from: classes10.dex */
public final class n implements u {
    public final u aeB;

    /* loaded from: classes10.dex */
    public static final class a {
        public static final n aeC = new n((byte) 0);
    }

    public n() {
        u pVar;
        if (com.kwad.framework.filedownloader.f.e.wD().aia) {
            pVar = new o();
        } else {
            pVar = new p(FileDownloadService.SeparateProcessService.class);
        }
        this.aeB = pVar;
    }

    public static n uC() {
        return a.aeC;
    }

    public static e.a uD() {
        if (uC().aeB instanceof o) {
            return (e.a) uC().aeB;
        }
        return null;
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean isConnected() {
        return this.aeB.isConnected();
    }

    public /* synthetic */ n(byte b) {
        this();
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean aY(int i) {
        return this.aeB.aY(i);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final byte aZ(int i) {
        return this.aeB.aZ(i);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final void ak(Context context) {
        this.aeB.ak(context);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean ba(int i) {
        return this.aeB.ba(i);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwad.framework.filedownloader.d.b bVar, boolean z3) {
        return this.aeB.a(str, str2, z, i, i2, i3, z2, bVar, z3);
    }
}

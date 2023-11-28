package com.kwad.framework.filedownloader;

import android.content.Context;
import android.content.Intent;
import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.kwad.framework.filedownloader.services.e;
import com.kwad.sdk.api.proxy.app.FileDownloadService;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class o implements e.a, u {
    public static Class<?> aeD;
    public final ArrayList<Runnable> aeE = new ArrayList<>();
    public com.kwad.framework.filedownloader.services.e aeF;

    public static Class<?> uF() {
        if (aeD == null) {
            aeD = FileDownloadService.SharedMainProcessService.class;
        }
        return aeD;
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean isConnected() {
        if (this.aeF != null) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.framework.filedownloader.services.e.a
    public final void onDisconnected() {
        this.aeF = null;
        f.up().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.disconnected, uF()));
    }

    private void a(Context context, Runnable runnable) {
        context.startService(new Intent(context, uF()));
    }

    @Override // com.kwad.framework.filedownloader.services.e.a
    public final void a(com.kwad.framework.filedownloader.services.e eVar) {
        this.aeF = eVar;
        this.aeE.clear();
        for (Runnable runnable : (List) this.aeE.clone()) {
            runnable.run();
        }
        f.up().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, uF()));
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwad.framework.filedownloader.d.b bVar, boolean z3) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.h(str, str2, z);
        }
        this.aeF.b(str, str2, z, i, i2, i3, z2, bVar, z3);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean aY(int i) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.aY(i);
        }
        return this.aeF.aY(i);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final byte aZ(int i) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.aZ(i);
        }
        return this.aeF.aZ(i);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final void ak(Context context) {
        a(context, null);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean ba(int i) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.ba(i);
        }
        return this.aeF.ba(i);
    }
}

package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;
/* loaded from: classes10.dex */
public abstract class e extends com.kwad.framework.filedownloader.event.c {
    public DownloadServiceConnectChangedEvent.ConnectStatus aej;

    public abstract void um();

    public abstract void un();

    public final DownloadServiceConnectChangedEvent.ConnectStatus uo() {
        return this.aej;
    }

    @Override // com.kwad.framework.filedownloader.event.c
    public final boolean a(com.kwad.framework.filedownloader.event.b bVar) {
        if (bVar instanceof DownloadServiceConnectChangedEvent) {
            DownloadServiceConnectChangedEvent.ConnectStatus vJ = ((DownloadServiceConnectChangedEvent) bVar).vJ();
            this.aej = vJ;
            if (vJ == DownloadServiceConnectChangedEvent.ConnectStatus.connected) {
                um();
                return false;
            }
            un();
            return false;
        }
        return false;
    }
}

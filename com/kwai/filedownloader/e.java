package com.kwai.filedownloader;

import com.kwai.filedownloader.event.DownloadServiceConnectChangedEvent;
/* loaded from: classes6.dex */
public abstract class e extends com.kwai.filedownloader.event.c {

    /* renamed from: a  reason: collision with root package name */
    public DownloadServiceConnectChangedEvent.ConnectStatus f36993a;

    public abstract void a();

    @Override // com.kwai.filedownloader.event.c
    public boolean a(com.kwai.filedownloader.event.b bVar) {
        if (bVar instanceof DownloadServiceConnectChangedEvent) {
            DownloadServiceConnectChangedEvent.ConnectStatus a2 = ((DownloadServiceConnectChangedEvent) bVar).a();
            this.f36993a = a2;
            if (a2 == DownloadServiceConnectChangedEvent.ConnectStatus.connected) {
                a();
                return false;
            }
            b();
            return false;
        }
        return false;
    }

    public abstract void b();

    public DownloadServiceConnectChangedEvent.ConnectStatus c() {
        return this.f36993a;
    }
}

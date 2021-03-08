package com.kwai.filedownloader;

import com.kwai.filedownloader.event.DownloadServiceConnectChangedEvent;
/* loaded from: classes3.dex */
public abstract class e extends com.kwai.filedownloader.event.c {

    /* renamed from: a  reason: collision with root package name */
    private DownloadServiceConnectChangedEvent.ConnectStatus f7204a;

    public abstract void a();

    @Override // com.kwai.filedownloader.event.c
    public boolean a(com.kwai.filedownloader.event.b bVar) {
        if (bVar instanceof DownloadServiceConnectChangedEvent) {
            this.f7204a = ((DownloadServiceConnectChangedEvent) bVar).a();
            if (this.f7204a == DownloadServiceConnectChangedEvent.ConnectStatus.connected) {
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
        return this.f7204a;
    }
}

package com.kwad.framework.filedownloader.event;
/* loaded from: classes10.dex */
public final class DownloadServiceConnectChangedEvent extends b {
    public final ConnectStatus agQ;
    public final Class<?> agR;

    /* loaded from: classes10.dex */
    public enum ConnectStatus {
        connected,
        disconnected,
        lost
    }

    public DownloadServiceConnectChangedEvent(ConnectStatus connectStatus, Class<?> cls) {
        super("event.service.connect.changed");
        this.agQ = connectStatus;
        this.agR = cls;
    }

    public final ConnectStatus vJ() {
        return this.agQ;
    }
}

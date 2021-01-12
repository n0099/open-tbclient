package com.kwai.filedownloader.event;
/* loaded from: classes4.dex */
public class DownloadServiceConnectChangedEvent extends b {
    private final ConnectStatus c;
    private final Class<?> d;

    /* loaded from: classes4.dex */
    public enum ConnectStatus {
        connected,
        disconnected,
        lost
    }

    public DownloadServiceConnectChangedEvent(ConnectStatus connectStatus, Class<?> cls) {
        super("event.service.connect.changed");
        this.c = connectStatus;
        this.d = cls;
    }

    public ConnectStatus a() {
        return this.c;
    }
}

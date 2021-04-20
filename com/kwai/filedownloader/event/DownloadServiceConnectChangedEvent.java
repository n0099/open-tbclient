package com.kwai.filedownloader.event;
/* loaded from: classes6.dex */
public class DownloadServiceConnectChangedEvent extends b {

    /* renamed from: c  reason: collision with root package name */
    public final ConnectStatus f37287c;

    /* renamed from: d  reason: collision with root package name */
    public final Class<?> f37288d;

    /* loaded from: classes6.dex */
    public enum ConnectStatus {
        connected,
        disconnected,
        lost
    }

    public DownloadServiceConnectChangedEvent(ConnectStatus connectStatus, Class<?> cls) {
        super("event.service.connect.changed");
        this.f37287c = connectStatus;
        this.f37288d = cls;
    }

    public ConnectStatus a() {
        return this.f37287c;
    }
}

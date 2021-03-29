package com.kwai.filedownloader.event;
/* loaded from: classes6.dex */
public class DownloadServiceConnectChangedEvent extends b {

    /* renamed from: c  reason: collision with root package name */
    public final ConnectStatus f36998c;

    /* renamed from: d  reason: collision with root package name */
    public final Class<?> f36999d;

    /* loaded from: classes6.dex */
    public enum ConnectStatus {
        connected,
        disconnected,
        lost
    }

    public DownloadServiceConnectChangedEvent(ConnectStatus connectStatus, Class<?> cls) {
        super("event.service.connect.changed");
        this.f36998c = connectStatus;
        this.f36999d = cls;
    }

    public ConnectStatus a() {
        return this.f36998c;
    }
}

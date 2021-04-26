package com.kwai.filedownloader.event;
/* loaded from: classes6.dex */
public class DownloadServiceConnectChangedEvent extends b {

    /* renamed from: c  reason: collision with root package name */
    public final ConnectStatus f35104c;

    /* renamed from: d  reason: collision with root package name */
    public final Class<?> f35105d;

    /* loaded from: classes6.dex */
    public enum ConnectStatus {
        connected,
        disconnected,
        lost
    }

    public DownloadServiceConnectChangedEvent(ConnectStatus connectStatus, Class<?> cls) {
        super("event.service.connect.changed");
        this.f35104c = connectStatus;
        this.f35105d = cls;
    }

    public ConnectStatus a() {
        return this.f35104c;
    }
}

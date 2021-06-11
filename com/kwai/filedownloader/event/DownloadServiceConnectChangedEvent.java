package com.kwai.filedownloader.event;
/* loaded from: classes7.dex */
public class DownloadServiceConnectChangedEvent extends b {

    /* renamed from: c  reason: collision with root package name */
    public final ConnectStatus f37762c;

    /* renamed from: d  reason: collision with root package name */
    public final Class<?> f37763d;

    /* loaded from: classes7.dex */
    public enum ConnectStatus {
        connected,
        disconnected,
        lost
    }

    public DownloadServiceConnectChangedEvent(ConnectStatus connectStatus, Class<?> cls) {
        super("event.service.connect.changed");
        this.f37762c = connectStatus;
        this.f37763d = cls;
    }

    public ConnectStatus a() {
        return this.f37762c;
    }
}

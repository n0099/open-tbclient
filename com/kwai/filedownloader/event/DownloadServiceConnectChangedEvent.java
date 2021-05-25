package com.kwai.filedownloader.event;
/* loaded from: classes6.dex */
public class DownloadServiceConnectChangedEvent extends b {

    /* renamed from: c  reason: collision with root package name */
    public final ConnectStatus f34278c;

    /* renamed from: d  reason: collision with root package name */
    public final Class<?> f34279d;

    /* loaded from: classes6.dex */
    public enum ConnectStatus {
        connected,
        disconnected,
        lost
    }

    public DownloadServiceConnectChangedEvent(ConnectStatus connectStatus, Class<?> cls) {
        super("event.service.connect.changed");
        this.f34278c = connectStatus;
        this.f34279d = cls;
    }

    public ConnectStatus a() {
        return this.f34278c;
    }
}

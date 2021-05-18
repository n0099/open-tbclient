package com.kwai.filedownloader.event;
/* loaded from: classes6.dex */
public class DownloadServiceConnectChangedEvent extends b {

    /* renamed from: c  reason: collision with root package name */
    public final ConnectStatus f34349c;

    /* renamed from: d  reason: collision with root package name */
    public final Class<?> f34350d;

    /* loaded from: classes6.dex */
    public enum ConnectStatus {
        connected,
        disconnected,
        lost
    }

    public DownloadServiceConnectChangedEvent(ConnectStatus connectStatus, Class<?> cls) {
        super("event.service.connect.changed");
        this.f34349c = connectStatus;
        this.f34350d = cls;
    }

    public ConnectStatus a() {
        return this.f34349c;
    }
}

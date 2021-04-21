package com.xiaomi.mipush.sdk;
/* loaded from: classes7.dex */
public class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NotificationClickedActivity f40534a;

    public ab(NotificationClickedActivity notificationClickedActivity) {
        this.f40534a = notificationClickedActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.xiaomi.channel.commonutils.logger.b.m55a("clicked activity finish by timeout.");
        this.f40534a.finish();
    }
}

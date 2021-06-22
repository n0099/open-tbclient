package com.xiaomi.mipush.sdk;
/* loaded from: classes7.dex */
public class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NotificationClickedActivity f41005a;

    public ab(NotificationClickedActivity notificationClickedActivity) {
        this.f41005a = notificationClickedActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.xiaomi.channel.commonutils.logger.b.m56a("clicked activity finish by timeout.");
        this.f41005a.finish();
    }
}

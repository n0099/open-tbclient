package com.xiaomi.mipush.sdk;
/* loaded from: classes7.dex */
public class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NotificationClickedActivity f40149a;

    public ab(NotificationClickedActivity notificationClickedActivity) {
        this.f40149a = notificationClickedActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.xiaomi.channel.commonutils.logger.b.m51a("clicked activity finish by timeout.");
        this.f40149a.finish();
    }
}

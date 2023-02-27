package com.xiaomi.mipush.sdk;
/* loaded from: classes8.dex */
public class ac implements Runnable {
    public final /* synthetic */ NotificationClickedActivity a;

    public ac(NotificationClickedActivity notificationClickedActivity) {
        this.a = notificationClickedActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.xiaomi.channel.commonutils.logger.b.e("clicked activity finish by timeout.");
        this.a.finish();
    }
}

package com.xiaomi.mipush.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes7.dex */
public class ac extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NotificationClickedActivity f40903a;

    public ac(NotificationClickedActivity notificationClickedActivity) {
        this.f40903a = notificationClickedActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        com.xiaomi.channel.commonutils.logger.b.b("clicked activity finish by normal.");
        this.f40903a.finish();
    }
}

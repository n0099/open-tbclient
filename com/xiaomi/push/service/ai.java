package com.xiaomi.push.service;

import android.app.NotificationManager;
import com.xiaomi.channel.commonutils.misc.h;
/* loaded from: classes3.dex */
final class ai extends h.a {
    final /* synthetic */ int a;
    final /* synthetic */ NotificationManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(int i, NotificationManager notificationManager) {
        this.a = i;
        this.b = notificationManager;
    }

    @Override // com.xiaomi.channel.commonutils.misc.h.a
    public int a() {
        return this.a;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.cancel(this.a);
    }
}

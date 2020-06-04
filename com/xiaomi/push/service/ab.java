package com.xiaomi.push.service;

import android.app.NotificationManager;
import com.xiaomi.push.ai;
/* loaded from: classes8.dex */
final class ab extends ai.a {
    final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ NotificationManager f834a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(int i, NotificationManager notificationManager) {
        this.a = i;
        this.f834a = notificationManager;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo163a() {
        return this.a;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f834a.cancel(this.a);
    }
}

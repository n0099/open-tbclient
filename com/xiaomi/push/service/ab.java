package com.xiaomi.push.service;

import android.app.NotificationManager;
import com.xiaomi.push.ai;
/* loaded from: classes5.dex */
final class ab extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f8506a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ NotificationManager f835a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(int i, NotificationManager notificationManager) {
        this.f8506a = i;
        this.f835a = notificationManager;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo170a() {
        return this.f8506a;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f835a.cancel(this.f8506a);
    }
}

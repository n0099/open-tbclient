package com.xiaomi.push.service;

import android.app.NotificationManager;
import com.xiaomi.push.ai;
/* loaded from: classes12.dex */
final class ab extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f5043a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ NotificationManager f836a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(int i, NotificationManager notificationManager) {
        this.f5043a = i;
        this.f836a = notificationManager;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo167a() {
        return this.f5043a;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f836a.cancel(this.f5043a);
    }
}

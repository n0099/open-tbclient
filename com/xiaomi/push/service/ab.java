package com.xiaomi.push.service;

import android.app.NotificationManager;
import com.xiaomi.push.ai;
/* loaded from: classes18.dex */
final class ab extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f4813a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ NotificationManager f836a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(int i, NotificationManager notificationManager) {
        this.f4813a = i;
        this.f836a = notificationManager;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo159a() {
        return this.f4813a;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f836a.cancel(this.f4813a);
    }
}

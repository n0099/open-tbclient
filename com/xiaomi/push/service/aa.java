package com.xiaomi.push.service;

import android.app.NotificationManager;
import com.xiaomi.push.ai;
/* loaded from: classes5.dex */
final class aa extends ai.a {
    final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ NotificationManager f844a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(int i, NotificationManager notificationManager) {
        this.a = i;
        this.f844a = notificationManager;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo143a() {
        return this.a;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f844a.cancel(this.a);
    }
}

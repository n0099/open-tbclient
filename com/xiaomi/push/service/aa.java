package com.xiaomi.push.service;

import android.app.NotificationManager;
import com.xiaomi.push.ai;
/* loaded from: classes8.dex */
final class aa extends ai.a {
    final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ NotificationManager f840a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(int i, NotificationManager notificationManager) {
        this.a = i;
        this.f840a = notificationManager;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo160a() {
        return this.a;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f840a.cancel(this.a);
    }
}

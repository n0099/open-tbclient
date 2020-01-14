package com.xiaomi.push.service;

import android.app.NotificationManager;
import com.xiaomi.push.ai;
/* loaded from: classes6.dex */
final class aa extends ai.a {
    final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ NotificationManager f843a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(int i, NotificationManager notificationManager) {
        this.a = i;
        this.f843a = notificationManager;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo152a() {
        return this.a;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f843a.cancel(this.a);
    }
}

package com.xiaomi.push.service;

import android.app.NotificationManager;
import com.xiaomi.push.ai;
/* loaded from: classes8.dex */
final class aa extends ai.a {
    final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ NotificationManager f839a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(int i, NotificationManager notificationManager) {
        this.a = i;
        this.f839a = notificationManager;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo155a() {
        return this.a;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f839a.cancel(this.a);
    }
}

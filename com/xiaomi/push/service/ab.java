package com.xiaomi.push.service;

import android.app.NotificationManager;
import com.xiaomi.push.ai;
/* loaded from: classes6.dex */
final class ab extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f14224a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ NotificationManager f914a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(int i, NotificationManager notificationManager) {
        this.f14224a = i;
        this.f914a = notificationManager;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo192a() {
        return this.f14224a;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f914a.cancel(this.f14224a);
    }
}

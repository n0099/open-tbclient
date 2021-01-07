package com.xiaomi.push.service;

import android.app.NotificationManager;
import com.xiaomi.push.ai;
/* loaded from: classes6.dex */
final class ab extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f14524a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ NotificationManager f915a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(int i, NotificationManager notificationManager) {
        this.f14524a = i;
        this.f915a = notificationManager;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo196a() {
        return this.f14524a;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f915a.cancel(this.f14524a);
    }
}

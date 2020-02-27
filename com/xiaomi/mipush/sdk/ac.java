package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes8.dex */
final class ac implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f34a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(Context context, Intent intent) {
        this.a = context;
        this.f34a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.startService(this.f34a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m47a(e.getMessage());
        }
    }
}

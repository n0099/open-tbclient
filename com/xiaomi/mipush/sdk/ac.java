package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes5.dex */
final class ac implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f38a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(Context context, Intent intent) {
        this.a = context;
        this.f38a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.startService(this.f38a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m33a(e.getMessage());
        }
    }
}

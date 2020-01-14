package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes6.dex */
final class ac implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f37a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(Context context, Intent intent) {
        this.a = context;
        this.f37a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.startService(this.f37a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m42a(e.getMessage());
        }
    }
}

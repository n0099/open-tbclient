package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes3.dex */
final class ac implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f33a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(Context context, Intent intent) {
        this.a = context;
        this.f33a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.startService(this.f33a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m30a(e.getMessage());
        }
    }
}

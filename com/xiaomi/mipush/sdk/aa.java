package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes8.dex */
final class aa implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f37a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(Context context, Intent intent) {
        this.a = context;
        this.f37a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.startService(this.f37a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m51a(e.getMessage());
        }
    }
}

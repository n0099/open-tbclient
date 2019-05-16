package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes3.dex */
final class ae implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ Intent b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(Context context, Intent intent) {
        this.a = context;
        this.b = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.startService(this.b);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e.getMessage());
        }
    }
}

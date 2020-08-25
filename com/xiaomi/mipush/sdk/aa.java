package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes7.dex */
final class aa implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f40a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(Context context, Intent intent) {
        this.a = context;
        this.f40a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.startService(this.f40a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m54a(e.getMessage());
        }
    }
}

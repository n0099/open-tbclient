package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes6.dex */
final class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f14096a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f118a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(Context context, Intent intent) {
        this.f14096a = context;
        this.f118a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f14096a.startService(this.f118a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m84a(e.getMessage());
        }
    }
}

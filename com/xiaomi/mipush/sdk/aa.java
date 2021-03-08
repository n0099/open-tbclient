package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes5.dex */
final class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f8205a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f38a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(Context context, Intent intent) {
        this.f8205a = context;
        this.f38a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f8205a.startService(this.f38a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m58a(e.getMessage());
        }
    }
}

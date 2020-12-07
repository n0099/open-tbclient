package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes18.dex */
final class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4512a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f39a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(Context context, Intent intent) {
        this.f4512a = context;
        this.f39a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f4512a.startService(this.f39a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m47a(e.getMessage());
        }
    }
}

package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes12.dex */
final class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4740a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f36a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(Context context, Intent intent) {
        this.f4740a = context;
        this.f36a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f4740a.startService(this.f36a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m54a(e.getMessage());
        }
    }
}

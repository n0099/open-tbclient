package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes6.dex */
final class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f13796a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f117a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(Context context, Intent intent) {
        this.f13796a = context;
        this.f117a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f13796a.startService(this.f117a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m80a(e.getMessage());
        }
    }
}

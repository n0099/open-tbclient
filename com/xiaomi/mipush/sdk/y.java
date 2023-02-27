package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes8.dex */
public final class y implements Runnable {
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Intent f91a;

    public y(Context context, Intent intent) {
        this.a = context;
        this.f91a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.startService(this.f91a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m97a(e.getMessage());
        }
    }
}

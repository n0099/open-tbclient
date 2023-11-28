package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes10.dex */
public final class y implements Runnable {
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Intent f87a;

    public y(Context context, Intent intent) {
        this.a = context;
        this.f87a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.startService(this.f87a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m190a(e.getMessage());
        }
    }
}

package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes7.dex */
public final class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f40963a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Intent f96a;

    public x(Context context, Intent intent) {
        this.f40963a = context;
        this.f96a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f40963a.startService(this.f96a);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m56a(e2.getMessage());
        }
    }
}

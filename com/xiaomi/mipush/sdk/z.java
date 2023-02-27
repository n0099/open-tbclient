package com.xiaomi.mipush.sdk;

import android.content.Context;
/* loaded from: classes8.dex */
public final class z implements Runnable {
    public final /* synthetic */ Context a;

    public z(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageHandleService.c(this.a);
    }
}

package com.xiaomi.mipush.sdk;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class ad implements Runnable {
    final /* synthetic */ Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageHandleService.c(this.a);
    }
}

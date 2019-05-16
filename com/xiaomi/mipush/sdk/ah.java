package com.xiaomi.mipush.sdk;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class ah implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = MiPushClient.sContext;
        com.xiaomi.push.mpcd.d.a(context);
    }
}

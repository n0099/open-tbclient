package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.dm;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class af implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = MiPushClient.sContext;
        dm.a(context);
    }
}

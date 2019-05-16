package com.xiaomi.channel.commonutils.misc;

import android.os.Looper;
/* loaded from: classes3.dex */
public class n {
    public static void a() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new RuntimeException("can't do this on ui thread");
        }
    }

    public static void a(boolean z) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread() && z) {
            throw new RuntimeException("can't do this on ui thread when debug_switch:" + z);
        }
        if (Looper.getMainLooper().getThread() != Thread.currentThread() || z) {
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.a("can't do this on ui thread when debug_switch:" + z);
    }
}

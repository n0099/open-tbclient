package com.xiaomi.push;

import android.content.Context;
import android.content.IntentFilter;
import com.xiaomi.push.mpcd.receivers.BroadcastActionsReceiver;
/* loaded from: classes6.dex */
public class dm {
    private static IntentFilter a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        intentFilter.addAction("android.intent.action.PACKAGE_DATA_CLEARED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addAction("android.intent.action.PACKAGE_RESTARTED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        return intentFilter;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static dr m219a() {
        return new dn();
    }

    public static void a(Context context) {
        ds.a(context).m220a();
        try {
            context.registerReceiver(new BroadcastActionsReceiver(m219a()), a());
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
        }
    }
}

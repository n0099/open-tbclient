package com.xiaomi.push;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
/* loaded from: classes7.dex */
public class ah {
    public static boolean a(Context context) {
        try {
            return ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }

    public static boolean b(Context context) {
        Intent intent = null;
        try {
            intent = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Exception e) {
        }
        if (intent == null) {
            return false;
        }
        int intExtra = intent.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }
}

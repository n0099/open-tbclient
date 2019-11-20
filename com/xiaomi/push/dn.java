package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
final class dn implements dr {
    private void a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (ag.a(context, String.valueOf(12), 1L)) {
                ho hoVar = new ho();
                hoVar.a(str + ":" + str2);
                hoVar.a(System.currentTimeMillis());
                hoVar.a(hi.BroadcastAction);
                dx.a(context, hoVar);
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, Intent intent) {
        try {
            String dataString = intent.getDataString();
            if (TextUtils.isEmpty(dataString)) {
                return;
            }
            String[] split = dataString.split(":");
            if (split.length < 2 || TextUtils.isEmpty(split[1])) {
                return;
            }
            String str = split[1];
            long currentTimeMillis = System.currentTimeMillis();
            boolean a = com.xiaomi.push.service.ag.a(context).a(hl.BroadcastActionCollectionSwitch.a(), true);
            if (TextUtils.equals("android.intent.action.PACKAGE_RESTARTED", intent.getAction())) {
                if (ag.a(context, String.valueOf(12), 1L) && a) {
                    if (TextUtils.isEmpty(dw.a)) {
                        dw.a += dq.f243a + ":";
                    }
                    dw.a += str + "(" + currentTimeMillis + ")" + Constants.ACCEPT_TIME_SEPARATOR_SP;
                }
            } else if (TextUtils.equals("android.intent.action.PACKAGE_CHANGED", intent.getAction())) {
                if (ag.a(context, String.valueOf(12), 1L) && a) {
                    if (TextUtils.isEmpty(dw.b)) {
                        dw.b += dq.b + ":";
                    }
                    dw.b += str + "(" + currentTimeMillis + ")" + Constants.ACCEPT_TIME_SEPARATOR_SP;
                }
            } else if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", intent.getAction())) {
                if (intent.getExtras().getBoolean("android.intent.extra.REPLACING") || !a) {
                    return;
                }
                a(context, String.valueOf(hi.BroadcastActionAdded.a()), str);
            } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", intent.getAction())) {
                if (intent.getExtras().getBoolean("android.intent.extra.REPLACING") || !a) {
                    return;
                }
                a(context, String.valueOf(hi.BroadcastActionRemoved.a()), str);
            } else if (TextUtils.equals("android.intent.action.PACKAGE_REPLACED", intent.getAction())) {
                if (a) {
                    a(context, String.valueOf(hi.BroadcastActionReplaced.a()), str);
                }
            } else if (TextUtils.equals("android.intent.action.PACKAGE_DATA_CLEARED", intent.getAction()) && a) {
                a(context, String.valueOf(hi.BroadcastActionDataCleared.a()), str);
            }
        } catch (Throwable th) {
        }
    }

    @Override // com.xiaomi.push.dr
    public void a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        ai.a(context).a(new Cdo(this, context, intent));
    }
}

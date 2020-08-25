package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes7.dex */
final class ds implements dw {
    private void a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (du.a(context, String.valueOf(12), 1L)) {
                return;
            }
            hu huVar = new hu();
            huVar.a(str + ":" + str2);
            huVar.a(System.currentTimeMillis());
            huVar.a(ho.BroadcastAction);
            ed.a(context, huVar);
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
            boolean a = com.xiaomi.push.service.ak.a(context).a(hr.BroadcastActionCollectionSwitch.a(), true);
            if (TextUtils.equals("android.intent.action.PACKAGE_RESTARTED", intent.getAction())) {
                if (du.a(context, String.valueOf(12), 1L) || !a) {
                    return;
                }
                if (TextUtils.isEmpty(ec.a)) {
                    ec.a += dv.f231a + ":";
                }
                ec.a += str + "(" + currentTimeMillis + ")" + Constants.ACCEPT_TIME_SEPARATOR_SP;
            } else if (TextUtils.equals("android.intent.action.PACKAGE_CHANGED", intent.getAction())) {
                if (du.a(context, String.valueOf(12), 1L) || !a) {
                    return;
                }
                if (TextUtils.isEmpty(ec.b)) {
                    ec.b += dv.b + ":";
                }
                ec.b += str + "(" + currentTimeMillis + ")" + Constants.ACCEPT_TIME_SEPARATOR_SP;
            } else if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", intent.getAction())) {
                if (intent.getExtras().getBoolean("android.intent.extra.REPLACING") || !a) {
                    return;
                }
                a(context, String.valueOf(ho.BroadcastActionAdded.a()), str);
            } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", intent.getAction())) {
                if (intent.getExtras().getBoolean("android.intent.extra.REPLACING") || !a) {
                    return;
                }
                a(context, String.valueOf(ho.BroadcastActionRemoved.a()), str);
            } else if (TextUtils.equals("android.intent.action.PACKAGE_REPLACED", intent.getAction())) {
                if (a) {
                    a(context, String.valueOf(ho.BroadcastActionReplaced.a()), str);
                }
            } else if (TextUtils.equals("android.intent.action.PACKAGE_DATA_CLEARED", intent.getAction()) && a) {
                a(context, String.valueOf(ho.BroadcastActionDataCleared.a()), str);
            }
        } catch (Throwable th) {
        }
    }

    @Override // com.xiaomi.push.dw
    public void a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        ai.a(context).a(new dt(this, context, intent));
    }
}

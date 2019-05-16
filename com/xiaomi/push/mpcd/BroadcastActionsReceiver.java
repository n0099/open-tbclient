package com.xiaomi.push.mpcd;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.an;
import com.xiaomi.xmpush.thrift.k;
/* loaded from: classes3.dex */
public class BroadcastActionsReceiver extends BroadcastReceiver {
    public static final String a = String.valueOf(com.xiaomi.xmpush.thrift.d.BroadcastActionRestarted.a());
    public static final String b = String.valueOf(com.xiaomi.xmpush.thrift.d.BroadcastActionChanged.a());

    private void a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (com.xiaomi.channel.commonutils.misc.f.a(context, String.valueOf(12), 1L)) {
                k kVar = new k();
                kVar.a(str + ":" + str2);
                kVar.a(System.currentTimeMillis());
                kVar.a(com.xiaomi.xmpush.thrift.d.BroadcastAction);
                com.xiaomi.push.mpcd.job.g.a(context, kVar);
            }
        } catch (Throwable th) {
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
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
            boolean a2 = an.a(context).a(com.xiaomi.xmpush.thrift.g.BroadcastActionCollectionSwitch.a(), true);
            if (TextUtils.equals("android.intent.action.PACKAGE_RESTARTED", intent.getAction())) {
                if (com.xiaomi.channel.commonutils.misc.f.a(context, String.valueOf(12), 1L) && a2) {
                    if (TextUtils.isEmpty(com.xiaomi.push.mpcd.job.f.a)) {
                        com.xiaomi.push.mpcd.job.f.a += a + ":";
                    }
                    com.xiaomi.push.mpcd.job.f.a += str + "(" + currentTimeMillis + ")" + Constants.ACCEPT_TIME_SEPARATOR_SP;
                }
            } else if (TextUtils.equals("android.intent.action.PACKAGE_CHANGED", intent.getAction())) {
                if (com.xiaomi.channel.commonutils.misc.f.a(context, String.valueOf(12), 1L) && a2) {
                    if (TextUtils.isEmpty(com.xiaomi.push.mpcd.job.f.b)) {
                        com.xiaomi.push.mpcd.job.f.b += b + ":";
                    }
                    com.xiaomi.push.mpcd.job.f.b += str + "(" + currentTimeMillis + ")" + Constants.ACCEPT_TIME_SEPARATOR_SP;
                }
            } else if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", intent.getAction())) {
                if (intent.getExtras().getBoolean("android.intent.extra.REPLACING") || !a2) {
                    return;
                }
                a(context, String.valueOf(com.xiaomi.xmpush.thrift.d.BroadcastActionAdded.a()), str);
            } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", intent.getAction())) {
                if (intent.getExtras().getBoolean("android.intent.extra.REPLACING") || !a2) {
                    return;
                }
                a(context, String.valueOf(com.xiaomi.xmpush.thrift.d.BroadcastActionRemoved.a()), str);
            } else if (TextUtils.equals("android.intent.action.PACKAGE_REPLACED", intent.getAction())) {
                if (a2) {
                    a(context, String.valueOf(com.xiaomi.xmpush.thrift.d.BroadcastActionReplaced.a()), str);
                }
            } else if (TextUtils.equals("android.intent.action.PACKAGE_DATA_CLEARED", intent.getAction()) && a2) {
                a(context, String.valueOf(com.xiaomi.xmpush.thrift.d.BroadcastActionDataCleared.a()), str);
            }
        } catch (Throwable th) {
        }
    }
}

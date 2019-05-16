package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b {
    public static StackTraceElement[] a;

    public static void a() {
        try {
            a = Thread.getAllStackTraces().get(Thread.currentThread());
        } catch (Throwable th) {
        }
    }

    public static void a(Context context) {
        com.xiaomi.channel.commonutils.misc.h.a(context).a(new c(context), 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(int i) {
        if (a == null || a.length <= 4) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 4; i2 < a.length && i2 < i + 4; i2++) {
            try {
                arrayList.add(a[i2].toString());
            } catch (Exception e) {
                return "";
            }
        }
        return arrayList.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(Context context) {
        com.xiaomi.push.service.an a2 = com.xiaomi.push.service.an.a(context);
        if (a2.a(com.xiaomi.xmpush.thrift.g.AggregationSdkMonitorSwitch.a(), false)) {
            return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_upload_call_stack_timestamp", 0L)) >= ((long) Math.max(60, a2.a(com.xiaomi.xmpush.thrift.g.AggregationSdkMonitorFrequency.a(), 86400)));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_upload_call_stack_timestamp", System.currentTimeMillis());
        edit.commit();
    }
}

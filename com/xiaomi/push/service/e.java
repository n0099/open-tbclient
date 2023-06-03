package com.xiaomi.push.service;

import android.app.NotificationChannel;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import com.xiaomi.push.service.ay;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class e {

    /* renamed from: a  reason: collision with other field name */
    public static final int[] f980a = {1, 2, 4, 8, 16};
    public static final SparseArray<ay.a<String, String, String>> a = new f(5);
    public static final SparseArray<Integer> b = new g(5);

    public static int a(String str, String str2) {
        int i = a(str, str2, 8) ? 8 : 0;
        if (a(str, str2, 16)) {
            i |= 16;
        }
        if (a(str, str2, 1)) {
            i |= 1;
        }
        if (a(str, str2, 2)) {
            i |= 2;
        }
        return a(str, str2, 4) ? i | 4 : i;
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("ch_permission_cache_file", 0);
    }

    public static void a(Context context, String str) {
        List<NotificationChannel> m780a;
        if (!com.xiaomi.push.j.m706a(context) || TextUtils.isEmpty(str) || (m780a = ax.a(context, str).m780a()) == null) {
            return;
        }
        synchronized (e.class) {
            SharedPreferences a2 = a(context);
            ArrayList arrayList = new ArrayList();
            for (NotificationChannel notificationChannel : m780a) {
                String str2 = (String) com.xiaomi.push.bj.a(notificationChannel, "mId");
                if (!TextUtils.isEmpty(str2) && a2.contains(str2)) {
                    arrayList.add(str2);
                }
            }
            if (arrayList.size() > 0) {
                a(a2, arrayList);
            }
        }
    }

    public static void a(Context context, String str, String str2, int i, String str3, boolean z, int i2) {
        if (!com.xiaomi.push.j.m706a(context) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            if (com.xiaomi.push.j.m706a(context)) {
                com.xiaomi.channel.commonutils.logger.b.m175a("ChannelPC: can`t setup permission with permissionCode:" + String.valueOf(str3) + " channelId:" + String.valueOf(str2) + " targetPkg:" + str);
                return;
            }
            return;
        }
        int a2 = com.xiaomi.push.t.a(str3, 0);
        boolean a3 = a(i, a2);
        if (z) {
            a(str, str2, a2, i2);
            if (a3) {
                synchronized (e.class) {
                    a(a(context), a2, str2);
                }
                return;
            }
            return;
        }
        synchronized (e.class) {
            SharedPreferences a4 = a(context);
            if (a3 || a4.contains(str2)) {
                a(a4, a2, str, str2, i2);
                if (a3) {
                    a(a4, a2, str2);
                } else {
                    a(a4, str2);
                }
            }
        }
    }

    public static void a(SharedPreferences sharedPreferences, int i, String str) {
        sharedPreferences.edit().putInt(str, i).commit();
    }

    public static void a(SharedPreferences sharedPreferences, int i, String str, String str2, int i2) {
        if (sharedPreferences.getInt(str2, 0) != i) {
            a(str, str2, i, i2);
        }
    }

    public static void a(SharedPreferences sharedPreferences, String str) {
        a(sharedPreferences, new h(str));
    }

    public static void a(SharedPreferences sharedPreferences, List<String> list) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        for (String str : list) {
            edit.remove(str);
        }
        edit.commit();
    }

    public static void a(String str, String str2, int i, int i2) {
        int[] iArr;
        for (int i3 : f980a) {
            if ((b.get(i3).intValue() & i2) == 0) {
                a(str, str2, i3, (i & i3) > 0);
            } else {
                com.xiaomi.channel.commonutils.logger.b.m175a("ChannelPermissions.grantPermission:" + str + ":" + str2 + ": <" + i3 + "> :stoped by userLock");
            }
        }
    }

    public static void a(String str, String str2, int i, boolean z) {
        boolean a2 = ay.a(com.xiaomi.push.s.m717a(), str, str2, a.get(i), z);
        com.xiaomi.channel.commonutils.logger.b.m175a("ChannelPermissions.grantPermission:" + str + ":" + str2 + ": <" + i + "=" + z + "> :" + a2);
    }

    public static boolean a(int i, int i2) {
        return i >= 4 || (i2 & 2) > 0 || (i2 & 1) > 0 || (i2 & 8) > 0 || (i2 & 16) > 0;
    }

    public static boolean a(String str, String str2, int i) {
        boolean z = ay.a(com.xiaomi.push.s.m717a(), str, str2, a.get(i)) == 1;
        com.xiaomi.channel.commonutils.logger.b.m175a("ChannelPermissions.checkPermission:" + str + ":" + str2 + ": <" + i + "=" + z + ">");
        return z;
    }
}

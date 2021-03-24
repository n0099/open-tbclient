package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class dw {
    public static void a(Context context, String str, int i, String str2) {
        ai.a(context).a(new dx(context, str, i, str2));
    }

    public static void a(Context context, HashMap<String, String> hashMap) {
        ee m264a = ea.a(context).m264a();
        if (m264a != null) {
            m264a.a(context, hashMap);
        }
    }

    public static void b(Context context, HashMap<String, String> hashMap) {
        ee m264a = ea.a(context).m264a();
        if (m264a != null) {
            m264a.c(context, hashMap);
        }
    }

    public static void c(Context context, String str, int i, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("awake_info", str);
            hashMap.put("event_type", String.valueOf(i));
            hashMap.put("description", str2);
            int a2 = ea.a(context).a();
            if (a2 != 1) {
                if (a2 != 2) {
                    if (a2 == 3) {
                        a(context, hashMap);
                    }
                }
                c(context, hashMap);
            } else {
                a(context, hashMap);
            }
            b(context, hashMap);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    public static void c(Context context, HashMap<String, String> hashMap) {
        ee m264a = ea.a(context).m264a();
        if (m264a != null) {
            m264a.b(context, hashMap);
        }
    }
}

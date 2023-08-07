package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.pose.PoseAR;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class dy {
    public static void a(Context context, String str, int i, String str2) {
        aj.a(context).a(new dz(context, str, i, str2));
    }

    public static void a(Context context, HashMap<String, String> hashMap) {
        eg m447a = ec.a(context).m447a();
        if (m447a != null) {
            m447a.a(context, hashMap);
        }
    }

    public static void b(Context context, HashMap<String, String> hashMap) {
        eg m447a = ec.a(context).m447a();
        if (m447a != null) {
            m447a.c(context, hashMap);
        }
    }

    public static void c(Context context, String str, int i, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("awake_info", str);
            hashMap.put(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, String.valueOf(i));
            hashMap.put("description", str2);
            int a = ec.a(context).a();
            if (a != 1) {
                if (a != 2) {
                    if (a == 3) {
                        a(context, hashMap);
                    }
                }
                c(context, hashMap);
            } else {
                a(context, hashMap);
            }
            b(context, hashMap);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    public static void c(Context context, HashMap<String, String> hashMap) {
        eg m447a = ec.a(context).m447a();
        if (m447a != null) {
            m447a.b(context, hashMap);
        }
    }
}

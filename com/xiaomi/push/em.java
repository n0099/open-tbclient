package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.pose.PoseAR;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class em {
    public static void a(Context context, String str, int i, String str2) {
        ai.a(context).a(new en(context, str, i, str2));
    }

    private static void a(Context context, HashMap<String, String> hashMap) {
        eu m266a = eq.a(context).m266a();
        if (m266a != null) {
            m266a.a(context, hashMap);
        }
    }

    private static void b(Context context, HashMap<String, String> hashMap) {
        eu m266a = eq.a(context).m266a();
        if (m266a != null) {
            m266a.c(context, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, String str, int i, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("awake_info", str);
            hashMap.put(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, String.valueOf(i));
            hashMap.put("description", str2);
            switch (eq.a(context).a()) {
                case 1:
                    a(context, hashMap);
                    break;
                case 2:
                    c(context, hashMap);
                    break;
                case 3:
                    a(context, hashMap);
                    c(context, hashMap);
                    break;
            }
            b(context, hashMap);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    private static void c(Context context, HashMap<String, String> hashMap) {
        eu m266a = eq.a(context).m266a();
        if (m266a != null) {
            m266a.b(context, hashMap);
        }
    }
}

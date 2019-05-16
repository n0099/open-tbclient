package com.xiaomi.push.service.awake;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.misc.h;
import com.xiaomi.push.service.awake.module.g;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b {
    public static void a(Context context, String str, int i, String str2) {
        h.a(context).a(new c(context, str, i, str2));
    }

    private static void a(Context context, HashMap<String, String> hashMap) {
        g a = com.xiaomi.push.service.awake.module.c.a(context).a();
        if (a != null) {
            a.a(context, hashMap);
        }
    }

    private static void b(Context context, HashMap<String, String> hashMap) {
        g a = com.xiaomi.push.service.awake.module.c.a(context).a();
        if (a != null) {
            a.c(context, hashMap);
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
            hashMap.put("event_type", String.valueOf(i));
            hashMap.put("description", str2);
            switch (com.xiaomi.push.service.awake.module.c.a(context).d()) {
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
        g a = com.xiaomi.push.service.awake.module.c.a(context).a();
        if (a != null) {
            a.b(context, hashMap);
        }
    }
}

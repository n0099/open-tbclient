package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.hl;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class ao {
    public static int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public static long f904a = -1;

    /* renamed from: a  reason: collision with other field name */
    public static Boolean f905a;

    public static void a(Context context, String str, String str2, an anVar) {
        if (context == null || anVar == null) {
            return;
        }
        hl hlVar = new hl();
        hlVar.d(str);
        hlVar.c(str2);
        hlVar.g("com.xiaomi.xmsf");
        hlVar.e("com.xiaomi.xmsf");
        HashMap hashMap = new HashMap();
        hashMap.put("chid", String.valueOf(anVar.a));
        hashMap.put("screen_on", String.valueOf(anVar.f901a));
        hashMap.put("wifi", String.valueOf(anVar.f903b));
        hashMap.put("rx_msg", String.valueOf(anVar.f900a));
        hashMap.put("enqueue", String.valueOf(anVar.f902b));
        hashMap.put("num", String.valueOf(anVar.b));
        hashMap.put("run", String.valueOf(anVar.c));
        hashMap.put("send", String.valueOf(anVar.d));
        hlVar.a(hashMap);
        ca.a(context, hlVar);
    }

    public static boolean a() {
        int a2 = com.xiaomi.push.ae.a();
        return a2 >= 8 && a2 <= 24 && (((a2 - 8) + 1) * 3) - a > 0;
    }

    public static boolean a(Context context) {
        String m832a = u.m832a(context);
        return !TextUtils.isEmpty(m832a) && m832a.length() >= 3 && com.xiaomi.push.t.a(m832a.substring(m832a.length() - 3), 1) < 1;
    }

    public static boolean a(Context context, String str, an anVar) {
        String str2;
        if (context == null || anVar == null) {
            return false;
        }
        if (f905a == null) {
            f905a = Boolean.valueOf(a(context));
        }
        if (f905a.booleanValue()) {
            long b = com.xiaomi.push.ae.b();
            if (b - f904a >= 1) {
                a = 0;
                f904a = b;
            }
            if (a()) {
                String str3 = "coord_down";
                if (!str.equals("coord_down")) {
                    str3 = "coord_up";
                    str2 = str.equals("coord_up") ? "category_coord_up" : "category_coord_up";
                    a++;
                    return true;
                }
                str2 = "category_coord_down";
                a(context, str2, str3, anVar);
                a++;
                return true;
            }
            return false;
        }
        return false;
    }
}

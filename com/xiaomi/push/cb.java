package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
/* loaded from: classes8.dex */
public class cb {

    /* renamed from: a  reason: collision with other field name */
    private static SimpleDateFormat f177a = new SimpleDateFormat("yyyy/MM/dd");
    private static String a = f177a.format(Long.valueOf(System.currentTimeMillis()));

    public static hk a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        hk hkVar = new hk();
        hkVar.d("category_push_stat");
        hkVar.a("push_sdk_stat_channel");
        hkVar.a(1L);
        hkVar.b(str);
        hkVar.a(true);
        hkVar.b(System.currentTimeMillis());
        hkVar.g(bk.a(context).m169a());
        hkVar.e("com.xiaomi.xmsf");
        hkVar.f("");
        hkVar.c("push_stat");
        return hkVar;
    }
}

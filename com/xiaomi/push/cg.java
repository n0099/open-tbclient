package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
/* loaded from: classes8.dex */
public class cg {

    /* renamed from: a  reason: collision with other field name */
    private static SimpleDateFormat f161a = new SimpleDateFormat("yyyy/MM/dd");
    private static String a = f161a.format(Long.valueOf(System.currentTimeMillis()));

    public static hq a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        hq hqVar = new hq();
        hqVar.d("category_push_stat");
        hqVar.a("push_sdk_stat_channel");
        hqVar.a(1L);
        hqVar.b(str);
        hqVar.a(true);
        hqVar.b(System.currentTimeMillis());
        hqVar.g(bp.a(context).m173a());
        hqVar.e("com.xiaomi.xmsf");
        hqVar.f("");
        hqVar.c("push_stat");
        return hqVar;
    }
}

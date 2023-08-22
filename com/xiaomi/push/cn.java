package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
/* loaded from: classes10.dex */
public class cn {
    public static String a;

    /* renamed from: a  reason: collision with other field name */
    public static SimpleDateFormat f181a;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f181a = simpleDateFormat;
        a = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static hl a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        hl hlVar = new hl();
        hlVar.d("category_push_stat");
        hlVar.a("push_sdk_stat_channel");
        hlVar.a(1L);
        hlVar.b(str);
        hlVar.a(true);
        hlVar.b(System.currentTimeMillis());
        hlVar.g(bw.a(context).m308a());
        hlVar.e("com.xiaomi.xmsf");
        hlVar.f("");
        hlVar.c("push_stat");
        return hlVar;
    }
}

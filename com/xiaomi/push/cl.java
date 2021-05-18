package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
/* loaded from: classes7.dex */
public class cl {

    /* renamed from: a  reason: collision with root package name */
    public static String f37466a;

    /* renamed from: a  reason: collision with other field name */
    public static SimpleDateFormat f185a;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f185a = simpleDateFormat;
        f37466a = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static hj a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        hj hjVar = new hj();
        hjVar.d("category_push_stat");
        hjVar.a("push_sdk_stat_channel");
        hjVar.a(1L);
        hjVar.b(str);
        hjVar.a(true);
        hjVar.b(System.currentTimeMillis());
        hjVar.g(bu.a(context).m179a());
        hjVar.e("com.xiaomi.xmsf");
        hjVar.f("");
        hjVar.c("push_stat");
        return hjVar;
    }
}

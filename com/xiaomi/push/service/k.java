package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.ap;
import java.util.Locale;
/* loaded from: classes9.dex */
public class k {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final String f917a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public k(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        this.f917a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.a = i;
    }

    public static boolean a() {
        try {
            return com.xiaomi.push.t.a(null, "miui.os.Build").getField("IS_ALPHA_BUILD").getBoolean(null);
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName()) && a();
    }

    private static boolean b(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    public ap.b a(XMPushService xMPushService) {
        ap.b bVar = new ap.b(xMPushService);
        a(bVar, xMPushService, xMPushService.b(), "c");
        return bVar;
    }

    public ap.b a(ap.b bVar, Context context, d dVar, String str) {
        bVar.f861a = context.getPackageName();
        bVar.f864b = this.f917a;
        bVar.h = this.c;
        bVar.c = this.b;
        bVar.g = "5";
        bVar.d = "XMPUSH-PASS";
        bVar.f863a = false;
        bVar.e = String.format("%1$s:%2$s,%3$s:%4$s,%5$s:%6$s:%7$s:%8$s,%9$s:%10$s,%11$s:%12$s", "sdk_ver", 39, "cpvn", "3_7_5", "cpvc", 30705, "aapn", b(context) ? com.xiaomi.push.g.b(context) : "", "country_code", a.a(context).b(), "region", a.a(context).a());
        bVar.f = String.format("%1$s:%2$s,%3$s:%4$s,%5$s:%6$s,sync:1", "appid", b(context) ? "1000271" : this.d, "locale", Locale.getDefault().toString(), Constants.EXTRA_KEY_MIID, com.xiaomi.push.t.a(context));
        if (a(context)) {
            bVar.f += String.format(",%1$s:%2$s", "ab", str);
        }
        bVar.f860a = dVar;
        return bVar;
    }
}

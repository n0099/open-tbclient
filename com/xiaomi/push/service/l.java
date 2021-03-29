package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.av;
import java.util.Locale;
/* loaded from: classes7.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public final int f41044a;

    /* renamed from: a  reason: collision with other field name */
    public final String f959a;

    /* renamed from: b  reason: collision with root package name */
    public final String f41045b;

    /* renamed from: c  reason: collision with root package name */
    public final String f41046c;

    /* renamed from: d  reason: collision with root package name */
    public final String f41047d;

    /* renamed from: e  reason: collision with root package name */
    public final String f41048e;

    /* renamed from: f  reason: collision with root package name */
    public final String f41049f;

    public l(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        this.f959a = str;
        this.f41045b = str2;
        this.f41046c = str3;
        this.f41047d = str4;
        this.f41048e = str5;
        this.f41049f = str6;
        this.f41044a = i;
    }

    public static boolean a() {
        try {
            return com.xiaomi.push.t.a(null, "miui.os.Build").getField("IS_ALPHA_BUILD").getBoolean(null);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName()) && a();
    }

    public static boolean b(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    public av.b a(XMPushService xMPushService) {
        av.b bVar = new av.b(xMPushService);
        a(bVar, xMPushService, xMPushService.b(), "c");
        return bVar;
    }

    public av.b a(av.b bVar, Context context, e eVar, String str) {
        bVar.f908a = context.getPackageName();
        bVar.f911b = this.f959a;
        bVar.f40968h = this.f41046c;
        bVar.f40963c = this.f41045b;
        bVar.f40967g = "5";
        bVar.f40964d = "XMPUSH-PASS";
        bVar.f910a = false;
        bVar.f40965e = String.format("%1$s:%2$s,%3$s:%4$s,%5$s:%6$s:%7$s:%8$s,%9$s:%10$s,%11$s:%12$s", "sdk_ver", 43, "cpvn", "3_8_5", "cpvc", 30805, "aapn", b(context) ? com.xiaomi.push.g.b(context) : "", "country_code", a.a(context).b(), "region", a.a(context).a());
        bVar.f40966f = String.format("%1$s:%2$s,%3$s:%4$s,%5$s:%6$s,sync:1", "appid", b(context) ? "1000271" : this.f41047d, "locale", Locale.getDefault().toString(), Constants.EXTRA_KEY_MIID, com.xiaomi.push.t.a(context));
        if (a(context)) {
            bVar.f40966f += String.format(",%1$s:%2$s", "ab", str);
        }
        bVar.f907a = eVar;
        return bVar;
    }
}

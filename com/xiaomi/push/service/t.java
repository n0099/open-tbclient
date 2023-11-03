package com.xiaomi.push.service;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.live.interfaces.DI;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.service.bg;
import com.xiaomi.push.t;
import java.util.Locale;
/* loaded from: classes10.dex */
public class t {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final String f1005a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public t(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        this.f1005a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.a = i;
    }

    public static String a(Context context) {
        if ("com.xiaomi.xmsf".equals(context)) {
            if (TextUtils.isEmpty(null)) {
                String m714a = com.xiaomi.push.j.m714a("ro.miui.region");
                return TextUtils.isEmpty(m714a) ? com.xiaomi.push.j.m714a(CountryCodeBean.LOCALE_REGION_COUNTRYSYSTEMPROP) : m714a;
            }
            return null;
        }
        return com.xiaomi.push.j.b();
    }

    public static boolean a() {
        try {
            return com.xiaomi.push.s.a(null, "miui.os.Build").getField("IS_ALPHA_BUILD").getBoolean(null);
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m841a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName()) && a();
    }

    public static boolean b(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    public bg.b a(XMPushService xMPushService) {
        bg.b bVar = new bg.b(xMPushService);
        a(bVar, xMPushService, xMPushService.m756b(), "c");
        return bVar;
    }

    public bg.b a(bg.b bVar, Context context, j jVar, String str) {
        bVar.f935a = context.getPackageName();
        bVar.f938b = this.f1005a;
        bVar.h = this.c;
        bVar.c = this.b;
        bVar.g = "5";
        bVar.d = "XMPUSH-PASS";
        bVar.f937a = false;
        t.a aVar = new t.a();
        aVar.a("sdk_ver", 48).a("cpvn", BuildConfig.VERSION_NAME).a("cpvc", 50005).a("country_code", a.a(context).b()).a("region", a.a(context).a()).a("miui_vn", com.xiaomi.push.j.c()).a("miui_vc", Integer.valueOf(com.xiaomi.push.j.a(context))).a("xmsf_vc", Integer.valueOf(com.xiaomi.push.g.a(context, "com.xiaomi.xmsf"))).a("android_ver", Integer.valueOf(Build.VERSION.SDK_INT)).a("n_belong_to_app", Boolean.valueOf(ax.m785a(context))).a("systemui_vc", Integer.valueOf(com.xiaomi.push.g.a(context)));
        String a = a(context);
        if (!TextUtils.isEmpty(a)) {
            aVar.a("latest_country_code", a);
        }
        String d = com.xiaomi.push.j.d();
        if (!TextUtils.isEmpty(d)) {
            aVar.a("device_ch", d);
        }
        String e = com.xiaomi.push.j.e();
        if (!TextUtils.isEmpty(e)) {
            aVar.a("device_mfr", e);
        }
        bVar.e = aVar.toString();
        String str2 = b(context) ? "1000271" : this.d;
        t.a aVar2 = new t.a();
        aVar2.a("appid", str2).a("locale", Locale.getDefault().toString()).a(NativeConstants.COMPONENT_SYNC_TEXT_VIEW, 1);
        if (m841a(context)) {
            aVar2.a(DI.AB_NAME, str);
        }
        bVar.f = aVar2.toString();
        bVar.f934a = jVar;
        return bVar;
    }
}

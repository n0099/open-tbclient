package com.cmic.sso.sdk.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.cmic.sso.sdk.d.k;
import com.cmic.sso.sdk.d.o;
/* loaded from: classes6.dex */
public class h {

    /* renamed from: b  reason: collision with root package name */
    public static String f30662b;

    /* renamed from: c  reason: collision with root package name */
    public static String f30663c;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f30661a = m.a();

    /* renamed from: d  reason: collision with root package name */
    public static long f30664d = 0;

    public static void b(Context context, String str, long j, String str2) {
        String a2 = b.a(context, str);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        k.a a3 = k.a();
        a3.a("phonescripcache", a2);
        a3.a("phonescripstarttime", j);
        a3.a("pre_sim_key", str2);
        a3.b();
    }

    public static boolean d() {
        if (TextUtils.isEmpty(f30662b)) {
            return !TextUtils.isEmpty(k.b("phonescripcache", "")) && a(k.a("phonescripstarttime", 0L));
        }
        c.b("PhoneScripUtils", f30663c + " " + f30664d);
        return a(f30664d);
    }

    public static void a(boolean z, boolean z2) {
        k.a a2 = k.a();
        a2.a("phonescripstarttime");
        a2.a("phonescripcache");
        a2.a("pre_sim_key");
        if (z2) {
            a2.a();
        } else {
            a2.b();
        }
        if (z) {
            f30662b = null;
            f30663c = null;
            f30664d = 0L;
        }
    }

    public static long b() {
        long a2;
        long j;
        long currentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(f30662b)) {
            c.b("PhoneScripUtils", f30663c + " " + f30664d);
            a2 = f30664d;
        } else {
            String b2 = k.b("phonescripcache", "");
            a2 = k.a("phonescripstarttime", 0L);
            if (TextUtils.isEmpty(b2)) {
                j = 0;
                return Math.max(j / 1000, 0L);
            }
        }
        j = (a2 - currentTimeMillis) - 10000;
        return Math.max(j / 1000, 0L);
    }

    public static boolean a() {
        return f30661a;
    }

    public static void a(final Context context, final String str, long j, final String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || j <= 0) {
            return;
        }
        c.b("PhoneScripUtils", "save phone scrip simKey = " + str2);
        f30662b = str;
        long j2 = j * 1000;
        f30664d = System.currentTimeMillis() + j2;
        c.b("sLifeTime", f30664d + "");
        f30663c = str2;
        if (!f30661a && !"operator".equals(str3)) {
            o.a(new o.a() { // from class: com.cmic.sso.sdk.d.h.1
                @Override // com.cmic.sso.sdk.d.o.a
                public void a() {
                    c.b("PhoneScripUtils", "start save scrip to sp in sub thread");
                    h.b(context, str, h.f30664d, str2);
                }
            });
        } else if (j2 > 3600000) {
            f30664d = System.currentTimeMillis() + 3600000;
        } else {
            f30664d = System.currentTimeMillis() + j2;
        }
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(f30662b)) {
            String b2 = k.b("phonescripcache", "");
            if (TextUtils.isEmpty(b2)) {
                c.a("PhoneScripUtils", StringUtil.NULL_STRING);
                return null;
            }
            f30664d = k.a("phonescripstarttime", 0L);
            f30663c = k.b("pre_sim_key", "");
            String b3 = b.b(context, b2);
            f30662b = b3;
            return b3;
        }
        return f30662b;
    }

    public static boolean a(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        c.b("PhoneScripUtils", j + "");
        c.b("PhoneScripUtils", currentTimeMillis + "");
        return j - currentTimeMillis > 10000;
    }

    public static int a(String str) {
        String b2;
        if (!TextUtils.isEmpty(f30663c)) {
            b2 = f30663c;
        } else {
            b2 = k.b("pre_sim_key", "");
            f30663c = b2;
        }
        if (TextUtils.isEmpty(b2)) {
            return 0;
        }
        return b2.equals(str) ? 1 : 2;
    }

    public static boolean a(com.cmic.sso.sdk.a aVar) {
        int a2 = a(aVar.b("scripKey"));
        aVar.a("imsiState", a2 + "");
        c.b("PhoneScripUtils", "simState = " + a2);
        if (a2 != 1) {
            if (a2 == 2) {
                a(true, false);
            }
            return false;
        }
        if (f30661a) {
            c.b("PhoneScripUtils", "phone is root");
            a(false, false);
        }
        return d();
    }
}

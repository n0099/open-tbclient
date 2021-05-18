package com.cmic.sso.sdk.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.config.AppConfig;
import com.cmic.sso.sdk.d.k;
import com.cmic.sso.sdk.d.o;
/* loaded from: classes6.dex */
public class h {

    /* renamed from: b  reason: collision with root package name */
    public static String f30641b;

    /* renamed from: c  reason: collision with root package name */
    public static String f30642c;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f30640a = m.a();

    /* renamed from: d  reason: collision with root package name */
    public static long f30643d = 0;

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
            f30641b = null;
            f30642c = null;
            f30643d = 0L;
        }
    }

    public static void c(Context context, String str, long j, String str2) {
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

    public static boolean b() {
        if (TextUtils.isEmpty(f30641b)) {
            return !TextUtils.isEmpty(k.b("phonescripcache", "")) && a(k.a("phonescripstarttime", 0L));
        }
        c.b("PhoneScripUtils", f30642c + " " + f30643d);
        return a(f30643d);
    }

    public static boolean a() {
        return f30640a;
    }

    public static void a(final Context context, final String str, final long j, final String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f30641b = str;
        f30643d = j;
        f30642c = str2;
        if (f30640a) {
            return;
        }
        o.a(new o.a() { // from class: com.cmic.sso.sdk.d.h.1
            @Override // com.cmic.sso.sdk.d.o.a
            public void a() {
                c.b("PhoneScripUtils", "start save scrip to sp in sub thread");
                h.c(context, str, j, str2);
            }
        });
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(f30641b)) {
            String b2 = k.b("phonescripcache", "");
            if (TextUtils.isEmpty(b2)) {
                c.a("PhoneScripUtils", StringUtil.NULL_STRING);
                return null;
            }
            String b3 = b.b(context, b2);
            f30641b = b3;
            return b3;
        }
        return f30641b;
    }

    public static boolean a(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        c.b("PhoneScripUtils", j + "");
        c.b("PhoneScripUtils", currentTimeMillis + "");
        return j - currentTimeMillis > AppConfig.TIMESTAMP_AVAILABLE_DURATION;
    }

    public static int a(String str) {
        String b2;
        if (!TextUtils.isEmpty(f30642c)) {
            b2 = f30642c;
        } else {
            b2 = k.b("pre_sim_key", "");
            f30642c = b2;
        }
        if (TextUtils.isEmpty(b2)) {
            return 0;
        }
        return b2.equals(str) ? 1 : 2;
    }

    public static boolean a(com.cmic.sso.sdk.a aVar) {
        int a2;
        if (!aVar.b("keyIsSimKeyICCID", false)) {
            a2 = a(aVar.b("imsi"));
        } else {
            a2 = a(aVar.b("iccid"));
        }
        aVar.a("imsiState", a2 + "");
        c.b("PhoneScripUtils", "simState = " + a2);
        if (a2 != 1) {
            if (a2 == 2) {
                a(true, false);
            }
            return false;
        }
        if (f30640a) {
            c.b("PhoneScripUtils", "phone is root");
            a(false, false);
        }
        return b();
    }
}

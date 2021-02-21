package com.cmic.sso.sdk.e;

import android.content.Context;
import android.text.TextUtils;
import com.cmic.sso.sdk.e.k;
import com.cmic.sso.sdk.e.o;
/* loaded from: classes15.dex */
public class h {

    /* renamed from: b  reason: collision with root package name */
    private static String f7727b;
    private static String c;

    /* renamed from: a  reason: collision with root package name */
    private static boolean f7726a = m.a();
    private static long d = 0;

    public static void a(boolean z, boolean z2) {
        k.a erD = k.erD();
        erD.a("phonescripstarttime");
        erD.a("phonescripcache");
        erD.a("pre_sim_key");
        if (z2) {
            erD.a();
        } else {
            erD.b();
        }
        if (z) {
            f7727b = null;
            c = null;
            d = 0L;
        }
    }

    public static boolean a() {
        return f7726a;
    }

    public static void a(final Context context, final String str, final long j, final String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            f7727b = str;
            d = j;
            c = str2;
            if (!f7726a) {
                o.a(new o.a() { // from class: com.cmic.sso.sdk.e.h.1
                    @Override // com.cmic.sso.sdk.e.o.a
                    protected void a() {
                        c.b("PhoneScripUtils", "start save scrip to sp in sub thread");
                        h.b(context, str, j, str2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str, long j, String str2) {
        String a2 = b.a(context, str);
        if (!TextUtils.isEmpty(a2)) {
            k.a erD = k.erD();
            erD.a("phonescripcache", a2);
            erD.a("phonescripstarttime", j);
            erD.a("pre_sim_key", str2);
            erD.b();
        }
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(f7727b)) {
            String b2 = k.b("phonescripcache", "");
            if (TextUtils.isEmpty(b2)) {
                c.a("PhoneScripUtils", "null");
                return null;
            }
            String b3 = b.b(context, b2);
            f7727b = b3;
            return b3;
        }
        return f7727b;
    }

    private static boolean b() {
        if (TextUtils.isEmpty(f7727b)) {
            return !TextUtils.isEmpty(k.b("phonescripcache", "")) && a(k.a("phonescripstarttime", 0L));
        }
        c.b("PhoneScripUtils", c + " " + d);
        return a(d);
    }

    private static boolean a(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        c.b("PhoneScripUtils", j + "");
        c.b("PhoneScripUtils", currentTimeMillis + "");
        return j - currentTimeMillis > 120000;
    }

    private static int a(String str) {
        String b2;
        if (!TextUtils.isEmpty(c)) {
            b2 = c;
        } else {
            b2 = k.b("pre_sim_key", "");
            c = b2;
        }
        if (TextUtils.isEmpty(b2)) {
            return 0;
        }
        if (b2.equals(str)) {
            return 1;
        }
        return 2;
    }

    public static boolean c(com.cmic.sso.sdk.a aVar) {
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
        if (f7726a) {
            c.b("PhoneScripUtils", "phone is root");
            a(false, false);
        }
        return b();
    }
}

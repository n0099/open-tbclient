package com.xiaomi.push;
/* loaded from: classes6.dex */
public class ab {
    private static int a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f115a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f116a;
    public static final boolean b;
    public static final boolean c;
    public static final boolean d;
    public static boolean e;
    public static final boolean f;
    public static final boolean g;

    static {
        boolean z = false;
        f115a = ae.f117a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f116a = f115a.contains("2A2FE0D7");
        b = f116a || "DEBUG".equalsIgnoreCase(f115a);
        c = "LOGABLE".equalsIgnoreCase(f115a);
        d = f115a.contains("YY");
        e = f115a.equalsIgnoreCase("TEST");
        f = "BETA".equalsIgnoreCase(f115a);
        if (f115a != null && f115a.startsWith("RC")) {
            z = true;
        }
        g = z;
        a = 1;
        if (f115a.equalsIgnoreCase("SANDBOX")) {
            a = 2;
        } else if (f115a.equalsIgnoreCase("ONEBOX")) {
            a = 3;
        } else {
            a = 1;
        }
    }

    public static int a() {
        return a;
    }

    public static void a(int i) {
        a = i;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m119a() {
        return a == 2;
    }

    public static boolean b() {
        return a == 3;
    }
}

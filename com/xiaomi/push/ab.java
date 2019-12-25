package com.xiaomi.push;
/* loaded from: classes5.dex */
public class ab {
    private static int a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f117a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f118a;
    public static final boolean b;
    public static final boolean c;
    public static final boolean d;
    public static boolean e;
    public static final boolean f;
    public static final boolean g;

    static {
        boolean z = false;
        f117a = ae.f119a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f118a = f117a.contains("2A2FE0D7");
        b = f118a || "DEBUG".equalsIgnoreCase(f117a);
        c = "LOGABLE".equalsIgnoreCase(f117a);
        d = f117a.contains("YY");
        e = f117a.equalsIgnoreCase("TEST");
        f = "BETA".equalsIgnoreCase(f117a);
        if (f117a != null && f117a.startsWith("RC")) {
            z = true;
        }
        g = z;
        a = 1;
        if (f117a.equalsIgnoreCase("SANDBOX")) {
            a = 2;
        } else if (f117a.equalsIgnoreCase("ONEBOX")) {
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
    public static boolean m110a() {
        return a == 2;
    }

    public static boolean b() {
        return a == 3;
    }
}

package com.xiaomi.push;
/* loaded from: classes18.dex */
public class ab {

    /* renamed from: a  reason: collision with root package name */
    private static int f4786a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f94a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f95a;
    public static final boolean b;
    public static final boolean c;
    public static final boolean d;
    public static boolean e;
    public static final boolean f;
    public static final boolean g;

    static {
        boolean z = false;
        f94a = ae.f96a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f95a = f94a.contains("2A2FE0D7");
        b = f95a || "DEBUG".equalsIgnoreCase(f94a);
        c = "LOGABLE".equalsIgnoreCase(f94a);
        d = f94a.contains("YY");
        e = f94a.equalsIgnoreCase("TEST");
        f = "BETA".equalsIgnoreCase(f94a);
        if (f94a != null && f94a.startsWith("RC")) {
            z = true;
        }
        g = z;
        f4786a = 1;
        if (f94a.equalsIgnoreCase("SANDBOX")) {
            f4786a = 2;
        } else if (f94a.equalsIgnoreCase("ONEBOX")) {
            f4786a = 3;
        } else {
            f4786a = 1;
        }
    }

    public static int a() {
        return f4786a;
    }

    public static void a(int i) {
        f4786a = i;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m128a() {
        return f4786a == 2;
    }

    public static boolean b() {
        return f4786a == 3;
    }
}

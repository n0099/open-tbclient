package com.xiaomi.push;
/* loaded from: classes12.dex */
public class ab {

    /* renamed from: a  reason: collision with root package name */
    private static int f4786a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f91a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f92a;
    public static final boolean b;
    public static final boolean c;
    public static final boolean d;
    public static boolean e;
    public static final boolean f;
    public static final boolean g;

    static {
        boolean z = false;
        f91a = ae.f93a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f92a = f91a.contains("2A2FE0D7");
        b = f92a || "DEBUG".equalsIgnoreCase(f91a);
        c = "LOGABLE".equalsIgnoreCase(f91a);
        d = f91a.contains("YY");
        e = f91a.equalsIgnoreCase("TEST");
        f = "BETA".equalsIgnoreCase(f91a);
        if (f91a != null && f91a.startsWith("RC")) {
            z = true;
        }
        g = z;
        f4786a = 1;
        if (f91a.equalsIgnoreCase("SANDBOX")) {
            f4786a = 2;
        } else if (f91a.equalsIgnoreCase("ONEBOX")) {
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
    public static boolean m125a() {
        return f4786a == 2;
    }

    public static boolean b() {
        return f4786a == 3;
    }
}

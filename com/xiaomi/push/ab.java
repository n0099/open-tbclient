package com.xiaomi.push;
/* loaded from: classes8.dex */
public class ab {
    private static int a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f90a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f91a;
    public static final boolean b;
    public static final boolean c;
    public static final boolean d;
    public static boolean e;
    public static final boolean f;
    public static final boolean g;

    static {
        boolean z = false;
        f90a = ae.f92a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f91a = f90a.contains("2A2FE0D7");
        b = f91a || "DEBUG".equalsIgnoreCase(f90a);
        c = "LOGABLE".equalsIgnoreCase(f90a);
        d = f90a.contains("YY");
        e = f90a.equalsIgnoreCase("TEST");
        f = "BETA".equalsIgnoreCase(f90a);
        if (f90a != null && f90a.startsWith("RC")) {
            z = true;
        }
        g = z;
        a = 1;
        if (f90a.equalsIgnoreCase("SANDBOX")) {
            a = 2;
        } else if (f90a.equalsIgnoreCase("ONEBOX")) {
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
    public static boolean m122a() {
        return a == 2;
    }

    public static boolean b() {
        return a == 3;
    }
}

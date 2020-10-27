package com.xiaomi.push;
/* loaded from: classes12.dex */
public class ab {

    /* renamed from: a  reason: collision with root package name */
    private static int f4784a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f89a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f90a;
    public static final boolean b;
    public static final boolean c;
    public static final boolean d;
    public static boolean e;
    public static final boolean f;
    public static final boolean g;

    static {
        boolean z = false;
        f89a = ae.f91a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f90a = f89a.contains("2A2FE0D7");
        b = f90a || "DEBUG".equalsIgnoreCase(f89a);
        c = "LOGABLE".equalsIgnoreCase(f89a);
        d = f89a.contains("YY");
        e = f89a.equalsIgnoreCase("TEST");
        f = "BETA".equalsIgnoreCase(f89a);
        if (f89a != null && f89a.startsWith("RC")) {
            z = true;
        }
        g = z;
        f4784a = 1;
        if (f89a.equalsIgnoreCase("SANDBOX")) {
            f4784a = 2;
        } else if (f89a.equalsIgnoreCase("ONEBOX")) {
            f4784a = 3;
        } else {
            f4784a = 1;
        }
    }

    public static int a() {
        return f4784a;
    }

    public static void a(int i) {
        f4784a = i;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m125a() {
        return f4784a == 2;
    }

    public static boolean b() {
        return f4784a == 3;
    }
}

package com.xiaomi.push;
/* loaded from: classes8.dex */
public class ab {
    private static int a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f96a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f97a;
    public static final boolean b;
    public static final boolean c;
    public static final boolean d;
    public static boolean e;
    public static final boolean f;
    public static final boolean g;

    static {
        boolean z = false;
        f96a = ae.f98a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f97a = f96a.contains("2A2FE0D7");
        b = f97a || "DEBUG".equalsIgnoreCase(f96a);
        c = "LOGABLE".equalsIgnoreCase(f96a);
        d = f96a.contains("YY");
        e = f96a.equalsIgnoreCase("TEST");
        f = "BETA".equalsIgnoreCase(f96a);
        if (f96a != null && f96a.startsWith("RC")) {
            z = true;
        }
        g = z;
        a = 1;
        if (f96a.equalsIgnoreCase("SANDBOX")) {
            a = 2;
        } else if (f96a.equalsIgnoreCase("ONEBOX")) {
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

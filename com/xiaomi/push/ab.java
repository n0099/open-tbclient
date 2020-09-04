package com.xiaomi.push;
/* loaded from: classes7.dex */
public class ab {
    private static int a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f92a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f93a;
    public static final boolean b;
    public static final boolean c;
    public static final boolean d;
    public static boolean e;
    public static final boolean f;
    public static final boolean g;

    static {
        boolean z = false;
        f92a = ae.f94a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f93a = f92a.contains("2A2FE0D7");
        b = f93a || "DEBUG".equalsIgnoreCase(f92a);
        c = "LOGABLE".equalsIgnoreCase(f92a);
        d = f92a.contains("YY");
        e = f92a.equalsIgnoreCase("TEST");
        f = "BETA".equalsIgnoreCase(f92a);
        if (f92a != null && f92a.startsWith("RC")) {
            z = true;
        }
        g = z;
        a = 1;
        if (f92a.equalsIgnoreCase("SANDBOX")) {
            a = 2;
        } else if (f92a.equalsIgnoreCase("ONEBOX")) {
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
    public static boolean m125a() {
        return a == 2;
    }

    public static boolean b() {
        return a == 3;
    }
}

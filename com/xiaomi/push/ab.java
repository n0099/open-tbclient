package com.xiaomi.push;
/* loaded from: classes7.dex */
public class ab {
    private static int a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f93a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f94a;
    public static final boolean b;
    public static final boolean c;
    public static final boolean d;
    public static boolean e;
    public static final boolean f;
    public static final boolean g;

    static {
        boolean z = false;
        f93a = ae.f95a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f94a = f93a.contains("2A2FE0D7");
        b = f94a || "DEBUG".equalsIgnoreCase(f93a);
        c = "LOGABLE".equalsIgnoreCase(f93a);
        d = f93a.contains("YY");
        e = f93a.equalsIgnoreCase("TEST");
        f = "BETA".equalsIgnoreCase(f93a);
        if (f93a != null && f93a.startsWith("RC")) {
            z = true;
        }
        g = z;
        a = 1;
        if (f93a.equalsIgnoreCase("SANDBOX")) {
            a = 2;
        } else if (f93a.equalsIgnoreCase("ONEBOX")) {
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

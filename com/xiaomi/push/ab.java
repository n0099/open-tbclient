package com.xiaomi.push;
/* loaded from: classes8.dex */
public class ab {
    private static int a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f97a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f98a;
    public static final boolean b;
    public static final boolean c;
    public static final boolean d;
    public static boolean e;
    public static final boolean f;
    public static final boolean g;

    static {
        boolean z = false;
        f97a = ae.f99a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f98a = f97a.contains("2A2FE0D7");
        b = f98a || "DEBUG".equalsIgnoreCase(f97a);
        c = "LOGABLE".equalsIgnoreCase(f97a);
        d = f97a.contains("YY");
        e = f97a.equalsIgnoreCase("TEST");
        f = "BETA".equalsIgnoreCase(f97a);
        if (f97a != null && f97a.startsWith("RC")) {
            z = true;
        }
        g = z;
        a = 1;
        if (f97a.equalsIgnoreCase("SANDBOX")) {
            a = 2;
        } else if (f97a.equalsIgnoreCase("ONEBOX")) {
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

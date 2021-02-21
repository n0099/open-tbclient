package com.xiaomi.push;
/* loaded from: classes6.dex */
public class ab {

    /* renamed from: a  reason: collision with root package name */
    private static int f13849a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f170a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f171a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f13850b;
    public static final boolean c;
    public static final boolean d;
    public static boolean e;
    public static final boolean f;
    public static final boolean g;

    static {
        boolean z = false;
        f170a = ae.f172a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f171a = f170a.contains("2A2FE0D7");
        f13850b = f171a || "DEBUG".equalsIgnoreCase(f170a);
        c = "LOGABLE".equalsIgnoreCase(f170a);
        d = f170a.contains("YY");
        e = f170a.equalsIgnoreCase("TEST");
        f = "BETA".equalsIgnoreCase(f170a);
        if (f170a != null && f170a.startsWith("RC")) {
            z = true;
        }
        g = z;
        f13849a = 1;
        if (f170a.equalsIgnoreCase("SANDBOX")) {
            f13849a = 2;
        } else if (f170a.equalsIgnoreCase("ONEBOX")) {
            f13849a = 3;
        } else {
            f13849a = 1;
        }
    }

    public static int a() {
        return f13849a;
    }

    public static void a(int i) {
        f13849a = i;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m150a() {
        return f13849a == 2;
    }

    public static boolean b() {
        return f13849a == 3;
    }
}

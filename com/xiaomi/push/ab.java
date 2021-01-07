package com.xiaomi.push;
/* loaded from: classes6.dex */
public class ab {

    /* renamed from: a  reason: collision with root package name */
    private static int f14147a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f171a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f172a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f14148b;
    public static final boolean c;
    public static final boolean d;
    public static boolean e;
    public static final boolean f;
    public static final boolean g;

    static {
        boolean z = false;
        f171a = ae.f173a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f172a = f171a.contains("2A2FE0D7");
        f14148b = f172a || "DEBUG".equalsIgnoreCase(f171a);
        c = "LOGABLE".equalsIgnoreCase(f171a);
        d = f171a.contains("YY");
        e = f171a.equalsIgnoreCase("TEST");
        f = "BETA".equalsIgnoreCase(f171a);
        if (f171a != null && f171a.startsWith("RC")) {
            z = true;
        }
        g = z;
        f14147a = 1;
        if (f171a.equalsIgnoreCase("SANDBOX")) {
            f14147a = 2;
        } else if (f171a.equalsIgnoreCase("ONEBOX")) {
            f14147a = 3;
        } else {
            f14147a = 1;
        }
    }

    public static int a() {
        return f14147a;
    }

    public static void a(int i) {
        f14147a = i;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m155a() {
        return f14147a == 2;
    }

    public static boolean b() {
        return f14147a == 3;
    }
}

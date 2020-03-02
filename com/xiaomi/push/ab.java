package com.xiaomi.push;
/* loaded from: classes8.dex */
public class ab {
    private static int a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f112a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f113a;
    public static final boolean b;
    public static final boolean c;
    public static final boolean d;
    public static boolean e;
    public static final boolean f;
    public static final boolean g;

    static {
        boolean z = false;
        f112a = ae.f114a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f113a = f112a.contains("2A2FE0D7");
        b = f113a || "DEBUG".equalsIgnoreCase(f112a);
        c = "LOGABLE".equalsIgnoreCase(f112a);
        d = f112a.contains("YY");
        e = f112a.equalsIgnoreCase("TEST");
        f = "BETA".equalsIgnoreCase(f112a);
        if (f112a != null && f112a.startsWith("RC")) {
            z = true;
        }
        g = z;
        a = 1;
        if (f112a.equalsIgnoreCase("SANDBOX")) {
            a = 2;
        } else if (f112a.equalsIgnoreCase("ONEBOX")) {
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
    public static boolean m124a() {
        return a == 2;
    }

    public static boolean b() {
        return a == 3;
    }
}

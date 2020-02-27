package com.xiaomi.push;
/* loaded from: classes8.dex */
public class ab {
    private static int a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f113a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f114a;
    public static final boolean b;
    public static final boolean c;
    public static final boolean d;
    public static boolean e;
    public static final boolean f;
    public static final boolean g;

    static {
        boolean z = false;
        f113a = ae.f115a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f114a = f113a.contains("2A2FE0D7");
        b = f114a || "DEBUG".equalsIgnoreCase(f113a);
        c = "LOGABLE".equalsIgnoreCase(f113a);
        d = f113a.contains("YY");
        e = f113a.equalsIgnoreCase("TEST");
        f = "BETA".equalsIgnoreCase(f113a);
        if (f113a != null && f113a.startsWith("RC")) {
            z = true;
        }
        g = z;
        a = 1;
        if (f113a.equalsIgnoreCase("SANDBOX")) {
            a = 2;
        } else if (f113a.equalsIgnoreCase("ONEBOX")) {
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

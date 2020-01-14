package com.xiaomi.push;
/* loaded from: classes6.dex */
public class ab {
    private static int a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f116a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f117a;
    public static final boolean b;
    public static final boolean c;
    public static final boolean d;
    public static boolean e;
    public static final boolean f;
    public static final boolean g;

    static {
        boolean z = false;
        f116a = ae.f118a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f117a = f116a.contains("2A2FE0D7");
        b = f117a || "DEBUG".equalsIgnoreCase(f116a);
        c = "LOGABLE".equalsIgnoreCase(f116a);
        d = f116a.contains("YY");
        e = f116a.equalsIgnoreCase("TEST");
        f = "BETA".equalsIgnoreCase(f116a);
        if (f116a != null && f116a.startsWith("RC")) {
            z = true;
        }
        g = z;
        a = 1;
        if (f116a.equalsIgnoreCase("SANDBOX")) {
            a = 2;
        } else if (f116a.equalsIgnoreCase("ONEBOX")) {
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

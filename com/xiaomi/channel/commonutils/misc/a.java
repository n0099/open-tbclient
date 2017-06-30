package com.xiaomi.channel.commonutils.misc;
/* loaded from: classes2.dex */
public class a {
    public static final String a;
    public static final boolean b;
    public static final boolean c;
    public static final boolean d;
    public static final boolean e;
    public static boolean f;
    public static final boolean g;
    public static final boolean h;
    private static int i;

    static {
        boolean z = false;
        a = c.a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        b = a.contains("2A2FE0D7");
        c = b || "DEBUG".equalsIgnoreCase(a);
        d = "LOGABLE".equalsIgnoreCase(a);
        e = a.contains("YY");
        f = a.equalsIgnoreCase("TEST");
        g = "BETA".equalsIgnoreCase(a);
        if (a != null && a.startsWith("RC")) {
            z = true;
        }
        h = z;
        i = 1;
        if (a.equalsIgnoreCase("SANDBOX")) {
            i = 2;
        } else if (a.equalsIgnoreCase("ONEBOX")) {
            i = 3;
        } else {
            i = 1;
        }
    }

    public static void a(int i2) {
        i = i2;
    }

    public static boolean a() {
        return i == 2;
    }

    public static boolean b() {
        return i == 3;
    }

    public static int c() {
        return i;
    }
}

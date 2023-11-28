package com.xiaomi.push;
/* loaded from: classes10.dex */
public class ab {
    public static int a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f90a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f91a;
    public static final boolean b;
    public static final boolean c;
    public static final boolean d;
    public static boolean e;
    public static final boolean f;
    public static final boolean g;

    static {
        int i;
        String str = af.f92a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f90a = str;
        boolean contains = str.contains("2A2FE0D7");
        f91a = contains;
        boolean z = false;
        b = contains || "DEBUG".equalsIgnoreCase(f90a);
        c = "LOGABLE".equalsIgnoreCase(f90a);
        d = f90a.contains("YY");
        e = f90a.equalsIgnoreCase("TEST");
        f = "BETA".equalsIgnoreCase(f90a);
        String str2 = f90a;
        if (str2 != null && str2.startsWith("RC")) {
            z = true;
        }
        g = z;
        a = 1;
        if (f90a.equalsIgnoreCase("SANDBOX")) {
            i = 2;
        } else if (!f90a.equalsIgnoreCase("ONEBOX")) {
            a = 1;
            return;
        } else {
            i = 3;
        }
        a = i;
    }

    public static int a() {
        return a;
    }

    public static void a(int i) {
        a = i;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m265a() {
        return a == 2;
    }

    public static boolean b() {
        return a == 3;
    }
}

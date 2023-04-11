package com.xiaomi.push;
/* loaded from: classes8.dex */
public class ab {
    public static int a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f94a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f95a;
    public static final boolean b;
    public static final boolean c;
    public static final boolean d;
    public static boolean e;
    public static final boolean f;
    public static final boolean g;

    static {
        int i;
        String str = af.f96a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f94a = str;
        boolean contains = str.contains("2A2FE0D7");
        f95a = contains;
        boolean z = false;
        b = contains || "DEBUG".equalsIgnoreCase(f94a);
        c = "LOGABLE".equalsIgnoreCase(f94a);
        d = f94a.contains("YY");
        e = f94a.equalsIgnoreCase("TEST");
        f = "BETA".equalsIgnoreCase(f94a);
        String str2 = f94a;
        if (str2 != null && str2.startsWith("RC")) {
            z = true;
        }
        g = z;
        a = 1;
        if (f94a.equalsIgnoreCase("SANDBOX")) {
            i = 2;
        } else if (!f94a.equalsIgnoreCase("ONEBOX")) {
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
    public static boolean m176a() {
        return a == 2;
    }

    public static boolean b() {
        return a == 3;
    }
}

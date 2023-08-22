package com.xiaomi.push;
/* loaded from: classes10.dex */
public class ab {
    public static int a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f95a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f96a;
    public static final boolean b;
    public static final boolean c;
    public static final boolean d;
    public static boolean e;
    public static final boolean f;
    public static final boolean g;

    static {
        int i;
        String str = af.f97a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f95a = str;
        boolean contains = str.contains("2A2FE0D7");
        f96a = contains;
        boolean z = false;
        b = contains || "DEBUG".equalsIgnoreCase(f95a);
        c = "LOGABLE".equalsIgnoreCase(f95a);
        d = f95a.contains("YY");
        e = f95a.equalsIgnoreCase("TEST");
        f = "BETA".equalsIgnoreCase(f95a);
        String str2 = f95a;
        if (str2 != null && str2.startsWith("RC")) {
            z = true;
        }
        g = z;
        a = 1;
        if (f95a.equalsIgnoreCase("SANDBOX")) {
            i = 2;
        } else if (!f95a.equalsIgnoreCase("ONEBOX")) {
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
    public static boolean m255a() {
        return a == 2;
    }

    public static boolean b() {
        return a == 3;
    }
}

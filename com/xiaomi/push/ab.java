package com.xiaomi.push;
/* loaded from: classes7.dex */
public class ab {

    /* renamed from: a  reason: collision with root package name */
    public static int f41070a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f100a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f101a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f41071b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f41072c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f41073d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f41074e;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f41075f;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f41076g;

    static {
        int i2;
        String str = ae.f102a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f100a = str;
        boolean contains = str.contains("2A2FE0D7");
        f101a = contains;
        boolean z = false;
        f41071b = contains || "DEBUG".equalsIgnoreCase(f100a);
        f41072c = "LOGABLE".equalsIgnoreCase(f100a);
        f41073d = f100a.contains("YY");
        f41074e = f100a.equalsIgnoreCase("TEST");
        f41075f = "BETA".equalsIgnoreCase(f100a);
        String str2 = f100a;
        if (str2 != null && str2.startsWith("RC")) {
            z = true;
        }
        f41076g = z;
        f41070a = 1;
        if (f100a.equalsIgnoreCase("SANDBOX")) {
            i2 = 2;
        } else if (!f100a.equalsIgnoreCase("ONEBOX")) {
            f41070a = 1;
            return;
        } else {
            i2 = 3;
        }
        f41070a = i2;
    }

    public static int a() {
        return f41070a;
    }

    public static void a(int i2) {
        f41070a = i2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m125a() {
        return f41070a == 2;
    }

    public static boolean b() {
        return f41070a == 3;
    }
}

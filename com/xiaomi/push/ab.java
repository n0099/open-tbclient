package com.xiaomi.push;
/* loaded from: classes7.dex */
public class ab {

    /* renamed from: a  reason: collision with root package name */
    public static int f40967a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f100a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f101a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f40968b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f40969c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f40970d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f40971e;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f40972f;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f40973g;

    static {
        int i2;
        String str = ae.f102a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f100a = str;
        boolean contains = str.contains("2A2FE0D7");
        f101a = contains;
        boolean z = false;
        f40968b = contains || "DEBUG".equalsIgnoreCase(f100a);
        f40969c = "LOGABLE".equalsIgnoreCase(f100a);
        f40970d = f100a.contains("YY");
        f40971e = f100a.equalsIgnoreCase("TEST");
        f40972f = "BETA".equalsIgnoreCase(f100a);
        String str2 = f100a;
        if (str2 != null && str2.startsWith("RC")) {
            z = true;
        }
        f40973g = z;
        f40967a = 1;
        if (f100a.equalsIgnoreCase("SANDBOX")) {
            i2 = 2;
        } else if (!f100a.equalsIgnoreCase("ONEBOX")) {
            f40967a = 1;
            return;
        } else {
            i2 = 3;
        }
        f40967a = i2;
    }

    public static int a() {
        return f40967a;
    }

    public static void a(int i2) {
        f40967a = i2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m125a() {
        return f40967a == 2;
    }

    public static boolean b() {
        return f40967a == 3;
    }
}

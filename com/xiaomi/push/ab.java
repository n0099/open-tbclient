package com.xiaomi.push;
/* loaded from: classes7.dex */
public class ab {

    /* renamed from: a  reason: collision with root package name */
    public static int f37359a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f100a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f101a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f37360b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f37361c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f37362d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f37363e;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f37364f;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f37365g;

    static {
        int i2;
        String str = ae.f102a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f100a = str;
        boolean contains = str.contains("2A2FE0D7");
        f101a = contains;
        boolean z = false;
        f37360b = contains || "DEBUG".equalsIgnoreCase(f100a);
        f37361c = "LOGABLE".equalsIgnoreCase(f100a);
        f37362d = f100a.contains("YY");
        f37363e = f100a.equalsIgnoreCase("TEST");
        f37364f = "BETA".equalsIgnoreCase(f100a);
        String str2 = f100a;
        if (str2 != null && str2.startsWith("RC")) {
            z = true;
        }
        f37365g = z;
        f37359a = 1;
        if (f100a.equalsIgnoreCase("SANDBOX")) {
            i2 = 2;
        } else if (!f100a.equalsIgnoreCase("ONEBOX")) {
            f37359a = 1;
            return;
        } else {
            i2 = 3;
        }
        f37359a = i2;
    }

    public static int a() {
        return f37359a;
    }

    public static void a(int i2) {
        f37359a = i2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m126a() {
        return f37359a == 2;
    }

    public static boolean b() {
        return f37359a == 3;
    }
}

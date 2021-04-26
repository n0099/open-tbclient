package com.xiaomi.push;
/* loaded from: classes7.dex */
public class ab {

    /* renamed from: a  reason: collision with root package name */
    public static int f38114a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f100a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f101a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f38115b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f38116c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f38117d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f38118e;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f38119f;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f38120g;

    static {
        int i2;
        String str = ae.f102a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f100a = str;
        boolean contains = str.contains("2A2FE0D7");
        f101a = contains;
        boolean z = false;
        f38115b = contains || "DEBUG".equalsIgnoreCase(f100a);
        f38116c = "LOGABLE".equalsIgnoreCase(f100a);
        f38117d = f100a.contains("YY");
        f38118e = f100a.equalsIgnoreCase("TEST");
        f38119f = "BETA".equalsIgnoreCase(f100a);
        String str2 = f100a;
        if (str2 != null && str2.startsWith("RC")) {
            z = true;
        }
        f38120g = z;
        f38114a = 1;
        if (f100a.equalsIgnoreCase("SANDBOX")) {
            i2 = 2;
        } else if (!f100a.equalsIgnoreCase("ONEBOX")) {
            f38114a = 1;
            return;
        } else {
            i2 = 3;
        }
        f38114a = i2;
    }

    public static int a() {
        return f38114a;
    }

    public static void a(int i2) {
        f38114a = i2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m127a() {
        return f38114a == 2;
    }

    public static boolean b() {
        return f38114a == 3;
    }
}

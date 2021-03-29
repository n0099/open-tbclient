package com.xiaomi.push;
/* loaded from: classes7.dex */
public class ab {

    /* renamed from: a  reason: collision with root package name */
    public static int f40215a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f100a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f101a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f40216b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f40217c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f40218d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f40219e;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f40220f;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f40221g;

    static {
        int i;
        String str = ae.f102a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f100a = str;
        boolean contains = str.contains("2A2FE0D7");
        f101a = contains;
        boolean z = false;
        f40216b = contains || "DEBUG".equalsIgnoreCase(f100a);
        f40217c = "LOGABLE".equalsIgnoreCase(f100a);
        f40218d = f100a.contains("YY");
        f40219e = f100a.equalsIgnoreCase("TEST");
        f40220f = "BETA".equalsIgnoreCase(f100a);
        String str2 = f100a;
        if (str2 != null && str2.startsWith("RC")) {
            z = true;
        }
        f40221g = z;
        f40215a = 1;
        if (f100a.equalsIgnoreCase("SANDBOX")) {
            i = 2;
        } else if (!f100a.equalsIgnoreCase("ONEBOX")) {
            f40215a = 1;
            return;
        } else {
            i = 3;
        }
        f40215a = i;
    }

    public static int a() {
        return f40215a;
    }

    public static void a(int i) {
        f40215a = i;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m120a() {
        return f40215a == 2;
    }

    public static boolean b() {
        return f40215a == 3;
    }
}

package com.xiaomi.push;
/* loaded from: classes7.dex */
public class ab {

    /* renamed from: a  reason: collision with root package name */
    public static int f40504a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f100a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f101a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f40505b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f40506c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f40507d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f40508e;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f40509f;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f40510g;

    static {
        int i;
        String str = ae.f102a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f100a = str;
        boolean contains = str.contains("2A2FE0D7");
        f101a = contains;
        boolean z = false;
        f40505b = contains || "DEBUG".equalsIgnoreCase(f100a);
        f40506c = "LOGABLE".equalsIgnoreCase(f100a);
        f40507d = f100a.contains("YY");
        f40508e = f100a.equalsIgnoreCase("TEST");
        f40509f = "BETA".equalsIgnoreCase(f100a);
        String str2 = f100a;
        if (str2 != null && str2.startsWith("RC")) {
            z = true;
        }
        f40510g = z;
        f40504a = 1;
        if (f100a.equalsIgnoreCase("SANDBOX")) {
            i = 2;
        } else if (!f100a.equalsIgnoreCase("ONEBOX")) {
            f40504a = 1;
            return;
        } else {
            i = 3;
        }
        f40504a = i;
    }

    public static int a() {
        return f40504a;
    }

    public static void a(int i) {
        f40504a = i;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m124a() {
        return f40504a == 2;
    }

    public static boolean b() {
        return f40504a == 3;
    }
}

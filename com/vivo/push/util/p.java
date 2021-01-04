package com.vivo.push.util;

import android.content.Context;
/* loaded from: classes3.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static final o f13994a = new n();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f13995b = z.b("persist.sys.log.ctrl", "no").equals("yes");
    private static boolean c;

    public static boolean a() {
        return f13995b;
    }

    public static void a(boolean z) {
        f13995b = z;
        c = z;
    }

    public static int a(String str, String str2) {
        return f13994a.a(str, str2);
    }

    public static int a(String str, Throwable th) {
        return f13994a.a(str, th);
    }

    public static int a(String str, String str2, Throwable th) {
        return f13994a.a(str, str2, th);
    }

    public static int b(String str, String str2) {
        return f13994a.b(str, str2);
    }

    public static int c(String str, String str2) {
        return f13994a.c(str, str2);
    }

    public static int d(String str, String str2) {
        return f13994a.d(str, str2);
    }

    public static int b(String str, String str2, Throwable th) {
        return f13994a.b(str, str2, th);
    }

    public static int e(String str, String str2) {
        return f13994a.e(str, str2);
    }

    public static String a(Throwable th) {
        return f13994a.a(th);
    }

    public static void a(Context context, String str) {
        f13994a.a(context, str);
    }

    public static void b(Context context, String str) {
        f13994a.b(context, str);
    }

    public static void c(Context context, String str) {
        f13994a.c(context, str);
    }
}

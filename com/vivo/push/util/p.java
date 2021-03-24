package com.vivo.push.util;

import android.content.Context;
/* loaded from: classes7.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static final o f39561a = new n();

    /* renamed from: b  reason: collision with root package name */
    public static boolean f39562b = z.b("persist.sys.log.ctrl", "no").equals("yes");

    /* renamed from: c  reason: collision with root package name */
    public static boolean f39563c;

    public static boolean a() {
        return f39562b;
    }

    public static int b(String str, String str2) {
        return f39561a.b(str, str2);
    }

    public static int c(String str, String str2) {
        return f39561a.c(str, str2);
    }

    public static int d(String str, String str2) {
        return f39561a.d(str, str2);
    }

    public static int e(String str, String str2) {
        return f39561a.e(str, str2);
    }

    public static void a(boolean z) {
        f39562b = z;
        f39563c = z;
    }

    public static int b(String str, String str2, Throwable th) {
        return f39561a.b(str, str2, th);
    }

    public static void c(Context context, String str) {
        f39561a.c(context, str);
    }

    public static void b(Context context, String str) {
        f39561a.b(context, str);
    }

    public static int a(String str, String str2) {
        return f39561a.a(str, str2);
    }

    public static int a(String str, Throwable th) {
        return f39561a.a(str, th);
    }

    public static int a(String str, String str2, Throwable th) {
        return f39561a.a(str, str2, th);
    }

    public static String a(Throwable th) {
        return f39561a.a(th);
    }

    public static void a(Context context, String str) {
        f39561a.a(context, str);
    }
}

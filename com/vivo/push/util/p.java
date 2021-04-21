package com.vivo.push.util;

import android.content.Context;
/* loaded from: classes7.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static final o f39946a = new n();

    /* renamed from: b  reason: collision with root package name */
    public static boolean f39947b = z.b("persist.sys.log.ctrl", "no").equals("yes");

    /* renamed from: c  reason: collision with root package name */
    public static boolean f39948c;

    public static boolean a() {
        return f39947b;
    }

    public static int b(String str, String str2) {
        return f39946a.b(str, str2);
    }

    public static int c(String str, String str2) {
        return f39946a.c(str, str2);
    }

    public static int d(String str, String str2) {
        return f39946a.d(str, str2);
    }

    public static int e(String str, String str2) {
        return f39946a.e(str, str2);
    }

    public static void a(boolean z) {
        f39947b = z;
        f39948c = z;
    }

    public static int b(String str, String str2, Throwable th) {
        return f39946a.b(str, str2, th);
    }

    public static void c(Context context, String str) {
        f39946a.c(context, str);
    }

    public static void b(Context context, String str) {
        f39946a.b(context, str);
    }

    public static int a(String str, String str2) {
        return f39946a.a(str, str2);
    }

    public static int a(String str, Throwable th) {
        return f39946a.a(str, th);
    }

    public static int a(String str, String str2, Throwable th) {
        return f39946a.a(str, str2, th);
    }

    public static String a(Throwable th) {
        return f39946a.a(th);
    }

    public static void a(Context context, String str) {
        f39946a.a(context, str);
    }
}

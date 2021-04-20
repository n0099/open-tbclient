package com.vivo.push.util;

import android.content.Context;
/* loaded from: classes7.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static final o f39851a = new n();

    /* renamed from: b  reason: collision with root package name */
    public static boolean f39852b = z.b("persist.sys.log.ctrl", "no").equals("yes");

    /* renamed from: c  reason: collision with root package name */
    public static boolean f39853c;

    public static boolean a() {
        return f39852b;
    }

    public static int b(String str, String str2) {
        return f39851a.b(str, str2);
    }

    public static int c(String str, String str2) {
        return f39851a.c(str, str2);
    }

    public static int d(String str, String str2) {
        return f39851a.d(str, str2);
    }

    public static int e(String str, String str2) {
        return f39851a.e(str, str2);
    }

    public static void a(boolean z) {
        f39852b = z;
        f39853c = z;
    }

    public static int b(String str, String str2, Throwable th) {
        return f39851a.b(str, str2, th);
    }

    public static void c(Context context, String str) {
        f39851a.c(context, str);
    }

    public static void b(Context context, String str) {
        f39851a.b(context, str);
    }

    public static int a(String str, String str2) {
        return f39851a.a(str, str2);
    }

    public static int a(String str, Throwable th) {
        return f39851a.a(str, th);
    }

    public static int a(String str, String str2, Throwable th) {
        return f39851a.a(str, str2, th);
    }

    public static String a(Throwable th) {
        return f39851a.a(th);
    }

    public static void a(Context context, String str) {
        f39851a.a(context, str);
    }
}

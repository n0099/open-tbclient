package com.vivo.push.util;

import android.content.Context;
/* loaded from: classes7.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static final o f36796a = new n();

    /* renamed from: b  reason: collision with root package name */
    public static boolean f36797b = z.b("persist.sys.log.ctrl", "no").equals("yes");

    /* renamed from: c  reason: collision with root package name */
    public static boolean f36798c;

    public static boolean a() {
        return f36797b;
    }

    public static int b(String str, String str2) {
        return f36796a.b(str, str2);
    }

    public static int c(String str, String str2) {
        return f36796a.c(str, str2);
    }

    public static int d(String str, String str2) {
        return f36796a.d(str, str2);
    }

    public static int e(String str, String str2) {
        return f36796a.e(str, str2);
    }

    public static void a(boolean z) {
        f36797b = z;
        f36798c = z;
    }

    public static int b(String str, String str2, Throwable th) {
        return f36796a.b(str, str2, th);
    }

    public static void c(Context context, String str) {
        f36796a.c(context, str);
    }

    public static void b(Context context, String str) {
        f36796a.b(context, str);
    }

    public static int a(String str, String str2) {
        return f36796a.a(str, str2);
    }

    public static int a(String str, Throwable th) {
        return f36796a.a(str, th);
    }

    public static int a(String str, String str2, Throwable th) {
        return f36796a.a(str, str2, th);
    }

    public static String a(Throwable th) {
        return f36796a.a(th);
    }

    public static void a(Context context, String str) {
        f36796a.a(context, str);
    }
}

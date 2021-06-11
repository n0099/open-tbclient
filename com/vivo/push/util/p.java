package com.vivo.push.util;

import android.content.Context;
/* loaded from: classes7.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static final o f40404a = new n();

    /* renamed from: b  reason: collision with root package name */
    public static boolean f40405b = z.b("persist.sys.log.ctrl", "no").equals("yes");

    /* renamed from: c  reason: collision with root package name */
    public static boolean f40406c;

    public static boolean a() {
        return f40405b;
    }

    public static int b(String str, String str2) {
        return f40404a.b(str, str2);
    }

    public static int c(String str, String str2) {
        return f40404a.c(str, str2);
    }

    public static int d(String str, String str2) {
        return f40404a.d(str, str2);
    }

    public static int e(String str, String str2) {
        return f40404a.e(str, str2);
    }

    public static void a(boolean z) {
        f40405b = z;
        f40406c = z;
    }

    public static int b(String str, String str2, Throwable th) {
        return f40404a.b(str, str2, th);
    }

    public static void c(Context context, String str) {
        f40404a.c(context, str);
    }

    public static void b(Context context, String str) {
        f40404a.b(context, str);
    }

    public static int a(String str, String str2) {
        return f40404a.a(str, str2);
    }

    public static int a(String str, Throwable th) {
        return f40404a.a(str, th);
    }

    public static int a(String str, String str2, Throwable th) {
        return f40404a.a(str, str2, th);
    }

    public static String a(Throwable th) {
        return f40404a.a(th);
    }

    public static void a(Context context, String str) {
        f40404a.a(context, str);
    }
}

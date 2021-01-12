package com.vivo.push.util;

import android.content.Context;
/* loaded from: classes3.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static final o f13695a = new n();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f13696b = z.b("persist.sys.log.ctrl", "no").equals("yes");
    private static boolean c;

    public static boolean a() {
        return f13696b;
    }

    public static void a(boolean z) {
        f13696b = z;
        c = z;
    }

    public static int a(String str, String str2) {
        return f13695a.a(str, str2);
    }

    public static int a(String str, Throwable th) {
        return f13695a.a(str, th);
    }

    public static int a(String str, String str2, Throwable th) {
        return f13695a.a(str, str2, th);
    }

    public static int b(String str, String str2) {
        return f13695a.b(str, str2);
    }

    public static int c(String str, String str2) {
        return f13695a.c(str, str2);
    }

    public static int d(String str, String str2) {
        return f13695a.d(str, str2);
    }

    public static int b(String str, String str2, Throwable th) {
        return f13695a.b(str, str2, th);
    }

    public static int e(String str, String str2) {
        return f13695a.e(str, str2);
    }

    public static String a(Throwable th) {
        return f13695a.a(th);
    }

    public static void a(Context context, String str) {
        f13695a.a(context, str);
    }

    public static void b(Context context, String str) {
        f13695a.b(context, str);
    }

    public static void c(Context context, String str) {
        f13695a.c(context, str);
    }
}

package d.r.b.a.a.m.c.d;

import android.util.Log;
/* loaded from: classes7.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static b f68145a;

    public static void a(String str, String str2) {
        b bVar = f68145a;
        if (bVar != null) {
            bVar.b(str, str2);
        } else {
            Log.e(str, str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        b bVar = f68145a;
        if (bVar != null) {
            bVar.error(str, str2, th);
        } else {
            f(str, th.getStackTrace());
        }
    }

    public static String c(String str, Object[] objArr) {
        try {
            return String.format(str, objArr);
        } catch (Exception e2) {
            return str + ", format failed: " + e2.getMessage();
        }
    }

    public static void d(String str, String str2) {
        b bVar = f68145a;
        if (bVar != null) {
            bVar.info(str, str2);
        } else {
            Log.i(str, str2);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        d(str, c(str2, objArr));
    }

    public static void f(String str, StackTraceElement[] stackTraceElementArr) {
        Log.e(str, "------------------Start StackTrace------------------");
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            Log.e(str, stackTraceElement.toString());
        }
        Log.e(str, "------------------ End StackTrace ------------------");
    }

    public static void g(String str, String str2) {
        b bVar = f68145a;
        if (bVar != null) {
            bVar.a(str, str2);
        } else {
            Log.w(str, str2);
        }
    }

    public static void h(String str, String str2, Object... objArr) {
        g(str, c(str2, objArr));
    }
}

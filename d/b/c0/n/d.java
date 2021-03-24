package d.b.c0.n;

import android.util.Log;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f42676a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f42677b = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f42678c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f42679d = true;

    public static void a(String str, Throwable th) {
        if (f42679d) {
            c(new Throwable().getStackTrace());
            Log.e("CashierSdk", d(str), th);
        }
    }

    public static void b(Object... objArr) {
        if (f42679d) {
            c(new Throwable().getStackTrace());
            Log.e("CashierSdk", d(objArr));
        }
    }

    public static void c(StackTraceElement[] stackTraceElementArr) {
        f42676a = stackTraceElementArr[1].getFileName();
        f42677b = stackTraceElementArr[1].getMethodName();
        f42678c = stackTraceElementArr[1].getLineNumber();
    }

    public static String d(Object... objArr) {
        if (objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj.toString());
            }
        }
        return f(sb.toString());
    }

    public static void e(String str) {
        if (f42679d) {
            Log.i("CashierSdk", str);
        }
    }

    public static String f(String str) {
        return Thread.currentThread().getName() + "[" + f42676a + ":" + f42677b + ":" + f42678c + "]" + str;
    }
}

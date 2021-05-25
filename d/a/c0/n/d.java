package d.a.c0.n;

import android.util.Log;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f39493a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f39494b = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f39495c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f39496d = true;

    public static void a(String str, Throwable th) {
        if (f39496d) {
            c(new Throwable().getStackTrace());
            Log.e("CashierSdk", d(str), th);
        }
    }

    public static void b(Object... objArr) {
        if (f39496d) {
            c(new Throwable().getStackTrace());
            Log.e("CashierSdk", d(objArr));
        }
    }

    public static void c(StackTraceElement[] stackTraceElementArr) {
        f39493a = stackTraceElementArr[1].getFileName();
        f39494b = stackTraceElementArr[1].getMethodName();
        f39495c = stackTraceElementArr[1].getLineNumber();
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
        if (f39496d) {
            Log.i("CashierSdk", str);
        }
    }

    public static String f(String str) {
        return Thread.currentThread().getName() + "[" + f39493a + ":" + f39494b + ":" + f39495c + "]" + str;
    }
}

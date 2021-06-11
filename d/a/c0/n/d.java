package d.a.c0.n;

import android.util.Log;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f43174a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f43175b = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f43176c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f43177d = true;

    public static void a(String str, Throwable th) {
        if (f43177d) {
            c(new Throwable().getStackTrace());
            Log.e("CashierSdk", d(str), th);
        }
    }

    public static void b(Object... objArr) {
        if (f43177d) {
            c(new Throwable().getStackTrace());
            Log.e("CashierSdk", d(objArr));
        }
    }

    public static void c(StackTraceElement[] stackTraceElementArr) {
        f43174a = stackTraceElementArr[1].getFileName();
        f43175b = stackTraceElementArr[1].getMethodName();
        f43176c = stackTraceElementArr[1].getLineNumber();
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
        if (f43177d) {
            Log.i("CashierSdk", str);
        }
    }

    public static String f(String str) {
        return Thread.currentThread().getName() + "[" + f43174a + ":" + f43175b + ":" + f43176c + "]" + str;
    }
}

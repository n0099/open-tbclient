package d.a.a0.n;

import android.util.Log;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f38473a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f38474b = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f38475c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f38476d = true;

    public static void a(String str, Throwable th) {
        if (f38476d) {
            c(new Throwable().getStackTrace());
            Log.e("CashierSdk", d(str), th);
        }
    }

    public static void b(Object... objArr) {
        if (f38476d) {
            c(new Throwable().getStackTrace());
            Log.e("CashierSdk", d(objArr));
        }
    }

    public static void c(StackTraceElement[] stackTraceElementArr) {
        f38473a = stackTraceElementArr[1].getFileName();
        f38474b = stackTraceElementArr[1].getMethodName();
        f38475c = stackTraceElementArr[1].getLineNumber();
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
        if (f38476d) {
            Log.i("CashierSdk", str);
        }
    }

    public static String f(String str) {
        return Thread.currentThread().getName() + "[" + f38473a + ":" + f38474b + ":" + f38475c + "]" + str;
    }
}

package d.b.a0.n;

import android.util.Log;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f42047a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f42048b = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f42049c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f42050d = true;

    public static void a(String str, Throwable th) {
        if (f42050d) {
            c(new Throwable().getStackTrace());
            Log.e("CashierSdk", d(str), th);
        }
    }

    public static void b(Object... objArr) {
        if (f42050d) {
            c(new Throwable().getStackTrace());
            Log.e("CashierSdk", d(objArr));
        }
    }

    public static void c(StackTraceElement[] stackTraceElementArr) {
        f42047a = stackTraceElementArr[1].getFileName();
        f42048b = stackTraceElementArr[1].getMethodName();
        f42049c = stackTraceElementArr[1].getLineNumber();
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
        if (f42050d) {
            Log.i("CashierSdk", str);
        }
    }

    public static String f(String str) {
        return Thread.currentThread().getName() + "[" + f42047a + ":" + f42048b + ":" + f42049c + "]" + str;
    }
}

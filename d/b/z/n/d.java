package d.b.z.n;

import android.util.Log;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f65745a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f65746b = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f65747c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f65748d = true;

    public static void a(String str, Throwable th) {
        if (f65748d) {
            c(new Throwable().getStackTrace());
            Log.e("CashierSdk", d(str), th);
        }
    }

    public static void b(Object... objArr) {
        if (f65748d) {
            c(new Throwable().getStackTrace());
            Log.e("CashierSdk", d(objArr));
        }
    }

    public static void c(StackTraceElement[] stackTraceElementArr) {
        f65745a = stackTraceElementArr[1].getFileName();
        f65746b = stackTraceElementArr[1].getMethodName();
        f65747c = stackTraceElementArr[1].getLineNumber();
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
        if (f65748d) {
            Log.i("CashierSdk", str);
        }
    }

    public static String f(String str) {
        return Thread.currentThread().getName() + "[" + f65745a + ":" + f65746b + ":" + f65747c + "]" + str;
    }
}

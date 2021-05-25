package d.a.o0.a;

import android.util.Log;
import java.util.Locale;
/* loaded from: classes5.dex */
public class a {
    public static void a(String str, String str2) {
        b(str, str2, new Object[0]);
    }

    public static void b(String str, String str2, Object... objArr) {
        String e2 = e(str2, objArr);
        Throwable g2 = g(objArr);
        if (g2 != null) {
            Log.d(i(str), e2, g2);
        } else {
            Log.d(i(str), e2);
        }
    }

    public static void c(String str, String str2, Object... objArr) {
        String d2 = d(str2, objArr);
        Throwable g2 = g(objArr);
        if (g2 != null) {
            Log.e(i(str), d2, g2);
        } else {
            Log.e(i(str), d2);
        }
    }

    public static String d(String str, Object... objArr) {
        return (objArr == null || objArr.length == 0) ? str : String.format(Locale.US, str, objArr);
    }

    public static String e(String str, Object... objArr) {
        return "[" + f() + "] " + d(str, objArr);
    }

    public static String f() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = a.class.getName();
        int i2 = 0;
        while (true) {
            if (i2 >= stackTrace.length) {
                break;
            } else if (stackTrace[i2].getClassName().equals(name)) {
                i2 += 4;
                break;
            } else {
                i2++;
            }
        }
        return stackTrace[i2].getFileName() + ":" + stackTrace[i2].getLineNumber();
    }

    public static Throwable g(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        Object obj = objArr[objArr.length - 1];
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        return null;
    }

    public static void h(String str, String str2, Object... objArr) {
        String d2 = d(str2, objArr);
        Throwable g2 = g(objArr);
        if (g2 != null) {
            Log.i(i(str), d2, g2);
        } else {
            Log.i(i(str), d2);
        }
    }

    public static String i(String str) {
        if (str.startsWith("cr_")) {
            return str;
        }
        int i2 = str.startsWith("cr.") ? 3 : 0;
        return "cr_" + str.substring(i2, str.length());
    }
}

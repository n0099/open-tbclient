package d.a.c0.n;

import android.util.Log;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f43277a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f43278b = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f43279c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f43280d = true;

    public static void a(String str, Throwable th) {
        if (f43280d) {
            c(new Throwable().getStackTrace());
            Log.e("CashierSdk", d(str), th);
        }
    }

    public static void b(Object... objArr) {
        if (f43280d) {
            c(new Throwable().getStackTrace());
            Log.e("CashierSdk", d(objArr));
        }
    }

    public static void c(StackTraceElement[] stackTraceElementArr) {
        f43277a = stackTraceElementArr[1].getFileName();
        f43278b = stackTraceElementArr[1].getMethodName();
        f43279c = stackTraceElementArr[1].getLineNumber();
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
        if (f43280d) {
            Log.i("CashierSdk", str);
        }
    }

    public static String f(String str) {
        return Thread.currentThread().getName() + PreferencesUtil.LEFT_MOUNT + f43277a + ":" + f43278b + ":" + f43279c + PreferencesUtil.RIGHT_MOUNT + str;
    }
}

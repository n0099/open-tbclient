package d.a.t.e;

import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f63970a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f63971b;

    /* renamed from: c  reason: collision with root package name */
    public static String f63972c;

    /* renamed from: d  reason: collision with root package name */
    public static ArrayList<String> f63973d;

    static {
        AppInfoService appInfoService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        if (appInfoService != null) {
            l(appInfoService.isDebug());
        }
        f63970a = a.class.getName();
        f63971b = false;
        f63972c = null;
        f63973d = new ArrayList<>();
    }

    public static String a(boolean z, String str, String str2, String str3) {
        if (i()) {
            String str4 = f63972c;
            if (str4 == null || str3.startsWith(str4)) {
                if (!z || j(str)) {
                    StringBuffer stringBuffer = new StringBuffer(100);
                    stringBuffer.append(str);
                    stringBuffer.append(":");
                    stringBuffer.append(str2);
                    stringBuffer.append(":");
                    stringBuffer.append(str3);
                    return stringBuffer.toString();
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public static void b(String str, String str2, String str3) {
        String a2 = a(true, str, str2, str3);
        if (a2 != null) {
            Log.d(f63970a, a2);
        }
    }

    public static int c(Throwable th) {
        if (!i() || th == null) {
            return -1;
        }
        Log.e(f63970a, th.getMessage(), th);
        return k(0, th.getMessage());
    }

    public static int d(String str) {
        return k(0, str);
    }

    public static int e(Throwable th) {
        return k(0, th.getMessage());
    }

    public static void f(String str, String str2, String str3) {
        String a2 = a(false, str, str2, str3);
        if (a2 != null) {
            Log.e(f63970a, a2);
        }
    }

    public static int g(String str) {
        return k(2, str);
    }

    public static void h(String str, String str2, String str3) {
        String a2 = a(true, str, str2, str3);
        if (a2 != null) {
            Log.i(f63970a, a2);
        }
    }

    public static boolean i() {
        return f63971b;
    }

    public static boolean j(String str) {
        boolean z = false;
        if (f63973d.size() == 0) {
            return false;
        }
        Iterator<String> it = f63973d.iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                z = true;
            }
        }
        return z;
    }

    public static int k(int i2, String str) {
        if (i()) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace.length < 5) {
                return -1;
            }
            StackTraceElement stackTraceElement = stackTrace[4];
            String methodName = stackTraceElement.getMethodName();
            String className = stackTraceElement.getClassName();
            if (i2 <= 1 || j(className)) {
                if (i2 == 0) {
                    f(className, methodName, str);
                    return 0;
                } else if (i2 == 1) {
                    n(className, methodName, str);
                    return 0;
                } else if (i2 == 2) {
                    h(className, methodName, str);
                    return 0;
                } else if (i2 == 3) {
                    b(className, methodName, str);
                    return 0;
                } else {
                    m(className, methodName, str);
                    return 0;
                }
            }
            return -1;
        }
        return -1;
    }

    public static void l(boolean z) {
        f63971b = z;
    }

    public static void m(String str, String str2, String str3) {
        String a2 = a(true, str, str2, str3);
        if (a2 != null) {
            Log.v(f63970a, a2);
        }
    }

    public static void n(String str, String str2, String str3) {
        String a2 = a(false, str, str2, str3);
        if (a2 != null) {
            Log.w(f63970a, a2);
        }
    }
}

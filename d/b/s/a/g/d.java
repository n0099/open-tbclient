package d.b.s.a.g;

import android.util.Log;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f65627a = "lcpsdk";

    public static void a(String str, String str2) {
        if (b.f65623a) {
            String str3 = f65627a;
            Log.d(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2);
        }
    }

    public static void b(String str, String str2) {
        if (b.f65623a) {
            String str3 = f65627a;
            Log.e(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        if (b.f65623a) {
            String str3 = f65627a;
            Log.e(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2, th);
        }
    }

    public static void d(String str, String str2) {
        if (b.f65623a) {
            String str3 = f65627a;
            Log.i(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2);
        }
    }

    public static void e(String str, String str2) {
        if (b.f65623a) {
            String str3 = f65627a;
            Log.v(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2);
        }
    }

    public static void f(String str, String str2) {
        if (b.f65623a) {
            String str3 = f65627a;
            Log.w(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2);
        }
    }
}

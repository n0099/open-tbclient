package d.a.t.a.h;

import android.util.Log;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static String f68441a = "lcpsdk";

    public static void a(String str, String str2) {
        if (c.f68437a) {
            String str3 = f68441a;
            Log.d(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2);
        }
    }

    public static void b(String str, String str2) {
        if (c.f68437a) {
            String str3 = f68441a;
            Log.e(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        if (c.f68437a) {
            String str3 = f68441a;
            Log.e(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2, th);
        }
    }

    public static void d(String str, String str2) {
        if (c.f68437a) {
            String str3 = f68441a;
            Log.i(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2);
        }
    }

    public static void e(String str, String str2) {
        if (c.f68437a) {
            String str3 = f68441a;
            Log.v(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2);
        }
    }

    public static void f(String str, String str2) {
        if (c.f68437a) {
            String str3 = f68441a;
            Log.w(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2);
        }
    }
}

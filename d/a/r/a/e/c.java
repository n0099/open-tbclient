package d.a.r.a.e;

import android.util.Log;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f68084a = "liteUBC";

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f68085b = d.a.r.a.a.d().b();

    public static void a(String str, String str2) {
        if (f68085b) {
            String str3 = f68084a;
            Log.d(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (f68085b) {
            String str3 = f68084a;
            Log.e(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2, th);
        }
    }

    public static void c(String str, String str2) {
        if (f68085b) {
            String str3 = f68084a;
            Log.i(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2);
        }
    }
}

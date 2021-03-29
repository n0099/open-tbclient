package d.b.g0.a.c0;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.bumptech.glide.load.engine.GlideException;
import d.b.g0.a.h;
import d.b.g0.a.i2.j;
import d.b.g0.a.k;
import d.b.g0.a.z0.f;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f43595a = false;

    public static void a(String str, Object... objArr) {
        if (!k.f45051a || objArr == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj.toString());
            }
        }
        Log.d(str, sb.toString());
    }

    public static void b(String str, String str2) {
        j("error", str, str2);
        d.b.g0.a.w0.a.U().e(str, str2);
        if (k.f45051a) {
            Log.e(str, str2);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        String str3;
        if (th != null) {
            str3 = "Exception:" + th.getMessage() + "\n" + str2;
        } else {
            str3 = str2;
        }
        j("error", str, str3);
        d.b.g0.a.w0.a.U().e(str, str2, th);
        if (k.f45051a) {
            Log.e(str, str2, th);
        }
    }

    public static boolean d() {
        return f43595a;
    }

    public static String e() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null && stackTrace.length > 5) {
            return stackTrace[5].getFileName();
        }
        return AppRuntime.getAppContext().getString(h.aiapps_err_message_get_name_fail);
    }

    public static int f() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null || stackTrace.length <= 5) {
            return -1;
        }
        return stackTrace[5].getLineNumber();
    }

    public static void g(String str, String str2) {
        j("info", str, str2);
        d.b.g0.a.w0.a.U().i(str, str2);
        if (k.f45051a) {
            Log.i(str, str2);
        }
    }

    public static void h(String str, String str2) {
        d.b.g0.a.w0.a.U().i(str, str2);
        if (k.f45051a) {
            Log.i(str, str2);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        d.b.g0.a.w0.a.U().e(str, str2, th);
        if (k.f45051a) {
            Log.e(str, str2, th);
        }
    }

    public static void j(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3) || !f43595a) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        String b2 = j.b(j.a(), "yyyy-MM-dd HH:mm:ss");
        String e2 = e();
        int f2 = f();
        sb.append(b2);
        sb.append(GlideException.IndentedAppendable.INDENT);
        sb.append(e2);
        sb.append(GlideException.IndentedAppendable.INDENT);
        sb.append("line:");
        sb.append(f2);
        sb.append("\n");
        sb.append("module:");
        sb.append(str2);
        sb.append("\n");
        sb.append(str3);
        f.V().F().X(str, sb.toString());
    }

    public static void k(boolean z) {
        f43595a = z;
    }

    public static void l(String str, String str2) {
        j("warn", str, str2);
        d.b.g0.a.w0.a.U().w(str, str2);
        if (k.f45051a) {
            Log.w(str, str2);
        }
    }
}

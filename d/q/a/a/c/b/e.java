package d.q.a.a.c.b;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
/* loaded from: classes7.dex */
public class e implements d.q.a.a.a.b.b {

    /* renamed from: e  reason: collision with root package name */
    public Context f67633e;

    public e(Context context) {
        this.f67633e = context;
    }

    public static String a(String str) {
        try {
            d a2 = c.a(new String[]{str}, false, true);
            return !TextUtils.isEmpty(a2.f67631b) ? a2.f67631b : (TextUtils.isEmpty(a2.f67632c) || !a2.f67632c.contains("denied")) ? TextUtils.isEmpty(a2.f67631b) ? "KWE_N" : "KWE_OTHER" : "KWE_PN";
        } catch (Throwable th) {
            b.c(th);
            return "KWE_PE";
        }
    }

    public static String b(Throwable th) {
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "UnknownHostException";
            }
            try {
            } catch (Throwable th3) {
                b.c(th3);
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        String stringWriter2 = stringWriter.toString();
        printWriter.close();
        return stringWriter2;
    }

    public static boolean c(Context context, String[] strArr) {
        for (int i2 = 0; i2 <= 0; i2++) {
            try {
                if (context.checkPermission(strArr[0], Process.myPid(), Process.myUid()) == -1) {
                    return false;
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        return true;
    }

    public static String d(String str) {
        return TextUtils.isEmpty(str) ? "KWE_N" : str;
    }

    public static boolean e(Context context, String[] strArr) {
        for (int i2 = 0; i2 < 2; i2++) {
            try {
                if (context.checkPermission(strArr[i2], Process.myPid(), Process.myUid()) == 0) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    @Override // d.q.a.a.a.b.b
    public void a(d.q.a.a.a.a.a aVar) {
        if (aVar != null) {
            try {
                b.e("meizu enter");
                aVar.a(c(), this);
            } catch (Throwable th) {
                b.c(th);
            }
        }
    }

    @Override // d.q.a.a.a.b.b
    public boolean a() {
        return false;
    }

    @Override // d.q.a.a.a.b.b
    public String b() {
        String e2 = d.q.a.a.a.b.e.a.a.a(this.f67633e).e();
        return TextUtils.isEmpty(e2) ? "" : e2;
    }

    @Override // d.q.a.a.a.b.b
    public boolean c() {
        return d.q.a.a.a.b.e.a.a.a(this.f67633e).d();
    }

    @Override // d.q.a.a.a.b.b
    public void d() {
    }
}

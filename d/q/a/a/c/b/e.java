package d.q.a.a.c.b;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
/* loaded from: classes7.dex */
public class e implements d.q.a.a.a.b.b {

    /* renamed from: e  reason: collision with root package name */
    public Context f67380e;

    public e(Context context) {
        this.f67380e = context;
    }

    public static String a(int i) {
        String str = null;
        try {
            str = h(String.format("/proc/%d/cmdline", Integer.valueOf(i)));
            if (!TextUtils.isEmpty(str)) {
                return str.trim();
            }
        } catch (Throwable th) {
            b.c(th);
        }
        return str;
    }

    public static String b(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return sb.toString();
            }
            if (z) {
                z = false;
            } else {
                sb.append('\n');
            }
            sb.append(readLine);
        }
    }

    public static String c(String str) {
        try {
            d a2 = c.a(new String[]{str}, false, true);
            return !TextUtils.isEmpty(a2.f67378b) ? a2.f67378b : (TextUtils.isEmpty(a2.f67379c) || !a2.f67379c.contains("denied")) ? TextUtils.isEmpty(a2.f67378b) ? "KWE_N" : "KWE_OTHER" : "KWE_PN";
        } catch (Throwable th) {
            b.c(th);
            return "KWE_PE";
        }
    }

    public static String d(Throwable th) {
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

    public static boolean e(Context context, String[] strArr) {
        for (int i = 0; i <= 0; i++) {
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

    public static String f(String str) {
        return TextUtils.isEmpty(str) ? "KWE_N" : str;
    }

    public static boolean g(Context context, String[] strArr) {
        for (int i = 0; i < 2; i++) {
            try {
                if (context.checkPermission(strArr[i], Process.myPid(), Process.myUid()) == 0) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static String h(String str) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            String b2 = b(fileInputStream);
            try {
                fileInputStream.close();
            } catch (Throwable unused) {
            }
            return b2;
        } catch (Throwable th2) {
            th = th2;
            try {
                b.c(th);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable unused2) {
                    }
                }
                return null;
            } catch (Throwable th3) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable unused3) {
                    }
                }
                throw th3;
            }
        }
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
        String e2 = d.q.a.a.a.b.e.a.a.a(this.f67380e).e();
        return TextUtils.isEmpty(e2) ? "" : e2;
    }

    @Override // d.q.a.a.a.b.b
    public boolean c() {
        return d.q.a.a.a.b.e.a.a.a(this.f67380e).d();
    }

    @Override // d.q.a.a.a.b.b
    public void d() {
    }
}

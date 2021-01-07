package com.yxcorp.kuaishou.addfp.android.b;

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
/* loaded from: classes5.dex */
public class e implements com.yxcorp.kuaishou.addfp.a.b.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f14690a;

    public e(Context context) {
        this.f14690a = context;
    }

    public static String a(int i) {
        try {
            String c = c(String.format("/proc/%d/cmdline", Integer.valueOf(i)));
            return !TextUtils.isEmpty(c) ? c.trim() : c;
        } catch (Throwable th) {
            b.a(th);
            return null;
        }
    }

    private static String a(InputStream inputStream) {
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

    public static String a(String str) {
        String str2 = "KWE_OTHER";
        try {
            d a2 = c.a(new String[]{str}, false, true);
            if (!TextUtils.isEmpty(a2.f14688a)) {
                str2 = a2.f14688a;
            } else if (!TextUtils.isEmpty(a2.f14689b) && a2.f14689b.contains("denied")) {
                str2 = "KWE_PN";
            } else if (TextUtils.isEmpty(a2.f14688a)) {
                str2 = "KWE_N";
            }
            return str2;
        } catch (Throwable th) {
            b.a(th);
            return "KWE_PE";
        }
    }

    public static String a(Throwable th) {
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "UnknownHostException";
            }
            try {
            } catch (Throwable th3) {
                b.a(th3);
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

    public static boolean a(Context context, String[] strArr) {
        for (int i = 0; i <= 0; i++) {
            try {
                if (context.checkPermission(strArr[0], Process.myPid(), Process.myUid()) == -1) {
                    return false;
                }
            } catch (Throwable th) {
                return false;
            }
        }
        return true;
    }

    public static String b(String str) {
        return TextUtils.isEmpty(str) ? "KWE_N" : str;
    }

    private static String c(String str) {
        FileInputStream fileInputStream;
        String str2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                str2 = a(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (Throwable th) {
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    b.a(th);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th3) {
                        }
                    }
                    return str2;
                } catch (Throwable th4) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th5) {
                        }
                    }
                    throw th4;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            fileInputStream = null;
        }
        return str2;
    }

    public static boolean e(Context context, String[] strArr) {
        for (int i = 0; i < 2; i++) {
            try {
                if (context.checkPermission(strArr[i], Process.myPid(), Process.myUid()) == 0) {
                    return true;
                }
            } catch (Throwable th) {
                return false;
            }
        }
        return false;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public void a(com.yxcorp.kuaishou.addfp.a.a.a aVar) {
        if (aVar != null) {
            try {
                b.b("meizu enter");
                aVar.a(c(), this);
            } catch (Throwable th) {
                b.a(th);
            }
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public boolean a() {
        return false;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public String b() {
        String b2 = com.yxcorp.kuaishou.addfp.a.b.d.a.a.jb(this.f14690a).b();
        return TextUtils.isEmpty(b2) ? "" : b2;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public boolean c() {
        return com.yxcorp.kuaishou.addfp.a.b.d.a.a.jb(this.f14690a).a();
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public void d() {
    }
}

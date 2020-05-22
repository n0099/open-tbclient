package tv.chushou.a.a.c;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes5.dex */
public final class a implements b {
    private static final a nMB = new a();
    private volatile boolean mhq = false;
    private volatile boolean nMC = false;

    public static b dRw() {
        return nMB;
    }

    @Override // tv.chushou.a.a.c.b
    public boolean dRx() {
        return this.mhq;
    }

    @Override // tv.chushou.a.a.c.b
    public void showLog(boolean z) {
        this.mhq = z;
    }

    @Override // tv.chushou.a.a.c.b
    public void xn(boolean z) {
        this.nMC = z;
    }

    public String dRy() {
        return "Router";
    }

    @Override // tv.chushou.a.a.c.b
    public void v(String str, String str2) {
        if (this.mhq) {
            Log.v(Sk(str), Sl(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void d(String str, String str2) {
        if (this.mhq) {
            Log.d(Sk(str), Sl(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void i(String str, String str2) {
        if (this.mhq) {
            Log.i(Sk(str), Sl(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void w(String str, String str2) {
        if (this.mhq) {
            Log.w(Sk(str), Sl(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2) {
        if (this.mhq) {
            Log.e(Sk(str), Sl(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2, Throwable th) {
        if (this.mhq) {
            Log.e(Sk(str), Sl(str2), th);
        }
    }

    private String Sk(String str) {
        return TextUtils.isEmpty(str) ? dRy() : str;
    }

    private String Sl(String str) {
        if (this.nMC) {
            return str + a(Thread.currentThread().getStackTrace()[3]);
        }
        return str;
    }

    static String a(StackTraceElement stackTraceElement) {
        StringBuilder sb = new StringBuilder("[");
        String name = Thread.currentThread().getName();
        String fileName = stackTraceElement.getFileName();
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        long id = Thread.currentThread().getId();
        int lineNumber = stackTraceElement.getLineNumber();
        sb.append("ThreadId=").append(id).append(" & ");
        sb.append("ThreadName=").append(name).append(" & ");
        sb.append("FileName=").append(fileName).append(" & ");
        sb.append("ClassName=").append(className).append(" & ");
        sb.append("MethodName=").append(methodName).append(" & ");
        sb.append("LineNumber=").append(lineNumber);
        sb.append(" ] ");
        return sb.toString();
    }
}

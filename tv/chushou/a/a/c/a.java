package tv.chushou.a.a.c;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes5.dex */
public final class a implements b {
    private static final a nNL = new a();
    private volatile boolean miC = false;
    private volatile boolean nNM = false;

    public static b dRK() {
        return nNL;
    }

    @Override // tv.chushou.a.a.c.b
    public boolean dRL() {
        return this.miC;
    }

    @Override // tv.chushou.a.a.c.b
    public void showLog(boolean z) {
        this.miC = z;
    }

    @Override // tv.chushou.a.a.c.b
    public void xp(boolean z) {
        this.nNM = z;
    }

    public String dRM() {
        return "Router";
    }

    @Override // tv.chushou.a.a.c.b
    public void v(String str, String str2) {
        if (this.miC) {
            Log.v(Sl(str), Sm(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void d(String str, String str2) {
        if (this.miC) {
            Log.d(Sl(str), Sm(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void i(String str, String str2) {
        if (this.miC) {
            Log.i(Sl(str), Sm(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void w(String str, String str2) {
        if (this.miC) {
            Log.w(Sl(str), Sm(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2) {
        if (this.miC) {
            Log.e(Sl(str), Sm(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2, Throwable th) {
        if (this.miC) {
            Log.e(Sl(str), Sm(str2), th);
        }
    }

    private String Sl(String str) {
        return TextUtils.isEmpty(str) ? dRM() : str;
    }

    private String Sm(String str) {
        if (this.nNM) {
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

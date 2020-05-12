package tv.chushou.a.a.c;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes5.dex */
public final class a implements b {
    private static final a nrE = new a();
    private volatile boolean lOb = false;
    private volatile boolean nrF = false;

    public static b dJC() {
        return nrE;
    }

    @Override // tv.chushou.a.a.c.b
    public boolean dJD() {
        return this.lOb;
    }

    @Override // tv.chushou.a.a.c.b
    public void wP(boolean z) {
        this.lOb = z;
    }

    @Override // tv.chushou.a.a.c.b
    public void wQ(boolean z) {
        this.nrF = z;
    }

    public String dJE() {
        return "Router";
    }

    @Override // tv.chushou.a.a.c.b
    public void v(String str, String str2) {
        if (this.lOb) {
            Log.v(Qe(str), Qf(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void d(String str, String str2) {
        if (this.lOb) {
            Log.d(Qe(str), Qf(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void i(String str, String str2) {
        if (this.lOb) {
            Log.i(Qe(str), Qf(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void w(String str, String str2) {
        if (this.lOb) {
            Log.w(Qe(str), Qf(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2) {
        if (this.lOb) {
            Log.e(Qe(str), Qf(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2, Throwable th) {
        if (this.lOb) {
            Log.e(Qe(str), Qf(str2), th);
        }
    }

    private String Qe(String str) {
        return TextUtils.isEmpty(str) ? dJE() : str;
    }

    private String Qf(String str) {
        if (this.nrF) {
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

package tv.chushou.a.a.c;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes5.dex */
public final class a implements b {
    private static final a nrB = new a();
    private volatile boolean lNX = false;
    private volatile boolean nrC = false;

    public static b dJF() {
        return nrB;
    }

    @Override // tv.chushou.a.a.c.b
    public boolean dJG() {
        return this.lNX;
    }

    @Override // tv.chushou.a.a.c.b
    public void wP(boolean z) {
        this.lNX = z;
    }

    @Override // tv.chushou.a.a.c.b
    public void wQ(boolean z) {
        this.nrC = z;
    }

    public String dJH() {
        return "Router";
    }

    @Override // tv.chushou.a.a.c.b
    public void v(String str, String str2) {
        if (this.lNX) {
            Log.v(Qb(str), Qc(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void d(String str, String str2) {
        if (this.lNX) {
            Log.d(Qb(str), Qc(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void i(String str, String str2) {
        if (this.lNX) {
            Log.i(Qb(str), Qc(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void w(String str, String str2) {
        if (this.lNX) {
            Log.w(Qb(str), Qc(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2) {
        if (this.lNX) {
            Log.e(Qb(str), Qc(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2, Throwable th) {
        if (this.lNX) {
            Log.e(Qb(str), Qc(str2), th);
        }
    }

    private String Qb(String str) {
        return TextUtils.isEmpty(str) ? dJH() : str;
    }

    private String Qc(String str) {
        if (this.nrC) {
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

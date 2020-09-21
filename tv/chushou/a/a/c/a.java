package tv.chushou.a.a.c;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes6.dex */
public final class a implements b {
    private static final a oWa = new a();
    private volatile boolean npU = false;
    private volatile boolean oWb = false;

    public static b eqb() {
        return oWa;
    }

    @Override // tv.chushou.a.a.c.b
    public boolean eqc() {
        return this.npU;
    }

    @Override // tv.chushou.a.a.c.b
    public void showLog(boolean z) {
        this.npU = z;
    }

    @Override // tv.chushou.a.a.c.b
    public void zr(boolean z) {
        this.oWb = z;
    }

    public String eqd() {
        return "Router";
    }

    @Override // tv.chushou.a.a.c.b
    public void v(String str, String str2) {
        if (this.npU) {
            Log.v(Xp(str), Xq(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void d(String str, String str2) {
        if (this.npU) {
            Log.d(Xp(str), Xq(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void i(String str, String str2) {
        if (this.npU) {
            Log.i(Xp(str), Xq(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void w(String str, String str2) {
        if (this.npU) {
            Log.w(Xp(str), Xq(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2) {
        if (this.npU) {
            Log.e(Xp(str), Xq(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2, Throwable th) {
        if (this.npU) {
            Log.e(Xp(str), Xq(str2), th);
        }
    }

    private String Xp(String str) {
        return TextUtils.isEmpty(str) ? eqd() : str;
    }

    private String Xq(String str) {
        if (this.oWb) {
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

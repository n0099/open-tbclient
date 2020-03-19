package tv.chushou.a.a.c;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes5.dex */
public final class a implements b {
    private static final a nXN = new a();
    private volatile boolean kXt = false;
    private volatile boolean nXO = false;

    public static b dQG() {
        return nXN;
    }

    @Override // tv.chushou.a.a.c.b
    public boolean dQH() {
        return this.kXt;
    }

    @Override // tv.chushou.a.a.c.b
    public void xk(boolean z) {
        this.kXt = z;
    }

    @Override // tv.chushou.a.a.c.b
    public void xl(boolean z) {
        this.nXO = z;
    }

    public String dQI() {
        return "Router";
    }

    @Override // tv.chushou.a.a.c.b
    public void v(String str, String str2) {
        if (this.kXt) {
            Log.v(SM(str), SN(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void d(String str, String str2) {
        if (this.kXt) {
            Log.d(SM(str), SN(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void i(String str, String str2) {
        if (this.kXt) {
            Log.i(SM(str), SN(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void w(String str, String str2) {
        if (this.kXt) {
            Log.w(SM(str), SN(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2) {
        if (this.kXt) {
            Log.e(SM(str), SN(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2, Throwable th) {
        if (this.kXt) {
            Log.e(SM(str), SN(str2), th);
        }
    }

    private String SM(String str) {
        return TextUtils.isEmpty(str) ? dQI() : str;
    }

    private String SN(String str) {
        if (this.nXO) {
            return str + b(Thread.currentThread().getStackTrace()[3]);
        }
        return str;
    }

    static String b(StackTraceElement stackTraceElement) {
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

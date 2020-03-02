package tv.chushou.a.a.c;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes5.dex */
public final class a implements b {
    private static final a nVP = new a();
    private volatile boolean kVE = false;
    private volatile boolean nVQ = false;

    public static b dQf() {
        return nVP;
    }

    @Override // tv.chushou.a.a.c.b
    public boolean dQg() {
        return this.kVE;
    }

    @Override // tv.chushou.a.a.c.b
    public void xc(boolean z) {
        this.kVE = z;
    }

    @Override // tv.chushou.a.a.c.b
    public void xd(boolean z) {
        this.nVQ = z;
    }

    public String dQh() {
        return "Router";
    }

    @Override // tv.chushou.a.a.c.b
    public void v(String str, String str2) {
        if (this.kVE) {
            Log.v(SL(str), SM(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void d(String str, String str2) {
        if (this.kVE) {
            Log.d(SL(str), SM(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void i(String str, String str2) {
        if (this.kVE) {
            Log.i(SL(str), SM(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void w(String str, String str2) {
        if (this.kVE) {
            Log.w(SL(str), SM(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2) {
        if (this.kVE) {
            Log.e(SL(str), SM(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2, Throwable th) {
        if (this.kVE) {
            Log.e(SL(str), SM(str2), th);
        }
    }

    private String SL(String str) {
        return TextUtils.isEmpty(str) ? dQh() : str;
    }

    private String SM(String str) {
        if (this.nVQ) {
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

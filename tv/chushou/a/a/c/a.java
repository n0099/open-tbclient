package tv.chushou.a.a.c;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes5.dex */
public final class a implements b {
    private static final a nWa = new a();
    private volatile boolean kVQ = false;
    private volatile boolean nWb = false;

    public static b dQg() {
        return nWa;
    }

    @Override // tv.chushou.a.a.c.b
    public boolean dQh() {
        return this.kVQ;
    }

    @Override // tv.chushou.a.a.c.b
    public void xc(boolean z) {
        this.kVQ = z;
    }

    @Override // tv.chushou.a.a.c.b
    public void xd(boolean z) {
        this.nWb = z;
    }

    public String dQi() {
        return "Router";
    }

    @Override // tv.chushou.a.a.c.b
    public void v(String str, String str2) {
        if (this.kVQ) {
            Log.v(SM(str), SN(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void d(String str, String str2) {
        if (this.kVQ) {
            Log.d(SM(str), SN(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void i(String str, String str2) {
        if (this.kVQ) {
            Log.i(SM(str), SN(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void w(String str, String str2) {
        if (this.kVQ) {
            Log.w(SM(str), SN(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2) {
        if (this.kVQ) {
            Log.e(SM(str), SN(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2, Throwable th) {
        if (this.kVQ) {
            Log.e(SM(str), SN(str2), th);
        }
    }

    private String SM(String str) {
        return TextUtils.isEmpty(str) ? dQi() : str;
    }

    private String SN(String str) {
        if (this.nWb) {
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

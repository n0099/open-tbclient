package tv.chushou.a.a.c;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes6.dex */
public final class a implements b {
    private static final a osm = new a();
    private volatile boolean mMC = false;
    private volatile boolean osn = false;

    public static b dZQ() {
        return osm;
    }

    @Override // tv.chushou.a.a.c.b
    public boolean dZR() {
        return this.mMC;
    }

    @Override // tv.chushou.a.a.c.b
    public void showLog(boolean z) {
        this.mMC = z;
    }

    @Override // tv.chushou.a.a.c.b
    public void yp(boolean z) {
        this.osn = z;
    }

    public String dZS() {
        return "Router";
    }

    @Override // tv.chushou.a.a.c.b
    public void v(String str, String str2) {
        if (this.mMC) {
            Log.v(TJ(str), TK(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void d(String str, String str2) {
        if (this.mMC) {
            Log.d(TJ(str), TK(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void i(String str, String str2) {
        if (this.mMC) {
            Log.i(TJ(str), TK(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void w(String str, String str2) {
        if (this.mMC) {
            Log.w(TJ(str), TK(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2) {
        if (this.mMC) {
            Log.e(TJ(str), TK(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2, Throwable th) {
        if (this.mMC) {
            Log.e(TJ(str), TK(str2), th);
        }
    }

    private String TJ(String str) {
        return TextUtils.isEmpty(str) ? dZS() : str;
    }

    private String TK(String str) {
        if (this.osn) {
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

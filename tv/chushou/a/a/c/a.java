package tv.chushou.a.a.c;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes6.dex */
public final class a implements b {
    private static final a qnH = new a();
    private volatile boolean osz = false;
    private volatile boolean qnI = false;

    public static b eHA() {
        return qnH;
    }

    @Override // tv.chushou.a.a.c.b
    public boolean eHB() {
        return this.osz;
    }

    @Override // tv.chushou.a.a.c.b
    public void showLog(boolean z) {
        this.osz = z;
    }

    @Override // tv.chushou.a.a.c.b
    public void By(boolean z) {
        this.qnI = z;
    }

    public String eHC() {
        return "Router";
    }

    @Override // tv.chushou.a.a.c.b
    public void v(String str, String str2) {
        if (this.osz) {
            Log.v(aaf(str), aag(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void d(String str, String str2) {
        if (this.osz) {
            Log.d(aaf(str), aag(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void i(String str, String str2) {
        if (this.osz) {
            Log.i(aaf(str), aag(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void w(String str, String str2) {
        if (this.osz) {
            Log.w(aaf(str), aag(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2) {
        if (this.osz) {
            Log.e(aaf(str), aag(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2, Throwable th) {
        if (this.osz) {
            Log.e(aaf(str), aag(str2), th);
        }
    }

    private String aaf(String str) {
        return TextUtils.isEmpty(str) ? eHC() : str;
    }

    private String aag(String str) {
        if (this.qnI) {
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

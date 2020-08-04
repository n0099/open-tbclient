package tv.chushou.a.a.c;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes6.dex */
public final class a implements b {
    private static final a oso = new a();
    private volatile boolean mME = false;
    private volatile boolean osp = false;

    public static b dZR() {
        return oso;
    }

    @Override // tv.chushou.a.a.c.b
    public boolean dZS() {
        return this.mME;
    }

    @Override // tv.chushou.a.a.c.b
    public void showLog(boolean z) {
        this.mME = z;
    }

    @Override // tv.chushou.a.a.c.b
    public void yp(boolean z) {
        this.osp = z;
    }

    public String dZT() {
        return "Router";
    }

    @Override // tv.chushou.a.a.c.b
    public void v(String str, String str2) {
        if (this.mME) {
            Log.v(TJ(str), TK(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void d(String str, String str2) {
        if (this.mME) {
            Log.d(TJ(str), TK(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void i(String str, String str2) {
        if (this.mME) {
            Log.i(TJ(str), TK(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void w(String str, String str2) {
        if (this.mME) {
            Log.w(TJ(str), TK(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2) {
        if (this.mME) {
            Log.e(TJ(str), TK(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2, Throwable th) {
        if (this.mME) {
            Log.e(TJ(str), TK(str2), th);
        }
    }

    private String TJ(String str) {
        return TextUtils.isEmpty(str) ? dZT() : str;
    }

    private String TK(String str) {
        if (this.osp) {
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

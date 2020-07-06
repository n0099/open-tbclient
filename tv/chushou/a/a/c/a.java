package tv.chushou.a.a.c;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes5.dex */
public final class a implements b {
    private static final a ojC = new a();
    private volatile boolean mEy = false;
    private volatile boolean ojD = false;

    public static b dWu() {
        return ojC;
    }

    @Override // tv.chushou.a.a.c.b
    public boolean dWv() {
        return this.mEy;
    }

    @Override // tv.chushou.a.a.c.b
    public void showLog(boolean z) {
        this.mEy = z;
    }

    @Override // tv.chushou.a.a.c.b
    public void xK(boolean z) {
        this.ojD = z;
    }

    public String dWw() {
        return "Router";
    }

    @Override // tv.chushou.a.a.c.b
    public void v(String str, String str2) {
        if (this.mEy) {
            Log.v(SY(str), SZ(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void d(String str, String str2) {
        if (this.mEy) {
            Log.d(SY(str), SZ(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void i(String str, String str2) {
        if (this.mEy) {
            Log.i(SY(str), SZ(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void w(String str, String str2) {
        if (this.mEy) {
            Log.w(SY(str), SZ(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2) {
        if (this.mEy) {
            Log.e(SY(str), SZ(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2, Throwable th) {
        if (this.mEy) {
            Log.e(SY(str), SZ(str2), th);
        }
    }

    private String SY(String str) {
        return TextUtils.isEmpty(str) ? dWw() : str;
    }

    private String SZ(String str) {
        if (this.ojD) {
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

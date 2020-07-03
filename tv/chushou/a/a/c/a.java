package tv.chushou.a.a.c;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes5.dex */
public final class a implements b {
    private static final a ojz = new a();
    private volatile boolean mEv = false;
    private volatile boolean ojA = false;

    public static b dWq() {
        return ojz;
    }

    @Override // tv.chushou.a.a.c.b
    public boolean dWr() {
        return this.mEv;
    }

    @Override // tv.chushou.a.a.c.b
    public void showLog(boolean z) {
        this.mEv = z;
    }

    @Override // tv.chushou.a.a.c.b
    public void xK(boolean z) {
        this.ojA = z;
    }

    public String dWs() {
        return "Router";
    }

    @Override // tv.chushou.a.a.c.b
    public void v(String str, String str2) {
        if (this.mEv) {
            Log.v(SX(str), SY(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void d(String str, String str2) {
        if (this.mEv) {
            Log.d(SX(str), SY(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void i(String str, String str2) {
        if (this.mEv) {
            Log.i(SX(str), SY(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void w(String str, String str2) {
        if (this.mEv) {
            Log.w(SX(str), SY(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2) {
        if (this.mEv) {
            Log.e(SX(str), SY(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2, Throwable th) {
        if (this.mEv) {
            Log.e(SX(str), SY(str2), th);
        }
    }

    private String SX(String str) {
        return TextUtils.isEmpty(str) ? dWs() : str;
    }

    private String SY(String str) {
        if (this.ojA) {
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

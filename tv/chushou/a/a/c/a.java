package tv.chushou.a.a.c;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes6.dex */
public final class a implements b {
    private static final a qme = new a();
    private volatile boolean oqV = false;
    private volatile boolean qmf = false;

    public static b eHz() {
        return qme;
    }

    @Override // tv.chushou.a.a.c.b
    public boolean eHA() {
        return this.oqV;
    }

    @Override // tv.chushou.a.a.c.b
    public void showLog(boolean z) {
        this.oqV = z;
    }

    @Override // tv.chushou.a.a.c.b
    public void Br(boolean z) {
        this.qmf = z;
    }

    public String eHB() {
        return "Router";
    }

    @Override // tv.chushou.a.a.c.b
    public void v(String str, String str2) {
        if (this.oqV) {
            Log.v(aau(str), aav(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void d(String str, String str2) {
        if (this.oqV) {
            Log.d(aau(str), aav(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void i(String str, String str2) {
        if (this.oqV) {
            Log.i(aau(str), aav(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void w(String str, String str2) {
        if (this.oqV) {
            Log.w(aau(str), aav(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2) {
        if (this.oqV) {
            Log.e(aau(str), aav(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2, Throwable th) {
        if (this.oqV) {
            Log.e(aau(str), aav(str2), th);
        }
    }

    private String aau(String str) {
        return TextUtils.isEmpty(str) ? eHB() : str;
    }

    private String aav(String str) {
        if (this.qmf) {
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

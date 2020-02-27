package tv.chushou.a.a.c;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes5.dex */
public final class a implements b {
    private static final a nVN = new a();
    private volatile boolean kVC = false;
    private volatile boolean nVO = false;

    public static b dQd() {
        return nVN;
    }

    @Override // tv.chushou.a.a.c.b
    public boolean dQe() {
        return this.kVC;
    }

    @Override // tv.chushou.a.a.c.b
    public void xc(boolean z) {
        this.kVC = z;
    }

    @Override // tv.chushou.a.a.c.b
    public void xd(boolean z) {
        this.nVO = z;
    }

    public String dQf() {
        return "Router";
    }

    @Override // tv.chushou.a.a.c.b
    public void v(String str, String str2) {
        if (this.kVC) {
            Log.v(SL(str), SM(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void d(String str, String str2) {
        if (this.kVC) {
            Log.d(SL(str), SM(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void i(String str, String str2) {
        if (this.kVC) {
            Log.i(SL(str), SM(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void w(String str, String str2) {
        if (this.kVC) {
            Log.w(SL(str), SM(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2) {
        if (this.kVC) {
            Log.e(SL(str), SM(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2, Throwable th) {
        if (this.kVC) {
            Log.e(SL(str), SM(str2), th);
        }
    }

    private String SL(String str) {
        return TextUtils.isEmpty(str) ? dQf() : str;
    }

    private String SM(String str) {
        if (this.nVO) {
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

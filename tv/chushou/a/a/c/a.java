package tv.chushou.a.a.c;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes6.dex */
public final class a implements b {
    private static final a oMy = new a();
    private volatile boolean nfS = false;
    private volatile boolean oMz = false;

    public static b emd() {
        return oMy;
    }

    @Override // tv.chushou.a.a.c.b
    public boolean eme() {
        return this.nfS;
    }

    @Override // tv.chushou.a.a.c.b
    public void showLog(boolean z) {
        this.nfS = z;
    }

    @Override // tv.chushou.a.a.c.b
    public void zj(boolean z) {
        this.oMz = z;
    }

    public String emf() {
        return "Router";
    }

    @Override // tv.chushou.a.a.c.b
    public void v(String str, String str2) {
        if (this.nfS) {
            Log.v(WN(str), WO(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void d(String str, String str2) {
        if (this.nfS) {
            Log.d(WN(str), WO(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void i(String str, String str2) {
        if (this.nfS) {
            Log.i(WN(str), WO(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void w(String str, String str2) {
        if (this.nfS) {
            Log.w(WN(str), WO(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2) {
        if (this.nfS) {
            Log.e(WN(str), WO(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2, Throwable th) {
        if (this.nfS) {
            Log.e(WN(str), WO(str2), th);
        }
    }

    private String WN(String str) {
        return TextUtils.isEmpty(str) ? emf() : str;
    }

    private String WO(String str) {
        if (this.oMz) {
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

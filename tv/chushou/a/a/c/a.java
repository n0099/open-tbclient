package tv.chushou.a.a.c;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes6.dex */
public final class a implements b {
    private static final a qcJ = new a();
    private volatile boolean ohQ = false;
    private volatile boolean qcK = false;

    public static b eDK() {
        return qcJ;
    }

    @Override // tv.chushou.a.a.c.b
    public boolean eDL() {
        return this.ohQ;
    }

    @Override // tv.chushou.a.a.c.b
    public void showLog(boolean z) {
        this.ohQ = z;
    }

    @Override // tv.chushou.a.a.c.b
    public void Bg(boolean z) {
        this.qcK = z;
    }

    public String eDM() {
        return "Router";
    }

    @Override // tv.chushou.a.a.c.b
    public void v(String str, String str2) {
        if (this.ohQ) {
            Log.v(ZQ(str), ZR(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void d(String str, String str2) {
        if (this.ohQ) {
            Log.d(ZQ(str), ZR(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void i(String str, String str2) {
        if (this.ohQ) {
            Log.i(ZQ(str), ZR(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void w(String str, String str2) {
        if (this.ohQ) {
            Log.w(ZQ(str), ZR(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2) {
        if (this.ohQ) {
            Log.e(ZQ(str), ZR(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2, Throwable th) {
        if (this.ohQ) {
            Log.e(ZQ(str), ZR(str2), th);
        }
    }

    private String ZQ(String str) {
        return TextUtils.isEmpty(str) ? eDM() : str;
    }

    private String ZR(String str) {
        if (this.qcK) {
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

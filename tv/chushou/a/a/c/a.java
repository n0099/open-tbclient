package tv.chushou.a.a.c;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes4.dex */
public final class a implements b {
    private static final a nUT = new a();
    private volatile boolean kUR = false;
    private volatile boolean nUU = false;

    public static b dOO() {
        return nUT;
    }

    @Override // tv.chushou.a.a.c.b
    public boolean dOP() {
        return this.kUR;
    }

    @Override // tv.chushou.a.a.c.b
    public void wZ(boolean z) {
        this.kUR = z;
    }

    @Override // tv.chushou.a.a.c.b
    public void xa(boolean z) {
        this.nUU = z;
    }

    public String dOQ() {
        return "Router";
    }

    @Override // tv.chushou.a.a.c.b
    public void v(String str, String str2) {
        if (this.kUR) {
            Log.v(SA(str), SB(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void d(String str, String str2) {
        if (this.kUR) {
            Log.d(SA(str), SB(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void i(String str, String str2) {
        if (this.kUR) {
            Log.i(SA(str), SB(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void w(String str, String str2) {
        if (this.kUR) {
            Log.w(SA(str), SB(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2) {
        if (this.kUR) {
            Log.e(SA(str), SB(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2, Throwable th) {
        if (this.kUR) {
            Log.e(SA(str), SB(str2), th);
        }
    }

    private String SA(String str) {
        return TextUtils.isEmpty(str) ? dOQ() : str;
    }

    private String SB(String str) {
        if (this.nUU) {
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

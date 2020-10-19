package tv.chushou.a.a.c;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes6.dex */
public final class a implements b {
    private static final a plu = new a();
    private volatile boolean nFo = false;
    private volatile boolean plv = false;

    public static b etM() {
        return plu;
    }

    @Override // tv.chushou.a.a.c.b
    public boolean etN() {
        return this.nFo;
    }

    @Override // tv.chushou.a.a.c.b
    public void showLog(boolean z) {
        this.nFo = z;
    }

    @Override // tv.chushou.a.a.c.b
    public void zY(boolean z) {
        this.plv = z;
    }

    public String etO() {
        return "Router";
    }

    @Override // tv.chushou.a.a.c.b
    public void v(String str, String str2) {
        if (this.nFo) {
            Log.v(Yd(str), Ye(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void d(String str, String str2) {
        if (this.nFo) {
            Log.d(Yd(str), Ye(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void i(String str, String str2) {
        if (this.nFo) {
            Log.i(Yd(str), Ye(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void w(String str, String str2) {
        if (this.nFo) {
            Log.w(Yd(str), Ye(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2) {
        if (this.nFo) {
            Log.e(Yd(str), Ye(str2));
        }
    }

    @Override // tv.chushou.a.a.c.b
    public void e(String str, String str2, Throwable th) {
        if (this.nFo) {
            Log.e(Yd(str), Ye(str2), th);
        }
    }

    private String Yd(String str) {
        return TextUtils.isEmpty(str) ? etO() : str;
    }

    private String Ye(String str) {
        if (this.plv) {
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

package com.facebook.common.c;

import android.util.Log;
import com.baidu.mobstat.Config;
import java.io.PrintWriter;
import java.io.StringWriter;
/* loaded from: classes2.dex */
public class b implements c {
    public static final b jzT = new b();
    private String jzU = "unknown";
    private int jzV = 5;

    public static b ctN() {
        return jzT;
    }

    private b() {
    }

    @Override // com.facebook.common.c.c
    public boolean isLoggable(int i) {
        return this.jzV <= i;
    }

    @Override // com.facebook.common.c.c
    public void v(String str, String str2) {
        n(2, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void d(String str, String str2) {
        n(3, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void i(String str, String str2) {
        n(4, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void w(String str, String str2) {
        n(5, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void w(String str, String str2, Throwable th) {
        b(5, str, str2, th);
    }

    @Override // com.facebook.common.c.c
    public void e(String str, String str2) {
        n(6, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void e(String str, String str2, Throwable th) {
        b(6, str, str2, th);
    }

    @Override // com.facebook.common.c.c
    public void ek(String str, String str2) {
        n(6, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void f(String str, String str2, Throwable th) {
        b(6, str, str2, th);
    }

    private void n(int i, String str, String str2) {
        Log.println(i, Fy(str), str2);
    }

    private void b(int i, String str, String str2, Throwable th) {
        Log.println(i, Fy(str), h(str2, th));
    }

    private String Fy(String str) {
        if (this.jzU != null) {
            return this.jzU + Config.TRACE_TODAY_VISIT_SPLIT + str;
        }
        return str;
    }

    private static String h(String str, Throwable th) {
        return str + '\n' + getStackTraceString(th);
    }

    private static String getStackTraceString(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}

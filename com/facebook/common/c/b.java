package com.facebook.common.c;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
/* loaded from: classes2.dex */
public class b implements c {
    public static final b hWQ = new b();
    private String hWR = "unknown";
    private int hWS = 5;

    public static b bRD() {
        return hWQ;
    }

    private b() {
    }

    @Override // com.facebook.common.c.c
    public boolean isLoggable(int i) {
        return this.hWS <= i;
    }

    @Override // com.facebook.common.c.c
    public void v(String str, String str2) {
        m(2, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void d(String str, String str2) {
        m(3, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void i(String str, String str2) {
        m(4, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void w(String str, String str2) {
        m(5, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void w(String str, String str2, Throwable th) {
        b(5, str, str2, th);
    }

    @Override // com.facebook.common.c.c
    public void e(String str, String str2) {
        m(6, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void e(String str, String str2, Throwable th) {
        b(6, str, str2, th);
    }

    @Override // com.facebook.common.c.c
    public void cW(String str, String str2) {
        m(6, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void f(String str, String str2, Throwable th) {
        b(6, str, str2, th);
    }

    private void m(int i, String str, String str2) {
        Log.println(i, yu(str), str2);
    }

    private void b(int i, String str, String str2, Throwable th) {
        Log.println(i, yu(str), j(str2, th));
    }

    private String yu(String str) {
        if (this.hWR != null) {
            return this.hWR + ":" + str;
        }
        return str;
    }

    private static String j(String str, Throwable th) {
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

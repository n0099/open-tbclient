package com.facebook.common.c;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
/* loaded from: classes2.dex */
public class b implements c {
    public static final b hYB = new b();
    private String hYC = "unknown";
    private int hYD = 5;

    public static b bQY() {
        return hYB;
    }

    private b() {
    }

    @Override // com.facebook.common.c.c
    public boolean isLoggable(int i) {
        return this.hYD <= i;
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
    public void cV(String str, String str2) {
        m(6, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void f(String str, String str2, Throwable th) {
        b(6, str, str2, th);
    }

    private void m(int i, String str, String str2) {
        Log.println(i, yz(str), str2);
    }

    private void b(int i, String str, String str2, Throwable th) {
        Log.println(i, yz(str), j(str2, th));
    }

    private String yz(String str) {
        if (this.hYC != null) {
            return this.hYC + ":" + str;
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

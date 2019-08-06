package com.facebook.common.c;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
/* loaded from: classes2.dex */
public class b implements c {
    public static final b kas = new b();
    private String kat = "unknown";
    private int kau = 5;

    public static b cFa() {
        return kas;
    }

    private b() {
    }

    @Override // com.facebook.common.c.c
    public boolean isLoggable(int i) {
        return this.kau <= i;
    }

    @Override // com.facebook.common.c.c
    public void v(String str, String str2) {
        p(2, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void d(String str, String str2) {
        p(3, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void i(String str, String str2) {
        p(4, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void w(String str, String str2) {
        p(5, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void c(String str, String str2, Throwable th) {
        b(5, str, str2, th);
    }

    @Override // com.facebook.common.c.c
    public void e(String str, String str2) {
        p(6, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void e(String str, String str2, Throwable th) {
        b(6, str, str2, th);
    }

    @Override // com.facebook.common.c.c
    public void ez(String str, String str2) {
        p(6, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void f(String str, String str2, Throwable th) {
        b(6, str, str2, th);
    }

    private void p(int i, String str, String str2) {
        Log.println(i, HG(str), str2);
    }

    private void b(int i, String str, String str2, Throwable th) {
        Log.println(i, HG(str), h(str2, th));
    }

    private String HG(String str) {
        if (this.kat != null) {
            return this.kat + ":" + str;
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

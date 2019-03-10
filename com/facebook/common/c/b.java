package com.facebook.common.c;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
/* loaded from: classes2.dex */
public class b implements c {
    public static final b jAb = new b();
    private String jAc = "unknown";
    private int jAd = 5;

    public static b ctK() {
        return jAb;
    }

    private b() {
    }

    @Override // com.facebook.common.c.c
    public boolean isLoggable(int i) {
        return this.jAd <= i;
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
    public void el(String str, String str2) {
        n(6, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void f(String str, String str2, Throwable th) {
        b(6, str, str2, th);
    }

    private void n(int i, String str, String str2) {
        Log.println(i, FA(str), str2);
    }

    private void b(int i, String str, String str2, Throwable th) {
        Log.println(i, FA(str), h(str2, th));
    }

    private String FA(String str) {
        if (this.jAc != null) {
            return this.jAc + ":" + str;
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

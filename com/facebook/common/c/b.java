package com.facebook.common.c;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
/* loaded from: classes6.dex */
public class b implements c {
    public static final b pzu = new b();
    private String pzv = "unknown";
    private int pzw = 5;

    public static b esK() {
        return pzu;
    }

    private b() {
    }

    @Override // com.facebook.common.c.c
    public boolean isLoggable(int i) {
        return this.pzw <= i;
    }

    @Override // com.facebook.common.c.c
    public void v(String str, String str2) {
        println(2, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void d(String str, String str2) {
        println(3, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void w(String str, String str2) {
        println(5, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void w(String str, String str2, Throwable th) {
        b(5, str, str2, th);
    }

    @Override // com.facebook.common.c.c
    public void e(String str, String str2) {
        println(6, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void e(String str, String str2, Throwable th) {
        b(6, str, str2, th);
    }

    @Override // com.facebook.common.c.c
    public void wtf(String str, String str2) {
        println(6, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void wtf(String str, String str2, Throwable th) {
        b(6, str, str2, th);
    }

    private void println(int i, String str, String str2) {
        Log.println(i, Zu(str), str2);
    }

    private void b(int i, String str, String str2, Throwable th) {
        Log.println(i, Zu(str), j(str2, th));
    }

    private String Zu(String str) {
        if (this.pzv != null) {
            return this.pzv + ":" + str;
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

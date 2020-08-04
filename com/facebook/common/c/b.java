package com.facebook.common.c;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
/* loaded from: classes12.dex */
public class b implements c {
    public static final b mQS = new b();
    private String mQT = "unknown";
    private int mQU = 5;

    public static b dCB() {
        return mQS;
    }

    private b() {
    }

    @Override // com.facebook.common.c.c
    public boolean isLoggable(int i) {
        return this.mQU <= i;
    }

    @Override // com.facebook.common.c.c
    public void v(String str, String str2) {
        q(2, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void d(String str, String str2) {
        q(3, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void w(String str, String str2) {
        q(5, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void w(String str, String str2, Throwable th) {
        b(5, str, str2, th);
    }

    @Override // com.facebook.common.c.c
    public void e(String str, String str2) {
        q(6, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void e(String str, String str2, Throwable th) {
        b(6, str, str2, th);
    }

    @Override // com.facebook.common.c.c
    public void wtf(String str, String str2) {
        q(6, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void wtf(String str, String str2, Throwable th) {
        b(6, str, str2, th);
    }

    private void q(int i, String str, String str2) {
        Log.println(i, Rn(str), str2);
    }

    private void b(int i, String str, String str2, Throwable th) {
        Log.println(i, Rn(str), j(str2, th));
    }

    private String Rn(String str) {
        if (this.mQT != null) {
            return this.mQT + ":" + str;
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

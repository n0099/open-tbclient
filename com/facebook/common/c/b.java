package com.facebook.common.c;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
/* loaded from: classes12.dex */
public class b implements c {
    public static final b mQQ = new b();
    private String mQR = "unknown";
    private int mQS = 5;

    public static b dCA() {
        return mQQ;
    }

    private b() {
    }

    @Override // com.facebook.common.c.c
    public boolean isLoggable(int i) {
        return this.mQS <= i;
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
        if (this.mQR != null) {
            return this.mQR + ":" + str;
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

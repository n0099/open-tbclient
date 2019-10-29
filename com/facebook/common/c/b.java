package com.facebook.common.c;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
/* loaded from: classes2.dex */
public class b implements c {
    public static final b kaY = new b();
    private String kaZ = "unknown";
    private int kba = 5;

    public static b cCM() {
        return kaY;
    }

    private b() {
    }

    @Override // com.facebook.common.c.c
    public boolean isLoggable(int i) {
        return this.kba <= i;
    }

    @Override // com.facebook.common.c.c
    public void v(String str, String str2) {
        r(2, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void d(String str, String str2) {
        r(3, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void i(String str, String str2) {
        r(4, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void w(String str, String str2) {
        r(5, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void c(String str, String str2, Throwable th) {
        b(5, str, str2, th);
    }

    @Override // com.facebook.common.c.c
    public void e(String str, String str2) {
        r(6, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void e(String str, String str2, Throwable th) {
        b(6, str, str2, th);
    }

    @Override // com.facebook.common.c.c
    public void em(String str, String str2) {
        r(6, str, str2);
    }

    @Override // com.facebook.common.c.c
    public void f(String str, String str2, Throwable th) {
        b(6, str, str2, th);
    }

    private void r(int i, String str, String str2) {
        Log.println(i, Gx(str), str2);
    }

    private void b(int i, String str, String str2, Throwable th) {
        Log.println(i, Gx(str), j(str2, th));
    }

    private String Gx(String str) {
        if (this.kaZ != null) {
            return this.kaZ + ":" + str;
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

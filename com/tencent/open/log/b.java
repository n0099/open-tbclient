package com.tencent.open.log;

import android.text.TextUtils;
import com.tencent.open.log.d;
import com.tencent.open.utils.l;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/* loaded from: classes10.dex */
public class b {
    public static SimpleDateFormat a = d.C0772d.a("yy.MM.dd.HH");
    public File g;
    public String b = "Tracer.File";
    public int c = Integer.MAX_VALUE;
    public int d = Integer.MAX_VALUE;
    public int e = 4096;
    public long f = 10000;
    public int h = 10;
    public String i = ".log";
    public long j = Long.MAX_VALUE;

    public File[] a() {
        return c(System.currentTimeMillis());
    }

    public File b() {
        File e = e();
        if (e != null) {
            e.mkdirs();
        }
        return e;
    }

    public String c() {
        return this.b;
    }

    public int d() {
        return this.e;
    }

    public File e() {
        return this.g;
    }

    public int f() {
        return this.h;
    }

    public b(File file, int i, int i2, int i3, String str, long j, int i4, String str2, long j2) {
        a(file);
        b(i);
        a(i2);
        c(i3);
        a(str);
        a(j);
        d(i4);
        b(str2);
        b(j2);
    }

    private String c(String str) {
        return "com.tencent.mobileqq_connectSdk." + str + ".log";
    }

    private String d(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return new SimpleDateFormat("yy.MM.dd.HH").format(calendar.getTime());
    }

    public void a(int i) {
        this.c = i;
    }

    public void b(int i) {
        this.d = i;
    }

    private File[] c(long j) {
        File b = b();
        String c = c(d(j));
        try {
            b = new File(b, c);
        } catch (Throwable th) {
            SLog.e(SLog.TAG, "getWorkFile,get old sdcard file exception:", th);
        }
        String b2 = l.b();
        File file = null;
        if (!TextUtils.isEmpty(b2) || b2 != null) {
            try {
                File file2 = new File(b2, c.o);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                file = new File(file2, c);
            } catch (Exception e) {
                SLog.e(SLog.TAG, "getWorkFile,get app specific file exception:", e);
            }
        }
        return new File[]{b, file};
    }

    public void a(long j) {
        this.f = j;
    }

    public void b(long j) {
        this.j = j;
    }

    public void c(int i) {
        this.e = i;
    }

    public void d(int i) {
        this.h = i;
    }

    public void a(File file) {
        this.g = file;
    }

    public void b(String str) {
        this.i = str;
    }

    public void a(String str) {
        this.b = str;
    }
}

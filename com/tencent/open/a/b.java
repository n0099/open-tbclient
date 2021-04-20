package com.tencent.open.a;

import com.tencent.open.a.d;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static SimpleDateFormat f39481a = d.C0531d.a("yy.MM.dd.HH");

    /* renamed from: g  reason: collision with root package name */
    public File f39487g;

    /* renamed from: b  reason: collision with root package name */
    public String f39482b = "Tracer.File";

    /* renamed from: c  reason: collision with root package name */
    public int f39483c = Integer.MAX_VALUE;

    /* renamed from: d  reason: collision with root package name */
    public int f39484d = Integer.MAX_VALUE;

    /* renamed from: e  reason: collision with root package name */
    public int f39485e = 4096;

    /* renamed from: f  reason: collision with root package name */
    public long f39486f = 10000;

    /* renamed from: h  reason: collision with root package name */
    public int f39488h = 10;
    public String i = ".log";
    public long j = Long.MAX_VALUE;

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

    private File c(long j) {
        File b2 = b();
        try {
            return new File(b2, c(d(j)));
        } catch (Throwable th) {
            th.printStackTrace();
            return b2;
        }
    }

    private String d(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return new SimpleDateFormat("yy.MM.dd.HH").format(calendar.getTime());
    }

    public File a() {
        return c(System.currentTimeMillis());
    }

    public File b() {
        File e2 = e();
        e2.mkdirs();
        return e2;
    }

    public File e() {
        return this.f39487g;
    }

    public int f() {
        return this.f39488h;
    }

    public void a(String str) {
        this.f39482b = str;
    }

    public void a(int i) {
        this.f39483c = i;
    }

    public void b(int i) {
        this.f39484d = i;
    }

    public void a(long j) {
        this.f39486f = j;
    }

    public void b(String str) {
        this.i = str;
    }

    private String c(String str) {
        return "com.tencent.mobileqq_connectSdk." + str + ".log";
    }

    public void a(File file) {
        this.f39487g = file;
    }

    public void b(long j) {
        this.j = j;
    }

    public int d() {
        return this.f39485e;
    }

    public String c() {
        return this.f39482b;
    }

    public void d(int i) {
        this.f39488h = i;
    }

    public void c(int i) {
        this.f39485e = i;
    }
}

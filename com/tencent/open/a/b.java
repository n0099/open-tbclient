package com.tencent.open.a;

import com.tencent.open.a.d;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static SimpleDateFormat f39192a = d.C0517d.a("yy.MM.dd.HH");

    /* renamed from: g  reason: collision with root package name */
    public File f39198g;

    /* renamed from: b  reason: collision with root package name */
    public String f39193b = "Tracer.File";

    /* renamed from: c  reason: collision with root package name */
    public int f39194c = Integer.MAX_VALUE;

    /* renamed from: d  reason: collision with root package name */
    public int f39195d = Integer.MAX_VALUE;

    /* renamed from: e  reason: collision with root package name */
    public int f39196e = 4096;

    /* renamed from: f  reason: collision with root package name */
    public long f39197f = 10000;

    /* renamed from: h  reason: collision with root package name */
    public int f39199h = 10;
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
        return this.f39198g;
    }

    public int f() {
        return this.f39199h;
    }

    public void a(String str) {
        this.f39193b = str;
    }

    public void a(int i) {
        this.f39194c = i;
    }

    public void b(int i) {
        this.f39195d = i;
    }

    public void a(long j) {
        this.f39197f = j;
    }

    public void b(String str) {
        this.i = str;
    }

    private String c(String str) {
        return "com.tencent.mobileqq_connectSdk." + str + ".log";
    }

    public void a(File file) {
        this.f39198g = file;
    }

    public void b(long j) {
        this.j = j;
    }

    public int d() {
        return this.f39196e;
    }

    public String c() {
        return this.f39193b;
    }

    public void d(int i) {
        this.f39199h = i;
    }

    public void c(int i) {
        this.f39196e = i;
    }
}

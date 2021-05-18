package com.tencent.open.a;

import com.tencent.open.a.d;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static SimpleDateFormat f36420a = d.C0465d.a("yy.MM.dd.HH");

    /* renamed from: g  reason: collision with root package name */
    public File f36426g;

    /* renamed from: b  reason: collision with root package name */
    public String f36421b = "Tracer.File";

    /* renamed from: c  reason: collision with root package name */
    public int f36422c = Integer.MAX_VALUE;

    /* renamed from: d  reason: collision with root package name */
    public int f36423d = Integer.MAX_VALUE;

    /* renamed from: e  reason: collision with root package name */
    public int f36424e = 4096;

    /* renamed from: f  reason: collision with root package name */
    public long f36425f = 10000;

    /* renamed from: h  reason: collision with root package name */
    public int f36427h = 10;

    /* renamed from: i  reason: collision with root package name */
    public String f36428i = ".log";
    public long j = Long.MAX_VALUE;

    public b(File file, int i2, int i3, int i4, String str, long j, int i5, String str2, long j2) {
        a(file);
        b(i2);
        a(i3);
        c(i4);
        a(str);
        a(j);
        d(i5);
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
        return this.f36426g;
    }

    public int f() {
        return this.f36427h;
    }

    public void a(String str) {
        this.f36421b = str;
    }

    public void a(int i2) {
        this.f36422c = i2;
    }

    public void b(int i2) {
        this.f36423d = i2;
    }

    public void a(long j) {
        this.f36425f = j;
    }

    public void b(String str) {
        this.f36428i = str;
    }

    private String c(String str) {
        return "com.tencent.mobileqq_connectSdk." + str + ".log";
    }

    public void a(File file) {
        this.f36426g = file;
    }

    public void b(long j) {
        this.j = j;
    }

    public int d() {
        return this.f36424e;
    }

    public String c() {
        return this.f36421b;
    }

    public void d(int i2) {
        this.f36427h = i2;
    }

    public void c(int i2) {
        this.f36424e = i2;
    }
}

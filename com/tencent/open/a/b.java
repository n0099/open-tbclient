package com.tencent.open.a;

import com.tencent.open.a.d;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static SimpleDateFormat f37175a = d.C0478d.a("yy.MM.dd.HH");

    /* renamed from: g  reason: collision with root package name */
    public File f37181g;

    /* renamed from: b  reason: collision with root package name */
    public String f37176b = "Tracer.File";

    /* renamed from: c  reason: collision with root package name */
    public int f37177c = Integer.MAX_VALUE;

    /* renamed from: d  reason: collision with root package name */
    public int f37178d = Integer.MAX_VALUE;

    /* renamed from: e  reason: collision with root package name */
    public int f37179e = 4096;

    /* renamed from: f  reason: collision with root package name */
    public long f37180f = 10000;

    /* renamed from: h  reason: collision with root package name */
    public int f37182h = 10;

    /* renamed from: i  reason: collision with root package name */
    public String f37183i = ".log";
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
        return this.f37181g;
    }

    public int f() {
        return this.f37182h;
    }

    public void a(String str) {
        this.f37176b = str;
    }

    public void a(int i2) {
        this.f37177c = i2;
    }

    public void b(int i2) {
        this.f37178d = i2;
    }

    public void a(long j) {
        this.f37180f = j;
    }

    public void b(String str) {
        this.f37183i = str;
    }

    private String c(String str) {
        return "com.tencent.mobileqq_connectSdk." + str + ".log";
    }

    public void a(File file) {
        this.f37181g = file;
    }

    public void b(long j) {
        this.j = j;
    }

    public int d() {
        return this.f37179e;
    }

    public String c() {
        return this.f37176b;
    }

    public void d(int i2) {
        this.f37182h = i2;
    }

    public void c(int i2) {
        this.f37179e = i2;
    }
}

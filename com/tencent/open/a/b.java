package com.tencent.open.a;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.tencent.open.a.d;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/* loaded from: classes15.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static SimpleDateFormat f13373a = d.C1270d.a("yy.MM.dd.HH");
    private File g;

    /* renamed from: b  reason: collision with root package name */
    private String f13374b = "Tracer.File";
    private int c = Integer.MAX_VALUE;
    private int d = Integer.MAX_VALUE;
    private int e = 4096;
    private long f = 10000;
    private int h = 10;
    private String i = BdStatsConstant.StatsFile.LOG_FILE_SUFFIX;
    private long j = Long.MAX_VALUE;

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

    public File a() {
        return c(System.currentTimeMillis());
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

    private String c(String str) {
        return "com.tencent.mobileqq_connectSdk." + str + BdStatsConstant.StatsFile.LOG_FILE_SUFFIX;
    }

    public File b() {
        File e = e();
        e.mkdirs();
        return e;
    }

    public String c() {
        return this.f13374b;
    }

    public void a(String str) {
        this.f13374b = str;
    }

    public void a(int i) {
        this.c = i;
    }

    public void b(int i) {
        this.d = i;
    }

    public int d() {
        return this.e;
    }

    public void c(int i) {
        this.e = i;
    }

    public void a(long j) {
        this.f = j;
    }

    public File e() {
        return this.g;
    }

    public void a(File file) {
        this.g = file;
    }

    public int f() {
        return this.h;
    }

    public void d(int i) {
        this.h = i;
    }

    public void b(String str) {
        this.i = str;
    }

    public void b(long j) {
        this.j = j;
    }
}

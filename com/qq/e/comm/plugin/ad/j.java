package com.qq.e.comm.plugin.ad;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private String f11894a;

    /* renamed from: b  reason: collision with root package name */
    private int f11895b;
    private double c;
    private int d;
    private int e;
    private long f;
    private String g;
    private String h;
    private String i;
    private long j;

    public String a() {
        return this.i;
    }

    public void a(double d) {
        this.c = d;
    }

    public void a(int i) {
        this.e = i;
    }

    public void a(long j) {
        this.j = j;
    }

    public void a(String str) {
        this.i = str;
    }

    public long b() {
        return this.j;
    }

    public void b(int i) {
        this.f11895b = i;
    }

    public void b(long j) {
        this.f = j;
    }

    public void b(String str) {
        this.f11894a = str;
    }

    public long c() {
        return this.f;
    }

    public void c(int i) {
        this.d = i;
    }

    public void c(String str) {
        this.h = str;
    }

    public String d() {
        return this.f11894a;
    }

    public void d(String str) {
        this.g = str;
    }

    public double e() {
        return this.c;
    }

    public int f() {
        return this.e;
    }

    public int g() {
        return this.f11895b;
    }

    public int h() {
        return this.d;
    }

    public String i() {
        return this.h;
    }

    public String j() {
        return this.g;
    }

    public String toString() {
        return "AppInfo{packageName='" + this.f11894a + "', score=" + this.f11895b + ", price=" + this.c + ", status=" + this.d + ", progress=" + this.e + ", downloads=" + this.f + ", iconUrl='" + this.g + "', appName='" + this.h + "', versionName='" + this.i + "', pkgSize=" + this.j + '}';
    }
}

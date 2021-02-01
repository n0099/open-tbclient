package com.meizu.flyme.openidsdk;
/* loaded from: classes15.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f11370a;

    /* renamed from: b  reason: collision with root package name */
    public String f11371b;
    public String c;
    public int d;

    public a(String str) {
        this.c = str;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(long j) {
        this.f11370a = j;
    }

    public void a(String str) {
        this.f11371b = str;
    }

    public boolean a() {
        return this.f11370a > System.currentTimeMillis();
    }

    public void b() {
        this.f11370a = 0L;
    }
}

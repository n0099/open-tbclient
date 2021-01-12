package com.meizu.flyme.openidsdk;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f11368a;

    /* renamed from: b  reason: collision with root package name */
    public String f11369b;
    public String c;
    public int d;

    public a(String str) {
        this.c = str;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(long j) {
        this.f11368a = j;
    }

    public void a(String str) {
        this.f11369b = str;
    }

    public boolean a() {
        return this.f11368a > System.currentTimeMillis();
    }

    public void b() {
        this.f11368a = 0L;
    }
}

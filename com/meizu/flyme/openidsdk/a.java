package com.meizu.flyme.openidsdk;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f11668a;

    /* renamed from: b  reason: collision with root package name */
    public String f11669b;
    public String c;
    public int d;

    public a(String str) {
        this.c = str;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(long j) {
        this.f11668a = j;
    }

    public void a(String str) {
        this.f11669b = str;
    }

    public boolean a() {
        return this.f11668a > System.currentTimeMillis();
    }

    public void b() {
        this.f11668a = 0L;
    }
}

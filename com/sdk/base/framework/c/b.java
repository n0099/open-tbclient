package com.sdk.base.framework.c;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    public int f39430c;

    /* renamed from: a  reason: collision with root package name */
    public long f39428a = System.currentTimeMillis();

    /* renamed from: b  reason: collision with root package name */
    public c f39429b = new c();

    /* renamed from: d  reason: collision with root package name */
    public String f39431d = "";

    public final String a() {
        return this.f39431d;
    }

    public final void a(int i2) {
        this.f39430c = i2;
    }

    public final void a(String str) {
        this.f39431d = str;
    }

    public final int b() {
        return this.f39430c;
    }

    public final c c() {
        return this.f39429b;
    }

    public final String toString() {
        return "MobileLog{time=" + this.f39428a + ", status=" + this.f39429b + '}';
    }
}

package com.sdk.base.framework.c;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    public int f39332c;

    /* renamed from: a  reason: collision with root package name */
    public long f39330a = System.currentTimeMillis();

    /* renamed from: b  reason: collision with root package name */
    public c f39331b = new c();

    /* renamed from: d  reason: collision with root package name */
    public String f39333d = "";

    public final String a() {
        return this.f39333d;
    }

    public final void a(int i2) {
        this.f39332c = i2;
    }

    public final void a(String str) {
        this.f39333d = str;
    }

    public final int b() {
        return this.f39332c;
    }

    public final c c() {
        return this.f39331b;
    }

    public final String toString() {
        return "MobileLog{time=" + this.f39330a + ", status=" + this.f39331b + '}';
    }
}

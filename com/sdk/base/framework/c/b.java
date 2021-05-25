package com.sdk.base.framework.c;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    public int f35653c;

    /* renamed from: a  reason: collision with root package name */
    public long f35651a = System.currentTimeMillis();

    /* renamed from: b  reason: collision with root package name */
    public c f35652b = new c();

    /* renamed from: d  reason: collision with root package name */
    public String f35654d = "";

    public final String a() {
        return this.f35654d;
    }

    public final void a(int i2) {
        this.f35653c = i2;
    }

    public final void a(String str) {
        this.f35654d = str;
    }

    public final int b() {
        return this.f35653c;
    }

    public final c c() {
        return this.f35652b;
    }

    public final String toString() {
        return "MobileLog{time=" + this.f35651a + ", status=" + this.f35652b + '}';
    }
}

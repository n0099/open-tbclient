package com.sdk.base.framework.c;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    public int f35724c;

    /* renamed from: a  reason: collision with root package name */
    public long f35722a = System.currentTimeMillis();

    /* renamed from: b  reason: collision with root package name */
    public c f35723b = new c();

    /* renamed from: d  reason: collision with root package name */
    public String f35725d = "";

    public final String a() {
        return this.f35725d;
    }

    public final void a(int i2) {
        this.f35724c = i2;
    }

    public final void a(String str) {
        this.f35725d = str;
    }

    public final int b() {
        return this.f35724c;
    }

    public final c c() {
        return this.f35723b;
    }

    public final String toString() {
        return "MobileLog{time=" + this.f35722a + ", status=" + this.f35723b + '}';
    }
}

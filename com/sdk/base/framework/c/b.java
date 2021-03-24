package com.sdk.base.framework.c;
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    public int f38510c;

    /* renamed from: a  reason: collision with root package name */
    public long f38508a = System.currentTimeMillis();

    /* renamed from: b  reason: collision with root package name */
    public c f38509b = new c();

    /* renamed from: d  reason: collision with root package name */
    public String f38511d = "";

    public final String a() {
        return this.f38511d;
    }

    public final void a(int i) {
        this.f38510c = i;
    }

    public final void a(String str) {
        this.f38511d = str;
    }

    public final int b() {
        return this.f38510c;
    }

    public final c c() {
        return this.f38509b;
    }

    public final String toString() {
        return "MobileLog{time=" + this.f38508a + ", status=" + this.f38509b + '}';
    }
}

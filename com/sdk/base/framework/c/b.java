package com.sdk.base.framework.c;
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    public int f38895c;

    /* renamed from: a  reason: collision with root package name */
    public long f38893a = System.currentTimeMillis();

    /* renamed from: b  reason: collision with root package name */
    public c f38894b = new c();

    /* renamed from: d  reason: collision with root package name */
    public String f38896d = "";

    public final String a() {
        return this.f38896d;
    }

    public final void a(int i) {
        this.f38895c = i;
    }

    public final void a(String str) {
        this.f38896d = str;
    }

    public final int b() {
        return this.f38895c;
    }

    public final c c() {
        return this.f38894b;
    }

    public final String toString() {
        return "MobileLog{time=" + this.f38893a + ", status=" + this.f38894b + '}';
    }
}

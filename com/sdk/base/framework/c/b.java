package com.sdk.base.framework.c;
/* loaded from: classes15.dex */
public final class b {
    private int c;

    /* renamed from: a  reason: collision with root package name */
    private long f13112a = System.currentTimeMillis();

    /* renamed from: b  reason: collision with root package name */
    private c f13113b = new c();
    private String d = "";

    public final String a() {
        return this.d;
    }

    public final void a(int i) {
        this.c = i;
    }

    public final void a(String str) {
        this.d = str;
    }

    public final int b() {
        return this.c;
    }

    public final c c() {
        return this.f13113b;
    }

    public final String toString() {
        return "MobileLog{time=" + this.f13112a + ", status=" + this.f13113b + '}';
    }
}

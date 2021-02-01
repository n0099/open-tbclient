package com.sdk.base.framework.c;
/* loaded from: classes4.dex */
public final class b {
    private int c;

    /* renamed from: a  reason: collision with root package name */
    private long f12814a = System.currentTimeMillis();

    /* renamed from: b  reason: collision with root package name */
    private c f12815b = new c();
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
        return this.f12815b;
    }

    public final String toString() {
        return "MobileLog{time=" + this.f12814a + ", status=" + this.f12815b + '}';
    }
}

package com.sdk.base.framework.c;
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    public int f38800c;

    /* renamed from: a  reason: collision with root package name */
    public long f38798a = System.currentTimeMillis();

    /* renamed from: b  reason: collision with root package name */
    public c f38799b = new c();

    /* renamed from: d  reason: collision with root package name */
    public String f38801d = "";

    public final String a() {
        return this.f38801d;
    }

    public final void a(int i) {
        this.f38800c = i;
    }

    public final void a(String str) {
        this.f38801d = str;
    }

    public final int b() {
        return this.f38800c;
    }

    public final c c() {
        return this.f38799b;
    }

    public final String toString() {
        return "MobileLog{time=" + this.f38798a + ", status=" + this.f38799b + '}';
    }
}

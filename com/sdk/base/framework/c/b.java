package com.sdk.base.framework.c;
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    public int f36479c;

    /* renamed from: a  reason: collision with root package name */
    public long f36477a = System.currentTimeMillis();

    /* renamed from: b  reason: collision with root package name */
    public c f36478b = new c();

    /* renamed from: d  reason: collision with root package name */
    public String f36480d = "";

    public final String a() {
        return this.f36480d;
    }

    public final void a(int i2) {
        this.f36479c = i2;
    }

    public final void a(String str) {
        this.f36480d = str;
    }

    public final int b() {
        return this.f36479c;
    }

    public final c c() {
        return this.f36478b;
    }

    public final String toString() {
        return "MobileLog{time=" + this.f36477a + ", status=" + this.f36478b + '}';
    }
}

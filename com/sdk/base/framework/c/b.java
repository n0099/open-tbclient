package com.sdk.base.framework.c;
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    public int f38511c;

    /* renamed from: a  reason: collision with root package name */
    public long f38509a = System.currentTimeMillis();

    /* renamed from: b  reason: collision with root package name */
    public c f38510b = new c();

    /* renamed from: d  reason: collision with root package name */
    public String f38512d = "";

    public final String a() {
        return this.f38512d;
    }

    public final void a(int i) {
        this.f38511c = i;
    }

    public final void a(String str) {
        this.f38512d = str;
    }

    public final int b() {
        return this.f38511c;
    }

    public final c c() {
        return this.f38510b;
    }

    public final String toString() {
        return "MobileLog{time=" + this.f38509a + ", status=" + this.f38510b + '}';
    }
}

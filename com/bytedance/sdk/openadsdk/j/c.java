package com.bytedance.sdk.openadsdk.j;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final long f7542a;

    /* renamed from: b  reason: collision with root package name */
    private final long f7543b;
    private final long c;

    public long a(int i) {
        return i <= 0 ? this.f7542a : Math.min(this.f7542a + (this.f7543b * i), this.c);
    }
}

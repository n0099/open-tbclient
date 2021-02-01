package com.bytedance.sdk.openadsdk.j;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final long f7245a;

    /* renamed from: b  reason: collision with root package name */
    private final long f7246b;
    private final long c;

    public long a(int i) {
        return i <= 0 ? this.f7245a : Math.min(this.f7245a + (this.f7246b * i), this.c);
    }
}

package com.bytedance.sdk.openadsdk.j;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final long f7243a;

    /* renamed from: b  reason: collision with root package name */
    private final long f7244b;
    private final long c;

    public long a(int i) {
        return i <= 0 ? this.f7243a : Math.min(this.f7243a + (this.f7244b * i), this.c);
    }
}

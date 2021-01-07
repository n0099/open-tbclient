package com.bytedance.sdk.openadsdk.j;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final long f7543a;

    /* renamed from: b  reason: collision with root package name */
    private final long f7544b;
    private final long c;

    public long a(int i) {
        return i <= 0 ? this.f7543a : Math.min(this.f7543a + (this.f7544b * i), this.c);
    }
}

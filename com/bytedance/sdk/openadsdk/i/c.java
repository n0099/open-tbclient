package com.bytedance.sdk.openadsdk.i;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final long f4817a;
    private final long b;
    private final long c;

    public long a(int i) {
        return i <= 0 ? this.f4817a : Math.min(this.f4817a + (this.b * i), this.c);
    }
}

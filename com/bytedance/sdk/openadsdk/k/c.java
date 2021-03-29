package com.bytedance.sdk.openadsdk.k;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final long f29605a;

    /* renamed from: b  reason: collision with root package name */
    public final long f29606b;

    /* renamed from: c  reason: collision with root package name */
    public final long f29607c;

    public long a(int i) {
        if (i <= 0) {
            return this.f29605a;
        }
        return Math.min(this.f29605a + (this.f29606b * i), this.f29607c);
    }
}

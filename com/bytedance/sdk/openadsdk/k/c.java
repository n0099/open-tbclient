package com.bytedance.sdk.openadsdk.k;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final long f29372a;

    /* renamed from: b  reason: collision with root package name */
    public final long f29373b;

    /* renamed from: c  reason: collision with root package name */
    public final long f29374c;

    public long a(int i2) {
        if (i2 <= 0) {
            return this.f29372a;
        }
        return Math.min(this.f29372a + (this.f29373b * i2), this.f29374c);
    }
}

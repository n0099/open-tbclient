package com.bytedance.sdk.openadsdk.k;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final long f29443a;

    /* renamed from: b  reason: collision with root package name */
    public final long f29444b;

    /* renamed from: c  reason: collision with root package name */
    public final long f29445c;

    public long a(int i2) {
        if (i2 <= 0) {
            return this.f29443a;
        }
        return Math.min(this.f29443a + (this.f29444b * i2), this.f29445c);
    }
}

package com.bytedance.sdk.openadsdk.k;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final long f29475a;

    /* renamed from: b  reason: collision with root package name */
    public final long f29476b;

    /* renamed from: c  reason: collision with root package name */
    public final long f29477c;

    public long a(int i2) {
        if (i2 <= 0) {
            return this.f29475a;
        }
        return Math.min(this.f29475a + (this.f29476b * i2), this.f29477c);
    }
}

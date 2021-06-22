package com.bytedance.sdk.openadsdk.k;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final long f29557a;

    /* renamed from: b  reason: collision with root package name */
    public final long f29558b;

    /* renamed from: c  reason: collision with root package name */
    public final long f29559c;

    public long a(int i2) {
        if (i2 <= 0) {
            return this.f29557a;
        }
        return Math.min(this.f29557a + (this.f29558b * i2), this.f29559c);
    }
}

package com.bytedance.sdk.openadsdk.k;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final long f30198a;

    /* renamed from: b  reason: collision with root package name */
    public final long f30199b;

    /* renamed from: c  reason: collision with root package name */
    public final long f30200c;

    public long a(int i2) {
        if (i2 <= 0) {
            return this.f30198a;
        }
        return Math.min(this.f30198a + (this.f30199b * i2), this.f30200c);
    }
}

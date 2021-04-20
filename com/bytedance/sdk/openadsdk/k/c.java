package com.bytedance.sdk.openadsdk.k;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final long f29290a;

    /* renamed from: b  reason: collision with root package name */
    public final long f29291b;

    /* renamed from: c  reason: collision with root package name */
    public final long f29292c;

    public long a(int i) {
        if (i <= 0) {
            return this.f29290a;
        }
        return Math.min(this.f29290a + (this.f29291b * i), this.f29292c);
    }
}

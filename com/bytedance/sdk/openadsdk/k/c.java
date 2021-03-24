package com.bytedance.sdk.openadsdk.k;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final long f29604a;

    /* renamed from: b  reason: collision with root package name */
    public final long f29605b;

    /* renamed from: c  reason: collision with root package name */
    public final long f29606c;

    public long a(int i) {
        if (i <= 0) {
            return this.f29604a;
        }
        return Math.min(this.f29604a + (this.f29605b * i), this.f29606c);
    }
}

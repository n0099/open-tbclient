package com.bytedance.sdk.openadsdk.k;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final long f29298a;

    /* renamed from: b  reason: collision with root package name */
    public final long f29299b;

    /* renamed from: c  reason: collision with root package name */
    public final long f29300c;

    public long a(int i) {
        if (i <= 0) {
            return this.f29298a;
        }
        return Math.min(this.f29298a + (this.f29299b * i), this.f29300c);
    }
}

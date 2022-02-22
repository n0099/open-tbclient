package com.meizu.cloud.pushsdk.base;
/* loaded from: classes4.dex */
public class i<T> {
    public T a;

    /* renamed from: b  reason: collision with root package name */
    public T f58873b;

    public i(T t) {
        if (t == null) {
            throw new RuntimeException("proxy must be has a default implementation");
        }
        this.f58873b = t;
    }

    public T c() {
        T t = this.a;
        return t != null ? t : this.f58873b;
    }
}

package com.meizu.cloud.pushsdk.base;
/* loaded from: classes7.dex */
public class i<T> {
    public T a;

    /* renamed from: b  reason: collision with root package name */
    public T f42061b;

    public i(T t) {
        if (t == null) {
            throw new RuntimeException("proxy must be has a default implementation");
        }
        this.f42061b = t;
    }

    public T c() {
        T t = this.a;
        return t != null ? t : this.f42061b;
    }
}

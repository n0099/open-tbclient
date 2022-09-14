package com.meizu.cloud.pushsdk.base;
/* loaded from: classes8.dex */
public class i<T> {
    public T a;
    public T b;

    public i(T t) {
        if (t == null) {
            throw new RuntimeException("proxy must be has a default implementation");
        }
        this.b = t;
    }

    public T c() {
        T t = this.a;
        return t != null ? t : this.b;
    }
}

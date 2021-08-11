package com.meizu.cloud.pushsdk.base;
/* loaded from: classes10.dex */
public class i<T> {

    /* renamed from: a  reason: collision with root package name */
    public T f74366a;

    /* renamed from: b  reason: collision with root package name */
    public T f74367b;

    public i(T t) {
        if (t == null) {
            throw new RuntimeException("proxy must be has a default implementation");
        }
        this.f74367b = t;
    }

    public T c() {
        T t = this.f74366a;
        return t != null ? t : this.f74367b;
    }
}

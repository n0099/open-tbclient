package com.meizu.cloud.pushsdk.base;
/* loaded from: classes6.dex */
public class i<T> {

    /* renamed from: a  reason: collision with root package name */
    public T f34852a;

    /* renamed from: b  reason: collision with root package name */
    public T f34853b;

    public i(T t) {
        if (t == null) {
            throw new RuntimeException("proxy must be has a default implementation");
        }
        this.f34853b = t;
    }

    public T c() {
        T t = this.f34852a;
        return t != null ? t : this.f34853b;
    }
}

package com.meizu.cloud.pushsdk.base;
/* loaded from: classes10.dex */
public class i<T> {

    /* renamed from: a  reason: collision with root package name */
    public T f75065a;

    /* renamed from: b  reason: collision with root package name */
    public T f75066b;

    public i(T t) {
        if (t == null) {
            throw new RuntimeException("proxy must be has a default implementation");
        }
        this.f75066b = t;
    }

    public T c() {
        T t = this.f75065a;
        return t != null ? t : this.f75066b;
    }
}

package com.meizu.cloud.pushsdk.base;
/* loaded from: classes10.dex */
public class i<T> {

    /* renamed from: a  reason: collision with root package name */
    public T f74746a;

    /* renamed from: b  reason: collision with root package name */
    public T f74747b;

    public i(T t) {
        if (t == null) {
            throw new RuntimeException("proxy must be has a default implementation");
        }
        this.f74747b = t;
    }

    public T c() {
        T t = this.f74746a;
        return t != null ? t : this.f74747b;
    }
}

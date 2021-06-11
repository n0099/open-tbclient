package com.meizu.cloud.pushsdk.base;
/* loaded from: classes7.dex */
public class i<T> {

    /* renamed from: a  reason: collision with root package name */
    public T f38460a;

    /* renamed from: b  reason: collision with root package name */
    public T f38461b;

    public i(T t) {
        if (t == null) {
            throw new RuntimeException("proxy must be has a default implementation");
        }
        this.f38461b = t;
    }

    public T c() {
        T t = this.f38460a;
        return t != null ? t : this.f38461b;
    }
}

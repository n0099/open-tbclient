package com.meizu.cloud.pushsdk.base;
/* loaded from: classes2.dex */
public class i<T> {

    /* renamed from: a  reason: collision with root package name */
    public T f67464a;

    /* renamed from: b  reason: collision with root package name */
    public T f67465b;

    public i(T t) {
        if (t == null) {
            throw new RuntimeException("proxy must be has a default implementation");
        }
        this.f67465b = t;
    }

    public T c() {
        T t = this.f67464a;
        return t != null ? t : this.f67465b;
    }
}

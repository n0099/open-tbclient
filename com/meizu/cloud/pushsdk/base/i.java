package com.meizu.cloud.pushsdk.base;
/* loaded from: classes2.dex */
public class i<T> {

    /* renamed from: a  reason: collision with root package name */
    public T f68376a;

    /* renamed from: b  reason: collision with root package name */
    public T f68377b;

    public i(T t) {
        if (t == null) {
            throw new RuntimeException("proxy must be has a default implementation");
        }
        this.f68377b = t;
    }

    public T c() {
        T t = this.f68376a;
        return t != null ? t : this.f68377b;
    }
}
